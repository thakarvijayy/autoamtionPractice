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

	@FindBy(id = "email")
	WebElement username;

	@FindBy(name = "passwd")
	WebElement password;

	@FindBy(name = "SubmitLogin")
	WebElement signInbutton;

	@FindBy(xpath="//h1[contains(text(),'Authentication')]")
	WebElement header;
	
	@FindBy(xpath="//li[contains(text(),'An email address required.')]")
	WebElement UserNameError;
	
	@FindBy(xpath="//li[contains(text(),'Password is required.')]")
	WebElement PasswordError;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath="//span[contains(text(),'Retrieve Password')]")
	WebElement retrievePassword;
	
	@FindBy(css="p[class*='alert-success']")
	WebElement confirmText;
	
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
	
	public String readUsernameError()
	{
		String actualError = UserNameError.getText();
		System.out.println(actualError);
		return actualError;
	}
	
	public String readPasswordError()
	{
		String actualError = PasswordError.getText();
		System.out.println(actualError);
		return actualError;
	}
	
	public String readConfirmationEmailText()
	{
		String successText = confirmText.getText();
		System.out.println(successText);
		return successText;
	}
	
	
	public String invalidEmailInForgotPassword()
	{
		String invalidEmail = invalidEmailInForgotPassword.getText();
		System.out.println(invalidEmail);
		return invalidEmail;
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
