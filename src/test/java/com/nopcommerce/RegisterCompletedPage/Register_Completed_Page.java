package com.nopcommerce.RegisterCompletedPage;

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

import commons.BaseTest;
import commons.GlobalConstantsHomePage;
import commons.GlobalConstantsLoginPage;
import commons.GlobalConstantsRegisterPage;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import reportConfig.ExtentTestManager;

public class Register_Completed_Page extends BaseTest {
	WebDriver driver;
	LoginPageObject login_Page;
	HomePageObject home_Page; 
	
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
		//register_Page = PageGeneratorManager.getRegisterpage(driver);
		emailAddress =  "edward_ecommerce" + generateNumber() + "@yopmail.com";
		invalidEmailAddress =  "test.com";
		fristname =  "Edward" + generateNumber();
		lastname =  "Vo" + generateNumber();
		invalidPassword = "123";
		
	}

}

