package selenium2;

import java.util.Arrays;
import java.util.List;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrder {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicit wait
		WebDriverWait wait = new WebDriverWait(driver, 10); //explicit wait
		
		String[] productItems = {"Carrot", "Beans", "Cucumber", "Banana", "Almonds"}; //Create array product
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		addItems(driver, productItems);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button[text()='PROCEED TO CHECKOUT']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode"))); //explicit wait
			driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo"))); //explicit wait
			System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		Thread.sleep(2000);
		driver.close();
	}
	
	public static void addItems(WebDriver driver, String[] productItems) throws InterruptedException {
		// TODO Auto-generated method stub
		List<WebElement> productElement = driver.findElements(By.cssSelector("h4.product-name")); //Untuk get button add to cart
		for (int i = 0; i < productElement.size(); i++) {
			String[] productName = productElement.get(i).getText().split("-"); //split 2 product name
			String toTrimName = productName[0].trim();
			int j = 0;
			List<String> itemList = Arrays.asList(productItems); //Change array to string
			if (itemList.contains(toTrimName)) {
				j++;
				System.out.println(toTrimName);
				Thread.sleep(2000);
				/* kalau pake ini ada case, saat text berubah. Nanti akan bergeser saat klik item selanjutnya
				 * driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				 */
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == productItems.length) {
					break;
				}
				
				/* hanya dipakai jika tidak ada array
				 * break;
				 */
			}
		}
		
	}

}
