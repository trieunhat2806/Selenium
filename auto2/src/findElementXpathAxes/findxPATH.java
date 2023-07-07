package findElementXpathAxes;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.List;
import org.testng.annotations.Test;


public class findxPATH {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://github.com/trieunhat2806");	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List <WebElement> listElement = driver.findElements
				(By.xpath("//li[.//a[normalize-space()='Overview']]//following::li[.//a[contains(@id,'tab')]]"));
		 
	        for (WebElement webElement : listElement) {
	            System.out.println(webElement.getText());
	        }
	     
	        driver.quit();
	}
}
