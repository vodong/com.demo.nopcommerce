package com.nopcommerce.ProductPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.nopcommerce.HomePage.HomePageObject;
import com.nopcommerce.LoginPage.LoginPageObject;
import com.nopcommerce.MyAddressPage.MyAddressPageObject;
import com.nopcommerce.MyPasswordsPage.copy.MyPasswordPageObject;
import com.nopcommerce.MyProductReviewPage.MyProductReviewPageObject;
import com.nopcommerce.ProductCategoryPage.ProductCategoryPageObject;
import com.nopcommerce.ProductDetailPage.ProductDetailPageObject;
import com.nopcommerce.ProductListPage.ProductListPageObject;

import commons.BaseTest;
import commons.GlobalConstantsLoginPage;
import commons.GlobalConstantsMyAccountPage;
import commons.GlobalConstantsMyAddressPage;
import commons.GlobalConstantsProductDetailPage;
import commons.GlobalConstantsProductlistPage;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import helpers.PropertiesHelper;
import reportConfig.ExtentTestManager;

public class Product_Page extends BaseTest {
	WebDriver driver;
	MyAddressPageObject myAddress_Page;
	MyPasswordPageObject myPassword_Page;
	HomePageObject home_Page;
	LoginPageObject login_Page;
	MyProductReviewPageObject my_product_review_page;
	ProductCategoryPageObject category_Page;
	ProductListPageObject product_List_Page;
	ProductDetailPageObject product_Detail_Page;
	String emailAddress, password, fristname, lastname, emailAddress1, new_password, product_Title, getCurrentUrl;

	Environment environment;

	@Parameters({ "envName", "serverName", "browser", "osName", "osVersion", "ipAddress", "portNumber" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("DEV") String serverName,
			@Optional("chrome") String browserName, @Optional("Windows") String osName,
			@Optional("10") String osVersion, @Optional("localhost") String ipAddress,
			@Optional("4444") String portNumber) {

		//driver = getBrowserDriver(envName, serverName, browserName, osName, osVersion, ipAddress, portNumber);
		driver = getDriverInstance();
		home_Page = PageGeneratorManager.getHomepage(driver);
		login_Page = PageGeneratorManager.getLoginpage(driver);
		PropertiesHelper.loadAllFiles();
		emailAddress = PropertiesHelper.getValue("email");
		password = PropertiesHelper.getValue("password");
	}
	
	@Test (groups = "Product Page")
	public void Sort_Product_Name_A_To_Z(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort Product Name A To Z");
		ExtentTestManager.getTest().log(Status.INFO, "Sort Product Name A To Z - Step 01: Open Product Category Page");
		category_Page = home_Page.clickOnProductCategoryOnHeaderMenu(GlobalConstantsMyAccountPage.getGlobalConstants().getProductCategoryLink());
//		if(driver.findElement(By.cssSelector("a.ico-login")).isDisplayed()) 
//		{
//			category_Page = home_Page.clickOnProductCategoryOnHeaderMenu(GlobalConstantsMyAccountPage.getGlobalConstants().getProductCategoryLink());
//		}else {
//			login_Page = home_Page.clickOnLoginLink();
//			login_Page.inputEmailAddress(emailAddress);
//			login_Page.inputPassword(password);	
//			home_Page = login_Page.clickOnLoginButton();
//			category_Page = home_Page.clickOnProductCategoryOnHeaderMenu(GlobalConstantsMyAccountPage.getGlobalConstants().getProductCategoryLink());
//		}
		ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 03: Open The Product List Page");
		product_List_Page = category_Page.clickOnProductListCategory(GlobalConstantsProductlistPage.getGlobalConstants().getNameProductCategoryList1());
		ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Select Option Sort By Name A To Z");
		product_List_Page.selectSortOption(GlobalConstantsProductlistPage.getGlobalConstants().getSortByNameAToZ());
		sleepInsecond(2);
		ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Verrify Product Name Sort By A To Z");
		List<WebElement> products_Webelement = driver.findElements(By.cssSelector("h2.product-title a"));
		List<String> productNames = new ArrayList<>();

        for (WebElement product : products_Webelement) {
            productNames.add(product.getText());
           // System.out.println(productNames);
        }

        // Verify if the names are sorted in descending order (Z to A)
        List<String> sortedNames = new ArrayList<>(productNames);
        Collections.sort(sortedNames);

        if (productNames.equals(sortedNames)) {
            System.out.println("Product names are sorted correctly from A to Z.");
        } else {
            System.out.println("Product names are not sorted correctly.");
        }
    }
	
	@Test (groups = "Product Page", dependsOnMethods = "Sort_Product_Name_A_To_Z")
	public void Sort_Product_Name_Z_To_A(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort Product Name Z To A");
		ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Select Option Sort By Name Z To A");
		product_List_Page.selectSortOption(GlobalConstantsProductlistPage.getGlobalConstants().getSortByNameZToA());
		sleepInsecond(2);
		ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Verrify Product Name Sort By Z To A");
		List<WebElement> products_Webelement = driver.findElements(By.cssSelector("h2.product-title a"));
		List<String> productNames = new ArrayList<>();

        for (WebElement product : products_Webelement) {
            productNames.add(product.getText());
           // System.out.println(productNames);
        }

        // Verify if the names are sorted in descending order (Z to A)
        List<String> sortedNames = new ArrayList<>(productNames);
        sortedNames.sort(Collections.reverseOrder());

        if (productNames.equals(sortedNames)) {
            System.out.println("Product names are sorted correctly from Z to A.");
        } else {
            System.out.println("Product names are not sorted correctly.");
        }
	}
	
	@Test (groups = "Product Page", dependsOnMethods = "Sort_Product_Name_Z_To_A")
	public void Sort_Product_Price_Low_To_High(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort Product Price Low To High");
		ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Select Option Sort By Price Low To High");
		product_List_Page.selectSortOption(GlobalConstantsProductlistPage.getGlobalConstants().getSortByPriceLowToHigh());
		sleepInsecond(2);
		ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Verrify Product By Price Low To High");
	    List<WebElement> prices = driver.findElements(By.cssSelector("span.actual-price"));

	    List<Double> priceValues = new ArrayList<>();
	    for (WebElement price : prices)
	    {
	    	String priceText = price.getText().replace("$", "").replace(",", "");
	    	priceValues.add(Double.parseDouble(priceText));
	    }

	    boolean isSorted = true;
        for (int i = 0; i < priceValues.size() - 1; i++) {
            if (priceValues.get(i) > priceValues.get(i + 1)) {
                isSorted = false;
                break;
            }
        }

        if (isSorted) {
            System.out.println("Prices are sorted correctly from low to high.");
        } else {
            System.out.println("Prices are not sorted correctly.");
        }
	}
	
	@Test (groups = "Product Page", dependsOnMethods = "Sort_Product_Price_Low_To_High")
	public void Sort_Product_Price_High_To_Low(Method method) {
		ExtentTestManager.startTest(method.getName(), "Sort Product Price High To Low");
		ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Select Option Sort By Price High To Low");
		product_List_Page.selectSortOption(GlobalConstantsProductlistPage.getGlobalConstants().getSortByPriceHighToLow());
		sleepInsecond(2);
		ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Verrify Product Sort By Price High To Low");
		List<WebElement> prices = driver.findElements(By.cssSelector("span.actual-price"));

		List<Double> priceValues = new ArrayList<>();
		    for (WebElement price : prices)
		    {
		    	String priceText = price.getText().replace("$", "").replace(",", "");
		    	priceValues.add(Double.parseDouble(priceText));
		    }

		  List<Double> sortedPrices = new ArrayList<>(priceValues);
          Collections.sort(sortedPrices, Collections.reverseOrder());

	      if (priceValues.equals(sortedPrices)) {
	    	  
	            System.out.println("Prices are sorted correctly from high to low.");
	      } else {
	            System.out.println("Prices are not sorted correctly.");
	      }
	}
	
	@Test (groups = "Product Page", dependsOnMethods = "Sort_Product_Price_High_To_Low")
	public void Product_Display_3_Products_Per_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Product Display 3 Products Per Page");
		ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Select Option Display 3 Per Page");
		product_List_Page.selectDisplayOption(GlobalConstantsProductlistPage.getGlobalConstants().getDisplay3ProductsOption());
		sleepInsecond(2);
		ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Verrify Product List Will Be Shown 3 Products Per Page");
		List<WebElement> products_Webelement = driver.findElements(By.cssSelector("h2.product-title a"));
        if (products_Webelement.size() <= 3) {
            	 System.out.println("The page is shown 3 products per page");
            }
            else {
                System.out.println("The page is shown more than 3 products per page");
            }
        ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Verrify The Next Button Will Be Shown When Chossing Page 1");
        assertTrue(product_List_Page.isNextButtonDisplayed());
        ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Go To The Next Page");
        product_List_Page.clickOnPagingNumber(GlobalConstantsProductlistPage.getGlobalConstants().getPageNumber2());
        ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Verrify The Previos Button Will Be Shown When Chossing Page 2");
        assertTrue(product_List_Page.isPreviousButtonDisplayed());
		ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Verrify The Next Button Will Not Be Shown When Chossing Page 2");
		assertTrue(product_List_Page.isNextButtonUnDisplayed());
	}
	
	@Test (groups = "Product Page", dependsOnMethods = "Product_Display_3_Products_Per_Page")
	public void Product_Display_6_Products_Per_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Product Display 6 Products Per Page");
		ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Select Option Display 6 Per Page");
		product_List_Page.selectDisplayOption(GlobalConstantsProductlistPage.getGlobalConstants().getDisplay6ProductsOption());
		sleepInsecond(2);
		ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Verrify Product List Will Be Shown 6 Products Per Page");
		List<WebElement> products_Webelement = driver.findElements(By.cssSelector("h2.product-title a"));
        if (products_Webelement.size() <= 6) {
            	 System.out.println("The page is shown 6 products per page");
            }
            else {
                System.out.println("The page is shown more than 6 products per page");
            }
		ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Verrify The Paging Will Not Be Shown When The Product List Is Less Than 7 Products");
		assertTrue(product_List_Page.isPagingUnDisplayed());
	}
	
	@Test (groups = "Product Page", dependsOnMethods = "Product_Display_3_Products_Per_Page")
	public void Product_Display_9_Products_Per_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "Product Display 9 Products Per Page");
		ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Select Option Display 9 Per Page");
		product_List_Page.selectDisplayOption(GlobalConstantsProductlistPage.getGlobalConstants().getDisplay9ProductsOption());
		sleepInsecond(2);
		ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Verrify Product List Will Be Shown 9 Products Per Page");
		List<WebElement> products_Webelement = driver.findElements(By.cssSelector("h2.product-title a"));
        if (products_Webelement.size() <= 9) {
            	 System.out.println("The page is shown 9 products per page");
            }
            else {
                System.out.println("The page is shown more than 9 products per page");
            }
		ExtentTestManager.getTest().log(Status.INFO, "Product Page - Product Listing Page - Step 04: Verrify The Paging Will Not Be Shown When The Product List Is Less Than 9 Products");
		assertTrue(product_List_Page.isPagingUnDisplayed());
	}
	
	public void sleepInsecond (long second) {
		try {
			Thread.sleep(second *1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Parameters({"browser"})
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		ExtentTestManager.getTest().log(Status.INFO, "Close browser '" + browserName + "'");
		closeBrowserAndDriver();
	}
}

