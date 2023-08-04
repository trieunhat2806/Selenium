package annotation_excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

@Test
public class ex1 {
	private WebDriver driver;
	private ChromeOptions options;
	private String baseUrl;
	String driverPath = "C:\\chromedriver.exe";
	public String expected = null;
    public String actual = null;
	
	@BeforeTest
	public void beforeTest() throws Exception{
		
		options = new ChromeOptions();
		options.addArguments("Start-maximized");
		driver=new ChromeDriver(options);
		baseUrl="https://demo.guru99.com/test/newtours/index.php";
		driver.get(baseUrl);
	}
	
	@BeforeMethod
	public void verifyHomePage() throws Exception{
			String expectedTitle="Welcome: Mercury Tours";
			String actualTitle=driver.getTitle();
			Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test (priority=0)
	public void registerPage() throws Exception{
		Actions actions = new Actions(driver);
		WebElement register = (WebElement) driver.findElement(By.xpath("//a[normalize-space()='REGISTER']"));
		actions.click(register).perform();
		expected = "Register: Mercury Tours";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
	}
	
	@Test (priority=1)
	public void supportPage() throws Exception{
		Actions actions = new Actions(driver);
		WebElement support = (WebElement) driver.findElement(By.xpath("//a[normalize-space()='SUPPORT']"));
		actions.click(support).perform();
		expected = "Under Construction: Mercury Tours";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
	}
	@AfterMethod
	public void goBackToHomePage() throws Exception{
		Actions actions = new Actions(driver);
		WebElement goback =(WebElement) driver.findElement(By.xpath("//a[normalize-space()='Home']"));
		actions.click(goback).perform();
	}
	@AfterTest
	public void afterTest() throws Exception{
		driver.close();
	}
	
}
