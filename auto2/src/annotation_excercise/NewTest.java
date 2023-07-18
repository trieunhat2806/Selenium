package annotation_excercise;

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
import org.testng.annotations.Test;

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
		baseUrl="https://demo.guru99.com/test/newtours/index.php";
		driver.get(baseUrl);
  }
  @BeforeMethod (groups="register-page")
  public void goToRegisterPage() throws Exception{
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
	  Actions actions=new Actions(driver);
	  WebElement register= (WebElement) driver.findElement(By.xpath("//a[normalize-space()='REGISTER']"));
	  actions.click(register).perform();
  }
  
	@Test (groups="register-page")
	 public void inputInf() throws Exception{
		  System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		  Actions actions=new Actions(driver);
	 
	 //input username
	 WebElement user= (WebElement) driver.findElement(By.xpath("//input[@name='password']//preceding::input[@id='email']"));
	 input="trieunhat2806@gmail.com";
	 actions.sendKeys(user,input).perform();
	 //input password
	 WebElement password= (WebElement) driver.findElement(By.xpath("//input[@name='password']"));
	 input="123456789";
	 actions.sendKeys(password,input).perform();
	 //input confirm psw
	 WebElement confirm= (WebElement) driver.findElement(By.xpath("//input[@name='confirmPassword']"));
	 input="123456789";
	 actions.sendKeys(confirm,input).perform();
	 
	 WebElement submit=(WebElement) driver.findElement(By.xpath("//input[@name='submit']"));
	 actions.click(submit).perform();
	 }
	
	@BeforeMethod (groups="login-page")
	public void LoginPage() throws Exception{
		Actions actions= new Actions(driver);
		WebElement login= (WebElement) driver.findElement(By.xpath("//a[normalize-space()='SIGN-ON']"));
		actions.click(login).perform();
	}

	@Test (groups="login-page")
	public void Login() throws Exception{
		Actions actions= new Actions(driver);
		
		
		 //input username
		 WebElement username= (WebElement) driver.findElement(By.xpath("//input[@name='password']//preceding::input[@name='userName']"));
		 input="trieunhat2806@gmail.com";
		 actions.sendKeys(username,input).perform();
		//input password
		 WebElement password= (WebElement) driver.findElement(By.xpath("//input[@name='password']"));
		 input="123456789";
		 actions.sendKeys(password,input).perform();
		 WebElement submit=(WebElement) driver.findElement(By.xpath("//input[@name='submit']"));
		 actions.click(submit).perform();
	}
	@AfterMethod
	public void ReturnHomePage() throws Exception{
		Actions actions = new Actions(driver);
		WebElement goback =(WebElement) driver.findElement(By.xpath("//a[normalize-space()='Home']"));
		actions.click(goback).perform();
	}
	
	 @AfterTest
	 public void afterTest() throws Exception{
		 driver.close();
	 }
}
