package GET_method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.List;


public class get_column_row_number {
	
	public static int getTotalRowNumber() {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		String baseUrl=("https://demo.guru99.com/test/web-table-element.php");
		driver.get(baseUrl);
		
		List<WebElement> row=driver.findElements(By.xpath(".//*[@id='leftcontainer']"
				+ "/table/tbody/tr"));
		System.out.print("number of rows:"+row.size());
			return row.size();
		}
	
	public static int getTotalColumnNumber() {
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			String baseUrl=("https://demo.guru99.com/test/web-table-element.php");
			driver.get(baseUrl);
			
			List<WebElement> col=driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
			System.out.print("number of columns: "+col.size());
				return col.size();
	}
	
	public static int getRowNumberByValue(String value) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		String baseUrl=("https://demo.guru99.com/test/web-table-element.php");
		driver.get(baseUrl);
		
		List<WebElement> getvalue= driver.findElements(By.xpath(""));
		return 0;
	}
	
	public static void getTabelCellValue(int row, int col) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		String baseUrl=("https://demo.guru99.com/test/web-table-element.php");
		driver.get(baseUrl);
		
		WebElement table= driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/table/tbody"));
		List<WebElement> rows_cols_table= table.findElements(By.tagName("tr"));
		int rows_count=rows_cols_table.size();
		int cols_count=rows_cols_table.size();
		
		System.out.print("Number of cells in Row "+row+" are "+cols_count);
		for(int i=0;i<cols_count;i++) {
			String cell= rows_cols_table.get(i).getText();
			System.out.print("cell value of row number"+row+"and column number "+col+"is "+cell);
		}
		return;
	}
	
	public static void main(String[]args) {
		//getTotalRowNumber();
		//getTotalColumnNumber();
		getTabelCellValue(1,2);
	}
}
	
	

