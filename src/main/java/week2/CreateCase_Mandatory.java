package week2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCase_Mandatory {

	@Test
	public void createCaseMandatory() throws InterruptedException{
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
		Thread.sleep(5000);
		//click on toggle
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//Click on view All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Search for Sales
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
		Thread.sleep(2000);
		//Click on Sales
		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		Thread.sleep(3000);
		//Click on More
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2000));
		WebElement ele_more=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='More']")));
		ele_more.click();
		Thread.sleep(4000);
		//Click on Cases
		WebElement ele_cases=driver.findElement(By.xpath("//span[@class='slds-truncate']/span[text()='Cases']"));
		driver.executeScript("arguments[0].click();", ele_cases);
		Thread.sleep(4000);
		//Click on Cases drop-down
		driver.findElement(By.xpath("//a[@title='Cases']//following::lightning-primitive-icon[1]")).click();
		Thread.sleep(4000);
		//Click on New Case
		WebElement ele_newcase=driver.findElement(By.xpath("//span[text()='New Case']"));
		driver.executeScript("arguments[0].click();", ele_newcase);
		//Click on Contacts
		driver.findElement(By.xpath("//input[@placeholder='Search Contacts...']")).click();
		//Select Contact
		driver.findElement(By.xpath("//input[@placeholder='Search Contacts...']//following::a[@role='option']")).click();
		//Click on Status drop-down
		WebElement ele_status=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button' and contains(@id,'combobox')]")));
		ele_status.click();
		//Select Working
		driver.findElement(By.xpath("//span[@title='--None--']")).click();
		//Enter Subject
		WebElement ele_subject=driver.findElement(By.xpath("//span[text()='Subject']//parent::label//following-sibling::input"));
		driver.executeScript("arguments[0].value='Testing'", ele_subject);
		//Enter description
		WebElement ele_desc=driver.findElement(By.xpath("//*[@role='textbox']"));
		driver.executeScript("arguments[0].value='Automation Testing'", ele_desc);
		//Click on Save
		driver.findElement(By.xpath("(//span[text()='Save' and @dir='ltr'])[2]")).click();
		//Validate error message
		System.out.println(driver.findElement(By.xpath("//span[contains(@class,'genericError')]")).getText());
		assert driver.findElement(By.xpath("//span[contains(@class,'genericError')]")).isDisplayed()==true;
		WebElement error_msg_second=driver.findElement(By.xpath("//ul[@class='errorsList']//li"));
		assert error_msg_second.isDisplayed()==true;
		System.out.println(error_msg_second.getText());
	}
}