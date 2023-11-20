package com.nopcommerce.RegisterCompletedPage;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.HomePage.HomePageObject;
import com.nopcommerce.RegisterPage.RegisterPageObject;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.nocommerce.RegisterCompletedPage.RegisterCompletedPageUI;

public class RegisterCompletedPageObject extends BasePage {
	private WebDriver driver;
	private long ShortTime = GlobalConstants.getGlobalConstants().getShortTimeoutWaiElement();
	
	public RegisterCompletedPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickOnRegisterLink() {
		waitForElementClickable(driver, RegisterCompletedPageUI.REGISTER_LINK);
		clickToElement(driver, RegisterCompletedPageUI.REGISTER_LINK);
		sleepInSecond(ShortTime);
		return PageGeneratorManager.getRegisterpage(driver);
	}

	public HomePageObject clickOnLogoutLink() {
		waitForElementClickable(driver, RegisterCompletedPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterCompletedPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomepage(driver);
	}

	public boolean isLoginLinkOnHeaderDisplayed() {
		waitForElementVisible(driver, RegisterCompletedPageUI.LOGIN_LINK);
		return isElementDisplayed(driver, RegisterCompletedPageUI.LOGIN_LINK);
	}

	public boolean isLoginLinkOnHeaderDisplayed(String string) {
		waitForElementVisible(driver, RegisterCompletedPageUI.LOGIN_LINK, string);
		return isElementDisplayed(driver, RegisterCompletedPageUI.LOGIN_LINK, string);
	}

}

