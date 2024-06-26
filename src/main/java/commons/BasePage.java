package commons;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	public void openPageURL(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getParentID(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public String getPageUrl(WebDriver driver) {
		overrideImplicitTimeout(driver, shorTimeOut);
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refeshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(3);
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait expliciWait = new WebDriverWait(driver, 30);
		return expliciWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void switchtowindowbytitle(WebDriver driver, String expectedtitle) {
		Set<String> Allwindows = driver.getWindowHandles();

		for (String id : Allwindows) {
			if (!id.equals(expectedtitle)) {
				driver.switchTo().window(id);
				String actualtitle = driver.getTitle();
				if (actualtitle.equals(expectedtitle))
					break;
			}
		}
		sleepInSecond(shorTimeOut);
	}

	public void switchtowindowbylink(WebDriver driver, String expectedrelativelink) {
		Set<String> Allwindows = driver.getWindowHandles();

		for (String id : Allwindows) {
			if (!id.equals(expectedrelativelink)) {
				sleepInSecond(shorTimeOut);
				driver.switchTo().window(id);
				sleepInSecond(shorTimeOut);
				String actuallink = driver.getCurrentUrl();
				if (actuallink.equals(expectedrelativelink))
					break;
			}
		}
	}
	
	public void switchToWindowById (WebDriver driver, String currentid) {
		Set<String> Allwindows = driver.getWindowHandles();
		
		for (String id : Allwindows) {
			if(!id.equals(currentid)) {
				driver.switchTo().window(id);	
			}
		}
	}

	protected void CloseAllWindownsWithoutParent(WebDriver driver, String parentid) {

		Set<String> Allwindows = driver.getWindowHandles();

		for (String id : Allwindows) {
			if (!id.equals(parentid)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentid);
	}

	private By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=")
				|| locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=")
				|| locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath") || locatorType.startsWith("XPATH")
				|| locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is not supported!");
		}
		return by;
	}

	private String getDynamicElement(String locatorType, String... values) {
		if (locatorType.startsWith("xpath") || locatorType.startsWith("XPATH") || locatorType.startsWith("Xpath=")
				|| locatorType.startsWith("XPath=")) {
			locatorType = String.format(locatorType, (Object[]) values);
		} else if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			locatorType = String.format(locatorType, (Object[]) values);
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=")
				|| locatorType.startsWith("Class=")) {
			locatorType = String.format(locatorType, (Object[]) values);
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=")
				|| locatorType.startsWith("Name=")) {
			locatorType = String.format(locatorType, (Object[]) values);
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			locatorType = String.format(locatorType, (Object[]) values);
		}
		return locatorType;
	}

	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	public List<WebElement> getListWebElements(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	protected void clickToElement(WebDriver driver, String locatorType) {
		highlightElement(driver, locatorType);
		getWebElement(driver, locatorType).click();
	}

	protected void clickToElement(WebDriver driver, String locatorType, String... dynamicValue) {
		highlightElement(driver, locatorType, dynamicValue);
		getWebElement(driver, getDynamicElement(locatorType, dynamicValue)).click();
	}

	protected void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
		//WebElement element = getWebElement(driver, locatorType);
		highlightElement(driver, locatorType);
		getWebElement(driver, locatorType).clear();
		getWebElement(driver, locatorType).sendKeys(textValue);
	}

	protected void sendkeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValue) {
		//WebElement element = getWebElement(driver, getDynamicElement(locatorType, dynamicValue));
		locatorType = getDynamicElement(locatorType, textValue);
		highlightElement(driver, locatorType, dynamicValue);
		getWebElement(driver, locatorType).clear();
		getWebElement(driver, locatorType).sendKeys(textValue);
	}

	protected String getElementText(WebDriver driver, String locatorType) {
		highlightElement(driver, locatorType);
		return getWebElement(driver, locatorType).getText();
	}

	protected String getElementText(WebDriver driver, String locatorType, String... dynamicValue) {
		highlightElement(driver, locatorType, dynamicValue);
		return getWebElement(driver, getDynamicElement(locatorType, dynamicValue)).getText();
	}

	protected void selectIteminDefaultDropDownList(WebDriver driver, String locatorType, String textitem) {
		highlightElement(driver, locatorType);
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(textitem);
	}

	protected void selectIteminDefaultDropDownList(WebDriver driver, String locatorType, String textitem,
			String... dynamicValue) {
		highlightElement(driver, locatorType, dynamicValue);
		Select select = new Select(getWebElement(driver, getDynamicElement(locatorType, dynamicValue)));
		select.selectByVisibleText(textitem);
	}

	protected String getFirstSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {
		highlightElement(driver, locatorType);
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

	protected String getFirstSelectedItemDefaultDropdown(WebDriver driver, String locatorType, String... dynamicValue) {
		highlightElement(driver, locatorType, dynamicValue);
		Select select = new Select(getWebElement(driver, getDynamicElement(locatorType, dynamicValue)));
		return select.getFirstSelectedOption().getText();
	}

	protected boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		highlightElement(driver, locatorType);
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}

	protected boolean isDropdownMultiple(WebDriver driver, String locatorType, String... dynamicValue) {
		highlightElement(driver, locatorType, dynamicValue);
		Select select = new Select(getWebElement(driver, getDynamicElement(locatorType, dynamicValue)));
		return select.isMultiple();
	}

	protected void selectitemindropdownlist(WebDriver driver, String parentXpath, String childXpath,
			String expectectTextItem) {
		highlightElement(driver, parentXpath);
		getWebElement(driver, parentXpath).click();
		sleepInSecond(1);
		
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		
		List<WebElement> allitems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
		
		for (WebElement item : allitems) {
			if (item.getText().trim().equals(expectectTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}
	
	protected void selectIteminDropdownListSearchArea(WebDriver driver, String parentXpath, String childXpath,
			String expectectTextItem) {
		highlightElement(driver, parentXpath);
		getWebElement(driver, parentXpath).click();
		sleepInSecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		List<WebElement> allitems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));

		for (WebElement item : allitems) {
			if (item.getText().trim().equals(expectectTextItem)) {
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}

	protected String getElementAttribute(WebDriver driver, String locatorType, String attibuteName) {
		return getWebElement(driver, locatorType).getAttribute(attibuteName);
	}

	protected String getCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}

	protected String getCssValue(WebDriver driver, String locatorType, String propertyName, String... dynamicValue) {
		return getWebElement(driver, getDynamicElement(locatorType, dynamicValue)).getCssValue(propertyName);
	}

	protected String covertRgbaToHex(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	protected int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElements(driver, locatorType).size();
	}

	protected int getElementSize(WebDriver driver, String locatorType, String... dynamicValue) {
		return getListWebElements(driver, getDynamicElement(locatorType, dynamicValue)).size();
	}

	protected void checkToDefaultCheckBoxOrRadio(WebDriver driver, String locatorType) {
		highlightElement(driver, locatorType);
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void checkToDefaultCheckBoxOrRadio(WebDriver driver, String locatorType, String... dynamicValue) {
		WebElement element = getWebElement(driver, getDynamicElement(locatorType, dynamicValue));
		highlightElement(driver, locatorType, dynamicValue);
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void uncheckToDefaultCheckBoxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	protected void uncheckToDefaultCheckBoxRadio(WebDriver driver, String locatorType, String... dynamicValue) {
		WebElement element = getWebElement(driver, getDynamicElement(locatorType, dynamicValue));
		if (element.isSelected()) {
			element.click();
		}
	}

	protected boolean isElementDisplayed(WebDriver driver, String locatorType) {
		highlightElement(driver, locatorType);
		return getWebElement(driver, locatorType).isDisplayed();
	}

	protected boolean isElementDisplayed(WebDriver driver, String locatorType, String... dynamicValue) {
		highlightElement(driver, locatorType, dynamicValue);
		return getWebElement(driver, getDynamicElement(locatorType, dynamicValue)).isDisplayed();
	}

	public void overrideImplicitTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public boolean isElementUndisplayed(WebDriver driver, String locatorType) {
		overrideImplicitTimeout(driver, shorTimeOut);
		List<WebElement> elements = getListWebElements(driver, locatorType);
		overrideImplicitTimeout(driver, longTimeOut);

		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean isElementEnabled(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

	protected boolean isElementEnabled(WebDriver driver, String locatorType, String... dynamicValue) {
		return getWebElement(driver, getDynamicElement(locatorType, dynamicValue)).isEnabled();
	}

	protected boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}

	protected void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}

	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	protected void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	protected void hoverMouseToElement(WebDriver driver, String locatorType, String... dynamicValue) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, getDynamicElement(locatorType, dynamicValue))).perform();
	}

	protected void pressKeyToElement(WebDriver driver, String locatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locatorType), key).perform();
	}

	protected void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String... dynamicValue) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicElement(locatorType, dynamicValue)), key).perform();
	}

	protected void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		String highlightStyle = "border: 2px solid red; border-style: dashed;";
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				highlightStyle);
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	protected void highlightElement(WebDriver driver, String locatorType, String... dynamicValue) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, getDynamicElement(locatorType, dynamicValue));
		String originalStyle = element.getAttribute("style");
		String highlightStyle = "border: 2px solid red; border-style: dashed;";
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", highlightStyle);
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	protected void clickToElementByJS(WebDriver driver, String locatorType) {
		highlightElement(driver, locatorType);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	protected void clickToElementByJS(WebDriver driver, String locatorType, String... dynamicValue) {
		highlightElement(driver, locatorType, dynamicValue);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();",
				getWebElement(driver, getDynamicElement(locatorType, dynamicValue)));
	}
	
	protected void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	protected void scrollToElement(WebDriver driver, String locatorType, String... dynamicValue) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, getDynamicElement(locatorType, dynamicValue)));
	}

	protected void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locatorType));
	}

	protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	protected String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void upLoadMultipleFiles(WebDriver driver, String... fileNames) {
		String filePath = GlobalConstants.getGlobalConstants().getUploadFile();
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, BasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
		sleepInSecond(shorTimeOut);
	}

	protected void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	protected void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions
				.visibilityOfElementLocated(getByLocator(getDynamicElement(locatorType, dynamicValue))));
	}

	/*
	 * Wait for element undisplayed in DOM or not in DOM and override implicit
	 * timeout
	 */
	protected void waitForElementUnDisplayed(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shorTimeOut);
		overrideImplicitTimeout(driver, shorTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overrideImplicitTimeout(driver, longTimeOut);
	}

	protected void waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	protected void waitForAllElementVisible(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicElement(locatorType, dynamicValue))));
	}

	protected void waitForElementInVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	protected void waitForAllElementInVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, locatorType)));
	}

	protected void waitForAllElementInVisible(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions
				.invisibilityOfAllElements(getListWebElements(driver, getDynamicElement(locatorType, dynamicValue))));
	}

	protected void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}
	
	protected void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(
				ExpectedConditions.elementToBeClickable(getByLocator(getDynamicElement(locatorType, dynamicValue))));
	}
	

	/*
	 * https://www.youtube.com/watch?v=D6zh-yUL1fo&list=PLo1QA-RK2zyqDT_-l5anWh-
	 * hiIX69hDo-&index=93 SearchTable, Datatable (1:25:36)
	 */

	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private long longTimeOut = GlobalConstants.getGlobalConstants().getLongTimeout();
	private long shorTimeOut = GlobalConstants.getGlobalConstants().getShortTimeout();

}
