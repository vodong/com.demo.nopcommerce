package commons;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.HomePage.HomePageObject;
import com.nopcommerce.LoginPage.LoginPageObject;
import com.nopcommerce.MyAccountPage.MyAccountPageObject;
import com.nopcommerce.MyAddressPage.MyAddressPageObject;
import com.nopcommerce.MyPasswordsPage.copy.MyPasswordPageObject;
import com.nopcommerce.MyProductReviewPage.MyProductReviewPageObject;
import com.nopcommerce.ProductCategoryPage.ProductCategoryPageObject;
import com.nopcommerce.ProductDetailPage.ProductDetailPageObject;
import com.nopcommerce.ProductListPage.ProductListPageObject;
import com.nopcommerce.RegisterCompletedPage.RegisterCompletedPageObject;
import com.nopcommerce.RegisterPage.RegisterPageObject;


public class PageGeneratorManager {

	public static HomePageObject getHomepage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static LoginPageObject getLoginpage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterpage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static RegisterCompletedPageObject getRegisterCompletedpage(WebDriver driver) {
		return new RegisterCompletedPageObject(driver);
	}

	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}

	public static MyAddressPageObject getMyAddressPageObject(WebDriver driver) {
		return new MyAddressPageObject(driver);
	}
	
	public static MyPasswordPageObject getMyPasswordPageObject(WebDriver driver) {
		return new MyPasswordPageObject(driver);
	}
	
	public static ProductCategoryPageObject getProductCategoryPageObject(WebDriver driver) {
		return new ProductCategoryPageObject(driver);
	}
	
	public static ProductListPageObject getProductListPageObject(WebDriver driver) {
		return new ProductListPageObject(driver);
	}
	
	public static ProductDetailPageObject getProductDetailPageObject(WebDriver driver) {
		return new ProductDetailPageObject(driver);
	}
	
	public static MyProductReviewPageObject getMyProductReviewList(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}

}
