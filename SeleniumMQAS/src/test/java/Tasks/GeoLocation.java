package Tasks;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GeoLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Parameters like Lattitude Longitude and accuracy should be stored in Map 
		
		HashMap<String, Object> Coordinates = new HashMap<String, Object>();
		
		Coordinates.put("latitude", 28.7041);
		Coordinates.put("longitude", 77.1);
		Coordinates.put("accuracy", 1);
		
		((ChromeDriver)driver).executeCdpCommand("Emulation.setGeolocationOverride", Coordinates);
		
		driver.get("https://my-location.org/");
		
		String location = driver.findElement(By.xpath("//div[text()='Your Location']/following-sibling::div")).getText();
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("   ");
		System.out.println("Your Location : "+ location);
		System.out.println("   ");
		System.out.println("-------------------------------------------------------------------------------------------");

		//driver.quit();
		
		//div[text()='Your Location']/following-sibling::div

	}

}
