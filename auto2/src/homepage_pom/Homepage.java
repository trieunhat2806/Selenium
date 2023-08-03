package homepage_pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Homepage {
	WebDriver driver;
	@FindBy(xpath="//a[normalize-space()='Send feedback']")
	WebElement title;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 /**
     * @param dashboard
	 * @return 

     */
	
	//get the "Latest changes" from homepage
	public  String getHomepageDashboard() {
		return title.getText();
	}
}