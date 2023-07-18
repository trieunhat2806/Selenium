package github_project;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;



	@Test
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
		baseUrl="https://github.com/";
		driver.get(baseUrl);
	  }
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void goToSignInPage() throws Exception{
		  Actions actions=new Actions(driver);
		  WebElement signIn=(WebElement) driver.findElement(By.xpath("//a[normalize-space()='Sign up']"
		  		+ "//preceding::a[normalize-space()='Sign in']"));
		  actions.click(signIn).perform();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
  @SuppressWarnings("deprecation")
@Test
//Login successfully
  public void signIn() throws Exception{
	  	Actions actions=new Actions(driver);
	  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //input username
	  	WebElement username=(WebElement) driver.findElement(By.xpath("//input[@id='password']//preceding::input[@id='login_field']"));
	  	input="viendanbac024@gmail.com";
	  	actions.sendKeys(username,input).perform();
	  	//input password
	  	WebElement password=(WebElement) driver.findElement(By.xpath("//input[@id='password']"));
	  	input="Lmaoxd@123";
	  	actions.sendKeys(password,input).perform();
	  	//click
	  	WebElement button=(WebElement) driver.findElement(By.xpath("//input[@name='commit']"));
	  	actions.click(button).perform();
  }
  

@AfterTest
  public void afterTest() {
	  try {
          Thread.sleep(5000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
	  driver.quit();
  }

}
