package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyErrorMessage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\webdriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("rahayuast18");
		driver.findElement(By.cssSelector("#password")).sendKeys("password");
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		System.out.println(driver.findElement(By.cssSelector("#error")).getText());
	}
}
