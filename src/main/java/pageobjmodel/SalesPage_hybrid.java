package pageobjmodel;

import projectspecmethods.CommonMethods;

public class SalesPage_hybrid extends CommonMethods{
	
	public AccountsPage clickOnAccount() {
		clickUsinJavaScriptExecutor(identifyElement("xpath", properties.getProperty("AccountsPage.clickOnAccount.xpath")));
		return new AccountsPage();
	}
	
}
