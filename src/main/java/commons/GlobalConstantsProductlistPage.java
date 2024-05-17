 package commons;

import java.io.File;

import lombok.Getter;

@Getter
public class GlobalConstantsProductlistPage {
	private static GlobalConstantsProductlistPage globalInstance;

	public static synchronized GlobalConstantsProductlistPage getGlobalConstants() {
		if (globalInstance == null) {
			globalInstance = new GlobalConstantsProductlistPage();
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
	private final String homeURL = "https://demo.nopcommerce.com/";
	private final String logoutText = "Log out";

	// Browser Stack
	private final String browserUserName = "vodongpham_vbRLlM";
	private final String browserAutomateKey = "idztyWmBznShx8tLvKAe";
	private final String browserStackUrl = "https://" + browserUserName + ":" + browserAutomateKey
			+ "@hub-cloud.browserstack.com/wd/hub";
	
	private final String messageProductReviewIsSuccessfullyDisplayed = "Product review is successfully added.";
	private final String nameProductCategoryList = "Desktops";
	private final String productName = "Build your own computer";
	private final String addYourReviewLink = "Add your review";
	private final String reviewTitleContent = "Edward Comment";
	private final String reviewTextContent = "Good Product";
	private final String ratingOption = "addproductrating_3";
}
