package selenium2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companions");
		
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();
		while (!driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='datepicker-switch']")).getText().contains("October")) {
			//System.out.println(driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='datepicker-switch']")).getText());
			driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='next']")).click();
		}
		List<WebElement> dates = driver.findElements(By.className("day"));
		int count = driver.findElements(By.className("day")).size();
		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			//System.out.println(text);
			if (text.equalsIgnoreCase("18")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}
}
