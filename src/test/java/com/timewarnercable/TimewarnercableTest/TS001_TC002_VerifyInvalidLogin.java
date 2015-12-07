package com.timewarnercable.TimewarnercableTest;

import org.testng.annotations.Test;

import com.timewarnercable.TimewarnercableTest.utilities.TimeWarnerCableDriver;

public class TS001_TC002_VerifyInvalidLogin extends TimeWarnerCableDriver{
	
	/* Verify Invalid Login and Error Message
	 * username - Technosoft
	 * password - Test1233
	 */
	
	private String testName = "Verify Invalid Login and error message";
	private String category = "RegressionGroup";
	private String username = "technosoft@gmail.com";
	private String password = "test1234";
	

	@Test(description="Verify and Validate Invalid Login and error message")
	public void verifyInvalidLogin(){
		
		startTest(testName, category);
		landingScreen().clickOnMyAccountButton();		
		landingScreen().enterUsername(username);		
		landingScreen().enterPassword(password);	
		landingScreen().clickOnSignInButton();	
		landingScreen().verifyLoginErrorMessage();
		endTestWithPassStatus(testName);	
	}
	
}
