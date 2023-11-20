package com.nopcommerce.MyAccountPage;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.RegisterPage.RegisterPageObject;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.nocommerce.LoginPage.FrontLoginPageUI;

public class MyAccountPageObject extends BasePage {
	private WebDriver driver;
	private long ShortTime = GlobalConstants.getGlobalConstants().getShortTimeoutWaiElement();
	
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
}

