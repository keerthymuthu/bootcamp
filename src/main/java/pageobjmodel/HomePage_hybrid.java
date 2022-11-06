package pageobjmodel;

import projectspecmethods.CommonMethods;

public class HomePage_hybrid extends CommonMethods{
	
	public HomePage_hybrid clickOnAppLauncher() {
		click(identifyElement("xpath", properties.getProperty("HomePage.appLauncher.xpath")));
		return this;
	}
	
	public HomePage_hybrid clickOnViewAll() {
		waitForclickability(identifyElement("xpath", properties.getProperty("HomePage.viewall.xpath")));
		click(identifyElement("xpath", properties.getProperty("HomePage.viewall.xpath")));
		return this;
	}
	
	public HomePage_hybrid searchAppLauncher(String module) {
		waitForclickability(identifyElement("xpath", properties.getProperty("HomePage.searchAppLauncher.xpath")));
		type(identifyElement("xpath", properties.getProperty("HomePage.searchAppLauncher.xpath")), module);
		return this;
	}
	
	public SalesPage_hybrid clickOnModule() {
		click(identifyElement("xpath", properties.getProperty("HomePage.clickOnSalesModule.xpath")));
		return new SalesPage_hybrid();
	}
}
