package Tasks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BigBasket1 {

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

		File file = new File("./Data/Parekh Integrated _ Test Scenarios for WMS  (2).xlsx");;
		FileOutputStream fos = new FileOutputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Items1");
		XSSFRow firstrow = sheet.createRow(0);
		firstrow.createCell(0).setCellValue("Item_Name");
		firstrow.createCell(1).setCellValue("Item_Price");
		XSSFRow row;
		List<WebElement> itemname = driver.findElements(By.xpath("//div[@class='break-words h-10 w-full']"));
		List<WebElement> itemprice = driver.findElements(By.xpath("//span[@class='Label-sc-15v1nk5-0 Pricing___StyledLabel-sc-pldi2d-1 gJxZPQ AypOi']"));
		WebElement itemnametext;
		WebElement itempricetext;
		for (int i = 1; i < itemname.size(); i++) {
			itemnametext=itemname.get(i);
			itempricetext=itemprice.get(i);
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(itemnametext.getText());
			row.createCell(1).setCellValue(itempricetext.getText());
			Reporter.log(""+i+") "+itemnametext.getText()+"-------->"+itempricetext.getText(),true);
		}
		driver.navigate().back();
		driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:R5bclm:']")).click();
		WebElement catogorytypebeverage = driver.findElement(By.xpath("//a[text()='Fruits & Vegetables']"));
		js.executeScript("arguments[0].click();", catogorytypebeverage);
		//driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:R5bclm:']")).click();
		
		
		
		
		
		
		
		//   BrowsingContext browsingContext = new BrowsingContext(driver, WindowType.TAB);

		//driver.quit();
		//fetch the price of the item


		/*	for (int i = 0; i < itemprice.size(); i++) {
			itempricetext=itemprice.get(i);
			Reporter.log(""+itempricetext.getText(),true);
		}*/


		driver.navigate().refresh();

	}

}
