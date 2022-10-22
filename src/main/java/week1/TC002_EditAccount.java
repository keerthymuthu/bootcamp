package week1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageomodel.LoginPage;
public class TC002_EditAccount extends BaseClass{
	
	@BeforeTest
	public void initValues() {
		dataSheetName="EditAccount_TC002";
	}
	
	@Test(dataProvider="fetchData")
	public void editAccount(String username,String password,String module,String name,String phone,String address) throws InterruptedException {
		new LoginPage(driver).enterUserName(username).enterPassword(password).clickLogin()
		.clickAppLauncher().clickOnViewAll().searchAppLauncher(module).clickOnModule().clickOnAccounts().searchAccount(name)
		.selectFromSearchResult().clickOnEdit().typePhoneNum(phone).clickOnType().selectType().clickOnIndustry().selectIndustryType()
		.typeBillingAddress(address).typeShippingAddress(address).clickOnCustomerPriority().selectCustomerPriority().clickOnSLA().selectSLASilver()
		.clickOnActive().clickOnNoActive().clickOnUpsellOppo().selectNoUpsellOppo().clickSave().validatePhoneNum(phone);
	}
	
}