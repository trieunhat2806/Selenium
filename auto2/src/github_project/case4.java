package github_project;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class case4 {
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
	public void goToSignInPage() throws Exception{
		  Actions actions=new Actions(driver);
		  WebElement signIn=(WebElement) driver.findElement(By.xpath("//a[normalize-space()='Sign up']"
		  		+ "//preceding::a[normalize-space()='Sign in']"));
		  actions.click(signIn).perform();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void signIn() throws Exception{
	  	goToSignInPage();
	  	Actions actions=new Actions(driver);
	  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  	
	  	WebElement button=(WebElement) driver.findElement(By.xpath("//input[@name='commit']"));
	  	actions.click(button).perform();
	  	Reporter.log("button clicked");
	  	
	  	//checkpoint
		WebElement msg=(WebElement) driver.findElement(By.xpath("//body/div[@class='logged-out env-production page-responsive session-authentication']"
	  			+ "/div[@class='application-main ']/main/div[@id='login']/div[@id='js-flash-container']/div[1]"));
		  	if (msg.isDisplayed()) {
		  		System.out.println("error message is displayed");  	
		  	} else {
		  		System.out.println("error msg isn't displayed");
		  	}
	  }
		@AfterTest
	public void afterTest() throws Exception {
		  try {
	          Thread.sleep(5000);
	      } catch (InterruptedException e) {
	          e.printStackTrace();
	      }
		  driver.quit();
	  }
}
