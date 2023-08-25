package com.nopcommerce.RegisterPage;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
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
		emailAddress =  "edward_ecommerce" + generateNumber() + "@yopmail.com";
		invalidEmailAddress =  "test.com";
		fristname =  "Edward" + generateNumber();
		lastname =  "Vo" + generateNumber();
		invalidPassword = "123";
		
	}
	
	@Test
	public void Front_Open_Login_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Open Home Page");
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 01: Register An Account Without Inputting Data");
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
		
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 13: Register An Account With The Valid Information");
			register_Page.inputFirstname(fristname);
			register_Page.inputLastname(lastname);
			register_Page.selectDayDropDown(GlobalConstantsRegisterPage.getGlobalConstants().getDay());
			register_Page.selectMonthDropDown(GlobalConstantsRegisterPage.getGlobalConstants().getMonth());
			register_Page.selectYearDropDown(GlobalConstantsRegisterPage.getGlobalConstants().getYear());
			register_Page.inputEmailAddress(emailAddress);
			register_Page.inputPassword(GlobalConstantsRegisterPage.getGlobalConstants().getPassword());
			register_Page.inputConfirmPassword(GlobalConstantsRegisterPage.getGlobalConstants().getPassword());
			register_Completed_Page = register_Page.clickOnRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 15: Register An Account With The Email Existed");
			register_Page = register_Completed_Page.clickOnRegisterLink();
			register_Page.inputFirstname(fristname);
			register_Page.inputLastname(lastname);
			register_Page.selectDayDropDown(GlobalConstantsRegisterPage.getGlobalConstants().getDay());
			register_Page.selectMonthDropDown(GlobalConstantsRegisterPage.getGlobalConstants().getMonth());
			register_Page.selectYearDropDown(GlobalConstantsRegisterPage.getGlobalConstants().getYear());
			register_Page.inputEmailAddress(emailAddress);
			register_Page.inputPassword(GlobalConstantsRegisterPage.getGlobalConstants().getPassword());
			register_Page.inputConfirmPassword(GlobalConstantsRegisterPage.getGlobalConstants().getPassword());
			register_Page.clickOnRegisterButton();
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 16: Verify The Error Message when Registering An Account With The Email Existed");
			assertTrue(register_Page.isErrorMessageEmailAlreadyExist(GlobalConstantsRegisterPage.getGlobalConstants().getErrorMessageEmailAlreadyExist()));
	}
	
	@Parameters({"browser"})
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		ExtentTestManager.getTest().log(Status.INFO, "Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}
}

