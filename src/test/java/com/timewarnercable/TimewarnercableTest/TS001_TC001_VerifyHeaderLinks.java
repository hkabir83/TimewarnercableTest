package com.timewarnercable.TimewarnercableTest;

import org.testng.annotations.Test;

import com.timewarnercable.TimewarnercableTest.utilities.TimeWarnerCableDriver;

public class TS001_TC001_VerifyHeaderLinks extends TimeWarnerCableDriver{
	
	/* Verify Header links of the www.timewarnercable.com
	 * 
	 */

	private String testName = "Verify and validate the header links";
	private String category = "RegressionGroup";
	private String passMsg = "Navigate to Home Page";
	
	
	@Test(description = "verify all header links")
	public void varifyHeader(){
		
		startTest(testName, category);
		landingScreen().verifyHeaderLinks();
		landingScreen().verifyYourHomeAsDefaultPage();
		landingScreen().clickOnAboutUs();
		landingScreen().verifyAboutUsPage();
		navigateToHome();
		getPass(passMsg);
		endTestWithPassStatus(testName);
	}
}
