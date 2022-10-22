package week3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateTask_Error {
	@Test
	public void createTaskError() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		//Launch Salesforce
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		//Key in credentials
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		//click on login
		driver.findElement(By.id("Login")).click();
		//Thread.sleep(5000);
		//Check for Lightning experience
		if(driver.getTitle().equals("Home Page ~ Salesforce - Developer Edition")) {
		if(driver.findElement(By.xpath("(//a[text()='Switch to Lightning Experience'])[1]")).isDisplayed())
			driver.findElement(By.xpath("(//a[text()='Switch to Lightning Experience'])[1]")).click();
		}
		System.out.println("Title: "+driver.getTitle());
		Thread.sleep(5000);
		//click on toggle
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//Click on view All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Search for Sales
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Tasks");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3000));
		WebElement ele_tasks=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mark[text()='Tasks']")));
		ele_tasks.click();
		WebElement ele_dropdown=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@data-target-reveals,'NewTask')]//lightning-icon")));
		ele_dropdown.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='New Task']")).click();
		//Click on Name
		driver.findElement(By.xpath("//span[text()='Name']//parent::label//following-sibling::div//input")).click();
		driver.findElement(By.xpath("//div[@class='listContent']//a")).click();
		//Enter Description
		driver.findElement(By.xpath("//span[@id='quickTextKeyboardTip']//following-sibling::textarea")).sendKeys("SALES FORCE Automation Using Selenium");
		//Click on Save
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		//Final Validation
		String error_one=driver.findElement(By.xpath("//div[@class='genericNotification']/span")).getText();
		assert error_one.equals("Review the errors on this page.");
		String error_two=driver.findElement(By.xpath("//ul[@class='errorsList']/li")).getText();
		assert error_two.equals("These required fields must be completed: Subject");
		System.out.println(error_one);
		System.out.println(error_two);
	}
}