package Tasks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BrokenLinks1 {

	
	
	@Test
	public void broke() throws InterruptedException, IOException
	{
		ChromeOptions options=new ChromeOptions();
		//options.addArguments("--headless");
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	
	 List<WebElement> search = driver.findElements(By.xpath("//a"));
	 
	 for (WebElement links : search) {
		String url = links.getAttribute("href");
		
		if(url==null || url.isEmpty()) {
			System.out.println("url is empty");
			continue;
		}
		
		HttpURLConnection brokenUrl = (HttpURLConnection)(new URL(url).openConnection());
		brokenUrl.connect();
		if(brokenUrl.getResponseCode()>=400) {
			System.out.println(brokenUrl+" is broken");
		}
		else {
			System.out.println(brokenUrl+"  is valid");
		}
	}
}
}
