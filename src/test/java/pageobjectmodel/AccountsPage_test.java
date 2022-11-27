package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import projectspecificmethods.CommonMethods_test;

public class AccountsPage_test extends CommonMethods_test{
	
	/*
	 * public AccountsPage_test(ExtentTest test) { //this.driver=driver;
	 * this.test=test; }
	 */
	
	public AccountsPage_test clickOnNew() {
		//driver.findElement(By.xpath("//div[text()='New']")).click();
		click(identifyElement("xpath", properties.getProperty("AccountsPage.clickOnNewAccount.xpath")));
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.clickOnNewAccount.xpath"))).click();
		return this;
	}
	
	
	public AccountsPage_test enterAccountName(String name) {
		//driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.enterAccountName.xpath"))).sendKeys(name);
		type(identifyElement("xpath",properties.getProperty("AccountsPage.enterAccountName.xpath")), name);
		return this;
	}
	
	public AccountsPage_test clickOnOwnerShip() {
		//driver.findElement(By.xpath("(//label[text()='Ownership']//following::button)[1]")).click();
		click(identifyElement("xpath", properties.getProperty("AccountsPage.clickOnOwnerShip.xpath")));
		return this;
	}
	
	public AccountsPage_test selectOwnerShip() {
		//driver.findElement(By.xpath("//span[@title='Public']")).click();
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.selectOwnerShip.xpath"))).click();
		click(identifyElement("xpath", properties.getProperty("AccountsPage.selectOwnerShip.xpath")));
		return this;
	}
	
	public AccountsPage_test clickSave() {
		//driver.findElement(By.xpath("//button[text()='Save']")).click();
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.save.xpath"))).click();
		click(identifyElement("xpath", properties.getProperty("AccountsPage.save.xpath")));
		return this;
	}
	
	public AccountsPage_test validateCreationName(String name) throws InterruptedException {
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4000));
		//WebElement final_name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("AccountsPage.creationName.xpath"))));
		//System.out.println(final_name.getText());
		//assert final_name.getText().equals(name);
		waitForPresence(By.xpath(properties.getProperty("AccountsPage.creationName.xpath")));
		System.out.println(getText(identifyElement("xpath", properties.getProperty("AccountsPage.creationName.xpath"))));
		assert true==verifyFullText(identifyElement("xpath", properties.getProperty("AccountsPage.creationName.xpath")),name);
		return this;
	}
	
	public AccountsPage_test validateToastMessage() {
		waitForclickability(identifyElement("xpath", properties.getProperty("AccountsPage.toast.xpath")));
		System.out.println(getText(identifyElement("xpath", properties.getProperty("AccountsPage.toast.xpath"))));
		assert true==verifyFullText(identifyElement("xpath", properties.getProperty("AccountsPage.toast.xpath")),"Account \"Salesforce Automation by POM\" was created.");
		return this;
	}
	
	public AccountsPage_test searchAccount(String name) {
		/*
		 * driver.findElement(By.xpath(properties.getProperty(
		 * "AccountsPage.searchbox.xpath"))).clear();
		 * driver.findElement(By.xpath(properties.getProperty(
		 * "AccountsPage.searchbox.xpath"))).sendKeys(name);
		 * driver.findElement(By.xpath(properties.getProperty(
		 * "AccountsPage.searchbox.xpath"))).sendKeys(Keys.ENTER);
		 */
			type(identifyElement("xpath", properties.getProperty("AccountsPage.searchbox.xpath")),name);
			pressEnter(identifyElement("xpath", properties.getProperty("AccountsPage.searchbox.xpath")));
		  return this;
	}
	
	public AccountsPage_test selectFromSearchResult() throws InterruptedException {
		//WebElement ele=driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a"));
		//WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(500));
		//Thread.sleep(5000);
		//WebElement n=new WebDriverWait(driver,Duration.ofSeconds(8)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a"))));
		//WebElement n=new WebDriverWait(driver,Duration.ofSeconds(8)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(properties.getProperty("AccountsPage.selectFromSearchResult.xpath")))));
		//n.click();
		//clickUsinJavaScriptExecutor(identifyElement("xpath", properties.getProperty("AccountsPage.clickOnAccount.xpath")));
		//waitForPresence(By.xpath(properties.getProperty("AccountsPage.selectFromSearchResult.xpath")));
		//click(identifyElement("xpath", properties.getProperty("AccountsPage.clickOuter.xpath")));
		//waitForclickability(identifyElement("xpath", properties.getProperty("AccountsPage.selectFromSearchResult.xpath")));
		//click(identifyElement("xpath", properties.getProperty("AccountsPage.selectFromSearchResult.xpath")));
		
		//clickUsinJavaScriptExecutor(identifyElement("xpath", properties.getProperty("AccountsPage.selectFromSearchResult.xpath")));
		getDriver().findElement(By.xpath("//button[@title='Refresh']")).click();
		//waitForclickability(identifyElement("xpath", properties.getProperty("AccountsPage.selectFromSearchResult.xpath")));
		Thread.sleep(4000);
		click(identifyElement("xpath", properties.getProperty("AccountsPage.selectFromSearchResult.xpath")));
		return this;
	}
	
	public AccountsPage_test clickOnEdit() {
		//WebElement edit=new WebDriverWait(driver,Duration.ofSeconds(6000)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Edit']"))));
		//driver.findElement(By.xpath("//a[@title='Edit']")).click();
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.Edit.xpath"))).click();
		//edit.click();
		click(identifyElement("xpath", properties.getProperty("AccountsPage.Edit.xpath")));
		return this;
	}
	
	public AccountsPage_test typePhoneNum(String phone) {
		//driver.findElement(By.xpath("//input[@name='Phone']")).clear();
		//driver.findElement(By.xpath("//input[@name='Phone']")).sendKeys(phone);
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.phonetextbox.xpath"))).clear();
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.phonetextbox.xpath"))).sendKeys(phone);;
		type(identifyElement("xpath", properties.getProperty("AccountsPage.phonetextbox.xpath")),phone);
		return this;
	}
	
	public AccountsPage_test clickOnType() {
		//driver.findElement(By.xpath("//label[text()='Type']//parent::lightning-combobox//child::button")).click();
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.typebutton.xpath"))).click();
		click(identifyElement("xpath", properties.getProperty("AccountsPage.typebutton.xpath")));
		return this;
	}
	
	public AccountsPage_test selectType() {
		//driver.findElement(By.xpath("//span[@title='Technology Partner']")).click();
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.typeoption.xpath"))).click();
		click(identifyElement("xpath", properties.getProperty("AccountsPage.typeoption.xpath")));
		return this;
	}
	
	public AccountsPage_test clickOnIndustry() {
		//driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//label[text()='Industry']//parent::lightning-combobox//child::button")));
		//driver.executeScript("arguments[0].click();", driver.findElement(By.xpath(properties.getProperty("AccountsPage.industrybutton.xpath"))));
		clickUsinJavaScriptExecutor(identifyElement("xpath", properties.getProperty("AccountsPage.industrybutton.xpath")));
		return this;
	}
	
	public AccountsPage_test selectIndustryType() {
		//driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@title='Healthcare']")));
		//driver.executeScript("arguments[0].click();", driver.findElement(By.xpath(properties.getProperty("AccountsPage.industryoption.xpath"))));
		clickUsinJavaScriptExecutor(identifyElement("xpath", properties.getProperty("AccountsPage.industryoption.xpath")));
		return this;
	}
	
	public AccountsPage_test typeBillingAddress(String address) {
		//driver.executeScript("arguments[0].value='"+address+"';", driver.findElement(By.xpath("//label[text()='Billing Street']//following-sibling::div//textarea")));
		//driver.executeScript("arguments[0].value='"+address+"';", driver.findElement(By.xpath(properties.getProperty("AccountsPage.typeBillingAddress.xpath"))));
		typeUsingJavaScriptExecutor(identifyElement("xpath", properties.getProperty("AccountsPage.industryoption.xpath")),address);
		return this;
	}
	
	public AccountsPage_test typeShippingAddress(String address) {
		//driver.findElement(By.xpath("//label[text()='Shipping Street']//parent::lightning-textarea//child::textarea")).sendKeys("Shipping address");
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.typeShippingAddress.xpath"))).sendKeys(address);
		type(identifyElement("xpath", properties.getProperty("AccountsPage.typeShippingAddress.xpath")),address);
		return this;
	}
	
	public AccountsPage_test clickOnCustomerPriority() {
		//driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//label[text()='Customer Priority']//parent::lightning-combobox//child::span")));
		//driver.executeScript("arguments[0].click();", driver.findElement(By.xpath(properties.getProperty("AccountsPage.clickCustomerPriority.xpath"))));
		clickUsinJavaScriptExecutor(identifyElement("xpath", properties.getProperty("AccountsPage.clickCustomerPriority.xpath")));
		return this;
	}
	
	public AccountsPage_test selectCustomerPriority() {
		//driver.findElement(By.xpath("//span[@title='Low']")).click();
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.selectCustomerPriority.xpath"))).click();
		click(identifyElement("xpath", properties.getProperty("AccountsPage.selectCustomerPriority.xpath")));
		return this;
	}
	
	public AccountsPage_test clickOnSLA() {
		//driver.findElement(By.xpath("//label[text()='SLA']//parent::lightning-combobox//descendant::button")).click();
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.clickOnSLA.xpath"))).click();
		click(identifyElement("xpath", properties.getProperty("AccountsPage.clickOnSLA.xpath")));
		return this;
	}
	
	public AccountsPage_test selectSLASilver() {
		//driver.findElement(By.xpath("//span[@title='Silver']")).click();
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.selectSLA.xpath"))).click();
		click(identifyElement("xpath", properties.getProperty("AccountsPage.selectSLA.xpath")));
		return this;
	}
	
	public AccountsPage_test clickOnActive() {
		//driver.findElement(By.xpath("//label[text()='Active']//parent::lightning-combobox//child::span")).click();
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.clickOnActiveLabel.xpath"))).click();
		//click(identifyElement("xpath", properties.getProperty("AccountsPage.clickOnActiveLabel.xpath")));
		clickUsinJavaScriptExecutor(identifyElement("xpath", properties.getProperty("AccountsPage.clickOnActiveLabel.xpath")));
		return this;
	}
	
	public AccountsPage_test clickOnNoActive() {
		//driver.findElement(By.xpath("//span[@title='No']")).click();
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.clickOnNoActive.xpath"))).click();
		//click(identifyElement("xpath", properties.getProperty("AccountsPage.clickOnNoActive.xpath")));
		clickUsinJavaScriptExecutor(identifyElement("xpath", properties.getProperty("AccountsPage.clickOnNoActive.xpath")));
		return this;
	}
	
	public AccountsPage_test clickOnUpsellOppo() {
		//driver.findElement(By.xpath("//label[text()='Upsell Opportunity']//parent::lightning-combobox//child::button")).click();
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.clickOnUpSellOppo.xpath"))).click();
		//click(identifyElement("xpath", properties.getProperty("AccountsPage.clickOnUpSellOppo.xpath")));
		clickUsinJavaScriptExecutor(identifyElement("xpath", properties.getProperty("AccountsPage.clickOnUpSellOppo.xpath")));
		return this;
	}
	
	public AccountsPage_test selectNoUpsellOppo() {
		//driver.findElement(By.xpath("//span[@title='No']")).click();
		//driver.findElement(By.xpath(properties.getProperty("AccountsPage.selectNoUpsellOppo.xpath"))).click();
		//click(identifyElement("xpath", properties.getProperty("AccountsPage.selectNoUpsellOppo.xpath")));
		clickUsinJavaScriptExecutor(identifyElement("xpath", properties.getProperty("AccountsPage.selectNoUpsellOppo.xpath")));
		return this;
	}
	
	public AccountsPage_test validatePhoneNum(String phone) throws InterruptedException {
		//Thread.sleep(4000);
		//String phone_num=driver.findElement(By.xpath("//tbody//tr[1]//td[4]//span[@dir='ltr']")).getText();
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(35));
		//String phone_num=driver.findElement(By.xpath(properties.getProperty("AccountsPage.phonenumber.xpath"))).getText();
		//String phone_num=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(properties.getProperty("AccountsPage.phonenumber.xpath")))).getText();
		//System.out.println("Phone#: "+phone_num);
		//assert phone_num.equals(phone);
		waitForPresence(By.xpath(properties.getProperty("AccountsPage.phonenumber.xpath")));
		String phone_num=getText(identifyElement("xpath", properties.getProperty("AccountsPage.phonenumber.xpath")));
		System.out.println("Phone#: "+phone_num);
		assert phone_num.equals(phone);
		return this;
	}
	
	public AccountsPage_test clickonDelete() {
		click(identifyElement("xpath", properties.getProperty("AccountsPage.Delete.xpath")));
		return this;
	}
	
	public AccountsPage_test clickConfirmDelete() {
		click(identifyElement("xpath", properties.getProperty("AccountsPage.confirmDelete.xpath")));
		return this;
	}
	
	public AccountsPage_test validateSearchResult() {
		waitForPresence(By.xpath(properties.getProperty("AccountsPage.deleteMessage.xpath")));
		assert true==verifyDisplayed(identifyElement("xpath", properties.getProperty("AccountsPage.deleteMessage.xpath")));
		return this;
	}
}
