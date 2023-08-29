package pageUIs.nocommerce.RegisterPage;

public class RegisterPageUI {
	public static final String REGISTER_BUTTON = "XPATH= //div[@class='buttons']//button[@name='register-button']";
	public static final String FIRST_NAME_TEXTBOX = "XPATH= //div[@class='inputs']//input[@name='FirstName']";
	public static final String ERROR_MESSAGE_FIRST_NAME_TEXTBOX = "XPATH= //span[@id='FirstName-error' and contains(.,'%s')]";
	public static final String LAST_NAME_TEXTBOX = "XPATH= //div[@class='inputs']//input[@name='LastName']";
	public static final String ERROR_MESSAGE_LAST_NAME_TEXTBOX = "XPATH= //span[@id='LastName-error' and contains(.,'%s')]";
	public static final String DAY_DROPDOWN = "XPATH= //div//div[@class='date-picker-wrapper']//select[@name='DateOfBirthDay']";
	public static final String MONTH_DROPDOWN = "XPATH= //div//div[@class='date-picker-wrapper']//select[@name='DateOfBirthMonth']";
	public static final String YEAR_DROPDOWN = "XPATH= //div//div[@class='date-picker-wrapper']//select[@name='DateOfBirthYear']";
	public static final String EMAIL_TEXTBOX = "XPATH= //div[@class='inputs']//input[@name='Email']";
	public static final String ERROR_MESSAGE_EMAIL_TEXTBOX = "XPATH= //span[@id='Email-error' and contains(.,'%s')]";
	public static final String ERROR_MESSAGE_EMAIL_ALREADY_EXIST = "XPATH= //div[@class='page-body']//li[contains(.,'%s')]";
	public static final String PASSWORD_TEXTBOX = "XPATH= //div[@class='inputs']//input[@name='Password']";
	public static final String ERROR_MESSAGE_PASSWORD_LESS_THAN_LINE1 = "XPATH= //span[@id='Password-error']/p[contains(.,'%s')]";
	public static final String ERROR_MESSAGE_PASSWORD_LESS_THAN_LINE2 = "XPATH= //span[@id='Password-error']//li[contains(.,'%s')]";
	public static final String ERROR_MESSAGE_PASSWORD_TEXTBOX = "XPATH= //input[@id='Password']/parent::div//span[@id='Password-error' and contains(.,'%s')]";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "XPATH= //div[@class='inputs']//input[@name='ConfirmPassword']";
	public static final String ERROR_MESSAGE_CONFIRM_PASSWORD_TEXTBOX = "XPATH= //input[@id='ConfirmPassword']/parent::div//span[@id='ConfirmPassword-error' and contains(.,'%s')]";
	public static final String LOGIN_LINK_ON_HEADER = "XPATH= //div[@class='header-links']//a[@class='ico-login']";
}
