package automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationpractice.base.TestBase;

public class SignUpPage extends TestBase {
	
	//Defining page Factory or Ibject Repository
	
		//for login Button
		@FindBy(className="login")
		WebElement loginbutton;
		
		@FindBy(id="email_create")
		WebElement email;
		
		@FindBy(id="SubmitCreate")
		WebElement createAnAccount;
		
		@FindBy(xpath="//h1[contains(text(),'Authentication')]")
		WebElement header;
		
		

}
