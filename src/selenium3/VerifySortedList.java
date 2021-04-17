package selenium3;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class VerifySortedList {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click header
		driver.findElement(By.xpath("//thead/tr[1]/th[1]")).click();
		
		//get text in array
		List<WebElement> elements = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		
		//get text
		
		//Script tanpa stream
//		for (int i = 0; i < elements.size(); i++) {
//			String valueString = elements.get(i).getText();
//			System.out.println(valueString);
//		}
//		System.out.println("");
		
		List<String> originaList = elements.stream().map(s -> s.getText()).collect(Collectors.toList());

		//Print text dengan kurung siku
//		System.out.println(originaList);
//		System.out.println("");
		
		//Print text tanpa kurung sikut
//		elements.stream().map(s -> s.getText()).forEach(s -> System.out.println(s));
//		System.out.println("");
		
		//sort list
		List<String> sortList = originaList.stream().sorted().collect(Collectors.toList());
		
		//compare
		Assert.assertTrue(originaList.equals(sortList));
		
		List<String> price;
		
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));
			if(price.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
				}
		} while (price.size() < 1);
		
		Thread.sleep(2000);
		driver.close();
		
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}
}
