package com.nopcommerce.ProductDetailPage;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.LoginPage.LoginPageObject;
import com.nopcommerce.MyAccountPage.MyAccountPageObject;
import com.nopcommerce.RegisterCompletedPage.RegisterCompletedPageObject;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.nocommerce.HomePage.FrontHomePageUI;
import pageUIs.nocommerce.MyAccountPage.MyAccountPageUI;
import pageUIs.nocommerce.MyPasswordpage.MyPasswordPageUI;
import pageUIs.nocommerce.ProductPageUI.ProductPageUI;
import pageUIs.nocommerce.RegisterPage.RegisterPageUI;

public class ProductDetailPageObject extends BasePage {
	private WebDriver driver;
	private long ShortTime = GlobalConstants.getGlobalConstants().getShortTimeoutWaiElement();
	private long LongTime = GlobalConstants.getGlobalConstants().getLongTimeout();
	
	public ProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductTitle() {
		waitForElementVisible(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		return getElementText(driver, ProductPageUI.PRODUCT_NAME_TEXT);
	}

	public void clickOnAddYourReviewLink(String addYourReviewLink) {
		waitForElementClickable(driver, ProductPageUI.ADD_YOUR_REVIEW_LINK, addYourReviewLink);
		clickToElement(driver, ProductPageUI.ADD_YOUR_REVIEW_LINK, addYourReviewLink);
	}

	public void inputReviewTitle(String reviewTitleContent) {
		waitForElementVisible(driver, ProductPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, ProductPageUI.REVIEW_TITLE_TEXTBOX, reviewTitleContent);
	}

	public void inputReviewText(String reviewTextContent) {
		waitForElementVisible(driver, ProductPageUI.REVIEW_TEXT_TEXTBOX);
		sendkeyToElement(driver, ProductPageUI.REVIEW_TEXT_TEXTBOX, reviewTextContent);
	}

	public void selectRating(String selectRatingOption) {
		waitForElementClickable(driver, ProductPageUI.RATING, selectRatingOption);
		clickToElement(driver, ProductPageUI.RATING, selectRatingOption);
	}

	public void clickOnSubmitReviewButton() {
		waitForElementClickable(driver, ProductPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, ProductPageUI.SUBMIT_REVIEW_BUTTON);
	}
	
	public boolean isMessageProductReviewIsSuccessfullyDisplayed(String messageProductReviewIsSuccessfullyDisplayed) {
		waitForElementVisible(driver, MyAccountPageUI.BAR_NOTIFICATION, messageProductReviewIsSuccessfullyDisplayed);
		return isElementDisplayed(driver, MyAccountPageUI.BAR_NOTIFICATION, messageProductReviewIsSuccessfullyDisplayed);
	}

	public void clickOnTheCloseButton() {
		waitForElementClickable(driver, MyPasswordPageUI.CLOSE_NOTIFY_BUTTON);
		clickToElement(driver, MyPasswordPageUI.CLOSE_NOTIFY_BUTTON);
	}

	public MyAccountPageObject clickonMyAccountLink() {
		waitForElementVisible(driver, FrontHomePageUI.MYACOUNT_LINK);
		clickToElement(driver, FrontHomePageUI.MYACOUNT_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);
	}

}

