package pageUIs.nocommerce.ProductPageUI;

public class ProductPageUI {
	public static final String PRODUCT_CATEGORY = "XPATH= //*[contains(@class,'notmobile')]//a[contains(., '%s')]";
	public static final String PRODUCT_CATEGORY_LIST = "XPATH= //div[@class='item-grid']//a[contains(.,'%s')]";
	public static final String PRODUCT_LIST = "XPATH= //div[@class='product-grid']//h2[@class='product-title']//a[contains(.,'%s')]";
	public static final String PRODUCT_NAME_TEXT = "XPATH= //div[@class='product-name']//h1";
	public static final String ADD_YOUR_REVIEW_LINK = "XPATH= //div[@class='product-reviews-overview']//a[contains(.,'%s')]";
	public static final String REVIEW_TITLE_TEXTBOX = "XPATH= //input[@class='review-title']";
	public static final String REVIEW_TEXT_TEXTBOX = "XPATH= //textarea[@class='review-text']";
	public static final String RATING = "XPATH= //div[@class='rating-options']//input[@id='%s']";
	public static final String SUBMIT_REVIEW_BUTTON = "XPATH= //button[@id='add-review']";
}
