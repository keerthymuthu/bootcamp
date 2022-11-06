package pageobjmodel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import projectspecmethods.CommonMethods;
import webdriverinterfaceimpl.Basic;
import week1.BaseClass;

public class AccountsPage extends CommonMethods{
	
	//public AccountsPage(ChromeDriver driver) {
	//	this.driver=driver;
	//}
	
	public AccountsPage clickOnNew() {
		//driver.findElement(By.xpath("//div[text()='New']")).click();
		click(identifyElement("xpath", properties.getProperty("AccountsPage.clickOnNewAccount.xpath")));
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.clickOnNewAccount.xpath"))).click();
		return this;
	}
	
	
	public AccountsPage enterAccountName(String name) {
		//driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.enterAccountName.xpath"))).sendKeys(name);
		type(identifyElement("xpath",properties.getProperty("AccountsPage.enterAccountName.xpath")), name);
		return this;
	}
	
	public AccountsPage clickOnOwnerShip() {
		//driver.findElement(By.xpath("(//label[text()='Ownership']//following::button)[1]")).click();
		click(identifyElement("xpath", properties.getProperty("AccountsPage.clickOnOwnerShip.xpath")));
		return this;
	}
	
	public AccountsPage selectOwnerShip() {
		//driver.findElement(By.xpath("//span[@title='Public']")).click();
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.selectOwnerShip.xpath"))).click();
		click(identifyElement("xpath", properties.getProperty("AccountsPage.selectOwnerShip.xpath")));
		return this;
	}
	
	public AccountsPage clickSave() {
		//driver.findElement(By.xpath("//button[text()='Save']")).click();
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.save.xpath"))).click();
		click(identifyElement("xpath", properties.getProperty("AccountsPage.save.xpath")));
		return this;
	}
	
	public AccountsPage validateCreationName(String name) throws InterruptedException {
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4000));
		//WebElement final_name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("AccountsPage.creationName.xpath"))));
		//System.out.println(final_name.getText());
		//assert final_name.getText().equals(name);
		waitForPresence(By.xpath(properties.getProperty("AccountsPage.creationName.xpath")));
		System.out.println(getText(identifyElement("xpath", properties.getProperty("AccountsPage.creationName.xpath"))));
		assert true==verifyFullText(identifyElement("xpath", properties.getProperty("AccountsPage.creationName.xpath")),name);
		return this;
	}
	
	public AccountsPage validateToastMessage() {
		waitForclickability(identifyElement("xpath", properties.getProperty("AccountsPage.toast.xpath")));
		System.out.println(getText(identifyElement("xpath", properties.getProperty("AccountsPage.toast.xpath"))));
		assert true==verifyFullText(identifyElement("xpath", properties.getProperty("AccountsPage.toast.xpath")),"Account \"Salesforce Automation by POM\" was created.");
		return this;
	}
	
	public AccountsPage searchAccount(String name) {
		/*
		 * driver.findElement(By.xpath("(//input[@type='search'])[2]")).clear();
		 * driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(name);
		 * driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.
		 * ENTER);
		 */
			driver.findElement(By.xpath(properties.getProperty("AccountsPage.searchbox.xpath"))).clear();
			driver.findElement(By.xpath(properties.getProperty("AccountsPage.searchbox.xpath"))).sendKeys(name);
			driver.findElement(By.xpath(properties.getProperty("AccountsPage.searchbox.xpath"))).sendKeys(Keys.ENTER);
		  return this;
	}
	
	public AccountsPage selectFromSearchResult() throws InterruptedException {
		//WebElement ele=driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a"));
		//WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(500));
		Thread.sleep(5000);
		//WebElement n=new WebDriverWait(driver,Duration.ofSeconds(8)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a"))));
		WebElement n=new WebDriverWait(driver,Duration.ofSeconds(8)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(properties.getProperty("AccountsPage.selectFromSearchResult.xpath")))));
		n.click();
		return this;
	}
	
	public AccountsPage clickOnEdit() {
		//WebElement edit=new WebDriverWait(driver,Duration.ofSeconds(6000)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Edit']"))));
		//driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.xpath(properties.getProperty("AccountsPage.Edit.xpath"))).click();
		//edit.click();
		return this;
	}
	
	public AccountsPage typePhoneNum(String phone) {
		//driver.findElement(By.xpath("//input[@name='Phone']")).clear();
		//driver.findElement(By.xpath("//input[@name='Phone']")).sendKeys(phone);
		driver.findElement(By.xpath(properties.getProperty("AccountsPage.phonetextbox.xpath"))).clear();
		driver.findElement(By.xpath(properties.getProperty("AccountsPage.phonetextbox.xpath"))).sendKeys(phone);;
		return this;
	}
	
	public AccountsPage clickOnType() {
		//driver.findElement(By.xpath("//label[text()='Type']//parent::lightning-combobox//child::button")).click();
		driver.findElement(By.xpath(properties.getProperty("AccountsPage.typebutton.xpath"))).click();
		return this;
	}
	
	public AccountsPage selectType() {
		//driver.findElement(By.xpath("//span[@title='Technology Partner']")).click();
		driver.findElement(By.xpath(properties.getProperty("AccountsPage.typeoption.xpath"))).click();
		return this;
	}
	
	public AccountsPage clickOnIndustry() {
		//driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//label[text()='Industry']//parent::lightning-combobox//child::button")));
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath(properties.getProperty("AccountsPage.industrybutton.xpath"))));
		return this;
	}
	
	public AccountsPage selectIndustryType() {
		//driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@title='Healthcare']")));
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath(properties.getProperty("AccountsPage.industryoption.xpath"))));
		return this;
	}
	
	public AccountsPage typeBillingAddress(String address) {
		//driver.executeScript("arguments[0].value='"+address+"';", driver.findElement(By.xpath("//label[text()='Billing Street']//following-sibling::div//textarea")));
		driver.executeScript("arguments[0].value='"+address+"';", driver.findElement(By.xpath(properties.getProperty("AccountsPage.typeBillingAddress.xpath"))));
		return this;
	}
	
	public AccountsPage typeShippingAddress(String address) {
		//driver.findElement(By.xpath("//label[text()='Shipping Street']//parent::lightning-textarea//child::textarea")).sendKeys("Shipping address");
		driver.findElement(By.xpath(properties.getProperty("AccountsPage.typeShippingAddress.xpath"))).sendKeys(address);
		return this;
	}
	
	public AccountsPage clickOnCustomerPriority() {
		//driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//label[text()='Customer Priority']//parent::lightning-combobox//child::span")));
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath(properties.getProperty("AccountsPage.clickCustomerPriority.xpath"))));
		return this;
	}
	
	public AccountsPage selectCustomerPriority() {
		//driver.findElement(By.xpath("//span[@title='Low']")).click();
		driver.findElement(By.xpath(properties.getProperty("AccountsPage.selectCustomerPriority.xpath"))).click();
		return this;
	}
	
	public AccountsPage clickOnSLA() {
		//driver.findElement(By.xpath("//label[text()='SLA']//parent::lightning-combobox//descendant::button")).click();
		driver.findElement(By.xpath(properties.getProperty("AccountsPage.clickOnSLA.xpath"))).click();
		return this;
	}
	
	public AccountsPage selectSLASilver() {
		//driver.findElement(By.xpath("//span[@title='Silver']")).click();
		driver.findElement(By.xpath(properties.getProperty("AccountsPage.selectSLA.xpath"))).click();
		return this;
	}
	
	public AccountsPage clickOnActive() {
		//driver.findElement(By.xpath("//label[text()='Active']//parent::lightning-combobox//child::span")).click();
		driver.findElement(By.xpath(properties.getProperty("AccountsPage.clickOnActiveLabel.xpath"))).click();
		return this;
	}
	
	public AccountsPage clickOnNoActive() {
		//driver.findElement(By.xpath("//span[@title='No']")).click();
		driver.findElement(By.xpath(properties.getProperty("AccountsPage.clickOnNoActive.xpath"))).click();
		return this;
	}
	
	public AccountsPage clickOnUpsellOppo() {
		//driver.findElement(By.xpath("//label[text()='Upsell Opportunity']//parent::lightning-combobox//child::button")).click();
		driver.findElement(By.xpath(properties.getProperty("AccountsPage.clickOnUpSellOppo.xpath"))).click();
		return this;
	}
	
	public AccountsPage selectNoUpsellOppo() {
		//driver.findElement(By.xpath("//span[@title='No']")).click();
		driver.findElement(By.xpath(properties.getProperty("AccountsPage.selectNoUpsellOppo.xpath"))).click();
		return this;
	}
	
	public AccountsPage validatePhoneNum(String phone) throws InterruptedException {
		Thread.sleep(4000);
		//String phone_num=driver.findElement(By.xpath("//tbody//tr[1]//td[4]//span[@dir='ltr']")).getText();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(35));
		//String phone_num=driver.findElement(By.xpath(properties.getProperty("AccountsPage.phonenumber.xpath"))).getText();
		String phone_num=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(properties.getProperty("AccountsPage.phonenumber.xpath")))).getText();
		System.out.println("Phone#: "+phone_num);
		assert phone_num.equals(phone);
		return this;
	}
}