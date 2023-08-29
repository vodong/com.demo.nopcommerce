package com.nopcommerce.LoginPage;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.RegisterPage.RegisterPageObject;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.nocommerce.LoginPage.FrontLoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	private long ShortTime = GlobalConstants.getGlobalConstants().getShortTimeoutWaiElement();
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnLoginButton() {
		waitForElementClickable(driver, FrontLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, FrontLoginPageUI.LOGIN_BUTTON);
	}

	public RegisterPageObject clickOnRegisterButton() {
		waitForElementClickable(driver, FrontLoginPageUI.REGISTER_BUTTON);
		clickToElement(driver, FrontLoginPageUI.REGISTER_BUTTON);
		sleepInSecond(ShortTime);
		return PageGeneratorManager.getRegisterpage(driver);
	}

	public void inputEmailAddress(String invalidEmailFormat) {
	waitForElementVisible(driver, FrontLoginPageUI.EMAIL_TEXTBOX);
	sendkeyToElement(driver, FrontLoginPageUI.EMAIL_TEXTBOX, invalidEmailFormat);
	}

	public boolean isErrorMessageInvalidEmailLine1Displayed(String errorMessageInvalidData1) {
		waitForElementVisible(driver, FrontLoginPageUI.ERROR_MESSAGE_LINE_1, errorMessageInvalidData1);
		return isElementDisplayed(driver, FrontLoginPageUI.ERROR_MESSAGE_LINE_1, errorMessageInvalidData1);
	}

	public boolean isErrorMessageInvalidEmailLine2Displayed(String errorMessageInvalidData) {
		waitForElementVisible(driver, FrontLoginPageUI.ERROR_MESSAGE_LINE_2, errorMessageInvalidData);
		return isElementDisplayed(driver, FrontLoginPageUI.ERROR_MESSAGE_LINE_2, errorMessageInvalidData);
	}

	public void inputPassword(String invalidPassword) {
		waitForElementVisible(driver, FrontLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, FrontLoginPageUI.PASSWORD_TEXTBOX, invalidPassword);
	}

	public String getErrorMessage(WebDriver driver) {
		waitForElementVisible(driver, FrontLoginPageUI.ERROR_MESSAGE_BELOW_EMAIL_TEXTBOX);
		return getElementText(driver, FrontLoginPageUI.ERROR_MESSAGE_BELOW_EMAIL_TEXTBOX);
	}
}

