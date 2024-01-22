package Tasks;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ImageDownload {

	@Test
	public void ajioimage() throws InterruptedException, IOException
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ajio.com/");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='MEN']"))).perform();
		driver.findElement(By.xpath("//a[text()='Sports Shoes']")).click();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		// Scroll to the end of the page
		jsExecutor.executeScript("window.scrollBy(0, arguments[0]);", 2000);

		List<WebElement> list = driver.findElements(By.tagName("img"));
		int count =1;
		for(WebElement element :list)
		{
			String src = element.getAttribute("src");
			System.out.println(src);



			if (src!=null &&src.contains(".jpg") ) {
				URL imageURL = new URL(src);
				//read image from web URL
				BufferedImage saveImage = ImageIO.read(imageURL);
				//BufferedImage saveImage = ImageIO.read(imageURL);
				File file = new File("./images/"+count+".jpg");
				ImageIO.write(saveImage, "jpg", file);
				count++;
			} else {
				System.out.println("Failed to load the image.");
			}
			//Writing the image


		}

		driver.quit();

	}
}
