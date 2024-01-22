package Tasks;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Report {

	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("Extentreport.html");
		spark.config().setDocumentTitle("Automation report");
		spark.config().setTheme(Theme.DARK);
		extent.setSystemInfo("Browser", "Chrome 118");
		extent.attachReporter(spark);
		
		//report.set sys info
	}


	@BeforeTest
	public void beforeTest() {
		//extent.createTest("Launch Browser", "description");
		

		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ajio.com/");
	}


	@Test
	public void TC_001() {
		ExtentTest test = extent.createTest("Name of the Test 1");
		test.info("information");
		}
	
	@Test
	public void TC_002() {
		ExtentTest test = extent.createTest("Name of the Test 2");
		
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@AfterClass
	public void afterClass() {
		extent.flush();
	}
}
