package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// memberitahu letak edge driver
		System.setProperty("webdriver.edge.driver", "C:\\webdriver\\msedgedriver.exe");
		// creare object driver untuk edge browser
		WebDriver driver = new EdgeDriver();
				
		driver.get("https://blazedemo.com/register");
		System.out.println(driver.getTitle());
		driver.close();
		
	}

}
