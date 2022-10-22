package week1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public RemoteWebDriver driver;
	public String dataSheetName,validationInput,output;
	public static Properties properties=new Properties();
	
	@BeforeSuite
	public void init() throws IOException {
		//WebDriverManager.chromedriver().setup();
//		FileInputStream file=new FileInputStream(new File("src/main/resources/AppConfig.properties"));
	//	properties.load(file);
	}

	//@Parameters({"URL"})
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException {
		FileInputStream file=new FileInputStream(new File("src/main/resources/AppConfig.properties"));
		properties.load(file);
		String url=properties.getProperty("appUrl");
		if(properties.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--incognito");
			driver=new ChromeDriver(options);
		}
		else if(properties.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--incognito");
			driver=new FirefoxDriver(options);
		}
		//Launch Salesforce
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		if(driver.getTitle().equals("Home Page ~ Salesforce - Developer Edition")) {
			if(driver.findElement(By.xpath("(//a[text()='Switch to Lightning Experience'])[1]")).isDisplayed())
				driver.findElement(By.xpath("(//a[text()='Switch to Lightning Experience'])[1]")).click();
		}
		System.out.println("Title: "+driver.getTitle());
		Thread.sleep(5000);
	}
	@DataProvider(name="fetchData")
	public  Object[][] getData() throws IOException{
		return TestDataProvider.getSheet(dataSheetName);		
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("In After method");
		driver.close();
	}

	@AfterSuite
	public void destroy() {
		System.out.println("In After suite");
		driver.quit();
	}

	public void waitForClickability(WebElement ele) {
		new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void type(WebElement ele,String text) {
		//ele.clear();
		ele.sendKeys(text);
	}

	public void click(WebElement ele) {
		waitForClickability(ele);
		ele.click();
	}
}