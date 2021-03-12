package selenium2;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		Set<String> windows = driver.getWindowHandles(); //parent, child, subchild ID
		Iterator<String> newIt = windows.iterator();
		String parentId = newIt.next();
		String childID = newIt.next();
		driver.switchTo().window(childID);
		System.out.println(driver.findElement(By.cssSelector("p[class='im-para red']")).getText());
		/* untuk debug pake ini
		 * driver.findElement(By.cssSelector("p[class='im-para red']")).getText();
		 */
		String emailID = driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at")[1].split("with")[0].trim();
		driver.switchTo().window(parentId);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(emailID);
		Thread.sleep(2000);
		driver.quit();
	}
}
