package com.nopcommerce.RegisterPage;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.nopcommerce.HomePage.HomePageObject;
import com.nopcommerce.LoginPage.LoginPageObject;
import com.nopcommerce.RegisterCompletedPage.RegisterCompletedPageObject;

import commons.BaseTest;
import commons.GlobalConstantsLoginPage;
import commons.GlobalConstantsRegisterPage;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import helpers.PropertiesHelper;
import reportConfig.ExtentTestManager;

public class Register_Page extends BaseTest {
	WebDriver driver;
	LoginPageObject login_Page;
	RegisterPageObject register_Page;
	HomePageObject home_Page; 
	RegisterCompletedPageObject register_Completed_Page;
	
	String getCurrentUrl, emailAddress, fristname, lastname, invalidPassword, invalidEmailAddress;
	Select select;

	Environment environment;

	@Parameters({ "envName", "serverName", "browser", "osName", "osVersion", "ipAddress", "portNumber" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("DEV") String serverName,
			@Optional("chrome") String browserName, @Optional("Windows") String osName,
			@Optional("10") String osVersion, @Optional("localhost") String ipAddress,
			@Optional("4444") String portNumber) {

		//driver = getBrowserDriver(envName, serverName, browserName, osName, osVersion, ipAddress, portNumber);
		driver = getDriverInstance();
		register_Page = PageGeneratorManager.getRegisterpage(driver);
		PropertiesHelper.loadAllFiles();
		emailAddress =  "edward_ecommerce" + generateNumber() + "@yopmail.com";
		invalidEmailAddress =  "test.com";
		fristname =  "Edward" + generateNumber();
		lastname =  "Vo" + generateNumber();
		invalidPassword = "123";
		PropertiesHelper.setValue("email", emailAddress);
	}
	
	@Test (groups = "Register An Account")
	public void Front_Register_An_Account_With_The_Invalid_Information(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register An Account With The Invalid Information");
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 01: Open Register Page");
		getCurrentUrl = register_Page.getPageUrl(driver);
		if(getCurrentUrl.equals(GlobalConstantsLoginPage.getGlobalConstants().getRegisterURL()))
		{
			register_Page.clickOnRegisterButton();
		}
		else {
			System.out.println("The Register URL Is Incorrect");
		}
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 02: Verify The Error Message Of The First Name Textbox");
		assertTrue(register_Page.istErrorMessageFirstnameDisplayed(GlobalConstantsRegisterPage.getGlobalConstants().getErrorMessageFirstname()));
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 03: Verify The Error Message Of The Last Name Textbox");
		assertTrue(register_Page.isErrorMessageLastnameDisplayed(GlobalConstantsRegisterPage.getGlobalConstants().getErrorMessageLasttname()));
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 04: Verify The Error Message Of The Email Textbox");
		assertTrue(register_Page.isErrorMessageEmailTextboxDisplayed(GlobalConstantsRegisterPage.getGlobalConstants().getErrorMessageEmailTextbox()));
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 05: Verify The Error Message Of The Password Textbox");
		assertTrue(register_Page.isErrorMessagePasswordTextboxDisplayed(GlobalConstantsRegisterPage.getGlobalConstants().getErrorMessagePasswordTextbox()));
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 06: Verify The Error Message Of The Confirmpassword Textbox");
		assertTrue(register_Page.isErrorMessageConfirmPasswordTextboxDisplayed(GlobalConstantsRegisterPage.getGlobalConstants().getErrorMessageConfirmPasswordTextbox()));
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 07: Register An Account With The Invalid Email");
		register_Page.inputEmailAddress(invalidEmailAddress);
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 08: Verify The Error Message Of The Email Textbox");
		assertTrue(register_Page.isErrorMessageEmailTextboxDisplayed(GlobalConstantsRegisterPage.getGlobalConstants().getErrorMessageInvalidEmail()));
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 09: Register An Account With The Password Is Less Than 6 Characters");
		register_Page.inputPassword(invalidPassword);
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 10: Verify The Error Message Of The Password Textbox");
		assertTrue(register_Page.isErrorMessagePasswordTextbox1Displayed(GlobalConstantsRegisterPage.getGlobalConstants().getErrorMessagePasswordLessThanSixChacracters1()));
		assertTrue(register_Page.isErrorMessagePasswordTextbox2Displayed(GlobalConstantsRegisterPage.getGlobalConstants().getErrorMessagePasswordLessThanSixChacracters2()));
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 11: Register An Account With The Password And The Confirm Password Don't Match");
		register_Page.inputPassword(GlobalConstantsRegisterPage.getGlobalConstants().getPassword());
		register_Page.inputConfirmPassword(invalidPassword);
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 12: Verify The Error Message Of The Confirmpassword Textbox");
		assertTrue(register_Page.isErrorMessageConfirmPasswordTextboxDisplayed(GlobalConstantsRegisterPage.getGlobalConstants().getErrorMessagePasswordDoesNotMatch()));
	}
	
	@Test (groups = "Register An Account", dependsOnMethods = "Front_Register_An_Account_With_The_Invalid_Information")
	public void Front_Register_An_Account_With_The_Valid_Information(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register An Account With The Valid Informationt");		
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 1: Input Firstname");
		register_Page.inputFirstname(fristname);
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 2: Input Lastname");
		register_Page.inputLastname(lastname);
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 3: Select Day Of Birth");
		register_Page.selectDayDropDown(GlobalConstantsRegisterPage.getGlobalConstants().getDay());
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 4: Select Month Of Birth");
		register_Page.selectMonthDropDown(GlobalConstantsRegisterPage.getGlobalConstants().getMonth());
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 5: Select Year Of Birth");
		register_Page.selectYearDropDown(GlobalConstantsRegisterPage.getGlobalConstants().getYear());
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 6: Input Emaill Doesn't Exist In The System");
		register_Page.inputEmailAddress(emailAddress);
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 7: Input Password More Than 6 Characters");
		register_Page.inputPassword(GlobalConstantsRegisterPage.getGlobalConstants().getPassword());
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 8: Input Confirm Password Match The Password");
		register_Page.inputConfirmPassword(GlobalConstantsRegisterPage.getGlobalConstants().getPassword());
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 9: Click On The Register Button");
		register_Completed_Page = register_Page.clickOnRegisterButton();
	}
	
	@Test (groups = "Register An Account", dependsOnMethods = {"Front_Register_An_Account_With_The_Invalid_Information" ,"Front_Register_An_Account_With_The_Valid_Information"})
	public void Front_Register_An_Account_With_The_Email_Has_Already_Registered(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register An Account With The Email Has Already ");
		register_Completed_Page.refeshCurrentPage(driver);
		register_Completed_Page.sleepInSecond(5);
		if(!driver.findElement(By.className("ico-login")).isDisplayed()) 
		{
			home_Page = register_Completed_Page.clickOnLogoutLink();
			register_Page = home_Page.openRegisterPage();
		}else {
			register_Page = register_Completed_Page.clickOnRegisterLink();
		}
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 1: Input Firstname");
			register_Page.inputFirstname(fristname);
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 2: Input Lastname");
			register_Page.inputLastname(lastname);
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 3: Select Day Of Birth");
			register_Page.selectDayDropDown(GlobalConstantsRegisterPage.getGlobalConstants().getDay());
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 4: Select Month Of Birth");
			register_Page.selectMonthDropDown(GlobalConstantsRegisterPage.getGlobalConstants().getMonth());
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 5: Select Year Of Birth");
			register_Page.selectYearDropDown(GlobalConstantsRegisterPage.getGlobalConstants().getYear());
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 6: Input Emaill Existed In The System");
			register_Page.inputEmailAddress(emailAddress);
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 7: Input Password More Than 6 Characters");
			register_Page.inputPassword(GlobalConstantsRegisterPage.getGlobalConstants().getPassword());
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 8: Input Confirm Password Match The Password");
			register_Page.inputConfirmPassword(GlobalConstantsRegisterPage.getGlobalConstants().getPassword());
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 9: Click On The Register Button");
			register_Page.clickOnRegisterButton();
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 10: Verify The Error Message when Registering An Account With The Email Existed");
			assertTrue(register_Page.isErrorMessageEmailAlreadyExist(GlobalConstantsRegisterPage.getGlobalConstants().getErrorMessageEmailAlreadyExist()));
	}

}

