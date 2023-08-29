package com.nopcommerce.HomePage;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopcommerce.HomePage.HomePageObject;
import com.nopcommerce.LoginPage.LoginPageObject;
import com.nopcommerce.RegisterPage.RegisterPageObject;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import reportConfig.ExtentTestManager;

public class Home_Page extends BaseTest {
	WebDriver driver;
	HomePageObject home_Page; 
	String getCurrentUrl;
	LoginPageObject login_Page;
	RegisterPageObject register_Page;

	Environment environment;

	@Parameters({ "envName", "serverName", "browser", "osName", "osVersion", "ipAddress", "portNumber" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("DEV") String serverName,
			@Optional("chrome") String browserName, @Optional("Windows") String osName,
			@Optional("10") String osVersion, @Optional("localhost") String ipAddress,
			@Optional("4444") String portNumber) {

		driver = getBrowserDriver(envName, serverName, browserName, osName, osVersion, ipAddress, portNumber);

		home_Page = PageGeneratorManager.getHomepage(driver);
	}
	
	@Test
	public void Front_Open_Home_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Open Home Page");
		ExtentTestManager.getTest().log(Status.INFO, "Home Page - Step 01: Open Home Page");
		getCurrentUrl = home_Page.getPageUrl(driver);
		assertEquals(home_Page.getPageUrl(driver), GlobalConstants.getGlobalConstants().getHomeURL());
		register_Page = home_Page.openRegisterPage();
	}
}

