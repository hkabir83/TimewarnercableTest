package com.timewarnercable.TimewarnercableTest;

import org.testng.annotations.Test;

import com.timewarnercable.TimewarnercableTest.utilities.TimeWarnerCableDriver;

public class TS001_TC005_ValidateInvalidEmailLogin extends TimeWarnerCableDriver{
	
	/*
	 * Validate Invalid Email Login
	 */
	
	private String testName = "Validate Invalid Email Login";
	private String category = "RegressionGroup";
	private String email = "technosoft@gmail.com";
	private String password = "test1234";
	

	@Test(description = "Validate Invalid Email Login")
	public void InvalidEmailLogin(){
		
		startTest(testName, category);
		navigateToHome();
		landingScreen().clickOnEmailIcon();
		switchToChildWindow();
		landingScreen().enterEmailAddress(email);
		landingScreen().enterEmailPassword(password);
		landingScreen().clickOnEmilLoginButton();
		landingScreen().VerifyEmailErrorMessage();
		endTestWithPassStatus(testName);
		switchToParentWindowAndCloseChildWindow();
	}
}
