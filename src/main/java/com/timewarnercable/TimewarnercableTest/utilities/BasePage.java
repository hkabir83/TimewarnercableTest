package com.timewarnercable.TimewarnercableTest.utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.base.Function;

public class BasePage extends TimeWarnerCableDriver {

	private final static String xpath = "xpath";
	private final static String id = "id";
	private final static String cssSelector = "css";
	private final static String name = "name";
	private final static String className = "className";
	private final static String tagName = "tagName";
	private final static String yes = "Yes";
	private final static String no = "No";
	public static FluentWait<WebDriver> wait = null;
	public static Function<WebDriver, WebElement> fwait = null;

	public static String getXpath() {
		return xpath;
	}

	public static String getId() {
		return id;
	}

	public static String getCssselector() {
		return cssSelector;
	}

	public static String getName() {
		return name;
	}

	public static String getClassName() {
		return className;
	}

	public static String getTagName() {
		return tagName;
	}

	public static String getYes() {
		return yes;
	}

	public static String getNo() {
		return no;
	}

	private void getShowStopperStatus(String blocker, String errorMessage) {

		String showStopper = blocker;

		if (showStopper.equalsIgnoreCase("yes")) {
			navigateToHome();
			getWarning("Exception : "
					+ new NoSuchElementException(errorMessage));
			throw new NoSuchElementException(errorMessage);
		} else if (showStopper.equalsIgnoreCase("no")) {
			getWarning("Exception : "
					+ new NoSuchElementException(errorMessage));
			Reporter.log(errorMessage);
		}

	}

	public boolean displayWebElement(String locator, String attributeOfLocator) {

		try {
			boolean displayed = getElement(locator, attributeOfLocator)
					.isDisplayed();
			return displayed;
		} catch (NoSuchElementException | TimeoutException e) {
			Reporter.log("No Such Element Found Exception Occured on: "
					+ locator + " " + attributeOfLocator);
		}
		return false;
	}

	public List<WebElement> getWebElements(String locator,
			String attributeOfLocator, String info, String blocker,
			String errorMessage) {
		List<WebElement> element = null;
		try {
			element = getElements(locator, attributeOfLocator);
			getInfo(info);
		} catch (NoSuchElementException | TimeoutException e) {
			getShowStopperStatus(blocker, errorMessage);
			e.printStackTrace();
		}

		return element;
	}

	// This method is used to click button
	public void clickButton(String locator, String attributeOfLocator,
			String passMessage, String blocker, String errorMessage) {
		try {
			WebElement ele = getElement(locator, attributeOfLocator);
			ele.click();
			getPass(passMessage);
		} catch (NoSuchElementException | TimeoutException e) {
			getShowStopperStatus(blocker, errorMessage);
		}
	}

	// This method is used to click button with hover
	public void clickButtonWithHover(String parentLocator,
			String parentAttribute, String childLocator, String childAttribute,
			String passMessage, String blocker, String errorMessage) {
		try {
			WebElement parent = getElement(parentLocator, parentAttribute);
			WebElement child = getElement(childLocator, childAttribute);

			Actions action = new Actions(driver);
			action.moveToElement(parent).moveToElement(child).click().build()
					.perform();
			getPass(passMessage);
		} catch (NoSuchElementException | TimeoutException e) {
			getShowStopperStatus(blocker, errorMessage);
		}
	}

	// This method is used for entering text on text field
	public void enterDataIntoTextField(String locator,
			String attributeOfLocator, String value, String passMessage,
			String blocker, String errorMessage) {

		try {
			WebElement ele = getElement(locator, attributeOfLocator);
			ele.sendKeys(value);
			getPass(passMessage);
		} catch (NoSuchElementException | TimeoutException e) {
			getShowStopperStatus(blocker, errorMessage);
		}

	}
	
	// This method is used for entering text on text field with hover
		public void enterDataIntoTextFieldWithHover(String parentLocator,
				String parentAttribute, String childLocator, String childAttribute, String value,
				String passMessage, String blocker, String errorMessage) {

			try {
				WebElement parent = getElement(parentLocator, parentAttribute);
				WebElement child = getElement(childLocator, childAttribute);

				Actions action = new Actions(driver);
				action.moveToElement(parent).moveToElement(child).click().sendKeys(value).build().perform();
				/*//or we can write like this
				Action allAction = action
						.moveToElement(parent)
						.moveToElement(child)
						.click()
						.sendKeys(value)
						.build();
				allAction.perform();*/
				getPass(passMessage);
			} catch (NoSuchElementException | TimeoutException e) {
				getShowStopperStatus(blocker, errorMessage);
			}

		}

	// This method is used for clearing text field
	public void clearTextField(String locator, String attributeOfLocator,
			String info, String blocker, String errorMessage) {
		try {
			WebElement ele = getElement(locator, attributeOfLocator);
			ele.clear();
			getInfo(info);
		} catch (NoSuchElementException | TimeoutException e) {
			getShowStopperStatus(blocker, errorMessage);
			e.printStackTrace();
		}
	}

	// Get text from page
	public String getPageText(String locator, String attributeOfLocator,
			String info, String blocker, String errorMessage) {
		String text = null;
		try {
			WebElement ele = getElement(locator, attributeOfLocator);
			text = ele.getText();
			getInfo(info);
		} catch (NoSuchElementException | TimeoutException e) {
			getShowStopperStatus(blocker, errorMessage);
			e.printStackTrace();
		}

		return text;
	}


	
	// Explici wait
	public void waitUntilElementVisible(By locator, int timeout){
		WebDriverWait expectedWaits = new WebDriverWait(driver, timeout);
		expectedWaits.pollingEvery(3, TimeUnit.SECONDS);
		expectedWaits.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitUntilElementVisible(String title, int timeout){
		WebDriverWait expectedWaits = new WebDriverWait(driver, timeout);
		expectedWaits.pollingEvery(3, TimeUnit.SECONDS);
		expectedWaits.until(ExpectedConditions.titleContains(title));
	}
	
	//Fluent Wait
	public void fluentWait(By locator){
		
		wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(30, TimeUnit.SECONDS);
		wait.pollingEvery(3, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		
		fwait = new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver arg0) {
					return arg0.findElement(locator);
			}
		};
	}
	
	// Get value from text field
	public String getValueFromTextField(String locator,
			String attributeOfLocator, String info, String blocker,
			String errorMessage) {

		String text = null;
		try {
			WebElement ele = getElement(locator, attributeOfLocator);
			text = ele.getAttribute("value");
			getInfo(info);
		} catch (NoSuchElementException e) {
			getShowStopperStatus(blocker, errorMessage);
			e.printStackTrace();
		}

		return text;
	}

	// This method is use assert value from web Page

	public void assertValue(WebElement actualResult, String expected,
			String passMessage, String blocker, String errorMessage) {

		try {
			Assert.assertEquals(actualResult, expected);
			getPass(passMessage);
		} catch (NoSuchElementException | TimeoutException | AssertionError e) {
			getShowStopperStatus(blocker, errorMessage);
			e.printStackTrace();
		}
	}

	public void assertValue(String actualResult, String expected,
			String passMessage, String blocker, String errorMessage) {

		try {
			Assert.assertEquals(actualResult, expected);
			getPass(passMessage);
		} catch (NoSuchElementException | TimeoutException | AssertionError e) {
			getShowStopperStatus(blocker, errorMessage);
			e.printStackTrace();
		}
	}

	public void assertValue(boolean actualResult, String expected,
			String passMessage, String blocker, String errorMessage) {

		try {
			Assert.assertEquals(actualResult, expected);
			getPass(passMessage);
		} catch (NoSuchElementException | TimeoutException | AssertionError e) {
			getShowStopperStatus(blocker, errorMessage);
			e.printStackTrace();
		}
	}

	public void assertValue(boolean expected, String passMessage,
			String blocker, String errorMessage) {

		try {
			Assert.assertTrue(expected);
			getPass(passMessage);
		} catch (NoSuchElementException | TimeoutException | AssertionError e) {
			getShowStopperStatus(blocker, errorMessage);
			e.printStackTrace();
		}
	}
}
