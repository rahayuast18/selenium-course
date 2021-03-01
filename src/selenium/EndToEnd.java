package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndToEnd {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("https://www.cleartrip.com/");
		// Form Origin
		driver.findElement(By.xpath("//input[@id='FromTag']")).sendKeys("new");
		// Date
		WebElement calenderElement = driver.findElement(By.xpath("(//i[@class='icon ir datePicker'])[1]"));
		js.executeScript("arguments[0].scrollIntoView();", calenderElement);
		driver.findElement(By.xpath("(//i[@class='icon ir datePicker'])[1]")).click();
		driver.findElement(By.cssSelector("a[class='ui-state-default ui-state-highlight ui-state-active ']")).click();
		// Select Dropdown Adult & Children
		WebElement adultElement = driver.findElement(By.id("Adults"));
		Select selectAdult = new Select(adultElement);
		selectAdult.selectByIndex(2);
		WebElement childernElement = driver.findElement(By.id("Childrens"));
		Select selectCildern = new Select(childernElement);
		selectCildern.selectByIndex(2);
		// Link
		driver.findElement(By.id("MoreOptionsLink")).click();
		// Dropdown Airline
		driver.findElement(By.cssSelector("input[name='airline']")).sendKeys("indigo");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(), 'IndiGo')]")).click();
		// Button Search
		driver.findElement(By.id("SearchBtn")).click();
		// Verify Error Message
		Assert.assertTrue(driver.findElement(By.id("homeErrorMessage")).isDisplayed());
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
		Thread.sleep(2000);
		driver.close();
	}

}
