package com.nopcommerce.HomePage;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.LoginPage.LoginPageObject;
import com.nopcommerce.RegisterPage.RegisterPageObject;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.nocommerce.HomePage.FrontHomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	private long ShortTime = GlobalConstants.getGlobalConstants().getShortTimeoutWaiElement();
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject openLoginPage() {
		waitForElementClickable(driver, FrontHomePageUI.LOGIN_LINK);
		clickToElement(driver, FrontHomePageUI.LOGIN_LINK);
		sleepInSecond(ShortTime);
		return PageGeneratorManager.getRegisterpage(driver);
	}
	
	public void clickOnLogoutLink() {
		waitForElementClickable(driver, FrontHomePageUI.LOGOUT_LINK);
		clickToElement(driver, FrontHomePageUI.LOGOUT_LINK);
	}

	public boolean isLogoutLinkDisplayed(String logoutText) {
		waitForElementVisible(driver, FrontHomePageUI.LOGOUT_TEXT, logoutText);
		return isElementDisplayed(driver, FrontHomePageUI.LOGOUT_TEXT, logoutText);
	}

	public RegisterPageObject openRegisterPage() {
		waitForElementClickable(driver, FrontHomePageUI.REGISTER_LINK);
		clickToElement(driver, FrontHomePageUI.REGISTER_LINK);
		sleepInSecond(ShortTime);
		return PageGeneratorManager.getRegisterpage(driver);
	}
}

