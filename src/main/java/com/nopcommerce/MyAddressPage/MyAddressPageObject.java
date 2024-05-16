package com.nopcommerce.MyAddressPage;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.MyPasswordsPage.copy.MyPasswordPageObject;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.nocommerce.MyAccountPage.MyAccountPageUI;
import pageUIs.nocommerce.MyAddressPage.MyAddressPageUI;

public class MyAddressPageObject extends BasePage {
	private WebDriver driver;
	private long ShortTime = GlobalConstants.getGlobalConstants().getShortTimeoutWaiElement();
	
	public MyAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnAddnewButton() {
		waitForElementClickable(driver, MyAddressPageUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver, MyAddressPageUI.ADD_NEW_ADDRESS_BUTTON);
	}
	
	public void inputFirstnameAddress(String fristname) {
		waitForElementVisible(driver, MyAddressPageUI.FIRST_NAME_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAddressPageUI.FIRST_NAME_ADDRESS_TEXTBOX, fristname);
	}
	
	public void inputLastnameAddress(String lastname) {
		waitForElementVisible(driver, MyAddressPageUI.LAST_NAME_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAddressPageUI.LAST_NAME_ADDRESS_TEXTBOX, lastname);
	}
	
	public void inputEmailInAddress(String emailAddress) {
		waitForElementVisible(driver, MyAddressPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAddressPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}
	
	public void inputCompanyAddress(String string) {
		waitForElementVisible(driver, MyAddressPageUI.COMPANY_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAddressPageUI.COMPANY_ADDRESS_TEXTBOX, string);
	}
	
	public void inputCityAddress(String string) {
		waitForElementVisible(driver, MyAddressPageUI.CITY_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAddressPageUI.CITY_ADDRESS_TEXTBOX, string);
	}
	
	public void inputAddress1(String string) {
		waitForElementVisible(driver, MyAddressPageUI.ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, MyAddressPageUI.ADDRESS1_TEXTBOX, string);
	}
	
	public void inputAddress2(String string) {
		waitForElementVisible(driver, MyAddressPageUI.ADDRESS2_TEXTBOX);
		sendkeyToElement(driver, MyAddressPageUI.ADDRESS2_TEXTBOX, string);
	}
	
	public void inputZipPostcodeAddress(String string) {
		waitForElementVisible(driver, MyAddressPageUI.ZIPCODE_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAddressPageUI.ZIPCODE_ADDRESS_TEXTBOX, string);
	}
	
	public void inputPhonenumberAddress(String string) {
		waitForElementVisible(driver, MyAddressPageUI.PHONE_NUMBER_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAddressPageUI.PHONE_NUMBER_ADDRESS_TEXTBOX, string);
	}
	
	public void inputFaxnumberAddress(String string) {
		waitForElementVisible(driver, MyAddressPageUI.FAX_NUMBER_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, MyAddressPageUI.FAX_NUMBER_ADDRESS_TEXTBOX, string);
	}
	
	public void clickOnSaveAddressButton() {
		waitForElementClickable(driver, MyAddressPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, MyAddressPageUI.SAVE_ADDRESS_BUTTON);
	}

	public boolean isMessageUpdateAddressSuccessfulllyDisplayed(String messageUpdateAddressSuccessfulllyDisplayed) {
		waitForElementVisible(driver, MyAddressPageUI.BAR_NOTIFICATION, messageUpdateAddressSuccessfulllyDisplayed);
		return isElementDisplayed(driver, MyAddressPageUI.BAR_NOTIFICATION, messageUpdateAddressSuccessfulllyDisplayed);
	}

	public void selectCountryAddress(String country) {
		waitForElementClickable(driver, MyAddressPageUI.COUNTRY_DROPDOWN, country);
		selectIteminDefaultDropDownList(driver, MyAddressPageUI.COUNTRY_DROPDOWN, country);
	}

	public MyPasswordPageObject clickOnChangePasswordLink(String changePasswordLink) {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_LINK, changePasswordLink);
		clickToElement(driver, MyAccountPageUI.ADDRESS_LINK, changePasswordLink);
		return PageGeneratorManager.getMyPasswordPageObject(driver); 
	}

	public boolean isMessageUpdatPasswordSuccessfulllyDisplayed(String messageUpdatePasswordSuccessfulllyDisplayed) {
		waitForElementVisible(driver, MyAddressPageUI.BAR_NOTIFICATION, messageUpdatePasswordSuccessfulllyDisplayed);
		return isElementDisplayed(driver, MyAddressPageUI.BAR_NOTIFICATION, messageUpdatePasswordSuccessfulllyDisplayed);
	}
}

