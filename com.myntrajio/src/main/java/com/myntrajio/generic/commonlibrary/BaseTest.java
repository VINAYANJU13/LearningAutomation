package com.myntrajio.generic.commonlibrary;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest extends ObjectLibrary {

	@BeforeMethod
	public void login() {
		Reporter.log("Login Sucessful", true);
	}

	@AfterMethod
	public void Logout() {
		Reporter.log("Logout Sucessful", true);

	}

	@Parameters("browser")
	@BeforeClass
	public void browsersetup(String bname) {

		// Create an Test Report
		test = report.createTest("registerValidData");
		test = report.createTest("vaildRegisterButtonSize");
		test = report.createTest("vaildRegisterButtonColor");
		test = report.createTest("vaildRegisterButtonPostion");



		// Create Object For All Library
		createObject();

		// Step 1:Launch the Browser
		webdriverlibrary.launchBrowser(bname);

		// Fetch URL Data from property-File
		String URL = propertyfilelibrary.readData("url");

		// Step2:Maximize the Browser
		webdriverlibrary.maximizeBrowser();

		// Step2:Navigate to the Application via URL
		webdriverlibrary.navigateToApp(URL);

		Reporter.log("BrowserSetup: " + bname + " Sucessful", true);

	}

	@AfterClass
	public void closebrowser() {
		// Close the browser
		webdriverlibrary.closeWindow();
		Reporter.log("Close browser sucessfully", true);
	}

	@BeforeTest
	public void precondition() {
		// Create an object for all library
		createObject();

		// Configure SparkReport Information
		spark.config().setDocumentTitle("Regression Testing for the RegisterPage");
		spark.config().setReportName("RegressionSuite");
		spark.config().setTheme(Theme.DARK);

		// Attach the Spark Report and ExtentReport
		report.attachReporter(spark);

		// Configure the System Information in Extent Report
		report.setSystemInfo("DeviceName", "Vinay");
		report.setSystemInfo("OS", "WINDOWS 11");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("BrowserVersion", "Chrome -- 128.0.6613.138");

		Reporter.log("precondition Done Sucessful", true);
	}

	@AfterTest
	public void postcondition() {
		// Flush the report information
		report.flush();
		Reporter.log("postcondition Done Sucessful", true);
	}

	@BeforeSuite
	public void getSuiteConnections() {
		Reporter.log("Get SuiteConnections Done Sucessful", true);
	}

	@AfterSuite
	public void terminateSuiteconnection() {
		Reporter.log("Terminate Suiteconnection Done Sucessful", true);

	}
}
