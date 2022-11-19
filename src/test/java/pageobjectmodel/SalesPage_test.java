package pageobjectmodel;

import projectspecificmethods.CommonMethods_test;

public class SalesPage_test extends CommonMethods_test{
	public AccountsPage_test clickOnAccount() {
		clickUsinJavaScriptExecutor(identifyElement("xpath", properties.getProperty("AccountsPage.clickOnAccount.xpath")));
		return new AccountsPage_test();
	}
	
	public OpportunitiesPage_test clickOnOpportunities() {
		clickUsinJavaScriptExecutor(identifyElement("xpath", properties.getProperty("OpportunitiesPage.clickOnOpportunity.xpath")));
		return new OpportunitiesPage_test();
	}
	
	public SalesPage_test clickOnMore() throws InterruptedException {
		//waitForclickability(identifyElement("xpath", properties.getProperty("SalesPage.More.xpath")));
		Thread.sleep(3000);
		clickUsinJavaScriptExecutor(identifyElement("xpath", properties.getProperty("SalesPage.More.xpath")));
		return this;
	}
	
	public SalesPage_test clickOnCase() {
		clickUsinJavaScriptExecutor(identifyElement("xpath", properties.getProperty("SalesPage.Case.xpath")));
		return this;
	}
	
	public CasePage_test clickOnCaseDropDown() {
		waitForclickability(identifyElement("xpath", properties.getProperty("SalesPage.CaseDropDown.xpath")));
		click(identifyElement("xpath", properties.getProperty("SalesPage.CaseDropDown.xpath")));
		return new CasePage_test();
	}
}
