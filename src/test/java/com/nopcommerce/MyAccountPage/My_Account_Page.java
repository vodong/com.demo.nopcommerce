package com.nopcommerce.MyAccountPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.nopcommerce.HomePage.HomePageObject;
import com.nopcommerce.LoginPage.LoginPageObject;

import commons.BaseTest;
import commons.GlobalConstantsLoginPage;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import helpers.PropertiesHelper;
import reportConfig.ExtentTestManager;

public class My_Account_Page extends BaseTest {
	WebDriver driver;
	MyAccountPageObject myAccount_Page;
	HomePageObject home_Page;
	LoginPageObject login_Page;
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
		login_Page = PageGeneratorManager.getLoginpage(driver);
		PropertiesHelper.loadAllFiles();
		emailAddress = PropertiesHelper.getValue("email");
		password = PropertiesHelper.getValue("password");
	}
	

	@Test (groups = "My Account")
	public void My_Account_Login_Success(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login Account And Valid Password");
		ExtentTestManager.getTest().log(Status.INFO, "Login Page - Step 01: Input Email Address Existed");
		login_Page.inputEmailAddress(emailAddress);
		ExtentTestManager.getTest().log(Status.INFO, "Login Page - Step 02: Input Valid Password");
		login_Page.inputPassword(password);
		ExtentTestManager.getTest().log(Status.INFO, "Login Page - Step 03: Click On The Login Button");
		home_Page = login_Page.clickOnLoginButton();
	}
	
	@Test (groups = "My Account", dependsOnMethods = "My_Account_Login_Success")
	public void My_Account_Update_Customer_Information(Method method) {
		ExtentTestManager.startTest(method.getName(), "Open My Account Page");
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 01: My Account Link Is Displayed");
		assertEquals(home_Page.isMyAccountLinkDisplayed(driver),"My account");
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 02: Click on My Account Link On The Header Page");
		myAccount_Page = home_Page.clickonMyAccountLink();
		assertEquals(home_Page.isMyAccountLinkDisplayed(driver),"My account");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 03: Update Gender");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 04: Update First Name");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 04: Update Last Name");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 04: Update Date Of Birth");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 05: Update Email Address");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 06: Update Company Name");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 07: Click On Save Button");
	}
	
	@Test (groups = "My Account", dependsOnMethods = "My_Account_Login_Success")
	public void My_Account_Add_Address(Method method) {
		ExtentTestManager.startTest(method.getName(), "Open Address Page");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 01: Open Customer Address Page");

		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 02: Click On Add New Button");

		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 03: Input First Name");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 04: Input Last Name");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 04: Input Email Address");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 04: Input Company");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 05: Input Country");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 05: Input State / Province");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 05: Input City");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 05: Input Address 1");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 05: Input Address 2");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 05: Input Zip / postal code");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 05: Input Phone number");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 05: Input Fax number");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 05: Click On Save Button");
	}

	@Parameters({"browser"})
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		ExtentTestManager.getTest().log(Status.INFO, "Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}

}

