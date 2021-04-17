package selenium2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// scroll page
		js.executeScript("window.scroll(0, 500)");
		Thread.sleep(2000);
		// scroll into the table
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=100");
		Thread.sleep(2000);
		driver.quit();
	}

}
