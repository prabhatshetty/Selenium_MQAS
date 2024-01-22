package Tasks;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ShadowRoot {
	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		//options.addArguments("--headless=new");
		//options.addArguments("--headless");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/shadow");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//textbox = js.executeScript("document.querySelector('#open-shadow').shadowRoot.querySelector('#fname')");
		
	WebElement textbox = (WebElement)js.executeScript("document.querySelector('#open-shadow').shadowRoot.querySelector('#fname')");
	
	textbox.sendKeys("Apple");
	//WebElement enterName = (WebElement) js.executeScript("return document.querySelector('div#open-shadow').shadowRoot.querySelector('input#fname')");
	
	//	enterName.sendKeys("prabhat");
	
	}

}
