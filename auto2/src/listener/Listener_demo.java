package listener;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;		

@Listeners(listener.Listener.class)
public class Listener_demo  {		
	private WebDriver driver;
	private ChromeOptions options;
	private String baseUrl;
	public String input = null;
					

	// Test to pass as to verify listeners .	
	@BeforeTest
	public void beforeTest() throws Exception{
	 	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
	 	options = new ChromeOptions();
		options.addArguments("Start-maximized");
		driver=new ChromeDriver(options);
		baseUrl="https://demo.guru99.com/V4/index.php";
		
		driver.get(baseUrl);
	  }
	@Test
	public void Login()				
	{		
		input="browser entered username";
	    driver.findElement(By.xpath("//input[@name='password']//preceding::input[@name='uid']")).sendKeys("mngr516668");		
	    Reporter.log(input);
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("AhUbamY");	
	    Reporter.log("browser entered password");
	    driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	    Reporter.log("browser clicked on the button Login");
	}		

	// Forcefully failed this test as to verify listener.		
	@Test
	public void TestToFail()				
	{		
	    System.out.println("This method to test fail");					
	    Assert.assertTrue(false);			
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
