package homepage_pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class error_message {
	WebDriver driver;
	@FindBy(xpath="//body/div[@class='logged-out env-production page-responsive session-authentication']\"\r\n"
			+ "	  			+ \"/div[@class='application-main ']/main/div[@id='login']/div[@id='js-flash-container']/div[1]")
	WebElement msg;
	
	public error_message(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
     * @param msg
	 * @return 

     */
	public  String getErrorMsg() {
		return msg.getText();
	}
}
