package pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import projectspecificmethods.CommonMethods_test;

public class CasePage_test extends CommonMethods_test{
	
	public CasePage_test(ChromeDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	
	public CasePage_test clickNewCase() {
		clickUsinJavaScriptExecutor(identifyElement("xpath", properties.getProperty("CasePage.NewCase.xpath")));
		return this;
	}
	
	public CasePage_test clickOnContact() {
		click(identifyElement("xpath", properties.getProperty("CasePage.ClickContacts.xpath")));
		return this;
	}
	
	public CasePage_test selectContact() {
		click(identifyElement("xpath", properties.getProperty("CasePage.SelectContacts.xpath")));
		return this;
	}
	
	public CasePage_test clickCaseOrigin() {
		click(identifyElement("xpath", properties.getProperty("CasePage.CaseOrigin.xpath")));
		return this;
	}
	
	public CasePage_test selectCaseOrigin(String option) {
		click(identifyElement("xpath", properties.getProperty("CasePage.CaseOption.xpath").replace("option", option)));
		return this;
	}
	
	public CasePage_test clickStatusDropDown() {
		click(identifyElement("xpath", properties.getProperty("CasePage.Status.xpath")));
		return this;
	}
	
	public CasePage_test selectStatusDropDown(String status) {
		click(identifyElement("xpath", properties.getProperty("CasePage.StatusValue.xpath").replace("option", status)));
		return this;
	}
	
	public CasePage_test typeSubject(String subject) {
		typeUsingJavaScriptExecutor(identifyElement("xpath", properties.getProperty("CasePage.Subject.xpath")),subject);
		return this;
	}
	
	public CasePage_test typeDescription(String desc) {
		typeUsingJavaScriptExecutor(identifyElement("xpath", properties.getProperty("CasePage.Description.xpath")),desc);
		return this;
	}
	
	public CasePage_test clickSave() {
		click(identifyElement("xpath", properties.getProperty("CasePage.Save.xpath")));
		return this;
	}
	
	public CasePage_test validateToastMessage(String output) {
		waitForclickability(identifyElement("xpath", properties.getProperty("AccountsPage.toast.xpath")));
		System.out.println(getText(identifyElement("xpath", properties.getProperty("AccountsPage.toast.xpath"))));
		WebElement ele=identifyElement("xpath", properties.getProperty("AccountsPage.toast.xpath"));
		String s=ele.getText();
		System.out.println(ele.getText()+" : "+output);
		assert s.contains(output);
		//assert true==verifyPartialText(ele,output);
		//Assert.assertEquals(true, verifyPartialText(ele,output));
		return this;
	}
}