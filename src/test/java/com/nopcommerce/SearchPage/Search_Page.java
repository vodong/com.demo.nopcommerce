package com.nopcommerce.SearchPage;

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
import com.nopcommerce.RegisterPage.RegisterPageObject;

import commons.BaseTest;
import commons.GlobalConstantsLoginPage;
import commons.GlobalConstantsSearchPage;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import helpers.PropertiesHelper;
import reportConfig.ExtentTestManager;

public class Search_Page extends BaseTest {
	WebDriver driver;
	SearchPageObject search_Page;
	LoginPageObject login_Page;
	HomePageObject home_Page;
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
		home_Page = PageGeneratorManager.getHomepage(driver);
		PropertiesHelper.loadAllFiles();
		emailAddress = PropertiesHelper.getValue("email");
		password = PropertiesHelper.getValue("password");
	}
	
	@Test (groups = "Search Account")
	public void Front_Open_Search_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Open Search Page");
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 01: Open Search Page");
		if(driver.findElement(By.cssSelector("a.ico-login")).isDisplayed()) 
		{
			search_Page = home_Page.clickOnSearchLinkAtFooter();
		}else {
			login_Page = home_Page.clickOnLoginLink();
			login_Page.inputEmailAddress(emailAddress);
			login_Page.inputPassword(password);	
			home_Page = login_Page.clickOnLoginButton();
			search_Page = home_Page.clickOnSearchLinkAtFooter();
		}
	}
	
	@Test (groups = "Search Account", dependsOnMethods = "Front_Open_Search_Page")
	public void Search_Without_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search Without Inputting Data");
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 01: Click On Search Button");
		search_Page.clickOnSearchButton();
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 02: Verify Error Message");
		assertTrue(search_Page.isErrorMessageDisplayed(GlobalConstantsSearchPage.getGlobalConstants().getErrorMessageEmptyData()));
	}
	
	@Test (groups = "Search Account", dependsOnMethods = "Search_Without_Data")
	public void Search_With_The_Data_Does_Not_Exist(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search With The Data Does Not Exist");
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 01: Input Keyword Does Not Exist");
		search_Page.inputKeyword("Macbook Pro 2050");
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 02: Click On Search Button");
		search_Page.clickOnSearchButton();
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 03: Verify Error Message");
		assertTrue(search_Page.isErrorMessageDisplayed(GlobalConstantsSearchPage.getGlobalConstants().getErrorMessageDoesNotExistData()));
	}
	
	@Test (groups = "Search Account", dependsOnMethods = "Search_With_The_Data_Does_Not_Exist")
	public void Search_With_Product_Exist(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search With Product Exist");
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 01: Input Product Exist");
		search_Page.inputKeyword("Lenovo");
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 02: Click On Search Button");
		search_Page.clickOnSearchButton();
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 03: Verify Search Result");
		assertTrue(search_Page.isProductDisplayed(GlobalConstantsSearchPage.getGlobalConstants().getProduct1()));
		assertTrue(search_Page.isProductDisplayed(GlobalConstantsSearchPage.getGlobalConstants().getProduct2()));
	}
	
	@Test (groups = "Search Account", dependsOnMethods = "Search_With_Product_Exist")
	public void Search_With_The_Exatcly_Product_Name(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search With The Exatcly Product Name");
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 01: Input Exatcly Product Name");
		search_Page.inputKeyword(GlobalConstantsSearchPage.getGlobalConstants().getProduct2());
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 02: Click On Search Button");
		search_Page.clickOnSearchButton();
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 03: Verify Search Result");
		assertTrue(search_Page.isProductDisplayed(GlobalConstantsSearchPage.getGlobalConstants().getProduct2()));
	}
	
	@Test (groups = "Search Account", dependsOnMethods = "Search_With_The_Exatcly_Product_Name")
	public void Search_With_The_Parent_Category(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search With The Category");
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 01: Input Product Name");
		search_Page.inputKeyword(GlobalConstantsSearchPage.getGlobalConstants().getProductName());
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 02: Select Advanced Search Option");
		search_Page.selectAdvancedSearchOption();
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 03: Select Category");
		search_Page.selectCategory(GlobalConstantsSearchPage.getGlobalConstants().getCategoryName());
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 04: Click On Search Button");
		search_Page.clickOnSearchButton();
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 05: Verify Search Result");
		assertTrue(search_Page.isErrorMessageDisplayed(GlobalConstantsSearchPage.getGlobalConstants().getErrorMessageDoesNotExistData()));
	}
	
	@Test (groups = "Search Account", dependsOnMethods = "Search_With_The_Parent_Category")
	public void Search_With_The_Sub_Categories(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search With The Category");
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 01: Input Product Name");
		search_Page.inputKeyword(GlobalConstantsSearchPage.getGlobalConstants().getProductName());
//		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 02: Select Advanced Search Option");
//		search_Page.selectAdvancedSearchOption();
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 02: Select Category");
		search_Page.selectCategory(GlobalConstantsSearchPage.getGlobalConstants().getCategoryName());
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 03: Select Automatically Search Sub Categories Option");
		search_Page.selectAutomaticallySearchOption();
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 04: Click On Search Button");
		search_Page.clickOnSearchButton();
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 05: Verify Search Result");
		assertTrue(search_Page.isProductDisplayed(GlobalConstantsSearchPage.getGlobalConstants().getProduct3()));
	}
	
	@Test (groups = "Search Account", dependsOnMethods = "Search_With_The_Sub_Categories")
	public void Search_With_The_Incorrect_Manufactuer(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search With The Category");
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 01: Input Product Name");
		search_Page.inputKeyword(GlobalConstantsSearchPage.getGlobalConstants().getProductName());
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 02: Select Advanced Search Option");
//		search_Page.selectAdvancedSearchOption();
//		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 03: Select Category");
		search_Page.selectCategory(GlobalConstantsSearchPage.getGlobalConstants().getCategoryName());
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 04: Select Automatically Search Sub Categories Option");
		search_Page.selectAutomaticallySearchOption();
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 05: Select Category");
		search_Page.selectManufactuer(GlobalConstantsSearchPage.getGlobalConstants().getManufacturerName1());
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 06: Click On Search Button");
		search_Page.clickOnSearchButton();
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 07: Verify Search Result");
		assertTrue(search_Page.isErrorMessageDisplayed(GlobalConstantsSearchPage.getGlobalConstants().getErrorMessageDoesNotExistData()));
	}
	
	@Test (groups = "Search Account", dependsOnMethods = "Search_With_The_Incorrect_Manufactuer")
	public void Search_With_The_Correct_Manufactuer(Method method) {
		ExtentTestManager.startTest(method.getName(), "Search With The Category");
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 01: Input Product Name");
		search_Page.inputKeyword(GlobalConstantsSearchPage.getGlobalConstants().getProductName());
//		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 02: Select Advanced Search Option");
//		search_Page.selectAdvancedSearchOption();
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 02: Select Category");
		search_Page.selectCategory(GlobalConstantsSearchPage.getGlobalConstants().getCategoryName());
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 03: Select Automatically Search Sub Categories Option");
		search_Page.selectAutomaticallySearchOption();
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 04: Select Category");
		search_Page.selectManufactuer(GlobalConstantsSearchPage.getGlobalConstants().getManufacturerName2());
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 05: Click On Search Button");
		search_Page.clickOnSearchButton();
		ExtentTestManager.getTest().log(Status.INFO, "Search Page - Step 06: Verify Search Result");
		assertTrue(search_Page.isProductDisplayed(GlobalConstantsSearchPage.getGlobalConstants().getProduct3()));
	}

}

