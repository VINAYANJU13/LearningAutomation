package TestDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LearningAdvanceReport {
	public static void main(String[] args) {
		// Create Object for SparkReport
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report.html");

		// Configure the SParkReport information
		spark.config().setDocumentTitle("Regression Testing for the RegisterPage");
		spark.config().setReportName("RegressionSuite");
		spark.config().setTheme(Theme.DARK);

		// Create tje Spark Report
		ExtentReports report = new ExtentReports();
		// Attach the Spark Report and ExtentReport
		report.attachReporter(spark);
		// Configure the System information in Extent Report by Attaching
		report.attachReporter(spark);
		report.setSystemInfo("DeviceName", "Vinay");
		report.setSystemInfo("OS", "WINDOWS 11");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("BrowserVersion", "Chrome -- 128.0.6613.85");

		// Create the test info
		ExtentTest test = report.createTest("Regressiontest");

		// Steps Information
		test.log(Status.INFO, "Step 1 : Launching the Browser Sucessfull");
		test.log(Status.INFO, "Step 2 : Navigating to application via URL Sucessfull");
		test.log(Status.PASS, "Step 3 : Verified the WebPage Sucessfull");
		if (true == true) {
			test.log(Status.PASS, "Step 4 : Verified the WebElement Sucessfull");
		} else {
			test.log(Status.SKIP, "Step 4 : WebElement is not Diplayed ");
		}
		test.log(Status.SKIP, "Step  : WebElement is Hidden ");

		// Flush the Report Information
		report.flush();
		System.out.println("Execution Done");

	}
}
