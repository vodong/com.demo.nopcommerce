package com.nopcommerce.MyAccountPage;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.MyAddressPage.MyAddressPageObject;
import com.nopcommerce.RegisterPage.RegisterPageObject;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.nocommerce.LoginPage.FrontLoginPageUI;
import pageUIs.nocommerce.MyAccountPage.MyAccountPageUI;
import pageUIs.nocommerce.RegisterPage.RegisterPageUI;

public class MyAccountPageObject extends BasePage {
	private WebDriver driver;
	private long ShortTime = GlobalConstants.getGlobalConstants().getShortTimeoutWaiElement();
	
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectGender(String Gender) {
		waitForElementVisible(driver, MyAccountPageUI.GENDER, Gender);
		clickToElement(driver, MyAccountPageUI.GENDER, Gender);
	}

	public void inputFirstname(String textValue) {
		waitForElementVisible(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, textValue);
	}

	public void inputLastname(String textValue) {
		waitForElementVisible(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, textValue);
	}

	public void selectDayDropDown(String dayValue) {
		waitForElementVisible(driver, MyAccountPageUI.DAY_DROPDOWN);
		selectIteminDefaultDropDownList(driver, MyAccountPageUI.DAY_DROPDOWN, dayValue);
	}

	public void selectMonthDropDown(String monthValue) {
		waitForElementClickable(driver, MyAccountPageUI.MONTH_DROPDOWN);
		selectIteminDefaultDropDownList(driver, MyAccountPageUI.MONTH_DROPDOWN, monthValue);
	}

	public void selectYearDropDown(String yearValue) {
		waitForElementClickable(driver, MyAccountPageUI.YEAR_DROPDOWN);
		selectIteminDefaultDropDownList(driver, MyAccountPageUI.YEAR_DROPDOWN, yearValue);
	}

	public void inputEmailaddress(String emaillAddress) {
		waitForElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, emaillAddress);
	}

	public void inputCompanyname(String companyName) {
		waitForElementVisible(driver, MyAccountPageUI.COMPANYNAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.COMPANYNAME_TEXTBOX, companyName);
	}

	public void clickOnSaveButton() {
		waitForElementClickable(driver, MyAccountPageUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_BUTTON);
	}

	public boolean isMessageUpdateSuccessfulllyDisplayed(String messageUpdateSuccessfulllyDisplayed) {
		waitForElementVisible(driver, MyAccountPageUI.BAR_NOTIFICATION, messageUpdateSuccessfulllyDisplayed);
		return isElementDisplayed(driver, MyAccountPageUI.BAR_NOTIFICATION, messageUpdateSuccessfulllyDisplayed);
	}

	public MyAddressPageObject clickOnAddressesLink(String addressLink) {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_LINK, addressLink);
		clickToElement(driver, MyAccountPageUI.ADDRESS_LINK, addressLink);
		return PageGeneratorManager.getMyAddressPageObject(driver); 
	}

}

