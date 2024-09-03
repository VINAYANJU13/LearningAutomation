package com.myntrajio.generic.webdriverlibrary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.myntrajio.generic.commonlibrary.FrameworkConstant;

public class WebDriverlibrary implements FrameworkConstant {
	
	public WebDriver driver;
	public WebDriver static_driver;
	public Actions action;
	public Select select;

	/**
	 * This method launches specified browser
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver launchBrowser(String browser) {
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			static_driver = driver;
			break;
		case "firefox":
			driver = new FirefoxDriver();
			static_driver = driver;
			break;
		case "edge":
			driver = new EdgeDriver();
			static_driver = driver;
			break;
		default:
			System.out.println("Invalid browser info");
		}
		return driver;
	}

	/**
	 * This method maximizes the browser
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to navigate to the application
	 * 
	 * @param url
	 */
	public void navigateToApp(String url) {
		driver.get(url);
	}

	/**
	 * This method waits until element or elements is found
	 */
	public void waitUntilElementFound() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitduration));
	}

	/**
	 * This method is used to close current tab or window
	 */
	public void closeWindow() {
		driver.close();
	}

	/**
	 * This method is used to close all the opened tabs or windows
	 */
	public void quitAllWindows() {
		driver.quit();
	}

}