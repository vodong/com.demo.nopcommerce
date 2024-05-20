package com.nopcommerce.SearchPage;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.HomePage.HomePageObject;
import com.nopcommerce.MyAccountPage.MyAccountPageObject;
import com.nopcommerce.RegisterPage.RegisterPageObject;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.nocommerce.LoginPage.FrontLoginPageUI;
import pageUIs.nocommerce.SearchPage.SearchPageUI;

public class SearchPageObject extends BasePage {
	private WebDriver driver;
	private long ShortTime = GlobalConstants.getGlobalConstants().getShortTimeoutWaiElement();
	
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnSearchButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}

	public boolean isErrorMessageDisplayed(String errorMessageValue) {
		waitForElementVisible(driver, SearchPageUI.ERROR_MESSAGE, errorMessageValue);
		return isElementDisplayed(driver, SearchPageUI.ERROR_MESSAGE, errorMessageValue);
	}

	public void inputKeyword(String string) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, string);
	}

	public boolean isProductDisplayed(String productName) {
		waitForElementVisible(driver, SearchPageUI.PRODUCT_NAME, productName);
		return isElementDisplayed(driver, SearchPageUI.PRODUCT_NAME, productName);
	}

	public void selectAdvancedSearchOption() {
		waitForElementClickable(driver, SearchPageUI.ADVANCED_SEARCH_OPTION);
		clickToElement(driver, SearchPageUI.ADVANCED_SEARCH_OPTION);
	}

	public void selectCategory(String categoryName) {
		waitForElementVisible(driver, SearchPageUI.CATEGORY_OPTION);
		selectIteminDefaultDropDownList(driver, SearchPageUI.CATEGORY_OPTION, categoryName);
	}

	public void selectAutomaticallySearchOption() {
		waitForElementClickable(driver, SearchPageUI.AUTOMATICALLY_SEARCH_OPTION);
		clickToElement(driver, SearchPageUI.AUTOMATICALLY_SEARCH_OPTION);
	}

	public void selectManufactuer(String manufacturerName1) {
		waitForElementVisible(driver, SearchPageUI.MANUFACTUER_OPTION);
		selectIteminDefaultDropDownList(driver, SearchPageUI.MANUFACTUER_OPTION, manufacturerName1);
	}

}

