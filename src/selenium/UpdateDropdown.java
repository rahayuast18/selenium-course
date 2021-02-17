package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.cssSelector("#divpaxinfo")).click();
		Thread.sleep(2000);
		// tambah
//		for (int i = 1; i <= 5; i++) {
//			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
//		}
		int i = 1;
		while (i <= 5) {
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
			i++;
		}
		// kurang
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[id='hrefDecAdt']")).click();
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		System.out.println(driver.findElement(By.cssSelector("#divpaxinfo")).getText());
		driver.close();
	}

}
