package com.nopcommerce.HomePage;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.LoginPage.LoginPageObject;
import com.nopcommerce.MyAccountPage.MyAccountPageObject;
import com.nopcommerce.ProductCategoryPage.ProductCategoryPageObject;
import com.nopcommerce.RegisterPage.RegisterPageObject;
import com.nopcommerce.SearchPage.SearchPageObject;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.nocommerce.HomePage.FrontHomePageUI;
import pageUIs.nocommerce.ProductPageUI.ProductPageUI;

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

	public String isMyAccountLinkDisplayed(WebDriver driver) {
		waitForElementVisible(driver, FrontHomePageUI.MYACOUNT_LINK);
		return getElementText(driver, FrontHomePageUI.MYACOUNT_LINK);
	}

	public MyAccountPageObject clickonMyAccountLink() {
		waitForElementClickable(driver, FrontHomePageUI.MYACOUNT_LINK);
		clickToElement(driver, FrontHomePageUI.MYACOUNT_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);
	}

	public LoginPageObject clickOnLoginLink() {
		waitForElementClickable(driver, FrontHomePageUI.LOGIN_LINK);
		clickToElement(driver, FrontHomePageUI.LOGIN_LINK);
		sleepInSecond(ShortTime);
		return PageGeneratorManager.getLoginpage(driver);
	}

	public SearchPageObject clickOnSearchLinkAtFooter() {
		waitForElementClickable(driver, FrontHomePageUI.SEARCH_LINK_FOOTER);
		clickToElement(driver, FrontHomePageUI.SEARCH_LINK_FOOTER);
		sleepInSecond(ShortTime);
		return PageGeneratorManager.getSearchPage(driver);
	}

	public ProductCategoryPageObject clickOnProductCategoryOnHeaderMenu(String productCategoryLink) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_CATEGORY, productCategoryLink);
		clickToElement(driver, ProductPageUI.PRODUCT_CATEGORY, productCategoryLink);
		return PageGeneratorManager.getProductCategoryPageObject(driver);
	}
}

