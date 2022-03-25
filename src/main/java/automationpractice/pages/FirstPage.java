package automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationpractice.base.TestBase;

public class FirstPage extends TestBase {
	
	
	@FindBy(xpath="//img[@alt=\"My Store\"]")
	WebElement logo;
	
	@FindBy(className="login")
	WebElement signIn;
	
	
	public FirstPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	
	public boolean logoCheck()
	{
		return logo.isDisplayed();
	}
	
	public void SignInClick()
	{
		signIn.click();
	}

}
