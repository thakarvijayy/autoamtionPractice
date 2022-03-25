package automationpractice.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import automationpractice.utilities.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	//Created constructor of the class
	public TestBase()
	{
		try {
			prop = new Properties(); //this will read the properties
			//below I have declared properties file path
			FileInputStream f = new FileInputStream("E:\\Selenium_WorkSpace\\AutomationPractice\\src\\main\\java\\automationpractice\\config\\config.properties"); 
			prop.load(f); //this will load the values
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException e){
				e.printStackTrace();
			}	
		
	}
	//TODO Here I have used chromedriver from my system so you have to add path accordingly to your system.
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\SeleniumJars\\chromedriver2.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("ie")){
			System.setProperty("webdriver.ie.driver", "E:\\SeleniumJars\\iedriver.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		//defining the URL
		driver.get(prop.getProperty("url"));
	
	
	}
}
