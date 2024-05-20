 package commons;

import java.io.File;

import lombok.Getter;

@Getter
public class GlobalConstantsSearchPage {
	private static GlobalConstantsSearchPage globalInstance;

	public static synchronized GlobalConstantsSearchPage getGlobalConstants() {
		if (globalInstance == null) {
			globalInstance = new GlobalConstantsSearchPage();
		}
		return globalInstance;
	}

	private final String projectPath = System.getProperty("user.dir");
	private final String javaVersion = System.getProperty("java.version");
	private final String osName = System.getProperty("os.name");
	private final String uploadFile = projectPath + File.separator + "uploadFiles" + File.separator;
	private final String testData = projectPath + File.separator + "testdata" + File.separator;
	private final String downloadFile = projectPath + File.separator + "downloadFiles";
	private final String browserLog = projectPath + File.separator + "browserLogs" + File.separator;
	private final String dragDropHTML5 = projectPath + File.separator + "dragDropHTML5";
	private final String autoITScritp = projectPath + File.separator + "autoIT";
	private final String reportingScreenshot = projectPath + File.separator + "reportNGImages" + File.separator;
	private final long shortTimeout = 2;
	private final long shortTimeoutWaiElement = 2;
	private final long longTimeout = 30;
	private final long retryTestFail = 3;

	// Definition URL
	private final String loginURL = "https://demo.nopcommerce.com/login?returnUrl=%2F";
	private final String registerURL = "https://demo.nopcommerce.com/register?returnUrl=%2F";
	private final String invalidEmailFormat = "test.com";
	private final String emailDoesNotExist = "test_ed@yop.com";
	private final String invalidPassword = "Admin@123456";

	// Browser Stack
	private final String browserUserName = "vodongpham_vbRLlM";
	private final String browserAutomateKey = "idztyWmBznShx8tLvKAe";
	private final String browserStackUrl = "https://" + browserUserName + ":" + browserAutomateKey
			+ "@hub-cloud.browserstack.com/wd/hub";
	
	private final String errorMessageEmptyData = "Search term minimum length is 3 characters";
	private final String errorMessageDoesNotExistData = "No products were found that matched your criteria.";
	private final String product1 = "Lenovo IdeaCentre 600 All-in-One PC";
	private final String product2 = "Lenovo Thinkpad X1 Carbon Laptop";
	private final String product3 = "Apple MacBook Pro 13-inch";
	private final String productName = "Apple Macbook Pro";
	private final String categoryName = "Computers";
	private final String manufacturerName1 = "HP";
	private final String manufacturerName2 = "Apple";
	
	}
