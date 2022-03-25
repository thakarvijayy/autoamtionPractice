package automationpractice.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationpractice.base.TestBase;
import automationpractice.pages.FirstPage;

public class FirstPageTest extends TestBase {

	FirstPage firstPage;

	public FirstPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		firstPage = new FirstPage();

	}
	
	@Test
	public void logoCheckTest()
	{
		boolean logo = firstPage.logoCheck();
		Assert.assertTrue(logo);
	}
	

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
