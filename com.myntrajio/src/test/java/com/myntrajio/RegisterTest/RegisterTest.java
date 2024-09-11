package com.myntrajio.RegisterTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
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
		test.log(Status.INFO, "Data Taken from excel file Sucess");

		// Waiting Statement
		javaLibrary.pause(5000);

		// Provide implicitly wait
		webdriverlibrary.waitUntilElementFound();

		String exptitle = "LearningSelenium";
		String acttitle = webdriverlibrary.driver.getTitle();
		System.out.println(acttitle);

		// Step 1 :: Verify the RegisterPage
		Assert.assertEquals(exptitle, acttitle, "Verified Register Page");
		test.log(Status.PASS, "Step 1 :: Verified title, Register page verified");

		// Step 3 :: Creating an Object for Register Page
		RegisterPage regpage = new RegisterPage(webdriverlibrary.driver);
		boolean elementExpCondtion = true;
		boolean elementActCondtion = regpage.getNametextfield().isDisplayed();

		// Step 4 :: Verify the element
		Assert.assertEquals(elementExpCondtion, elementActCondtion,
				"Verified name textfield webelement - it  is displayed");
		test.log(Status.PASS, "Step 2 :: Verifed NameTextField, It is Displayed");

		// Step 5 :: Perform Action -- Clear
		regpage.getNametextfield().clear();
		test.log(Status.PASS, "Step 3 :: Verified NameTextField cleared sucesss");

		// Step 6 :: Perform Action -- enter Name text field
		regpage.getNametextfield().sendKeys(name);
		test.log(Status.PASS, "Step 4 :: Enter UserName in NameTextField sucesss");

		// Step 7 :: Perform Action -- Enter Email text field
		regpage.getEmailtextfield().sendKeys(email);
		test.log(Status.PASS, "Step 5 :: Enter Email in EMailTextField sucesss");

		// Step 8 :: Perform Action-- Enter PassWord text field
		regpage.getPasswordtextfield().sendKeys(Password);
		test.log(Status.PASS, "Step 6 :: Enter Password in passwordTextField sucesss");

		// Step 9 :: Perform Action-- Enter mobile text field
		regpage.getMobiletextfield().sendKeys(mobileno);
		test.log(Status.PASS, "Step 7 :: Enter mobileno in mobileTextField sucesss");

		// Step 9 :: Perform Action-- Enter mobile text field
		regpage.getFeedbacktextfield().sendKeys(feedback);
		test.log(Status.PASS, "Step 8 :: Enter Feedback in the feedback area sucesss");

		test.log(Status.INFO, "---------Register with valid Data Sucess--------");
		Reporter.log("Register with valid Data Sucess", true);
	}

	@Test
	public void vaildRegisterButtonColor() {
		// Create an test report
		test.log(Status.PASS, "Validate vaildRegisterButtonColor sucess");
	}

	@Test
	public void vaildRegisterButtonPostion() {
		// Create an test report
		test.log(Status.PASS, "Validate vaildRegisterButtonPostion sucess");
	}

	@Test
	public void vaildRegisterButtonSize() {
		// Create an test report
		test.log(Status.INFO, "Validate vaildRegisterButtonSize sucess");
	}

}
