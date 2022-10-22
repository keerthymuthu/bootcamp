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

public class CreateTask {

	@Test
	public void createTask() throws InterruptedException {
		// TODO Auto-generated method stub
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
		//Enter subject
		driver.findElement(By.xpath("//input[contains(@id,'combobox-input')]")).sendKeys("Bootcamp");
		//Enter Contacts
		driver.findElement(By.xpath("//input[@role='combobox' and @title='Search Contacts']")).click();
		driver.findElement(By.xpath("//ul[@role='presentation' and contains(@class,'lookup')]//li[3]")).click();
		//Enter Status
		driver.findElement(By.xpath("//span[text()='Status' and contains(@id,'a-label')]//parent::span//following-sibling::div//a")).click();
		driver.findElement(By.xpath("//a[@title='Waiting on someone else']")).click();
		//Click on Save
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		WebElement ele_toastspan=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage')]")));
		System.out.println("Toast Message: "+ele_toastspan.getText());
		assert "Task Bootcamp was created.".equals(ele_toastspan.getText());
	}
}