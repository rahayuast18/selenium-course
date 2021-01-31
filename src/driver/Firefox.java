package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// memberitahu letak firefox driver
		System.setProperty("webdriver.gecko.driver", "C:\\webdriver\\geckodriver.exe");
		// creare object driver untuk firefox browser
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://twitter.com");
		System.out.println(driver.getTitle());
		driver.close();

	}

}
