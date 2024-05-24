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
	public static final String SORT_BY_DROPDOWN_LIST = "XPATH= //div//select[@id='products-orderby']";
	public static final String DISPLAY_PER_PAGE_DROPDOWN_LIST = "XPATH= //div//select[@id='products-pagesize']";
	public static final String PRODUCT_TITLE_NAME = "CSS= h2.product-title a";
	public static final String NEXT_BUTTON_PAGING = "XPATH= //div//li[@class='next-page']";
	public static final String PAGING_NAVIGATION = "XPATH= //div[@class='pager']";
	public static final String PREVIOUS_BUTTON_PAGING = "XPATH= //div//li[@class='previous-page']";
	public static final String PAGE_NUMBER_OPTION = "XPATH= //div//li[@class='individual-page']/a[text()='%s']";
}
