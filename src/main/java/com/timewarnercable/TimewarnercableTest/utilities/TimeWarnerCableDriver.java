package com.timewarnercable.TimewarnercableTest.utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.timewarnercable.TimewarnercableTest.pages.LandingScreen;

public abstract class TimeWarnerCableDriver {

	public static WebDriver driver = null;
	public static String timewarnercable = "https://www.timewarnercable.com";
	public static ExtentReports extentReport = null;
	public static ExtentTest extentTest = null;
	private File locaFilePath = new File("screenshot").getAbsoluteFile();
	private String parentWindow = null;
	private Set<String> listOfWindows = null;

	@BeforeSuite
	public void setUp() {

		getInstance();
		//driver = new FirefoxDriver();
		
		ReadConfigFile file = new ReadConfigFile();
		
		if("firefox".equalsIgnoreCase(file.getBrowser())){
			driver = new FirefoxDriver();
		}else if("chrome".equalsIgnoreCase(file.getBrowser())) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			System.setProperty("webdriver.chrome.driver", new File("chromedriver32").getAbsolutePath()+"/chromedriver.exe");
			driver = new ChromeDriver(options);
		}else if("safari".equalsIgnoreCase(file.getBrowser())) {
			driver = new SafariDriver();
		}else if("ie".equalsIgnoreCase(file.getBrowser())) {
			System.setProperty("webdriver.ie.driver", new File("IEDriverServer_x64").getAbsolutePath()+"/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else {
			driver = new HtmlUnitDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		navigateToLandingPage();
	}

	@AfterMethod(enabled = true)
	public void handleScreenShot(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			String screenShot_path = captureScreenShot(driver, result.getName());
			String image = extentTest.addScreenCapture(screenShot_path);
			extentTest.log(LogStatus.FAIL,
					"Failed Method name : " + result.getName(), image);
			extentReport.endTest(extentTest);
		}

		extentReport.flush();
	}

	public void navigateToHome() {
		navigateToLandingPage();
	}

	public void navigateTo(String url){
		driver.navigate().to(url);
	}
	
	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		// extentReport.flush();
		extentReport.close();
		driver.close();
	}

	public void navigateToLandingPage() {
		driver.navigate().to(timewarnercable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	private ExtentReports getInstance() {

		extentReport = new ExtentReports("Extent_Reports/textExtent.html", true);
		extentReport.config().documentTitle("Automation Report")
				.reportName("Regression Result")
				.reportHeadline("Report for built #101");
		return extentReport;
	}

	public static ExtentTest startTest(String testName, String testGroup){
		extentTest = extentReport.startTest(testName).assignCategory(testGroup);
		return extentTest;
	}
	
	public static void endTestWithPassStatus(String message){
		extentTest.log(LogStatus.PASS, message);
		extentReport.endTest(extentTest);
	}

	public static void getPass(String message){
		extentTest.log(LogStatus.PASS, message);
	}
	
	public static void getWarning(String message){
		extentTest.log(LogStatus.WARNING, message);
	}
	
	public static void getFail(String message){
		extentTest.log(LogStatus.FAIL, message);
	}
	
	public static void getInfo(String info){
		extentTest.log(LogStatus.INFO, info);
	}
	
	public String captureScreenShot(WebDriver driver, String screenShotName) {

		try {
			TakesScreenshot screenShot = (TakesScreenshot) driver;
			File source = screenShot.getScreenshotAs(OutputType.FILE);
			String dest = locaFilePath + "/" + screenShotName + ".png";
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot Taken");
			return dest;
		} catch (IOException e) {
			System.out.println("Exception while taking Screenshot "
					+ e.getMessage());
			return e.getMessage();
		}
	}

	public static WebElement getElement(String locator,
			String attributeOfLocator) {

		if (locator.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(attributeOfLocator));
		} else if (locator.equalsIgnoreCase("className")) {
			return driver.findElement(By.className(attributeOfLocator));
		} else if (locator.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(attributeOfLocator));
		} else if (locator.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(attributeOfLocator));
		} else if (locator.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(attributeOfLocator));
		} else
			throw new NoSuchElementException("No Such Element"
					+ attributeOfLocator);
	}
	
	public static List<WebElement> getElements(String locator,
			String attributeOfLocator) {

		if (locator.equalsIgnoreCase("id")) {
			return driver.findElements(By.id(attributeOfLocator));
		} else if (locator.equalsIgnoreCase("className")) {
			return driver.findElements(By.className(attributeOfLocator));
		} else if (locator.equalsIgnoreCase("name")) {
			return driver.findElements(By.name(attributeOfLocator));
		} else if (locator.equalsIgnoreCase("xpath")) {
			return driver.findElements(By.xpath(attributeOfLocator));
		} else if (locator.equalsIgnoreCase("css")) {
			return driver.findElements(By.cssSelector(attributeOfLocator));
		} else
			throw new NoSuchElementException("No Such Element"
					+ attributeOfLocator);
	}
	
		
	public void switchToChildWindow(){
		
		parentWindow = driver.getWindowHandle();
		listOfWindows = driver.getWindowHandles();
		for(String browserWindow : listOfWindows){
			if(!browserWindow.equals(parentWindow)){
				driver.switchTo().window(browserWindow);
				break;
			}
		}
		
	}
	
	public void switchToParentWindowAndCloseChildWindow(){
		listOfWindows = null;
		listOfWindows = driver.getWindowHandles();
		for(String browserWindow : listOfWindows){
			if(!browserWindow.equals(parentWindow)){
				driver.switchTo().window(browserWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}
	
	
	
	public LandingScreen landingScreen() {

		LandingScreen landingScreen = new LandingScreen(driver);
		return landingScreen;

	}
}