package selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ExcerciseDropdown_keysDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String input = "ind";
		driver.findElement(By.id("autocomplete")).sendKeys(input);
		Thread.sleep(2000);
		for (int i = 0; i < 3; i++) {
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			if (i == 2) {
				String country = driver.findElement(By.id("autocomplete")).getAttribute("value");
				Assert.assertNotSame(input, country);
				System.out.println("Input type has been updated from " + input + " to " + country);
			}
		}		
		Thread.sleep(2000);
		driver.quit();
	}

}
