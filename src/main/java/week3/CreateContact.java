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

public class CreateContact {
	
	@Test
	public void createContact() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver=new ChromeDriver(options);
		
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2000));
		WebElement elementUsername=driver.findElement(By.id("username"));
		elementUsername.sendKeys("hari.radhakrishnan@qeagle.com");
		WebElement elementPassword=driver.findElement(By.id("password"));
		elementPassword.sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("contacts");
		driver.findElement(By.xpath("//mark[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//a[@title='New']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//label[text()='Salutation']//following-sibling::div//lightning-base-combobox/div")).click();
		driver.findElement(By.xpath("//span[text()='Mr.']")).click();
		driver.findElement(By.xpath("//label[text()='First Name']//following-sibling::div//input")).sendKeys("Naveen");
		driver.findElement(By.xpath("//label[text()='Last Name']//following-sibling::div//input")).sendKeys("Elumalai");
		WebElement ele_email=driver.findElement(By.xpath("//label[text()='Email']//following-sibling::div//input"));
		driver.executeScript("arguments[0].value='naveen@test.com';", ele_email);
		
		//Click on Account Name
		WebElement ele_accountname=driver.findElement(By.xpath("//label[text()='Account Name']//following-sibling::div//input"));
		driver.executeScript("arguments[0].click();", ele_accountname);
		WebElement ele_new=driver.findElement(By.xpath("//span[text()='New Account']"));
		driver.executeScript("arguments[0].click();", ele_new);
		
		//New Account
		driver.findElement(By.xpath("//span[text()='Account Name']//parent::label//following-sibling::input")).sendKeys("Credits");
		driver.findElement(By.xpath("(//span[text()='Save'])[2]//parent::button")).click();
		Thread.sleep(8000);
		
		//Click on Save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		WebElement ele_toastspan=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage')]")));
		System.out.println("Toast Message: "+ele_toastspan.getText());
		assert ele_toastspan.getText().contains("Contact \"Mr. Naveen Elumalai\" was created.");
	}
}