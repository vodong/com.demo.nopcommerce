package com.nopcommerce.MyPasswordsPage.copy;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.HomePage.HomePageObject;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.nocommerce.MyAddressPage.MyAddressPageUI;
import pageUIs.nocommerce.MyPasswordpage.MyPasswordPageUI;
import pageUIs.nocommerce.RegisterCompletedPage.RegisterCompletedPageUI;


public class MyPasswordPageObject extends BasePage {
	private WebDriver driver;
	private long ShortTime = GlobalConstants.getGlobalConstants().getShortTimeoutWaiElement();
	
	public MyPasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputOldPassword(String password) {
		waitForElementVisible(driver ,MyPasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver,  MyPasswordPageUI.OLD_PASSWORD_TEXTBOX, password);
	}

	public void inputNewpassword(String newPassword) {
		waitForElementVisible(driver, MyPasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver,  MyPasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
	}

	public void inputConfirmPassword(String confirmPassword) {
		waitForElementVisible(driver, MyPasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver,  MyPasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public void clickonChangePasswordButton() {
		waitForElementClickable(driver, MyPasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, MyPasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public HomePageObject clickOnLogoutLink() {
		waitForElementClickable(driver, RegisterCompletedPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterCompletedPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomepage(driver);
	}

	public void clickOnTheCloseButton() {
		waitForElementClickable(driver, MyPasswordPageUI.CLOSE_NOTIFY_BUTTON);
		clickToElement(driver, MyPasswordPageUI.CLOSE_NOTIFY_BUTTON);
	}
	
}

