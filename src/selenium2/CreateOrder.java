package selenium2;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrder {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String[] productItems = {"Carrot", "Capsicum", "Orange"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		//Untuk get button add to cart
		List<WebElement> productElement = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < productElement.size(); i++) {
			String[] productName = productElement.get(i).getText().split("-"); //split 2 product name
			String toTrimName = productName[0].trim();
			List<String> itemList = Arrays.asList(productItems);
			if (itemList.contains(toTrimName)) {
				System.out.println(toTrimName);
				Thread.sleep(2000);
				/*** INI KLIK NYA BELUM SESUAI ***/
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				/* hanya dipakai jika tidak ada array
				break;
				*/
			}
		}

	}

}
