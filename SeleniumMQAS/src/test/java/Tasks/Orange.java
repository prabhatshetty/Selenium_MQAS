package Tasks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Orange {
	@Test
	public void orangrcrm() throws InterruptedException
	{
		ChromeOptions options=new ChromeOptions();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		driver.findElement(By.xpath("//span[text()='Recruitment']")).click();
		driver.findElement(By.xpath("//label[text()='Job Title']/../following-sibling::div/div/div")).click();
		driver.findElement(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']//div[@class='oxd-select-option']/span")).click();
		driver.findElement(By.xpath("//label[text()='Vacancy']/../following-sibling::div/div/div")).click();
		driver.findElement(By.xpath("//span[text()='Junior Account Assistant']")).click();
		driver.findElement(By.xpath("//label[text()='Hiring Manager']/../following-sibling::div/div/div")).click();
		driver.findElement(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']//div[@class='oxd-select-option']/span")).click();
		driver.findElement(By.xpath("//label[text()='Status']/../following-sibling::div/div/div")).click();
		driver.findElement(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']//div[@class='oxd-select-option']/span")).click();
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Jos");
		driver.findElement(By.xpath("//span[text()='Joshua  Malfoy']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter comma seperated words...']")).sendKeys("Abcd");
		driver.findElement(By.xpath("//input[@placeholder='From']")).click();
		driver.findElement(By.xpath("//div[text()='1']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='2']")).click();
 
		driver.findElement(By.xpath("//label[text()='Method of Application']/../following-sibling::div/div/div")).click();
		driver.findElement(By.xpath("//span[text()='Manual']")).click();
		driver.findElement(By.xpath("//button[text()=' Search ']")).click();
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("")).click();
		
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		//driver.quit();
		
	}

}
