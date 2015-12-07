package com.timewarnercable.TimewarnercableTest;

import org.testng.annotations.Test;

import com.timewarnercable.TimewarnercableTest.utilities.TimeWarnerCableDriver;

public class TS001_TC002_VerifyInvalidLoginWithHover extends TimeWarnerCableDriver{
	
	private String testName = "Verify Invalid Login and Error Message with Hover";
	private String category = "RegressionGroup";
	private String username = "technosoft@gmail.com";
	private String password = "test1234";
	
	@Test(description = "Verify Invalid Login With Hover")
	public void VerifyInvalidLoginWithHover(){
		
		startTest(testName, category);
		landingScreen().enterUsernameWithHover(username);
		landingScreen().enterPasswordWithHover(password);
		landingScreen().clickOnSignInButtonWithHover();
		landingScreen().verifyLoginErrorMessage();
		endTestWithPassStatus(testName);
		
	}

}
