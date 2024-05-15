 package commons;

import java.io.File;

import lombok.Getter;

@Getter
public class GlobalConstantsLoginPage {
	private static GlobalConstantsLoginPage globalInstance;

	public static synchronized GlobalConstantsLoginPage getGlobalConstants() {
		if (globalInstance == null) {
			globalInstance = new GlobalConstantsLoginPage();
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
	private final String errorMessageEmptyData = "Please enter your email";
	private final String errorMessageInvalidEmail = "Please enter a valid email address.";
	private final String errorMessageEmailDoesNotExist = "No customer account found";
	private final String errorMessageInvalidData1 = "Login was unsuccessful. Please correct the errors and try again.";
	private final String errorMessageInvalidData2 = "The credentials provided are incorrect";

	// Browser Stack
	private final String browserUserName = "vodongpham_vbRLlM";
	private final String browserAutomateKey = "idztyWmBznShx8tLvKAe";
	private final String browserStackUrl = "https://" + browserUserName + ":" + browserAutomateKey
			+ "@hub-cloud.browserstack.com/wd/hub";
	}
