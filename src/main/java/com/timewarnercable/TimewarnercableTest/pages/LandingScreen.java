package com.timewarnercable.TimewarnercableTest.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.timewarnercable.TimewarnercableTest.utilities.BasePage;

public class LandingScreen extends BasePage {

	private static WebDriver driver = null;

	// Attribute of locator
	//For First Test Case
	private String yourHome = "//div[@class='section list']/ul/li[1]//a";
	private String aboutUs = "//div[@class='section list']/ul/li[4]//a";
	private String headerListXpath = "//div[@class='section list']/ul/li";
	private String[] headerList = { "Your Home", "Your Business",
			"TWC Central", "About Us", "Investor Relations", "Careers",
			"Español" };
	
	//For Second Test Case Without Hover and With Hover
	private String myAccountButton = "//div[@class='twc-new-nav list']/ul/li[4]//a";
	private String username = "username";
	private String password = "password";
	private String signInButton = "//button[@class='sign-in-btn mys-btn']";
	private String signInWithHover = "form_submit";
	private String errorMessage = "//div[@class='message']";
	private String loginErrorMsg1 = "Sorry, that username and password combination does not exist. Would you like to try again?";
	private String loginErrorMsg2 = "Sorry, we are still unable to validate that username and password combination. If you're not sure of your username or password, you can recover them below.";
	
	//For Third Test Case
	private String locationIcon = "//div[@class='newIcons horizontal list']/descendant::div[4]/a/span[1]";
	private String zipUnderLocationIcon = "//div[@class='newIcons horizontal list']/descendant::div[4]/a/span[2]";
	private String inputLocUpd = "//div[@class='twc-search-input-wrap']/input[contains(@placeholder,'Update')]";
	private String inputLocReEnt = "//div[@class='twc-search-input-wrap']/input[contains(@placeholder,'Re-Enter')]";
	private String customerLoc = "//div[@class='twc-customerLocation']";
	private String partialGoButton = "/following-sibling::div/button";
	private String locationErrorMsg = "//div[@class='parsys oof-error-content']/self::div//p[2]";
	private String inputType = "input";
	private String buttonType = "button";
	
	//For Fourth Test Case
	private String searchButton = "//div[@class='section newHeaderIcons']/descendant::li[5]//a";
	private String searchInpField = "//div[@class='message-box']/descendant::input[4]";
	private String searchGoButton = "//div[@class='message-box']/descendant::button[4]";
	private String searchResultText = "//div[@class='results searchResults']/span";
	private String searchResultErrorText = "//div[@class='noResultsText']/p";
	
	//For Fifth Test Case
	private String emailIcon = "//div[@class='section newHeaderIcons']/descendant::li[3]//a";
	private String enterEmailInputField = "//table[@class='mainPanelInBodyTableFormatting']/descendant::td[@class='mainPanelComposeMailPadding3'][1]/input";
	private String enterEmailPassInputField = "//table[@class='mainPanelInBodyTableFormatting']/descendant::td[@class='mainPanelComposeMailPadding3'][2]/input";
	private String emailLogin = "//input[@id='loginButton']";
	private String emailErrMsg = "//div[@class='webmailErrorInfoTxt']";
	
	//Other
	private String assertErrorMessage = "ActualResult and Expected did not match";
	

	public LandingScreen(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAboutUs() {
		clickButton(getXpath(), aboutUs, "Click on about us link", getNo(),
				"Unable to click on About Us link");
		waitForPageLoad(10);
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
		
		if(!(displayWebElement(getXpath(), customerLoc))){
			clickButton(getXpath(), locationIcon, "Click on location icon",
					getYes(), "Unable to click on Location Icon");
			}			
	}

	public void clickOnGoButton() {
		
		String clickGo = selectLocationInput(buttonType);
		clickButton(getXpath(), clickGo, "Click on GO button",
				getYes(), "Unable click on Go button");
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
			
		String entLacation = selectLocationInput(inputType);
		enterDataIntoTextField(getXpath(), entLacation,
				value, "Enter zip code " + value, getYes(),
				"Unable to enter zip code");
	}

	

	public void clearLocationZipcodeTextField() {	
		
		String locationInput = selectLocationInput(inputType);
		clearTextField(getXpath(), locationInput,
				"Cleared location zip code input field", getNo(),
				"Unable to find location zip code input field");
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
			assertValue(true, "Verify Zip code "+zip+" under location icon", getNo(),
					assertErrorMessage);
		} else {
			assertValue(false, "Verify Zip code "+zip+" under location icon", getNo(),
					assertErrorMessage);
		}
	}

	public void verifyUpdatedZipcodeUnderLocationIcon() {
		
		implicitWait(10);
		
		if(!(displayWebElement(getXpath(), customerLoc))){
			clickButton(getXpath(), locationIcon, "Click on location icon",
					getYes(), "Unable to click on Location Icon");
			}
		
		String locationInput = selectLocationInput(inputType);
				
		String updZip = getPageText(getXpath(), zipUnderLocationIcon,
				"Got zip code under location", getNo(),
				"Unable to find zip code under location");
		System.out.println(updZip);
		String inputtedZip = getValueFromTextField(getXpath(),
				locationInput,
				"Got inputted zip code from location input field", getNo(),
				"Unable to retrieve inputted zip code from location input field");

		System.out.println(inputtedZip);
		assertValue(updZip, inputtedZip,
				"Verify updated zip code "+updZip+" under location icon", getNo(),
				assertErrorMessage);
		
	}

	public void verifyErrorMessageOnLocationOverlay() {
				
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
	
	
	public String selectLocationInput(String xpathType){
				
			if(displayWebElement(getXpath(), locationErrorMsg)){
				if(xpathType.equalsIgnoreCase("input")){
					return inputLocReEnt;
				}else if(xpathType.equalsIgnoreCase("button")){
					return inputLocReEnt+partialGoButton;
				}else{
					return null;
				}
			}else{
				if(xpathType.equalsIgnoreCase("input")){
					return inputLocUpd;
				}else if(xpathType.equalsIgnoreCase("button")){
					return inputLocUpd+partialGoButton;
				}else{
					return null;
				}
			}
		
		
	}
	
}
