package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://twitter.com");
		Thread.sleep(2000); //ms
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		
		driver.get("https://google.com");
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().back();
		//driver.navigate().forward();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.close(); //untuk close tab window yang sedang dibuka
		//driver.quit(); //untuk close all tab window yang sedang dibuka
	}

}
