 package commons;

import java.io.File;

import lombok.Getter;

@Getter
public class GlobalConstantsRegisterCompletedPage {
	private static GlobalConstantsRegisterCompletedPage globalInstance;

	public static synchronized GlobalConstantsRegisterCompletedPage getGlobalConstants() {
		if (globalInstance == null) {
			globalInstance = new GlobalConstantsRegisterCompletedPage();
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
	private final String registerElement = "//div[@class='header-links']//a[@class='ico-register']";


	// Browser Stack
	private final String browserUserName = "vodongpham_vbRLlM";
	private final String browserAutomateKey = "idztyWmBznShx8tLvKAe";
	private final String browserStackUrl = "https://" + browserUserName + ":" + browserAutomateKey
			+ "@hub-cloud.browserstack.com/wd/hub";
}
