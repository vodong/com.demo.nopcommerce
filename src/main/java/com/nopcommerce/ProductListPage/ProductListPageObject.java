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

	public void selectSortOption(String sortOptionValue) {
		waitForElementVisible(driver, ProductPageUI.SORT_BY_DROPDOWN_LIST);
		selectIteminDefaultDropDownList(driver, ProductPageUI.SORT_BY_DROPDOWN_LIST, sortOptionValue);
	}

	public void selectDisplayOption(String displayProductsOption) {
		waitForElementVisible(driver, ProductPageUI.DISPLAY_PER_PAGE_DROPDOWN_LIST);
		selectIteminDefaultDropDownList(driver, ProductPageUI.DISPLAY_PER_PAGE_DROPDOWN_LIST, displayProductsOption);
	}

	public boolean isNextButtonDisplayed() {
		waitForElementVisible(driver, ProductPageUI.NEXT_BUTTON_PAGING);
		return isElementDisplayed(driver, ProductPageUI.NEXT_BUTTON_PAGING);
	}

	public void clickOnPagingNumber(String pageNumber) {
		waitForElementClickable(driver, ProductPageUI.PAGE_NUMBER_OPTION, pageNumber);
		clickToElement(driver, ProductPageUI.PAGE_NUMBER_OPTION, pageNumber);
	}

	public boolean isPreviousButtonDisplayed() {
		waitForElementVisible(driver, ProductPageUI.PREVIOUS_BUTTON_PAGING);
		return isElementDisplayed(driver, ProductPageUI.PREVIOUS_BUTTON_PAGING);
	}

	public boolean isNextButtonUnDisplayed() {
		waitForElementUnDisplayed(driver, ProductPageUI.NEXT_BUTTON_PAGING);
		return isElementUndisplayed(driver, ProductPageUI.NEXT_BUTTON_PAGING);
	}

	public boolean isPagingUnDisplayed() {
		waitForElementUnDisplayed(driver, ProductPageUI.PAGING_NAVIGATION);
		return isElementUndisplayed(driver, ProductPageUI.PAGING_NAVIGATION);
	}
}

