package com.nopcommerce.RegisterCompletedPage;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.HomePage.HomePageObject;
import com.nopcommerce.RegisterPage.RegisterPageObject;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.nocommerce.RegisterCompletedPage.RegisterCompletedPageUI;
import pageUIs.nocommerce.RegisterPage.RegisterPageUI;

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

}

