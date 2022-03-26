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

	// For checking log in page title
	@Test(priority = 1)
	public void signInPageTitleTest() {
		first.SignInClick();
		String title = signInPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login - My Store");
	}

	// For checking Header in Log in Page to make sure we are at right page
	@Test(priority = 2)
	public void signInPageHeaderTest() {
		first.SignInClick();
		boolean header = signInPage.validateHeader();
		Assert.assertTrue(header);
	}

	// For valid log in functionality
	@Test(priority = 3)
	public void validloginTest() {
		first.SignInClick();
		// this login is returning homepage class so we saved as homePage
		homePage = signInPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	// For empty user test with valid password
	@Test(priority = 4)
	public void emptyUsernameWithValidPasswordloginTest() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("emptyUsername"), prop.getProperty("password"));
		Assert.assertEquals(signInPage.readUsernameError(), "An email address required.");
	}

	// for Empty username with Invalid password
	@Test(priority = 5)
	public void emptyUsernameWithInvalidPasswordloginTest() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("emptyUsername"), prop.getProperty("invalidPassword"));
		Assert.assertEquals(signInPage.readUsernameError(), "An email address required.");
	}

	// for unregistered email with registered password
	@Test(priority = 6)
	public void unregisteredUsernameWithValidPasswordLoginTest() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("unregisteredUsername"), prop.getProperty("password"));
		Assert.assertEquals(signInPage.reaadAuthenticationError(), "Authentication failed.");
	}

	// for unregistered email with unregistered password
	@Test(priority = 7)
	public void unregisteredUsernameWithUnregisteredPasswordLoginTest() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("unregisteredUsername"), prop.getProperty("invalidPassword"));
		Assert.assertEquals(signInPage.reaadAuthenticationError(), "Authentication failed.");
	}

	// For valid username and empty password
	@Test(priority = 8)
	public void invalidPasswordWithValidUsernameloginTest() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("username"), prop.getProperty("emptyPassword"));
		Assert.assertEquals(signInPage.readPasswordError(), "Password is required.");
	}

	// fir both empty username and password
	@Test(priority = 9)
	public void invalidCredentialsloginTest() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("emptyUsername"), prop.getProperty("emptyPassword"));
		Assert.assertEquals(signInPage.readUsernameError(), "An email address required.");
	}

	// Test for Passing String as Email Address(Invalid Email) and valid password
	@Test(priority = 10)
	public void stringAsUsernameWithValidPasswordTest() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("stringAsUsername"), prop.getProperty("password"));
		Assert.assertEquals(signInPage.readInvalidEmailAddressInLogin(), "Invalid email address.");

	}

	// Test For passing String as Email Address(Invalid Email) and empty password
	@Test(priority = 11)
	public void stringAsUsernameWithEmptyPasswordTest() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("stringAsUsername"), prop.getProperty("emptyPassword"));
		Assert.assertEquals(signInPage.readInvalidEmailAddressInLogin(), "Invalid email address.");
	}

	// Test for passing String as Email Address(Invalid Email) and invalid password
	@Test(priority = 12)
	public void stringAsUsernameWithInvalidPasswordTest() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("stringAsUsername"), prop.getProperty("invalidPassword"));
		Assert.assertEquals(signInPage.readInvalidEmailAddressInLogin(), "Invalid email address.");
	}

	// Test for passing number as Email address(Invalid Email) and valid password
	@Test(priority = 13)
	public void numberAsUsernameWithValidPassword() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("numbersAsUsername"), prop.getProperty("password"));
		Assert.assertEquals(signInPage.readInvalidEmailAddressInLogin(), "Invalid email address.");

	}

	// Test for passing number as Email address(Invalid Email) with empty password
	@Test(priority = 14)
	public void numberAsUsernameWithEmptyPassword() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("numbersAsUsername"), prop.getProperty("emptyPassword"));
		Assert.assertEquals(signInPage.readInvalidEmailAddressInLogin(), "Invalid email address.");
	}

	// Test for passing number as Email Address(Invalid Email) with Invalid Password
	@Test(priority = 15)
	public void numberAsUsernameWithInvalidPassword() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("numbersAsUsername"), prop.getProperty("invalidPassword"));
		Assert.assertEquals(signInPage.readInvalidEmailAddressInLogin(), "Invalid email address.");
	}

	// Test for only Special Character as Email Address(Invalid Email) with valid
	// password
	@Test(priority = 16)
	public void specialCharAsUsernameWithValidPassword() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("onlySpecialCharacterAsUsername"), prop.getProperty("password"));
		Assert.assertEquals(signInPage.readInvalidEmailAddressInLogin(), "Invalid email address.");

	}

	// Test for only special Characters as Email Address(Invalid Email) with empty
	// password
	@Test(priority = 17)
	public void specialCharAsUsernameWithEmptyPassword() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("onlySpecialCharacterAsUsername"),
				prop.getProperty("emptyPassword"));
		Assert.assertEquals(signInPage.readInvalidEmailAddressInLogin(), "Invalid email address.");
	}

	// Test for only special Characters as Email Address(Invalid Email) with invalid
	// password
	@Test(priority = 18)
	public void specialCharAsUsernameWithInvalidPassword() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("onlySpecialCharacterAsUsername"),
				prop.getProperty("invalidPassword"));
		Assert.assertEquals(signInPage.readInvalidEmailAddressInLogin(), "Invalid email address.");
	}

	// Test for missing . (dot) as Email Address(invalid Email) with valid password
	@Test(priority = 19)
	public void missingDotAsEmailWithValidPasswordTest() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("missingDotAsUsername"), prop.getProperty("password"));
		Assert.assertEquals(signInPage.readInvalidEmailAddressInLogin(), "Invalid email address.");
	}

	// Test for missing . (dot) as Email Address(Invalid Email) with empty password
	@Test(priority = 20)
	public void missingDotAsEmailWithEmptyPasswordTest() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("missingDotAsUsername"), prop.getProperty("emptyPassword"));
		Assert.assertEquals(signInPage.readInvalidEmailAddressInLogin(), "Invalid email address.");
	}

	// Test for missing . (dot) as Email Address(Invalid Email) with invalid
	// password
	@Test(priority = 21)
	public void missingDotAsEmailWithInvalidPasswordTest() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("missingDotAsUsername"), prop.getProperty("invalidPassword"));
		Assert.assertEquals(signInPage.readInvalidEmailAddressInLogin(), "Invalid email address.");
	}

	// Test for 2 @ sign as Email Address(invalid email) with valid password
	@Test(priority = 22)
	public void twoAtSignInEmailWithValidPasswordTest() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("twoAtSignAsUsername"), prop.getProperty("password"));
		Assert.assertEquals(signInPage.readInvalidEmailAddressInLogin(), "Invalid email address.");
	}

	// Test for 2 @ sign as Email Address (Invalid Email) with empty password
	@Test(priority = 23)
	public void twoAtSignInEmailAddressWithEmptyPassword() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("missingDotAsUsername"), prop.getProperty("emptyPassword"));
		Assert.assertEquals(signInPage.readInvalidEmailAddressInLogin(), "Invalid email address.");
	}

	// Test for 2 @ sign as Email Address (Invalid Email) with invalid password
	@Test(priority = 24)
	public void twoAtSignInEmailAddressWithInvalidPassword() {
		first.SignInClick();
		homePage = signInPage.login(prop.getProperty("missingDotAsUsername"), prop.getProperty("invalidPassword"));
		Assert.assertEquals(signInPage.readInvalidEmailAddressInLogin(), "Invalid email address.");
	}

	// Test for performing valid forgot password funtion
	@Test(priority = 25)
	public void validForgotPasswordLinkFunction() {
		first.SignInClick();
		signInPage.validForgotPasswordFunction(prop.getProperty("username"));
		Assert.assertEquals(signInPage.readConfirmationEmailText(),
				"A confirmation email has been sent to your address: " + prop.getProperty("username"));
	}

	// Test for performing invalid forgot password function
	@Test(priority = 26)
	public void invalidForgotPasswordLinkFunction() {
		first.SignInClick();
		signInPage.validForgotPasswordFunction(prop.getProperty("emptyUsername"));
		Assert.assertEquals(signInPage.invalidEmailInForgotPassword(), "Invalid email address.");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
