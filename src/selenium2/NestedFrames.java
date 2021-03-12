package selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		WebElement topFrame = driver.findElement(By.cssSelector("frame[name='frame-top']"));
		driver.switchTo().frame(topFrame);
		WebElement frameMiddle = driver.findElement(By.cssSelector("frame[name='frame-middle']"));
		driver.switchTo().frame(frameMiddle);
		System.out.println(driver.findElement(By.id("content")).getText());
		Thread.sleep(2000);
		driver.close();
	}

}
