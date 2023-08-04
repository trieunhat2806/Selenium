package GET_method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.List;


public class get_column_row_number {
	
	
	public static int getTotalRowNumber() throws Exception {	
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.guru99.com/test/web-table-element.php");

		List<WebElement> row=driver.findElements(By.xpath(".//*[@id='leftcontainer']"
				+ "/table/tbody/tr"));
		System.out.println("number of rows:"+row.size());
			return row.size();
		}
	
	public static int getTotalColumnNumber() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		
		
		List<WebElement> col=driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		System.out.println("number of columns: "+col.size());
			return col.size();
	}
	
	public static void getRowNumberByValue(String value) throws Exception {	
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		
		List<WebElement> column= driver.findElements(By.xpath("//*[@id='leftcontainer']"
				+ "/table/tbody/tr/td[1]"));
		for (int i=0;i<column.size();i++) {
			if(column.get(i).getText().equals(value)) {
				System.out.print("Value is: "+(i+1));
			}
		}
	}
	
	public static int getTabelCellValue(int row, int col) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		
		WebElement value = driver.findElement(By.xpath
        		("//*[@id=\"leftcontainer\"]/table"
        				+ "/tbody/tr["+ col +"]/td["+ row +"]\r\n"));
		//List<WebElement> rows_table= table.findElements(By.tagName("tr"));
		//int rows_count=rows_table.size();
		
		//for(int a=0;a<rows_count;a++) {
		//	List<WebElement> rows_cols= rows_table.get(a).findElements(By.tagName("td"));
		//int cols_count=rows_cols.size();
		//System.out.print("Number of cells in Row "+row+" are "+cols_count);
		
		//for(int b=0;b<cols_count;b++) {
			//String cell= rows_cols.get(b).getText();
			//System.out.println("cell value of row number "+row+" and column number "+col+" is "+cell);
		//}
//}
		 String a = value.getText();
		 System.out.println("Result: " + a);
		return 0;
	}
	
	public static int checkValueIfExist(String value) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		

		List<WebElement> column = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]"
				+ "/table/thead/tr/th"));
		List<WebElement> row = driver.findElements(By.xpath("//*[@id='leftcontainer']"
				+ "/table/tbody/tr"));

		WebElement table= driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/table/tbody"));
		List<WebElement> rows_cols_table= table.findElements(By.tagName("tr"));
		int rows_count=rows_cols_table.size();
		int cols_count=rows_cols_table.size();

		
		for(int rows = 1; rows<row.size(); rows++)
		{
			for(int columns=1; columns<column.size(); columns++) {
		        WebElement input = driver.findElement(By.xpath
		        		("//*[@id=\"leftcontainer\"]/table/tbody/tr["+ rows +"]/td["+ columns +"]\r\n"));
		        String num = input.getText();
		        
		        if(num.equals(value)) {
		        	System.out.print("There's result "+num+" "
		        			+ "existed at column "+columns+" and at row "+rows+"");
		        }
			}
		}
		
		return 0;
	}
	@Test
	public void Test() throws Exception {
		getTotalRowNumber();
		getTotalColumnNumber();
		getTabelCellValue(2,3);
		getRowNumberByValue("Bata India");
		checkValueIfExist("IDFC L");
		
	}
}
	
	

