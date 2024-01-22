package Tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SpiceJet {
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
		driver.findElement(By.xpath("//div[text()='Mumbai']")).click();
		//driver.findElement(By.xpath("//div[text()='To']/..")).sendKeys("Del");
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("d");

		// Format the date as a string
		String formattedDate = sdf.format(currentDate);

		int date = (Integer.parseInt(formattedDate)+2);

		driver.findElement(By.xpath("//div[text()='"+date+"']")).click();
		driver.findElement(By.xpath("//div[text()='Passengers']/following-sibling::div")).click();
		driver.findElement(By.xpath("//div[text()='Adult']/../following-sibling::div//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		driver.findElement(By.xpath("//div[text()='Passengers']/following-sibling::div")).click();
		Thread.sleep(4000);
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(10));
		act.moveToElement(driver.findElement(By.xpath("//div[text()='Search Flight']"))).click().perform();
		File file = new File("./Data/Parekh Integrated _ Test Scenarios for WMS  (8).xlsx");;
		FileOutputStream fos = new FileOutputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Flight_details");
		XSSFRow firstrow = sheet.createRow(0);
		firstrow.createCell(0).setCellValue("Flightid");
		firstrow.createCell(1).setCellValue(" Price1");
		firstrow.createCell(2).setCellValue(" Price2");
		firstrow.createCell(3).setCellValue(" Price3");
		XSSFRow row;
		List<WebElement> flights = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-13awgt0']//child::div[@class='css-76zvg2 r-homxoj r-1i10wst']"));
		WebElement flightinfo;
		for (int i = 0; i < flights.size(); i++) {
			row = sheet.createRow(i+1);
			flightinfo = flights.get(i);
			Reporter.log(""+(i+1)+") "+flightinfo.getText(),true);
			row.createCell(0).setCellValue(flightinfo.getText());
		}
		//List<WebElement> flightsprice = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1sgu7fw r-1ljd8xs r-1phboty r-1777fci r-e9bn0q']/.."));
		List<WebElement> flightsprice = driver.findElements(By.xpath("//span[@class='css-76zvg2 css-16my406 r-homxoj r-16dba41']/.."));
		//List<WebElement> flightsprice = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1sgu7fw r-1ljd8xs r-1phboty r-1777fci r-e9bn0q']"));
		int j=1;
		WebElement flighpricetext;
		for (int i = 0; i < flightsprice.size(); i=i+3) {
			row=sheet.getRow(j);
			flighpricetext=flightsprice.get(i);
			row.createCell(1).setCellValue(flighpricetext.getText());
			Reporter.log(""+flighpricetext.getText(),true);
			j++;
		}
		int k=1;
		for (int i = 1; i < flightsprice.size(); i=i+3) {
			row=sheet.getRow(k);
			flighpricetext=flightsprice.get(i);
			row.createCell(2).setCellValue(flighpricetext.getText());
			Reporter.log(""+flighpricetext.getText(),true);
			k++;
		}
		int l=1;
		for (int i = 2; i < flightsprice.size(); i=i+3) {
			row=sheet.getRow(l);
			flighpricetext=flightsprice.get(i);
			row.createCell(3).setCellValue(flighpricetext.getText());
			Reporter.log(""+flighpricetext.getText(),true);
			l++;
		}
		//WebElement continuebutton = driver.findElement(By.xpath("//div[@data-testid='continue-search-page-cta']"));
		act.moveToElement(driver.findElement(By.xpath("//div[@data-testid='continue-search-page-cta']"))).click().perform();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//input[@data-testid='first-inputbox-contact-details']")).sendKeys("Prabhat1");
		driver.findElement(By.xpath("//input[@data-testid='last-inputbox-contact-details']")).sendKeys("Shetty");
		driver.findElement(By.xpath("//input[@data-testid='contact-number-input-box']")).sendKeys("9482928700");
		driver.findElement(By.xpath("//input[@data-testid='emailAddress-inputbox-contact-details']")).sendKeys("baro02@mailinator.com");
		driver.findElement(By.xpath("//input[@data-testid='city-inputbox-contact-details']")).sendKeys("Banglore");
		driver.findElement(By.xpath("//input[@data-testid='traveller-0-first-traveller-info-input-box']")).sendKeys("Prabhat ");
		driver.findElement(By.xpath("//input[@data-testid='traveller-0-last-traveller-info-input-box']")).sendKeys("Shetty");
		driver.findElement(By.xpath("//input[@data-testid='sc-member-mobile-number-input-box']")).sendKeys("9482928782");
		driver.findElement(By.xpath("//div[text()='Passenger 2']")).click();
		driver.findElement(By.xpath("//input[@data-testid='traveller-1-first-traveller-info-input-box']")).sendKeys("Prabhat2");
		driver.findElement(By.xpath("//input[@data-testid='traveller-1-last-traveller-info-input-box']")).sendKeys("Prabhat1");
		driver.findElement(By.xpath("//input[@data-testid='sc-member-mobile-number-input-box']")).sendKeys("9482928701");
		act.moveToElement(driver.findElement(By.xpath("//div[@data-testid='traveller-info-continue-cta']"))).click().perform();
		Thread.sleep(4000);
		WebElement continuebuttonn = driver.findElement(By.xpath("//div[@data-testid='add-ons-continue-footer-button' and not(@id)]"));
		Thread.sleep(8000);
		js.executeScript("window.scrollBy(0,1000)");
		js.executeScript("arguments[0].scrollIntoView(true);", continuebuttonn);
		wait.until(ExpectedConditions.visibilityOf(continuebuttonn));
		js.executeScript("arguments[0].click();", continuebuttonn);
		js.executeScript("arguments[0].click();", continuebuttonn);
		js.executeScript("arguments[0].click();", continuebuttonn);
		js.executeScript("arguments[0].click();", continuebuttonn);
		//act.moveToElement(driver.findElement(By.xpath("//div[@data-testid='add-ons-continue-footer-button' and not(@id)]"))).click().perform();
		WebElement button = driver.findElement(By.xpath("//div[@data-testid='common-proceed-to-pay']"));//
		wait.until(ExpectedConditions.visibilityOf(button));
		boolean buttonvalue = button.isEnabled();
		
		boolean a = true;
		
		if(a==buttonvalue)
		{
			Reporter.log("Button is enabled ",true);	
		}
		else
			Reporter.log("Button is notenabled ",true);
		
		workbook.write(fos);
		fos.close();
		driver.quit();

	}
}
