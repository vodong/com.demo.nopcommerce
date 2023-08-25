 package commons;

import java.io.File;

import lombok.Getter;

@Getter
public class GlobalConstantsRegisterPage {
	private static GlobalConstantsRegisterPage globalInstance;

	public static synchronized GlobalConstantsRegisterPage getGlobalConstants() {
		if (globalInstance == null) {
			globalInstance = new GlobalConstantsRegisterPage();
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
	private final long shortTimeout = 5;
	private final long shortTimeoutWaiElement = 2;
	private final long longTimeout = 30;
	private final long retryTestFail = 3;

	// Definition Information
	private final String homeURL = "https://demo.nopcommerce.com/";
	private final String emailAddress = "abcde1@yopmail.com";
	private final String invalidEmailAddress = "abcde1@.com";
	private final String password = "Admin@123";
	private final String day = "2";
	private final String month = "March";
	private final String year = "1987";
	private final String errorMessageFirstname = "First name is required.";
	private final String errorMessageLasttname = "Last name is required.";
	private final String errorMessageEmailAlreadyExist = "The specified email already exists";
	private final String errorMessageEmailTextbox = "Email is required.";
	private final String errorMessageInvalidEmail = "Wrong email";
	private final String errorMessagePasswordTextbox = "Password is required.";
	private final String errorMessageConfirmPasswordTextbox = "Password is required.";
	private final String errorMessagePasswordLessThanSixChacracters1 = "Password must meet the following rules:";
	private final String errorMessagePasswordLessThanSixChacracters2 = "must have at least 6 characters";
	private final String errorMessagePasswordDoesNotMatch = "The password and confirmation password do not match.";


	// Browser Stack
	private final String browserUserName = "vodongpham_vbRLlM";
	private final String browserAutomateKey = "idztyWmBznShx8tLvKAe";
	private final String browserStackUrl = "https://" + browserUserName + ":" + browserAutomateKey
			+ "@hub-cloud.browserstack.com/wd/hub";
}
