package Tasks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BrokenUrls {
	@Test
	public void broke() throws InterruptedException, IOException
	{
		ChromeOptions options=new ChromeOptions();
		//options.addArguments("--headless");
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://dev.thehosteller.com/hostels");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		int listcount = links.size();
		System.out.println(" Link count --"+listcount);
		for(WebElement link :links )
		{
			String url = link.getAttribute("href");
			//Reporter.log(""+url,true);
		if(url!=null) 
		{ try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode >= 400) {
                System.out.println("Broken URL: " + url + " - Response Code: " + responseCode);
            } else {
                System.out.println("Working URL: " + url + " - Response Code: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println("Error while checking URL: " + url);
        }
    }
}

		driver.quit();



	}	
}
