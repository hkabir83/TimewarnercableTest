package com.timewarnercable.TimewarnercableTest;

import org.testng.annotations.Test;

import com.timewarnercable.TimewarnercableTest.utilities.TimeWarnerCableDriver;

public class TS001_TC004_ValidateSearchFunctionality extends TimeWarnerCableDriver{
	
	/*
	 * Validate Search Functionality by clicking Search Icon
	 */

	private String testName = "Validate Search Functionality";
	private String category = "RegressionGroup";
	private String searchText1 = "Cable";
	private String searchText2 = "xwert";
	
	
	@Test(description ="Validate Search Functionality")
	public void validateSearch(){
		
		startTest(testName, category);
		landingScreen().clickOnSearchIcon();
		landingScreen().enterSearchText(searchText1);
		landingScreen().clickOnSearchGOButton();
		landingScreen().VerifySearchResult(searchText1);
		landingScreen().clickOnSearchIcon();
		landingScreen().enterSearchText(searchText2);
		landingScreen().clickOnSearchGOButton();
		landingScreen().VerifySearchErrorMessage();
		endTestWithPassStatus(testName);
		
	}
	
}
