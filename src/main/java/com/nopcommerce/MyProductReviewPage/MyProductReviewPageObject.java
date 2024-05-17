package com.nopcommerce.MyProductReviewPage;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.MyAddressPage.MyAddressPageObject;
import com.nopcommerce.ProductCategoryPage.ProductCategoryPageObject;
import com.nopcommerce.RegisterPage.RegisterPageObject;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.nocommerce.LoginPage.FrontLoginPageUI;
import pageUIs.nocommerce.MyAccountPage.MyAccountPageUI;
import pageUIs.nocommerce.ProductPageUI.ProductPageUI;
import pageUIs.nocommerce.RegisterPage.RegisterPageUI;

public class MyProductReviewPageObject extends BasePage {
	private WebDriver driver;
	private long ShortTime = GlobalConstants.getGlobalConstants().getShortTimeoutWaiElement();
	
	public MyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

}

