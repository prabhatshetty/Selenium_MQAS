package Tasks;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BigBasket {
	@Test
	public void fetchproductdetails() throws InterruptedException, IOException
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.bigbasket.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:R5bclm:']")).click();
		WebElement catogorytype = driver.findElement(By.xpath("//a[text()='Eggs, Meat & Fish']"));
		js.executeScript("arguments[0].click();", catogorytype);
		driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:R5bclm:']")).click();
		List<WebElement> itemname = driver.findElements(By.xpath("//div[@class='break-words h-10 w-full']"));
		List<WebElement> itemprice = driver.findElements(By.xpath("//span[@class='Label-sc-15v1nk5-0 Pricing___StyledLabel-sc-pldi2d-1 gJxZPQ AypOi']"));
		WebElement itemnametext;
		WebElement itempricetext;
		for (int i = 0; i < itemname.size(); i++) {
			itemnametext=itemname.get(i);
			itempricetext=itemprice.get(i);
			Reporter.log(""+itemnametext.getText()+"-------->"+itempricetext.getText(),true);
		}
     //   BrowsingContext browsingContext = new BrowsingContext(driver, WindowType.TAB);

		driver.quit();
		//fetch the price of the item
		
		
	/*	for (int i = 0; i < itemprice.size(); i++) {
			itempricetext=itemprice.get(i);
			Reporter.log(""+itempricetext.getText(),true);
		}*/
		
		
		//driver.navigate().refresh();
		
	}
}
