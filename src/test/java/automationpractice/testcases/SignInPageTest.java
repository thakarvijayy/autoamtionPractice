package automationpractice.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationpractice.base.TestBase;
import automationpractice.pages.FirstPage;
import automationpractice.pages.HomePage;
import automationpractice.pages.SignInPage;

public class SignInPageTest extends TestBase {

	SignInPage signInPage;
	HomePage homePage;
	FirstPage first;

	// Initializing the super class constructor properties
	public SignInPageTest() {
		super(); // this will call the super class constructor
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		first = new FirstPage();
		signInPage = new SignInPage();

	}

	@Test(priority=1)
	public void SignInPageTitleTest() {
		first.SignInClick();
		String title = signInPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login - My Store");
	}

	@Test(priority=2)
	public void SignInPageHeaderTest() {
		first.SignInClick();
		boolean header = signInPage.validateHeader();
		Assert.assertTrue(header);
	}

	@Test(priority=3)
	public void ValidloginTest() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("username"), prop.getProperty("password")); // this login is
																									// returning home
																									// page class so we
																									// saved as homePage

	}

	@Test(priority=4)
	public void InvalidUsernameloginTest() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("emptyUsername"), prop.getProperty("password"));
		Assert.assertEquals(signInPage.readUsernameError(), "An email address required.");
	}

	@Test(priority=5)
	public void InvalidPasswordloginTest() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("username"), prop.getProperty("emptyPassword"));
		Assert.assertEquals(signInPage.readPasswordError(), "Password is required.");
	}

	@Test(priority = 6)
	public void InvalidCredentialsloginTest() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("emptyUsername"), prop.getProperty("emptyPassword"));
		Assert.assertEquals(signInPage.readUsernameError(), "An email address required.");
	}
	
	@Test(priority=7)
	public void validForgotPasswordLinkFunction() 
	{
		first.SignInClick();
		signInPage.validForgotPasswordFunction(prop.getProperty("username"));
		Assert.assertEquals(signInPage.readConfirmationEmailText(), "A confirmation email has been sent to your address: " +  prop.getProperty("username") );
	}
	
	@Test(priority=8)
	public void invalidForgotPasswordLinkFunction() 
	{
		first.SignInClick();
		signInPage.validForgotPasswordFunction(prop.getProperty("emptyUsername"));
		Assert.assertEquals(signInPage.invalidEmailInForgotPassword(), "Invalid email address.");
	}	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
