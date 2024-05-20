package pageUIs.nocommerce.SearchPage;

public class SearchPageUI {
	public static final String SEARCH_BUTTON = "XPATH= //div[@class='buttons']//button[@type='submit']";
	public static final String ERROR_MESSAGE = "XPATH= //div[@class='products-wrapper']//div[contains(.,'%s')]";
	public static final String SEARCH_TEXTBOX = "XPATH= //input[@class='search-text']";
	public static final String PRODUCT_NAME = "XPATH= //div[@class='item-grid']//h2[contains(.,'%s')]";
	public static final String ADVANCED_SEARCH_OPTION = "XPATH= //div//input[@id='advs']";
	public static final String AUTOMATICALLY_SEARCH_OPTION = "XPATH= //div//input[@id='isc']";
	public static final String SEARCH_IN_PRODUCT_OPTION = "XPATH= //div//input[@id='sid']";
	public static final String CATEGORY_OPTION = "XPATH= //div[@class='inputs']//select[@name='cid']";
	public static final String MANUFACTUER_OPTION = "XPATH= //div[@class='inputs']//select[@name='mid']";

}
