package selenium2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesAndScreenshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().deleteCookieNamed("sessionKey");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("D:\\screenshot.png"));
		
		Thread.sleep(2000);
		driver.quit();
	}

}
