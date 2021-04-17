package selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcerciseTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement table = driver.findElement(By.xpath("//legend[text()='Web Table Example']"));
		js.executeScript("arguments[0].scrollIntoView();", table);
		
		int row = driver.findElements(By.cssSelector("[class='table-display'] tr td:nth-child(1)")).size();
		System.out.println("Size of row = " + row);
		int coloumn = driver.findElements(By.cssSelector("[class='table-display'] tr th")).size();
		System.out.println("Size of coloumn = " + coloumn);
		for (int i = 0; i < row; i++) {
			if (i == 2) {
				String text = driver.findElements(By.cssSelector("[class='table-display'] tr")).get(i).getText();
				System.out.println(text);
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
