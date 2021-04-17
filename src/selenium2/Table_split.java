package selenium2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Table_split {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement table = driver.findElement(By.xpath("//legend[text()='Web Table Example']"));
		js.executeScript("arguments[0].scrollIntoView();", table);
		
		List<WebElement> values = driver.findElements(By.cssSelector("[class='tableFixHead'] td:nth-child(4)"));
		int sum = 0;
		for (int i = 0; i < values.size(); i++) {
			sum = sum + Integer.parseInt(values.get(i).getText());
		}
		int total = Integer.parseInt(driver.findElement(By.cssSelector("[class='totalAmount']")).getText().split(":")[1].trim());
		System.out.println(sum + " dan " + total);
		Assert.assertEquals(sum, total);
		Thread.sleep(2000);
		driver.quit();
	}
}
