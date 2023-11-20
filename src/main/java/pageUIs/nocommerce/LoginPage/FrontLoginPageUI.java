package pageUIs.nocommerce.LoginPage;

public class FrontLoginPageUI {
	public static final String LOGIN_BUTTON = "XPATH= //div[@class='buttons']//button[@type='submit']";
	public static final String REGISTER_BUTTON = "XPATH= //div[@class='buttons']//button[@type='button']";
	public static final String ERROR_MESSAGE_BELOW_EMAIL_TEXTBOX = "XPATH= //input[@id='Email']//parent::div//span//span[@id='Email-error']";
	public static final String ERROR_MESSAGE_LINE_1 = "XPATH= //form[@method='post']//div[contains(.,'%s')]";
	public static final String ERROR_MESSAGE_LINE_2 = "XPATH= //form[@method='post']//div//li[contains(.,'%s')]";
	public static final String EMAIL_TEXTBOX = "XPATH= //input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "XPATH= //input[@id='Password']";
}
