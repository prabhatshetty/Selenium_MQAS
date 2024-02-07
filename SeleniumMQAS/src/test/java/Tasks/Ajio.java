package Tasks;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Ajio {
	@Test
	public void ajio() throws InterruptedException, IOException
	{
		
		//start
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ajio.com/");
		//	WebElement menlink = driver.findElement(By.xpath("//a[text()='MEN']"));
		//menlink.click();
		Actions act = new Actions(driver);

		Random random = new Random();


		List<WebElement> links = driver.findElements(By.xpath("//div[@class='nameCls']"));
		int i = links.size();
		WebElement link;
		// Generate a random number between 1 and 10

		int j = random.nextInt(4);
		//	for (int i = 0; i < links.size(); i++) {
		//row=sheet.getRow(j);
		link=links.get(j);
		//row.createCell(1).setCellValue(flighpricetext.getText());
		//link.click();
		act.moveToElement(link).perform();





		//act.moveToElement(driver.findElement(By.xpath("//a[text()='MEN']"))).perform();
		WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(10));
		List<WebElement> itemslists = driver.findElements(By.xpath("//div[@class='column column-2']"));
		int h = itemslists.size();
		WebElement itemslist;
		int g = random.nextInt(h);
		itemslist=itemslists.get(g);
		//row.createCell(1).setCellValue(flighpricetext.getText());

		act.moveToElement(itemslist).click().perform();

		List<WebElement> items = driver.findElements(By.xpath("//div[@class='nameCls']"));
		int k=1;
		WebElement itemstext;
		for (int l = 0; l < items.size(); i++) {
			//row=sheet.getRow(j);
			itemstext=items.get(l);
			//row.createCell(1).setCellValue(flighpricetext.getText());
			Reporter.log(""+k+" ) "+itemstext.getText(),true);
			k++;
		}




		//driver.findElement(By.xpath("//a[text()='Sports Shoes']")).click();



	}
}
