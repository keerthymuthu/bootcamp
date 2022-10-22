package week1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditAccount extends BaseClass{
	
	@BeforeTest
	public void init() {
		dataSheetName="EditAccount";
	}

	@Test(dataProvider="fetchData")
	public void editAccount(String module,String input,String phone,String address) throws InterruptedException {
		//Search for Sales
		
		  driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys(module); 
		  //Click on Sales
		  driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click(); 
		  //Click on Account 
		  WebElement account=driver.findElement(By.xpath("//a[@title='Accounts']"));
		  driver.executeScript("arguments[0].click();",account); 
		  //Search and select account 
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(input);
		  driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER); 
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a")).click(); 
		  //Click on Edit button 
		  driver.findElement(By.xpath("//a[@title='Edit']")).click();
		  Thread.sleep(2000); 
		  //Edit Phone number 
		  WebElement ele_phone=driver.findElement(By.xpath("//input[@name='Phone']"));
		  ele_phone.clear(); 
		  Thread.sleep(2000); 
		  ele_phone.sendKeys(phone); 
		  //Click and Edit Type 
		  driver.findElement(By.xpath("//label[text()='Type']//parent::lightning-combobox//child::button")).click(); 
		  //Select Type
		  driver.findElement(By.xpath("//span[@title='Technology Partner']")).click();
		  //Click and edit Industry 
		  WebElement industry=driver.findElement(By.xpath("//label[text()='Industry']//parent::lightning-combobox//child::button"));
		  driver.executeScript("arguments[0].click();", industry); 
		  //Select Type
		  WebElement type_industry=driver.findElement(By.xpath("//span[@title='Healthcare']"));
		  driver.executeScript("arguments[0].click();", type_industry);
		  //Enter billing address 
		  WebElement billing=driver.findElement(By.xpath("//label[text()='Billing Street']//following-sibling::div//textarea"));
		  driver.executeScript("arguments[0].value='"+address+"';", billing); 
		  //Enter Shipping address 
		  driver.findElement(By.xpath("//label[text()='Shipping Street']//parent::lightning-textarea//child::textarea")).sendKeys("Shipping address"); 
		  //Click on Customer Priority
		  WebElement cust_priority=driver.findElement(By.xpath("//label[text()='Customer Priority']//parent::lightning-combobox//child::span")); 
		  driver.executeScript("arguments[0].click();", cust_priority); 
		  //Select Low 
		  driver.findElement(By.xpath("//span[@title='Low']")).click(); 
		  //Click on SLA 
		  driver.findElement(By.xpath("//label[text()='SLA']//parent::lightning-combobox//descendant::button")).click(); 
		  //Select Silver
		  driver.findElement(By.xpath("//span[@title='Silver']")).click(); 
		  //Click on Active 
		  driver.findElement(By.xpath("//label[text()='Active']//parent::lightning-combobox//child::span")).click();
		  //Select No 
		  driver.findElement(By.xpath("//span[@title='No']")).click();
		  //Click on Upsell Opportunity 
		  driver.findElement(By.xpath("//label[text()='Upsell Opportunity']//parent::lightning-combobox//child::button")).click(); 
		  //Select No
		  driver.findElement(By.xpath("//span[@title='No']")).click(); //Click on Save
		  driver.findElement(By.xpath("//button[text()='Save']")).click(); 
		  Thread.sleep(3000); 
		  String phone_num=driver.findElement(By.xpath("//tbody//tr[1]//td[4]//span[@dir='ltr']")).getText();
		  output=driver.findElement(By.xpath("//tbody//tr[1]//td[4]//span[@dir='ltr']")).getText(); 
		  System.out.println("In Edit Class: "+output);
		  validationInput=phone;
		 
		Assert.assertEquals(phone_num, phone);
	}
}