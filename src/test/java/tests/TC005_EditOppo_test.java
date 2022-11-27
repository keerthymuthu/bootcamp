package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjectmodel.LoginPage_test;
import projectspecificmethods.CommonMethods_test;

public class TC005_EditOppo_test extends CommonMethods_test{
	
	@BeforeTest
	public void initValues() {
		testCaseName = "Opportunity Edition";
		testDescription = "Edit an Opportunity";
		nodes = "Opportunity";
		dataSheetName="EditOpportunity_TC002";
	}
	
	@Test(dataProvider="fetchData")
	public void editOpportunity(String username,String password,String module,String name,String output,String description) throws InterruptedException {
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
		.editOpportunity()
		.modifyDate()
		.clickOnStage()
		.selectStage()
		.clickOnSaveNew()
		.validateStage(output);
	}

}
