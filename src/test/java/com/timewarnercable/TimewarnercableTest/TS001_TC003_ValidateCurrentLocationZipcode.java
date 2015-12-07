package com.timewarnercable.TimewarnercableTest;

import org.testng.annotations.Test;

import com.timewarnercable.TimewarnercableTest.utilities.TimeWarnerCableDriver;

public class TS001_TC003_ValidateCurrentLocationZipcode extends TimeWarnerCableDriver{

	/*Validate Current Location Zip Code
	 * 
	 */
	
	private String testName = "Validate Current Location Zipcode";
	private String category = "RegressionGroup";
	private String testZip = "10007";
	private String invalidTestZip = "32432";
	
	
	@Test(description = "Validate Current Location Zipcode")
	public void validateCurrentLocation(){
		
		startTest(testName, category);
		navigateToHome();
		//landingScreen().clickOnLocationIcon();
		landingScreen().verifyZipcodeUnderLocationIcon();		
		landingScreen().clickOnLocationIcon();	
		landingScreen().clearLocationZipcodeTextField();
		landingScreen().enterZipCode(testZip);		
		landingScreen().clickOnGoButton();			
		landingScreen().verifyUpdatedZipcodeUnderLocationIcon();		
		landingScreen().clickOnLocationIcon();		
		landingScreen().clearLocationZipcodeTextFieldAftUpdZip();
		landingScreen().enterUpdateZipCode(invalidTestZip);		
		landingScreen().clickOnGoButtonAftUpdZip();		
		landingScreen().verifyErrorMessageOnLocationOverlay();
		endTestWithPassStatus(testName);
		
	}
}
