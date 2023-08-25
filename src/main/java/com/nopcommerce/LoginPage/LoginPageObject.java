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
}

