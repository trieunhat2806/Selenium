package j_testcase_github;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import homepage_pom.Homepage;
import homepage_pom.Login;

public class Testcase_Login {
	String path="C:\\chromedriver.exe";
	private ChromeOptions options;
	private String baseUrl;
	WebDriver driver;
	Homepage objHomepage;
	Login objLogin;
	
@SuppressWarnings("deprecation")
	@BeforeTest
	public void testSetup() throws Exception{
		options = new ChromeOptions();
		options.addArguments("Start-maximized");
		driver=new ChromeDriver(options);
		//go to github.com
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseUrl="https://github.com/login";
		driver.get(baseUrl);
		Reporter.log("successfully proceeded to loginPage");
	}

	@SuppressWarnings("deprecation")
	@Test (priority=0, groups="case 1")
	public void test() throws Exception{
		//login page obj
		objLogin=new Login(driver);
		
		//login
		objLogin.loginToGithub("viendanbac024@gmail.com","Lmaoxd@123");
		Reporter.log("login successful");
		
		// Initialize Homepage object after login
		objHomepage = new Homepage(driver);
		
		//1st checkpoint
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualText = objHomepage.getHomepageDashboard().trim().toLowerCase();
		Assert.assertTrue(actualText.matches(".*send feedback.*"), "Text not found: Send feedback");
		Reporter.log(actualText);

	}
	
	@AfterTest
	public void afterTest() throws Exception{
		 try {
	          Thread.sleep(5000);
	      } catch (InterruptedException e) {
	          e.printStackTrace();
	      }
		  driver.quit();
	}
}
