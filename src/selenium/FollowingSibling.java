package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FollowingSibling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		for (int i=1; i <= 2; i++) {
			driver.findElement(By.xpath("//button[contains(@class,'btn')]/following-sibling::button["+ i +"]")).click();
			System.out.println("pass " + i);
			Thread.sleep(2000);
		}
		driver.close();
	}

}
