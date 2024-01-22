package Tasks;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Scroll {
	@Test
	public void orangrcrm() throws InterruptedException, IOException
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[text()='From']/..")).click();
		driver.findElement(By.xpath("//div[text()='Delhi']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Mumbai = driver.findElement(By.xpath("//div[@class=\"css-1dbjc4n r-b5h31w r-95jzfe\"]/child::div[@class=\"css-1dbjc4n r-18u37iz\"]//div[text()=\"Bengaluru\"]"));
		Thread.sleep(4000);
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("arguments[0].scrollIntoView(true);", Mumbai);
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,-350)", "");
		Mumbai.click();
		
		
	}
}
