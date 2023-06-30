package findElementXpathAxes;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.List;
import org.testng.annotations.Test;

public class Xpath {
	
		@SuppressWarnings("deprecation")
		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://demo.guru99.com/test/guru99home/");	
			
			 List <WebElement> listElement = driver.findElements
					 (By.xpath("//div[.//a[text()='SELENIUM']]"
					 		+ "/ancestor::div[@class='rt-grid-2 rt-omega']"
					 		+ "/following-sibling::div"));
			 
		        for (WebElement webElement : listElement) {
		            System.out.println(webElement.getText());
		        }
		     
		        driver.quit();
		    }
	}
