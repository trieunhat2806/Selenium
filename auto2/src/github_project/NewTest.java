package github_project;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;




public class NewTest {
		private WebDriver driver;
		private ChromeOptions options;
		private String baseUrl;
		public String input = null;
@BeforeTest		
public void beforeTest() throws Exception{
	 	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
	 	options = new ChromeOptions();
		options.addArguments("Start-maximized");
		driver=new ChromeDriver(options);
		//go to github.com
		baseUrl="https://github.com/";
		driver.get(baseUrl);
	  }
	
@SuppressWarnings("deprecation")
public void goToSignInPage() throws Exception{
		  Actions actions=new Actions(driver);
		  //go to sign in page on github.com
		  WebElement signIn=(WebElement) driver.findElement(By.xpath("//a[normalize-space()='Sign up']"
		  		+ "//preceding::a[normalize-space()='Sign in']"));
		  actions.click(signIn).perform();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
  @SuppressWarnings("deprecation")
@Test
//Login successfully
  public void signIn() throws Exception{
	  	goToSignInPage();
	  	
	  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
	  	WebElement username=(WebElement) driver.findElement(By.xpath("//input[@id='password']//preceding::input[@id='login_field']"));
	  	input="viendanbac024@gmail.com";
	  	username.sendKeys(input);
	  	Reporter.log("username entered");
	  	
	  	
	  	WebElement password=(WebElement) driver.findElement(By.xpath("//input[@id='password']"));
	  	input="Lmaoxd@123";
	  	password.sendKeys(input);
	  	Reporter.log("password entered");
	  	
	  	WebElement button=(WebElement) driver.findElement(By.xpath("//input[@name='commit']"));
	  	button.click();
	  	Reporter.log("button clicked");
	  	
	  	//checkpoint
	  	WebElement Homepage=(WebElement) driver.findElement(By.xpath("//a[@aria-label='Homepage ']//*[name()='svg']"));
	  	
	  	if(Homepage.isDisplayed()) {
	  		System.out.println("Login successful");
	  		Assert.assertTrue(true);
	  	} else {
	  		System.out.println("Login failed");
	  		Assert.assertTrue(false);
	  	}
	  	Reporter.log("Homepage is displayed");
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
