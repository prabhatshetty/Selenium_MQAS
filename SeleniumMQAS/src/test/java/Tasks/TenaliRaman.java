package Tasks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TenaliRaman {
 {
	
}
	@Test(invocationCount = 1)
	public void fetchname() throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		//options.addArguments("--headless=new");
		//options.addArguments("--headless");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://books-pwakit.appspot.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//document.querySelector('book-app').shadowRoot.querySelector('input')
		WebElement textbox = (WebElement) js.executeScript("return document.querySelector('book-app').shadowRoot.querySelector('input')");
		textbox.sendKeys("Tenali Raman",Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
		 Thread.sleep(3000);
		 
		WebElement booktittle = (WebElement) js.executeScript("return document.querySelector('book-app').shadowRoot.querySelector('main').querySelector('book-explore').shadowRoot.querySelector('section').querySelector('ul').querySelector('book-item').shadowRoot.querySelector('h2')");
		System.out.println(booktittle.getText());
		WebElement booktittle1 = (WebElement) js.executeScript("return document.querySelector('book-app').shadowRoot.querySelector('main').querySelector('book-explore').shadowRoot.querySelector('section').querySelectorAll('ul>li>book-item')[2].shadowRoot.querySelector('h2')");
		System.out.println(booktittle1.getText());
		WebElement booktittle2 = (WebElement) js.executeScript("return document.querySelector('book-app').shadowRoot.querySelector('main').querySelector('book-explore').shadowRoot.querySelector('section').querySelectorAll('ul>li>book-item')[3].shadowRoot.querySelector('h2')");
		System.out.println(booktittle2.getText());
		WebElement booktittle3 = (WebElement) js.executeScript("return document.querySelector('book-app').shadowRoot.querySelector('main').querySelector('book-explore').shadowRoot.querySelector('section').querySelectorAll('ul>li>book-item')[4].shadowRoot.querySelector('h2')");
		System.out.println(booktittle3.getText());
		WebElement booktittle4 = (WebElement) js.executeScript("return document.querySelector('book-app').shadowRoot.querySelector('main').querySelector('book-explore').shadowRoot.querySelector('section').querySelectorAll('ul>li>book-item')[5].shadowRoot.querySelector('h2')");
		System.out.println(booktittle4.getText());
		WebElement booktittle5 = (WebElement) js.executeScript("return document.querySelector('book-app').shadowRoot.querySelector('main').querySelector('book-explore').shadowRoot.querySelector('section').querySelectorAll('ul>li>book-item')[6].shadowRoot.querySelector('h2')");
		System.out.println(booktittle5.getText());
		WebElement booktittle6 = (WebElement) js.executeScript("return document.querySelector('book-app').shadowRoot.querySelector('main').querySelector('book-explore').shadowRoot.querySelector('section').querySelectorAll('ul>li>book-item')[7].shadowRoot.querySelector('h2')");
		System.out.println(booktittle6.getText());
		
		// List<WebElement>bookTitle = (List<WebElement>) js.executeScript("return document.querySelector('book-app').shadowRoot.querySelector('main').querySelector('book-explore').shadowRoot.querySelector('section').querySelectorAll('ul>li>book-item')");
		// WebElement booknametext;
			
			
		driver.quit();
		
}
}
