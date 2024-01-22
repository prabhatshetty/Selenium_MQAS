package Tasks;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class IrctcBusBook {

	@Test
	public void busbook() throws IOException, InterruptedException
	{
		ChromeOptions options=new ChromeOptions();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.irctc.co.in/nget/train-search");
		String parentWindowId = driver.getWindowHandle();
		List<WebElement> header = driver.findElements(By.xpath("//li[@class='menu-list header-icon-menu']"));
		WebElement headerwebele;
		for (int i = 1; i < header.size(); i++) {
			headerwebele = header.get(i);
			Reporter.log(headerwebele.getText(),true);
		}
		driver.findElement(By.xpath("//a[ text()=' BUSES ']")).click();
		
		Set<String> allWindowIds = driver.getWindowHandles();
		allWindowIds.remove(parentWindowId);
		for(String windowId:allWindowIds) {
			driver.switchTo().window(windowId);
		}
		driver.findElement(By.xpath("//input[@id='departFrom']")).sendKeys("Banga");
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Bangalore']")).click();
		driver.findElement(By.xpath("//input[@id='goingTo']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Chennai']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Departure Date']")).click();
		//td[@data-month='10' and .='30']
		LocalDate currentDate = LocalDate.now();
		String sysdate = currentDate.toString();
		String X = sysdate.substring(5,7);
		String Y = sysdate.substring(8);
		System.out.println(Y);
		//td[@data-month='10' and .='30']
		driver.findElement(By.xpath("//a[text()='"+Y+"']")).click();
		driver.findElement(By.xpath("//button[text()='Search Bus ']")).click();
		driver.findElement(By.xpath("//label[text()='After 6 pm']")).click();

		System.out.println("Bus List*****************" );
		List<WebElement> bus = driver.findElements(By.xpath("//div[@class='SearchCard SearchCard01']/label"));
		WebElement busname;
		for (int i = 1; i < bus.size(); i++) {
			busname = bus.get(i);
			Reporter.log(""+i+") "+busname.getText(),true);
		}
		driver.findElement(By.xpath("//button[text()='Select Seat']")).click();
		driver.findElement(By.xpath("//span[contains(@title,'Seat No.')]")).click();
		//driver.findElement(By.xpath("//input[@name='debordTime']")).click();
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Dropping Point']")).click();
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed to Book ']")).click();
		driver.findElement(By.xpath("//a[text()='Guest User Login ']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter Your Email']")).sendKeys("prabhat.s@testyantra.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Your Mobile Number']")).sendKeys("9482928782");
		driver.findElement(By.xpath("//label[text()='Mobile Number']/../following-sibling::div/button")).click();
		driver.findElement(By.xpath("//input[@placeholder='Mobile Nunber']")).sendKeys("9482928782");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Testing address");
		driver.findElement(By.xpath("//input[@placeholder='Pin Code']")).sendKeys("574108");
		driver.findElement(By.xpath("//option[text()='Select Country']")).click();
		driver.findElement(By.xpath("//option[text()='India']")).click();
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='state']"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("KARNATAKA");
		driver.findElement(By.xpath("//input[@placeholder='Traveller Name']")).sendKeys("Prabhat");
		driver.findElement(By.xpath("//option[.='Select Gender']")).click();
		driver.findElement(By.xpath("//option[.='Male']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Age']")).sendKeys("25");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement expectedEle = driver.findElement(By.xpath("//input[@id='agree']"));
		//js.executeScript("arguments[0].scrollIntoView(true);", expectedEle);
		js.executeScript("window.scrollBy(0,350)","");
		//js.executeScript("argument[0].click();", expectedEle);
		expectedEle.click();
		driver.findElement(By.xpath("//button[text()='Continue to Book ']")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;
		//File tempScreenshot = ts.getScreenshotAs(OutputType.FILE);
		Thread.sleep(20000);
		driver.findElement(By.xpath("//button[text()='Verify']")).click();
		WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[.='Summary ']/../div[@class='modal-body']")));
		
		File tempScreenshot = driver.findElement(By.xpath("//div[.='Summary ']/../div[@class='modal-body']")).getScreenshotAs(OutputType.FILE);
		File screenshot = new File("./errorshots/screenshot1.png");
//		tempScreenshot.renameTo(screenshot);
		FileUtils.copyFile(tempScreenshot, screenshot);	
		
		
		
		driver.quit();
	}
	
}
