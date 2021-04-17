package selenium2;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeLimitation_linkNewTab {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerLink = driver.findElement(By.xpath("//div[@id='gf-BIG']")); //scope
		System.out.println(footerLink.findElements(By.tagName("a")).size());
		
		WebElement footerFirst = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		Integer count = footerFirst.findElements(By.tagName("a")).size();
		System.out.println(count);
		
		// click for each link
		for (int i = 1; i < count ; i++) {
			String clickLink = Keys.chord(Keys.CONTROL, Keys.ENTER); // open in a new tab
			footerFirst.findElements(By.tagName("a")).get(i).sendKeys(clickLink);
			Thread.sleep(3000);
		}
		
		// move window for get tittle
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> newIt = windows.iterator();
		
		while (newIt.hasNext()) {
			String nextTab = newIt.next();
			driver.switchTo().window(nextTab);
			System.out.println(driver.getTitle());
		}
		
		Thread.sleep(2000);
		driver.quit();
	}

}
