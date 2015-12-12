package com.timewarnercable.TimewarnercableTest.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.timewarnercable.TimewarnercableTest.utilities.BasePage;

public class LandingScreen extends BasePage {

	private static WebDriver driver = null;

	// Attribute of locator
	private String yourHome = "//div[@class='section list']/ul/li[1]//a";
	// private String yourBusiness = "//div[@class='section list']/ul/li[2]//a";
	// private String twcCentral = "//div[@class='section list']/ul/li[3]//a";
	private String aboutUs = "//div[@class='section list']/ul/li[4]//a";
	// private String investorRelations =
	// "//div[@class='section list']/ul/li[5]//a";
	// private String careers = "//div[@class='section list']/ul/li[6]//a";
	// private String espanol = "//div[@class='section list']/ul/li[7]//a";*/
	private String headerListXpath = "//div[@class='section list']/ul/li";
	private String[] headerList = { "Your Home", "Your Business",
			"TWC Central", "About Us", "Investor Relations", "Careers",
			"Español" };
	private String myAccountButton = "//div[@class='twc-new-nav list']/ul/li[4]//a";
	private String username = "username";
	private String password = "password";
	private String signInButton = "//button[@class='sign-in-btn mys-btn']";
	private String signInWithHover = "form_submit";
	private String errorMessage = "//div[@class='message']";
	private String loginErrorMsg1 = "Sorry, that username and password combination does not exist. Would you like to try again?";
	private String loginErrorMsg2 = "Sorry, we are still unable to validate that username and password combination. If you're not sure of your username or password, you can recover them below.";
	private String locationIcon = "//div[@class='newIcons horizontal list']/descendant::div[4]/a/span[1]";
	private String zipUnderLocationIcon = "//div[@class='newIcons horizontal list']/descendant::div[4]/a/span[2]";
	private String locationOverlayTextField = "//div[@class='message-box']/descendant::input[position()=3]";
	private String locationOverlayTextFieldAftUpd = "//div[@class='message-box']/descendant::input[position()=1]";
	private String goButton = "//div[@class='message-box']/descendant::button[position()=3]";
	private String goButtonAftUpdZip = "//div[@class='message-box']/descendant::button[position()=1]";
	private String messageBox = "//div[@class='message-box']";
	private String locationErrorMsg = "//div[@class='parsys oof-error-content']/self::div//p[2]";
	// private String locationErrorMsg =
	// "//div[@class='parsys oof-error-content']/descendant::p[2]";
	private String currentLocation = "//div[@class='parsys localized-content']//p";
	private String searchButton = "//div[@class='section newHeaderIcons']/descendant::li[5]//a";
	private String searchInpField = "//div[@class='message-box']/descendant::input[4]";
	private String searchGoButton = "//div[@class='message-box']/descendant::button[4]";
	private String searchResultText = "//div[@class='results searchResults']/span";
	private String searchResultErrorText = "//div[@class='noResultsText']/p";
	private String emailIcon = "//div[@class='section newHeaderIcons']/descendant::li[3]//a";
	private String enterEmailInputField = "//table[@class='mainPanelInBodyTableFormatting']/descendant::td[@class='mainPanelComposeMailPadding3'][1]/input";
	private String enterEmailPassInputField = "//table[@class='mainPanelInBodyTableFormatting']/descendant::td[@class='mainPanelComposeMailPadding3'][2]/input";
	private String emailLogin = "//input[@id='loginButton']";
	private String emailErrMsg = "//div[@class='webmailErrorInfoTxt']";
	private String assertErrorMessage = "ActualResult and Expected did not match";

	public LandingScreen(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAboutUs() {
		clickButton(getXpath(), aboutUs, "Click on about us link", getNo(),
				"Unable to click on About Us link");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	public void clickOnMyAccountButton() {
		clickButton(getXpath(), myAccountButton, "Click on My Account Button",
				getYes(), "Unable to click on My Accound button");
	}

	public void clickOnSignInButton() {
		clickButton(getXpath(), signInButton, "Click on the login button",
				getYes(), "Unable to click on Sign In button");
	}

	public void clickOnSignInButtonWithHover() {
		clickButtonWithHover(getXpath(), myAccountButton, getId(),
				signInWithHover, "Click on the login button", getYes(),
				"Unable to click on Sign In button");
	}

	public void clickOnLocationIcon() {

		boolean msgBox = displayWebElement(getXpath(), messageBox);
		boolean currLoc = displayWebElement(getXpath(), currentLocation);

		if (!currLoc) {
			if(!msgBox){
			clickButton(getXpath(), locationIcon, "Click on location icon",
					getYes(), "Unable to click on Location Icon");
			}
		}
			
	}

	public void clickOnGoButton() {
		boolean currLoc = displayWebElement(getXpath(), currentLocation);
		if (!currLoc) {
			clickButton(getXpath(), goButton, "Click on GO button", getYes(),
					"Unable click on Go button");
		} else {
			clickButton(getXpath(), goButtonAftUpdZip, "Click on GO button",
					getYes(), "Unable click on Go button");
		}
	}

	public void clickOnGoButtonAftUpdZip() {
		clickButton(getXpath(), goButtonAftUpdZip,
				"Click on GO button after updated zip", getYes(),
				"Unable to click on Go button after update zip code");
	}

	public void clickOnSearchIcon() {
		clickButton(getXpath(), searchButton, "Search icon clicked", getYes(),
				"Unable to click on Search Icon");
	}

	public void clickOnSearchGOButton() {
		clickButton(getXpath(), searchGoButton, "Search GO button clicked",
				getYes(), "Unable to click on Search Go button");
	}

	public void clickOnEmailIcon() {
		clickButton(getXpath(), emailIcon, "Email Icon Clicked", getYes(),
				"Unable to click on Email icon");
	}

	public void clickOnEmilLoginButton() {
		clickButton(getXpath(), emailLogin, "Email Login button Clicked",
				getYes(), "Unable to click on Email Login button");
	}

	public void enterEmailAddress(String email) {

		enterDataIntoTextField(getXpath(), enterEmailInputField, email,
				"Entered Email Address", getNo(),
				"Unable to enter Email Address");
	}

	public void enterEmailPassword(String pass) {
		enterDataIntoTextField(getXpath(), enterEmailPassInputField, pass,
				"Entered Email Password", getNo(),
				"Unable to enter Email Password");
	}

	public void enterSearchText(String searchText) {
		enterDataIntoTextField(getXpath(), searchInpField, searchText,
				"Entered Search Text as " + searchText, getYes(),
				"Unable to enter text into search field");
	}

	public void enterUsername(String value) {
		waitUntilElementVisible(By.name(username), 20);
		enterDataIntoTextField(getName(), username, value,
				"Entered username as " + value, getNo(),
				"Unable to enter username");
	}

	public void enterUsernameWithHover(String value) {
		enterDataIntoTextFieldWithHover(getXpath(), myAccountButton, getName(),
				username, value, "Entered username as " + value, getNo(),
				"Unable to enter username");
	}

	public void enterPassword(String value) {
		enterDataIntoTextField(getName(), password, value, "Enter password as "
				+ value, getNo(), "Unable to enter password");
	}

	public void enterPasswordWithHover(String value) {
		enterDataIntoTextFieldWithHover(getXpath(), myAccountButton, getName(),
				password, value, "Entered password as " + value, getNo(),
				"Unable to enter password");
	}

	public void enterZipCode(String value) {
		boolean currLoc = displayWebElement(getXpath(), currentLocation);
		if (!currLoc) {
			enterDataIntoTextField(getXpath(), locationOverlayTextField, value,
					"Enter zip code " + value, getYes(),
					"Unable to enter zip code");
		} else {
			enterDataIntoTextField(getXpath(), locationOverlayTextFieldAftUpd,
					value, "Enter zip code " + value, getYes(),
					"Unable to enter zip code");
		}
	}

	public void enterUpdateZipCode(String value) {
		enterDataIntoTextField(getXpath(), locationOverlayTextFieldAftUpd,
				value, "Enter Invalid zip code " + value, getYes(),
				"Unable to enter another zip code");
	}

	public void clearLocationZipcodeTextField() {
		boolean currLoc = displayWebElement(getXpath(), currentLocation);
		if (!currLoc) {
			clearTextField(getXpath(), locationOverlayTextField,
					"Cleared location zip code input field", getNo(),
					"Unable to find location zip code input field");
		} else {
			clearTextField(getXpath(), locationOverlayTextFieldAftUpd,
					"Cleared location zip code input field", getNo(),
					"Unable to find location zip code input field");
		}
	}

	public void clearLocationZipcodeTextFieldAftUpdZip() {
		clearTextField(getXpath(), locationOverlayTextFieldAftUpd,
				"Cleared location zip code input field", getNo(),
				"Unable to find location zip code input field after update zip");
	}

	public void verifyHeaderLinks() {

		List<WebElement> list = getWebElements(getXpath(), headerListXpath,
				"Retrieved Header List", getNo(),
				"Unable to retrieve header list");

		if (list.size() > 0) {
			for (WebElement element : list) {
				String listText = headerList[list.indexOf(element)];
				assertValue(element.getText(), listText, listText
						+ " has been verified", getNo(), assertErrorMessage);
			}
		}
	}

	/*
	 * public void verifyLinksTitleOnPageHeader() { String yourhome =
	 * getPageText(getXpath(), yourHome, "Got your home text", getNo(),
	 * "Unable to find your home text"); String yourbusiness =
	 * getPageText(getXpath(), yourBusiness, "Got your business text", getNo(),
	 * "Unable to find your business text"); String twccentral =
	 * getPageText(getXpath(),twcCentral, "Got TWC Central text", getNo(),
	 * "Unable to find TWC Central text"); String aboutus =
	 * getPageText(getXpath(), aboutUs, "Got About Us text", getNo(),
	 * "Unable to find About US text"); String investorrelations =
	 * getPageText(getXpath(), investorRelations,"Got Investor Relations text",
	 * getNo(), "Unable to find Investor Relations text"); String career =
	 * getPageText(getXpath(), careers, "Got Careers text", getNo(),
	 * "Unable to find Careers text"); String espan = getPageText(getXpath(),
	 * espanol, "Got Español text", getNo(), "Unable to find Español text");
	 * 
	 * assertValue(yourhome,
	 * "Your Home","Verify Your Home on Page Header",getNo(),
	 * assertErrorMessage); assertValue(yourbusiness,
	 * "Your Business","Verify Your Business on Page Header",getNo()
	 * ,assertErrorMessage); assertValue(twccentral, "TWC Central",
	 * "Verify TWC Central on Page Header",getNo(), assertErrorMessage);
	 * assertValue(aboutus, "About Us",
	 * "Verify About Us on Page Header",getNo(), assertErrorMessage);
	 * assertValue(investorrelations, "Investor Relations",
	 * "Verify Investor Relations on Page Header",getNo(), assertErrorMessage);
	 * assertValue(career, "Careers", "Verify Careers on Page Header",getNo(),
	 * assertErrorMessage); assertValue(espan, "Español",
	 * "Verify Español on Page Header",getNo(), assertErrorMessage); }
	 */

	public void verifyYourHomeAsDefaultPage() {
		String previousUrl = driver.getCurrentUrl();
		clickButton(getXpath(), yourHome, "Your Home link clicked", getNo(),
				"Unable to click on You Home link");
		String currentUrl = driver.getCurrentUrl();
		assertValue(currentUrl, previousUrl,
				"Verify Your Home as a Default page", getNo(),
				assertErrorMessage);
	}

	public void verifyAboutUsPage() {
		waitUntilElementVisible("About Us", 20);
		String pageTitle = driver.getTitle();
		assertValue(pageTitle.contains("About Us"),
				"Verify About Us page by clicking the 'About Us' link",
				getNo(), assertErrorMessage);
	}

	public void verifyLoginErrorMessage() {
		
		waitUntilElementVisible(By.xpath(errorMessage), 20);
		
		String actualErrorMsg = getPageText(getXpath(), errorMessage,
				"Got actual login error message", getNo(),
				"Unable to find Login error text");
		if (actualErrorMsg.equals(loginErrorMsg1)
				|| actualErrorMsg.equals(loginErrorMsg2)) {
			assertValue(true, "Verify Login Error Message", getNo(),
					assertErrorMessage);
		} else {
			assertValue(false, "Verify Login Error Message", getNo(),
					assertErrorMessage);
		}
	}

	public void verifyZipcodeUnderLocationIcon() {
		String zip = getPageText(getXpath(), zipUnderLocationIcon,
				"Got zip code under location", getNo(),
				"Unable to find zip code under location");
		if (!zip.isEmpty()) {
			assertValue(true, "Verify Zip code under location icon", getNo(),
					assertErrorMessage);
		} else {
			assertValue(false, "Verify Zip code under location icon", getNo(),
					assertErrorMessage);
		}
	}

	public void verifyUpdatedZipcodeUnderLocationIcon() {

		boolean currLoc = displayWebElement(getXpath(), currentLocation);

		if (!currLoc) {
			clickButton(getXpath(), locationIcon, "Location Icon clicked",
					getYes(), "Unable to click on Location Icon");
		}

		String updZip = getPageText(getXpath(), zipUnderLocationIcon,
				"Got zip code under location", getNo(),
				"Unable to find zip code under location");
		String inputtedZip = getValueFromTextField(getXpath(),
				locationOverlayTextField,
				"Got inputted zip code from location input field", getNo(),
				"Unable to retrieve inputted zip code from location input field");

		assertValue(updZip, inputtedZip,
				"Verify updated zip code under location icon", getNo(),
				assertErrorMessage);
	}

	public void verifyErrorMessageOnLocationOverlay() {
		
		//waitUntilElementVisible(By.xpath(locationErrorMsg), 30);
		
		fluentWait(By.xpath(locationErrorMsg));
		wait.until(fwait).getText();
		
		String errMsg = getPageText(getXpath(), locationErrorMsg,
				"Got error message on location overlay", getNo(),
				"Unable to find error message on location overlay");
		String zip = getPageText(getXpath(), zipUnderLocationIcon,
				"Got zip code under location", getNo(),
				"Unable to find zip code under location");
		String expected = "Our services may not be available in "
				+ zip
				+ ". If this is not your ZIP Code, please enter your ZIP Code here. If it is correct, visit cablemover.com to contact the cable provider that serves your area or call 1-855-394-6832 FREE.";

		assertValue(errMsg, expected,
				"Verify error message on location overlay", getNo(),
				assertErrorMessage);

	}

	public void VerifySearchResult(String input1) {
		
		waitUntilElementVisible(By.xpath(searchResultText), 40);
		
		String searchText = getPageText(getXpath(), searchResultText,
				"Got Search text from search result", getNo(),
				"Unable to retrive Search text from search result");

		if (searchText.contains(input1)) {
			assertValue(true, "Search Result Verified", getNo(),
					assertErrorMessage);
		} else {
			assertValue(false, "Search Result Verified", getNo(),
					assertErrorMessage);
		}
	}

	public void VerifySearchErrorMessage() {
		
		waitUntilElementVisible(By.xpath(searchResultErrorText), 20);
		
		String searchErrText = getPageText(getXpath(), searchResultErrorText,
				"Got Search error text from search result", getNo(),
				"Unable to retrive Search error text from search result");
		String expected = "Your search returned no matches. Please try again or Contact Us for more help.";
		assertValue(searchErrText, expected,
				"Search Result Error Message Verified", getNo(),
				assertErrorMessage);
	}

	public void VerifyEmailErrorMessage() {

		String expected = "The email address or password is incorrect.";
		String actualResult = getPageText(getXpath(), emailErrMsg,
				"Got actual Email error message", getNo(),
				"Unable to find Email error message");
		assertValue(actualResult, expected, "Email Error Message Verified",
				getNo(), assertErrorMessage);
	}
}
