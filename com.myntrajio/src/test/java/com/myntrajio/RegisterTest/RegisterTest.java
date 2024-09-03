package com.myntrajio.RegisterTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.myntrajio.generic.PageRepository.RegisterPage;
import com.myntrajio.generic.commonlibrary.BaseTest;

public class RegisterTest extends BaseTest {
	@Test
	public void registerValidData() {

		String name = excellibrary.readData("Registerdetails", 1, 0);
		String email = excellibrary.readData("Registerdetails", 1, 1);
		String Password = excellibrary.readData("Registerdetails", 1, 2);
		String mobileno = excellibrary.readData("Registerdetails", 1, 3);
		String feedback = excellibrary.readData("Registerdetails", 1, 5);

		// Waiting Statement
		javaLibrary.pause(5000);

		// Provide implicitly wait
		webdriverlibrary.waitUntilElementFound();
		String exptitle = "LearningSelenium";
		String acttitle = webdriverlibrary.driver.getTitle();

		// Step 1 :: Verify the RegisterPage
		Assert.assertEquals(exptitle, acttitle, "Verified Register Page");

		// Step 3 :: Creating an Object for Register Page
		RegisterPage regpage = new RegisterPage(webdriverlibrary.driver);
		boolean elementExpCondtion = true;
		boolean elementActCondtion = regpage.getNametextfield().isDisplayed();

		// Step 4 :: Verify the element
		Assert.assertEquals(elementExpCondtion, elementActCondtion,
				"Verified name textfield webelement - it  is displayed");

		// Step 5 :: Perform Action -- Clear
		regpage.getNametextfield().clear();

		// Step 6 :: Perform Action -- enter Name text field
		regpage.getNametextfield().sendKeys(name);

		// Step 7 :: Perform Action -- Enter Email text field
		regpage.getEmailtextfield().sendKeys(email);

		// Step 8 :: Perform Action-- Enter PassWord text field
		regpage.getPasswordtextfield().sendKeys(Password);

		// Step 9 :: Perform Action-- Enter mobile text field
		regpage.getMobiletextfield().sendKeys(mobileno);

		// Step 9 :: Perform Action-- Enter mobile text field
		regpage.getFeedbacktextfield().sendKeys(feedback);

		Reporter.log("Register with valid Data Sucess", true);
	}
}
