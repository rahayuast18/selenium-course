package selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		//array list
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		//memilih array sesuai dengan yang di inginkan
		//for-each
		for (WebElement option : options) {
			//equalsIgnoreCase untuk apa?
			if (option.getText().equalsIgnoreCase("Indonesia")) {
				option.click();
				break;
			}
		}
		//tidak mau print kenapa?
		System.out.println(driver.findElement(By.xpath("//input[@id='autosuggest']")).getText());
		Thread.sleep(2000);
		driver.close();
	}
	
}
