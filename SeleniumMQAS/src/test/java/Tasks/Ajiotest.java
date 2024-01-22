package Tasks;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Ajiotest {

	@Test
	public void ajio() throws InterruptedException, IOException
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ajio.com/");
		//	WebElement menlink = driver.findElement(By.xpath("//a[text()='MEN']"));
		//menlink.click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='MEN']"))).perform();
		driver.findElement(By.xpath("//a[text()='Sports Shoes']")).click();
		List<WebElement> items = driver.findElements(By.xpath("//div[@class='nameCls']"));
		int k=1;
		WebElement itemstext;
		for (int i = 0; i < items.size();i++) {
			//row=sheet.getRow(j);
			itemstext=items.get(i);
			//row.createCell(1).setCellValue(flighpricetext.getText());
			Reporter.log(""+k+") "+itemstext.getText(),true);
			k++;
		}
	driver.quit();
	}
}
