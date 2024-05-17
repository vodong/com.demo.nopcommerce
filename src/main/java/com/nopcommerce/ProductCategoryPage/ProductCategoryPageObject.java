package com.nopcommerce.ProductCategoryPage;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.LoginPage.LoginPageObject;
import com.nopcommerce.ProductListPage.ProductListPageObject;
import com.nopcommerce.RegisterCompletedPage.RegisterCompletedPageObject;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.nocommerce.MyAccountPage.MyAccountPageUI;
import pageUIs.nocommerce.ProductPageUI.ProductPageUI;
import pageUIs.nocommerce.RegisterPage.RegisterPageUI;

public class ProductCategoryPageObject extends BasePage {
	private WebDriver driver;
	private long ShortTime = GlobalConstants.getGlobalConstants().getShortTimeoutWaiElement();
	private long LongTime = GlobalConstants.getGlobalConstants().getLongTimeout();
	
	public ProductCategoryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public ProductListPageObject clickOnProductListCategory(String nameProductCategoryList) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_CATEGORY_LIST, nameProductCategoryList);
		clickToElement(driver, ProductPageUI.PRODUCT_CATEGORY_LIST, nameProductCategoryList);
		return PageGeneratorManager.getProductListPageObject(driver);
	}

}

