package com.nopcommerce.LoginPage;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
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
import reportConfig.ExtentTestManager;

public class Login_Page extends BaseTest {
	WebDriver driver;
	LoginPageObject login_Page;
	RegisterPageObject register_Page;
	String getCurrentUrl;

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
		
	}
	
	@Test
	public void Front_Open_Login_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Open Home Page");
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 01: Open Login Page");
		getCurrentUrl = login_Page.getPageUrl(driver);
		if(getCurrentUrl.equals(GlobalConstantsLoginPage.getGlobalConstants().getLoginURL()))
		{
			register_Page = login_Page.clickOnRegisterButton();
			//login_Page.clickOnLoginButton();
		}
		else {
			System.out.println("The Login URL Is Incorrect");
		}
	}

}

