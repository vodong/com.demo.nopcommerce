package commons;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.HomePage.HomePageObject;
import com.nopcommerce.LoginPage.LoginPageObject;
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

}
