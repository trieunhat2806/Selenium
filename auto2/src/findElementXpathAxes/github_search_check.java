package findElementXpathAxes;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

public class github_search_check {
	private WebDriver driver;
	private ChromeOptions options;
	private String baseUrl;
	@BeforeTest
	public void beforeTest() throws Exception{
		options = new ChromeOptions();
		options.addArguments("Start-maximized");
		driver=new ChromeDriver(options);
		baseUrl="https://github.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
	//"//a[@id='repositories-tab']/..//a[@id="+Xitem+"]"
	@SuppressWarnings("unchecked")
	public void SearchItem(String Xitem) throws Exception{
		Actions actions = new Actions(driver);
		//click on the search bar
		WebElement item= (WebElement) driver.findElement(By.xpath("//button[@class='header-search-button placeholder input-button form-control d-flex flex-1 flex-self-stretch flex-items-center no-wrap width-full py-0 pl-2 pr-0 text-left border-0 box-shadow-none']"));
		actions.click(item).perform();
		//input text
		WebElement item2= (WebElement) driver.findElement(By.xpath("//input[@id='query-builder-test']"));
		actions.sendKeys(item2, Xitem).perform();
		//Search
		WebElement item3=(WebElement) driver.findElement(By.xpath("//input[@id='query-builder-test']//following::ul[@id='query-builder-test-results']"));
		actions.click(item3).perform();
	
		//Return search result	//testcase 3	
			//WebElement item4=(WebElement) driver.findElement(By.xpath("//span[@class='Text-sc-17v1xeu-0 eUuDoS']//preceding::div[@class='Box-sc-g0xbh4-0 cgQapc']"));
			//String Result=(item4.getText());
			//String text="there are: ";
			//System.out.print(text);
			//System.out.println(Result);
		
	}	
	@Test
	public void Test() throws Exception{
		driver.get(baseUrl);
		SearchItem("selenium");
	}
	@AfterTest
	public void afterTest() throws Exception{
		//driver.close();
	}
	
}