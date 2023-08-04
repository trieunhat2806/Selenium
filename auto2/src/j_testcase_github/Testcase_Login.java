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


import POI_POM.ExcelUtils;
import homepage_pom.Homepage;
import homepage_pom.Login;
import homepage_pom.error_message;


public class Testcase_Login {
	String path="C:\\chromedriver.exe";
	private ChromeOptions options;
	private String baseUrl;
	WebDriver driver;
	Homepage objHomepage;
	Login objLogin;
	error_message objerrorMsg;
	
	
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
		ExcelUtils.setExcelFile(".\\testdata.xlsx","TC_01");
		//login page obj
		objLogin=new Login(driver);
		
		//login
		objLogin.loginToGithub(ExcelUtils.getCellData(1, 2), ExcelUtils.getCellData(1, 3));
		Reporter.log("login successful");
		
		// Initialize Homepage object after login
		objHomepage = new Homepage(driver);
		
		//1st checkpoint
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualText = objHomepage.getHomepageDashboard().trim().toLowerCase();
		Assert.assertTrue(actualText.matches(".*send feedback.*"), "Text not found: Send feedback");
		Reporter.log(actualText);
	}
	
//	@SuppressWarnings("deprecation")
//	@Test(priority=1, groups="case 2")
//	public void test2() throws Exception{
//		objLogin=new Login(driver);
//		
//		//login
//		objLogin.loginToGithub("viendanbac024@gmail.com","Lmaoxd@12345");
//		Reporter.log("login failed");
//		
//		// Initialize Homepage object after login
//		objHomepage = new Homepage(driver);
//
//		//1st checkpoint
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		String actualText = objerrorMsg.getErrorMsg().trim().toLowerCase();
//		Assert.assertTrue(actualText.matches(".*Incorrect username or password..*"), "Text not found: Incorrect username or password.");
//	}
//	
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
