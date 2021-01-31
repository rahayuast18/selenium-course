package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// memberitahu letak chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		// creare object driver untuk chrome browser
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://blazedemo.com/register");
		System.out.println(driver.getTitle());
		driver.close();
	}
}
