package com.nopcommerce.RegisterPage;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.RegisterCompletedPage.RegisterCompletedPageObject;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.nocommerce.RegisterPage.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;
	private long ShortTime = GlobalConstants.getGlobalConstants().getShortTimeoutWaiElement();
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterCompletedPageObject clickOnRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		sleepInSecond(ShortTime);
		return PageGeneratorManager.getRegisterCompletedpage(driver);
	}

	public void selectDayDropDown(String day) {
		waitForElementVisible(driver, RegisterPageUI.DAY_DROPDOWN);
		selectIteminDefaultDropDownList(driver, RegisterPageUI.DAY_DROPDOWN, day);
	}

	public void selectMonthDropDown(String month) {
		waitForElementClickable(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectIteminDefaultDropDownList(driver, RegisterPageUI.MONTH_DROPDOWN, month);
	}

	public void selectYearDropDown(String year) {
		waitForElementClickable(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectIteminDefaultDropDownList(driver, RegisterPageUI.YEAR_DROPDOWN, year);
	}

	public void inputFirstname(String fristname) {
		waitForElementClickable(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, fristname);
	}

	public void inputLastname(String lastname) {
		waitForElementClickable(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastname);
	}

	public void inputEmailAddress(String emailAddress) {
		waitForElementClickable(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inputPassword(String invalidPassword) {
		waitForElementClickable(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, invalidPassword);
	}

	public void inputConfirmPassword(String invalidPassword) {
		waitForElementClickable(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, invalidPassword);
	}

	public boolean istErrorMessageFirstnameDisplayed(String errorMessageFirstname) {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MESSAGE_FIRST_NAME_TEXTBOX, errorMessageFirstname);
		return isElementDisplayed(driver, RegisterPageUI.ERROR_MESSAGE_FIRST_NAME_TEXTBOX, errorMessageFirstname);
	}

	public boolean isErrorMessageLastnameDisplayed(String errorMessageLasttname) {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MESSAGE_LAST_NAME_TEXTBOX, errorMessageLasttname);
		return isElementDisplayed(driver, RegisterPageUI.ERROR_MESSAGE_LAST_NAME_TEXTBOX, errorMessageLasttname);
	}

	public boolean isErrorMessageEmailTextboxDisplayed(String errorMessageEmailTextbox) {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MESSAGE_EMAIL_TEXTBOX, errorMessageEmailTextbox);
		return isElementDisplayed(driver, RegisterPageUI.ERROR_MESSAGE_EMAIL_TEXTBOX, errorMessageEmailTextbox);
	}

	public boolean isErrorMessagePasswordTextboxDisplayed(String errorMessagePasswordTextbox) {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MESSAGE_PASSWORD_TEXTBOX, errorMessagePasswordTextbox);
		return isElementDisplayed(driver, RegisterPageUI.ERROR_MESSAGE_PASSWORD_TEXTBOX, errorMessagePasswordTextbox);
	}

	public boolean isErrorMessageConfirmPasswordTextboxDisplayed(String errorMessageConfirmPasswordTextbox) {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MESSAGE_CONFIRM_PASSWORD_TEXTBOX, errorMessageConfirmPasswordTextbox);
		return isElementDisplayed(driver, RegisterPageUI.ERROR_MESSAGE_CONFIRM_PASSWORD_TEXTBOX, errorMessageConfirmPasswordTextbox);
	}

	public boolean isErrorMessagePasswordTextbox1Displayed(String errorMessagePasswordLessThanSixChacracters1) {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MESSAGE_PASSWORD_LESS_THAN_LINE1, errorMessagePasswordLessThanSixChacracters1);
		return isElementDisplayed(driver, RegisterPageUI.ERROR_MESSAGE_PASSWORD_LESS_THAN_LINE1, errorMessagePasswordLessThanSixChacracters1);
	}

	public boolean isErrorMessagePasswordTextbox2Displayed(String errorMessagePasswordLessThanSixChacracters2) {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MESSAGE_PASSWORD_LESS_THAN_LINE2, errorMessagePasswordLessThanSixChacracters2);
		return isElementDisplayed(driver, RegisterPageUI.ERROR_MESSAGE_PASSWORD_LESS_THAN_LINE2, errorMessagePasswordLessThanSixChacracters2);
	}

	public boolean isErrorMessageEmailAlreadyExist(String errorMessageEmailAlreadyExist) {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MESSAGE_EMAIL_ALREADY_EXIST, errorMessageEmailAlreadyExist);
		return isElementDisplayed(driver, RegisterPageUI.ERROR_MESSAGE_EMAIL_ALREADY_EXIST, errorMessageEmailAlreadyExist);
	}

}

