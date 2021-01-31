package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://blazedemo.com/register");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("name")).sendKeys("Rahayu Puji Astuty");
		driver.findElement(By.name("company")).sendKeys("PT. Tri Ade Berengan (Antaraja)");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("rahayuast18@antaraja.id");
		driver.findElement(By.cssSelector("#password")).sendKeys("Pas$w0rD");
		driver.findElement(By.id("password-confirm")).sendKeys("Pas$w0rD");
		//driver.findElement(By.linkText("BlazeDemo")).click();
		//Thread.sleep(2000);
		//driver.close();
	}
}