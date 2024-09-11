package com.myntrajio.generic.commonlibrary;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.myntrajio.generic.excellibrary.ReadExcelFile;
import com.myntrajio.generic.javalibrary.JavaLibrary;
import com.myntrajio.generic.propertyfilelibrary.ReadPropertyFileLibrary;
import com.myntrajio.generic.webdriverlibrary.WebDriverlibrary;

public class ObjectLibrary implements FrameworkConstant{
	public ReadExcelFile excellibrary;
	public ReadPropertyFileLibrary propertyfilelibrary;
	public JavaLibrary javaLibrary;
	public WebDriverlibrary webdriverlibrary;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;

	public void createObject() {
		excellibrary = new ReadExcelFile();
		javaLibrary = new JavaLibrary();
		propertyfilelibrary = new ReadPropertyFileLibrary();
		webdriverlibrary = new WebDriverlibrary();
		
		//Create an object for SparkReport
		spark = new ExtentSparkReporter(reportpath);
		
		//Create an object for Extent report
		report = new ExtentReports();
	}
}
