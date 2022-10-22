package week2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditCase {

	@Test
	public void editCase() throws InterruptedException {
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
		//Search for the subject
		WebElement search=driver.findElement(By.xpath("//label[text()='Search this list...']//following-sibling::div//input"));
		search.clear();
		search.sendKeys("Testing"+Keys.ENTER);
		Thread.sleep(3000);
		//Click on Edit
		driver.findElement(By.xpath("//tbody//tr[1]//td[7]//a")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		//Fetch the Case #
		WebElement ele_case_num=driver.findElement(By.xpath("//span[contains(@class,'is-read-only')]//span[@class='uiOutputText']"));
		String case_num=ele_case_num.getText();
		System.out.println("Case Num: "+case_num);
		//Click on Status drop-down
		WebElement ele_status=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button' and contains(@id,'combobox')]")));
		ele_status.click();
		//Select Working
		driver.findElement(By.xpath("//span[@title='Working']")).click();
		//Click on Priority
		driver.findElement(By.xpath("//span[text()='Priority']//parent::span[contains(@class,'label inputLabel')]//following-sibling::div//a")).click();
		driver.findElement(By.xpath("//a[@title='Low']")).click();
		//Click on Case Origin
		driver.findElement(By.xpath("//span[text()='Case Origin']//parent::span[contains(@class,'label inputLabel')]//following-sibling::div//a")).click();
		driver.findElement(By.xpath("//a[@title='Phone']")).click();
		//Click On SLA Violation
		driver.findElement(By.xpath("//span[text()='SLA Violation']//parent::span[contains(@class,'label inputLabel')]//following-sibling::div//a")).click();
		driver.findElement(By.xpath("//a[@title='No']")).click();
		//Click on Save
		driver.findElement(By.xpath("(//span[text()='Save' and @dir='ltr'])[2]")).click();
		//Get Toast message
		WebElement ele_toastspan=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage')]")));
		System.out.println("Toast Message: "+ele_toastspan.getText());
		//Final validation
		search.clear();
		search.sendKeys(case_num+Keys.ENTER);
		assert "Working"==driver.findElement(By.xpath("//tbody//tr//td[4]//span[@class='slds-truncate']")).getText();
	}
}
