package com.nopcommerce.MyAccountPage;

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
import com.nopcommerce.HomePage.HomePageObject;
import com.nopcommerce.LoginPage.LoginPageObject;
import com.nopcommerce.MyAddressPage.MyAddressPageObject;
import com.nopcommerce.MyPasswordsPage.copy.MyPasswordPageObject;

import commons.BaseTest;
import commons.GlobalConstantsLoginPage;
import commons.GlobalConstantsMyAccountPage;
import commons.GlobalConstantsMyAddressPage;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import helpers.PropertiesHelper;
import reportConfig.ExtentTestManager;

public class My_Account_Page extends BaseTest {
	WebDriver driver;
	MyAccountPageObject myAccount_Page;
	MyAddressPageObject myAddress_Page;
	MyPasswordPageObject myPassword_Page;
	HomePageObject home_Page;
	LoginPageObject login_Page;
	String getCurrentUrl;
	String emailAddress, password, fristname, lastname, emailAddress1, new_password;

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
		emailAddress1 =  "Automation_Team" + generateNumber() + "@yopmail.com";
		password = PropertiesHelper.getValue("password");
		fristname =  "Edward" + generateNumber();
		lastname =  "Vo" + generateNumber();
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
		myAccount_Page.selectGender("male");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 04: Update First Name");
		myAccount_Page.inputFirstname("1");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 05: Update Last Name");
		myAccount_Page.inputLastname("2");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 06: Select Day Of Birth");
		myAccount_Page.selectDayDropDown("1");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 07: Select Month Of Birth");
		myAccount_Page.selectMonthDropDown("April");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 08: Select Year Of Birth");
		myAccount_Page.selectYearDropDown("1987");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 09: Update Email Address");
		myAccount_Page.inputEmailaddress(emailAddress1);
		PropertiesHelper.setValue("email", emailAddress1);
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 10: Update Company Name");
		myAccount_Page.inputCompanyname("1231231");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 11: Click On Save Button");
		myAccount_Page.clickOnSaveButton();
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 12: The Message To Notify The Customer Has Been Update Successfully");
		assertTrue(myAccount_Page.isMessageUpdateSuccessfulllyDisplayed(GlobalConstantsMyAccountPage.getGlobalConstants().getMessageUpdateSuccessfulllyDisplayed()));
	}
	
	@Test (groups = "My Account", dependsOnMethods = "My_Account_Update_Customer_Information")
	public void My_Account_Add_Address(Method method) {
		ExtentTestManager.startTest(method.getName(), "Open Address Page");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 01: Open Customer Address Page");
		myAddress_Page = myAccount_Page.clickOnAddressesLink(GlobalConstantsMyAccountPage.getGlobalConstants().getAddressLink());
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 02: Click On Add New Button");
		myAddress_Page.clickOnAddnewButton();
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 03: Input First Name");
		myAddress_Page.inputFirstnameAddress(fristname);
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 04: Input Last Name");
		myAddress_Page.inputLastnameAddress(lastname);
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 05: Input Email Address");
		myAddress_Page.inputEmailInAddress(emailAddress1);
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 06: Input Company");
		myAddress_Page.inputCompanyAddress("1 Hồng Hà");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 07: Select Country");
		myAddress_Page.selectCountryAddress(GlobalConstantsMyAddressPage.getGlobalConstants().getCountry());
//		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 05: Select State / Province");
//		//myAccount_Page.selectStateProvinceAddress();
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 08: Input City");
		myAddress_Page.inputCityAddress("Hồ Chí Minh");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 09: Input Address 1");
		myAddress_Page.inputAddress1("1 Hồng Hà");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 10: Input Address 2");
		myAddress_Page.inputAddress2("1 Phạm Ngũ Lão");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 11: Input Zip / postal code");
		myAddress_Page.inputZipPostcodeAddress("70000");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 12: Input Phone number");
		myAddress_Page.inputPhonenumberAddress("01231231112");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 13: Input Fax number");
		myAddress_Page.inputFaxnumberAddress("01231231112");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 14: Click On Save Button");
		myAddress_Page.clickOnSaveAddressButton();
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 15: The Message To Notify The Customer Has Been Update Successfully");
		assertTrue(myAddress_Page.isMessageUpdateAddressSuccessfulllyDisplayed(GlobalConstantsMyAddressPage.getGlobalConstants().getMessageUpdateAddressSuccessfulllyDisplayed()));
	}
	
	@Test (groups = "My Account", dependsOnMethods = "My_Account_Add_Address")
	public void My_Account_Change_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "Open Change Password Page");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Change Password Page - Step 01: Open Change Password Page");
		myPassword_Page = myAddress_Page.clickOnChangePasswordLink(GlobalConstantsMyAccountPage.getGlobalConstants().getChangePasswordLink());
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 02: Input Old Password");
		myPassword_Page.inputOldPassword(password);
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 03: Input New Password");
		myPassword_Page.inputNewpassword(GlobalConstantsMyAddressPage.getGlobalConstants().getNewPassword());
		PropertiesHelper.setValue("password", GlobalConstantsMyAddressPage.getGlobalConstants().getNewPassword());
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 04: Input Confirm Password");
		myPassword_Page.inputConfirmPassword(GlobalConstantsMyAddressPage.getGlobalConstants().getNewPassword());
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 05: Click On Change Password Button");
		myPassword_Page.clickonChangePasswordButton();
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 06: The Message To Notify The Customer Has Been Update Password Successfully");
		assertTrue(myAddress_Page.isMessageUpdatPasswordSuccessfulllyDisplayed(GlobalConstantsMyAddressPage.getGlobalConstants().getMessageUpdatePasswordSuccessfulllyDisplayed()));
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 07: Close The Message Notify On The Header");
		myPassword_Page.clickOnTheCloseButton();
	}
	
	@Test (groups = "My Account", dependsOnMethods = "My_Account_Change_Password")
	public void My_Account_Login_After_Updating_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "Logout And Login Account After Changing Password");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Change Password Page - Step 01: Click On Logout Link On Header");
		home_Page = myPassword_Page.clickOnLogoutLink();
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 02: Open Login Page");
		login_Page = home_Page.clickOnLoginLink();
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 03: Input Email Address");
		login_Page.inputEmailAddress(emailAddress1);
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 04: Input The Old Password");
		login_Page.inputPassword("123456");
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 05: Click On Login Button");
		login_Page.clickOnLoginButton();
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 06: Verify Message When Login With The Old Password");
		assertTrue(login_Page.isErrorMessageInvalidEmailLine1Displayed(GlobalConstantsLoginPage.getGlobalConstants().getErrorMessageInvalidData1()));
		assertTrue(login_Page.isErrorMessageInvalidEmailLine2Displayed(GlobalConstantsLoginPage.getGlobalConstants().getErrorMessageInvalidData2()));
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 07: Input Email Address");
		login_Page.inputEmailAddress(emailAddress1);
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 08: Input The New Password Has Been Changed");
		PropertiesHelper.loadAllFiles();
		new_password = PropertiesHelper.getValue("password");
		login_Page.inputPassword(new_password);
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Address Page - Step 09: Click On Login Button");
		home_Page = login_Page.clickOnLoginButton();
		ExtentTestManager.getTest().log(Status.INFO, "My Account - Customer Info Page - Step 10: Verify The Customer Can Login Successfully");
		assertEquals(home_Page.isMyAccountLinkDisplayed(driver),"My account");
		myAccount_Page = home_Page.clickonMyAccountLink();
	}
	

	@Parameters({"browser"})
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		ExtentTestManager.getTest().log(Status.INFO, "Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}

}

