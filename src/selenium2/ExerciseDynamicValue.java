package selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExerciseDynamicValue {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// check option3 & getText
		driver.findElement(By.xpath("//label[@for='honda']/input")).click();
		String selectText = driver.findElement(By.xpath("//label[@for='honda']")).getText();
		// select dropdown based on selected checkbox
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText(selectText);
		// input value based on selected checkbox
		driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys(selectText);
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if (alertText.contains(selectText)) {
			System.out.println(alertText);
		} else {
			System.out.println("There is Something Wrong!");
		}
		Thread.sleep(2000);
		driver.quit();
	}
}
