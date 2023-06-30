package findElementXpathAxes;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.List;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class selectMenuItem {
	private WebDriver driver;
	private ChromeOptions options;
	private String baseUrl;
	
	@BeforeTest
	public void beforeTest() throws Exception{
		options = new ChromeOptions();
		options.addArguments("Start-maximized");
		driver=new ChromeDriver(options);
		baseUrl="https://demo.guru99.com/test/guru99home/";
	}
	
	public void selectMenuItem1(String MenuItem) {
		
		List<WebElement> item= driver.findElements(By.xpath("//li[starts-with(@class,'item')]"
				+ "/child::a[contains(text()," + MenuItem + ")]"));
		
		for(int i=0; i<item.size();i++) {
			
			if(item.get(i).getText().contentEquals(MenuItem)) {
				item.get(i).click();
				break;
			}
		}
	}
	
	@Test
	public void Test() throws Exception{
		driver.get(baseUrl);
		selectMenuItem1("Testing");
	}
}

	
	