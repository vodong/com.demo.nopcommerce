package com.nopcommerce.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.nopcommerce.RegisterPage.RegisterPageObject;

import commons.BaseTest;
import commons.GlobalConstantsLoginPage;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import helpers.PropertiesHelper;
import reportConfig.ExtentTestManager;

public class Login_Page extends BaseTest {
	WebDriver driver;
	LoginPageObject login_Page;
	RegisterPageObject register_Page;
	String getCurrentUrl;
	String emailAddress, password;

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
		emailAddress = PropertiesHelper.getValue("email");
		password = PropertiesHelper.getValue("password");
	}
	
	@Test (groups = "Login Account")
	public void Front_Open_Login_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Open Login Page");
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 01: Open Login Page");
		login_Page = register_Page.clickOnLoginLinkOnHeader();
	}
	
	@Test (groups = "Login Account", dependsOnMethods = "Front_Open_Login_Page")
	public void Front_Login_Without_Inputting(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login Without Inputting Information");
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 01: Click On The Login Button");
		login_Page.clickOnLoginButton();
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 02: Verify Error Message Of The Email Textbox");
		assertEquals(login_Page.getErrorMessage(driver), GlobalConstantsLoginPage.getGlobalConstants().getErrorMessageEmptyData());
	}
	
	@Test (groups = "Login Account", dependsOnMethods = "Front_Login_Without_Inputting")
	public void Front_Login_With_The_Invalid_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login With The Invalid Email");
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 01: Input Email Address Does Not Exist");
		login_Page.inputEmailAddress(GlobalConstantsLoginPage.getGlobalConstants().getInvalidEmailFormat());
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 02: Click On The Login Button");
		login_Page.clickOnLoginButton();
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 03: Verify Error Message Of The Email Textbox");
		assertEquals(login_Page.getErrorMessage(driver), GlobalConstantsLoginPage.getGlobalConstants().getErrorMessageInvalidEmail());
	}
	
	@Test (groups = "Login Account", dependsOnMethods = "Front_Login_With_The_Invalid_Email")
	public void Front_Login_With_The_Email_Does_Not_Exist(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login With The Email Does Not Exist");
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 02: Input Email Address Does Not Exist");
		login_Page.inputEmailAddress(GlobalConstantsLoginPage.getGlobalConstants().getEmailDoesNotExist());
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 03: Click On The Login Button");
		login_Page.clickOnLoginButton();
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 04: Verify Error Message When Email Does Not Exist In The System");
		assertTrue(login_Page.isErrorMessageInvalidEmailLine1Displayed(GlobalConstantsLoginPage.getGlobalConstants().getErrorMessageInvalidData1()));
		assertTrue(login_Page.isErrorMessageInvalidEmailLine2Displayed(GlobalConstantsLoginPage.getGlobalConstants().getErrorMessageInvalidData2()));
	}
	
	@Test (groups = "Login Account", dependsOnMethods = "Front_Login_With_The_Email_Does_Not_Exist")
	public void Front_Login_Email_Without_Inputting_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login Account Without Inputting Password");
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 01: Input Email Address Existed");
		login_Page.inputEmailAddress(emailAddress);
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 02: Click On The Login Button");
		login_Page.clickOnLoginButton();
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 03: Verify Error Message Of The Email Textbox");
		assertTrue(login_Page.isErrorMessageInvalidEmailLine1Displayed(GlobalConstantsLoginPage.getGlobalConstants().getErrorMessageInvalidData1()));
		assertTrue(login_Page.isErrorMessageInvalidEmailLine2Displayed(GlobalConstantsLoginPage.getGlobalConstants().getErrorMessageInvalidData2()));
	}
	
	@Test (groups = "Login Account", dependsOnMethods = "Front_Login_Email_Without_Inputting_Password")
	public void Front_Login_Email_And_Input_Invalid_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login Account With The Invalid Password");
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 01: Input Email Address Existed");
		login_Page.inputEmailAddress(emailAddress);
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 02: Input Incorrect Password");
		login_Page.inputPassword(GlobalConstantsLoginPage.getGlobalConstants().getInvalidPassword());
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 03: Click On The Login Button");
		login_Page.clickOnLoginButton();
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 04: Verify Error Message Of The Email Textbox");
		assertTrue(login_Page.isErrorMessageInvalidEmailLine1Displayed("test"));
		assertTrue(login_Page.isErrorMessageInvalidEmailLine2Displayed("test"));
	}
	
	@Test (groups = "Login Account", dependsOnMethods = "Front_Login_Email_And_Input_Invalid_Password")
	public void Front_Login_Success(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login Account And Valid Password");
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 01: Input Email Address Existed");
		login_Page.inputEmailAddress(emailAddress);
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 02: Input Valid Password");
		login_Page.inputPassword(password);
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 03: Click On The Login Button");
		login_Page.clickOnLoginButton();
	}
	
	@Parameters({"browser"})
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		ExtentTestManager.getTest().log(Status.INFO, "Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}

}

