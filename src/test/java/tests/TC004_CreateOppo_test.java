package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjectmodel.LoginPage_test;
import projectspecificmethods.CommonMethods_test;

public class TC004_CreateOppo_test extends CommonMethods_test{
	@BeforeTest
	public void initValues() {
		testCaseName = "Opportunity Creation";
		testDescription = "Create a new Opportunity";
		nodes = "Opportunity";
		dataSheetName="CreateOpportunity_TC001";
	}
	
	@Test(dataProvider="fetchData")
	public void createOppo(String username,String password,String module,String name,String output) {
		new LoginPage_test(driver,test)
		.enterUserName(username)
		.enterPassword(password)
		.clickOnLogin()
		.clickOnAppLauncher()
		.clickOnViewAll()
		.searchAppLauncher(module)
		.clickOnModule()
		.clickOnOpportunities()
		.createNewOppo()
		.enterName(name)
		.clickOnNewDropDown()
		.selectNewDropDown()
		.clickOnCalendarIcon()
		.selectTodayOnCalendar()
		.clickOnSaveNew()
		.validateToastMessage(output)
		.validateFinalName(name);
	}
}