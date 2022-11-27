package pageobjectmodel;

import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import projectspecificmethods.CommonMethods_test;

public class HomePage_test extends CommonMethods_test{
	
	/*
	 * public HomePage_test(ExtentTest test) { //this.driver=driver; this.test=test;
	 * }
	 */
	
	public HomePage_test clickOnAppLauncher() {
		click(identifyElement("xpath", properties.getProperty("HomePage.appLauncher.xpath")));
		return this;
	}
	
	public HomePage_test clickOnViewAll() {
		waitForclickability(identifyElement("xpath", properties.getProperty("HomePage.viewall.xpath")));
		click(identifyElement("xpath", properties.getProperty("HomePage.viewall.xpath")));
		return this;
	}
	
	public HomePage_test searchAppLauncher(String module) {
		waitForclickability(identifyElement("xpath", properties.getProperty("HomePage.searchAppLauncher.xpath")));
		type(identifyElement("xpath", properties.getProperty("HomePage.searchAppLauncher.xpath")), module);
		return this;
	}
	
	public SalesPage_test clickOnModule() {
		click(identifyElement("xpath", properties.getProperty("HomePage.clickOnSalesModule.xpath")));
		return new SalesPage_test();
	}
}
