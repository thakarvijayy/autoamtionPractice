package automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import automationpractice.base.TestBase;

public class SignInPage extends TestBase {

	// Defining page Factory or Ibject Repository

	// for login Button
	@FindBy(className = "login")
	WebElement loginbutton;
	
	
	//for email address field
	@FindBy(id = "email")
	WebElement username;
	
	//for password field
	@FindBy(name = "passwd")
	WebElement password;
	
	//for submit button
	@FindBy(name = "SubmitLogin")
	WebElement signInbutton;
	
	//to check header value on login page
	@FindBy(xpath="//h1[contains(text(),'Authentication')]")
	WebElement header;
	
	//when passing only password
	@FindBy(xpath="//li[contains(text(),'An email address required.')]")
	WebElement UserNameError;
	
	//When passing wrong email
	@FindBy(xpath="//li[contains(text(),'Invalid email address.')]")
	WebElement invalidEmail;
	
	//When passing validEmail and wrong password
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]")
	WebElement authenticationFailed;
	
	
	//When passing only username
	@FindBy(xpath="//li[contains(text(),'Password is required.')]")
	WebElement PasswordError;
	
	//For forgot password link
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	WebElement forgotPasswordLink;
	
	//for retrieve password button
	@FindBy(xpath="//span[contains(text(),'Retrieve Password')]")
	WebElement retrievePassword;
	
	//For confirm text after clicking retrivepassword button
	@FindBy(css="p[class*='alert-success']")
	WebElement confirmText;
	
	//when passing invalid email in forgot password field
	@FindBy(xpath="//li[contains(text(),'Invalid email address.')]")
	WebElement invalidEmailInForgotPassword;
	
	// to intialize page factory
	public SignInPage() {

		PageFactory.initElements(driver, this);
	}

	// actions / features
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	//if header is displayed then it will display in boolean
	public boolean validateHeader()
	{
		return header.isDisplayed();
	}
	
	public HomePage login(String uname, String pswd)
	{
		
		
		username.sendKeys(uname);
		password.sendKeys(pswd);
		signInbutton.click();
		
		return new HomePage();
	}
	
	public void invalidUsernameLogin(String uname, String pswd)
	{
		username.sendKeys(uname);
		password.sendKeys(pswd);
		signInbutton.click();
		
	}
	
	//for username error text
	public String readUsernameError()
	{
		String actualError = UserNameError.getText();
		System.out.println(actualError);
		return actualError;
	}
	
	//for password error text
	public String readPasswordError()
	{
		String actualError = PasswordError.getText();
		System.out.println(actualError);
		return actualError;
	}
	
	//for invalid authentication error // when passing valid email and wrong password
	public String reaadAuthenticationError()
	{
		String authError = authenticationFailed.getText();
		System.out.println(authError);
		return authError;
	}
	
	// For invalid email address // when passing invalid email and correct password
	public String readInvalidEmailAddressInLogin()
	{
		String invalidEmailInLogin = invalidEmail.getText();
		System.out.println(invalidEmailInLogin);
		return invalidEmailInLogin;
	}
	
	//to read confirmation email text after passing valid email in forgot password page
	public String readConfirmationEmailText()
	{
		String successText = confirmText.getText();
		System.out.println(successText);
		return successText;
	}
	
	//to read invalid email in forgot password page
	public String invalidEmailInForgotPassword()
	{
		String invalidEmail = invalidEmailInForgotPassword.getText();
		System.out.println(invalidEmail);
		return invalidEmail;
	}
	
	//Giving String as Email Address without any @ sign
	public void StringAsEmailAddress(String uname, String pswd)
	{
		username.sendKeys(uname);
		password.sendKeys(pswd);
		signInbutton.click();
	}
	
	//Passing number as a Email address
	public void numberAsEmailAddress(String uname, String pswd)
	{
		username.sendKeys(uname);
		password.sendKeys(pswd);
		signInbutton.click();
	}
	
	//passing only special characters as a Email address
	public void onlySpecialCharacterAsEmailAddress(String uname, String pswd)
	{
		username.sendKeys(uname);
		password.sendKeys(pswd);
		signInbutton.click();
	}
	
	//Passing email value without dot
	public void missingDotAsEmailAddress(String uname, String pswd)
	{
		username.sendKeys(uname);
		password.sendKeys(pswd);
		signInbutton.click();
	}
	
	//passing 2 @ sign as email address
	public void twoAtSignsAsEmailAddress(String uname, String pswd)
	{
		username.sendKeys(uname);
		password.sendKeys(pswd);
		signInbutton.click();
	}
	
	
	public void validForgotPasswordFunction(String uname)
	{
		forgotPasswordLink.click();
		username.sendKeys(uname);
		retrievePassword.click();
		
	}
	
	
	public void invalidForgotPasswordFunction(String uname)
	{
		forgotPasswordLink.click();
		username.sendKeys(uname);
		retrievePassword.click();
		
	}
	
	
	
	

}
