package selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameDroppable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://jqueryui.com/droppable/");
		
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector("iframe.demo-frame")));
		Thread.sleep(2000);
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame"))); //switch to frame
		System.out.println(driver.findElement(By.tagName("iframe")).getSize());
		driver.switchTo().frame(0);
		Actions drag = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		drag.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.cssSelector("div[class='demo-description'] p")).getText());
		Thread.sleep(2000);
		driver.close();
	}

}
