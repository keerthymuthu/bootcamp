package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjectmodel.LoginPage_test;
import projectspecificmethods.CommonMethods_test;

public class TC006_DeleteOppo_test extends CommonMethods_test{
	@BeforeTest
	public void initValues() {
		dataSheetName="DeleteOpportunity_TC003";
	}
	
	@Test(dataProvider="fetchData")
	public void deleteOpportunity(String username,String password,String module,String name,String output) throws InterruptedException {
		new LoginPage_test()
		.enterUserName(username)
		.enterPassword(password)
		.clickOnLogin()
		.clickOnAppLauncher()
		.clickOnViewAll()
		.searchAppLauncher(module)
		.clickOnModule()
		.clickOnOpportunities()
		.searchOpportunity(name)
		.selectOpportunity()
		.deleteOpportunity()
		.confirmDeleteOpportunity()
		.validateDeletion(output);
	}

}
