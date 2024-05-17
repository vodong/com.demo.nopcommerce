package com.nopcommerce.ProductListPage;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.LoginPage.LoginPageObject;
import com.nopcommerce.ProductDetailPage.ProductDetailPageObject;
import com.nopcommerce.RegisterCompletedPage.RegisterCompletedPageObject;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.nocommerce.MyAccountPage.MyAccountPageUI;
import pageUIs.nocommerce.ProductPageUI.ProductPageUI;
import pageUIs.nocommerce.RegisterPage.RegisterPageUI;

public class ProductListPageObject extends BasePage {
	private WebDriver driver;
	private long ShortTime = GlobalConstants.getGlobalConstants().getShortTimeoutWaiElement();
	private long LongTime = GlobalConstants.getGlobalConstants().getLongTimeout();
	
	public ProductListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public ProductDetailPageObject clickOnProduct(String productName) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_LIST, productName);
		clickToElement(driver, ProductPageUI.PRODUCT_LIST, productName);
		return PageGeneratorManager.getProductDetailPageObject(driver);
	}


}

