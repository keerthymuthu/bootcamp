package pageobjectmodel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;

import projectspecificmethods.CommonMethods_test;

public class OpportunitiesPage_test extends CommonMethods_test{
	
	public OpportunitiesPage_test createNewOppo() {
		click(identifyElement("xpath", properties.getProperty("OpportunitiesPage.clickOnNew.xpath")));
		return this;
	}
	
	public OpportunitiesPage_test enterName(String name) {
		type(identifyElement("xpath", properties.getProperty("OpportunitiesPage.Name.xpath")),name);
		return this;
	}
	
	public OpportunitiesPage_test clickOnNewDropDown() {
		click(identifyElement("xpath", properties.getProperty("OpportunitiesPage.dropdown.xpath")));
		return this;
	}
	
	public OpportunitiesPage_test selectNewDropDown() {
		click(identifyElement("xpath", properties.getProperty("OpportunitiesPage.selectdropdown.xpath")));
		return this;
	}
	
	public OpportunitiesPage_test clickOnCalendarIcon() {
		click(identifyElement("xpath", properties.getProperty("OpportunitiesPage.clickOnCalendar.xpath")));
		return this;
	}
	
	public OpportunitiesPage_test selectTodayOnCalendar() {
		click(identifyElement("xpath", properties.getProperty("OpportunitiesPage.selectTodayOnCalendar.xpath")));
		return this;
	}
	
	public OpportunitiesPage_test clickOnSaveNew() {
		clickUsinJavaScriptExecutor(identifyElement("xpath", properties.getProperty("OpportunitiesPage.Save.xpath")));
		return this;
	}
	
	public OpportunitiesPage_test validateToastMessage(String output) {
		waitForclickability(identifyElement("xpath", properties.getProperty("AccountsPage.toast.xpath")));
		System.out.println(getText(identifyElement("xpath", properties.getProperty("AccountsPage.toast.xpath"))));
		assert true==verifyFullText(identifyElement("xpath", properties.getProperty("AccountsPage.toast.xpath")),output);
		return this;
	}
	
	public OpportunitiesPage_test validateFinalName(String name) {
		waitForPresence(By.xpath(properties.getProperty("OpportunitiesPage.finalName.xpath")));
		System.out.println(getText(identifyElement("xpath", properties.getProperty("OpportunitiesPage.finalName.xpath"))));
		assert true==verifyFullText(identifyElement("xpath", properties.getProperty("OpportunitiesPage.finalName.xpath")), name);
		return this;
	}
	
	public OpportunitiesPage_test searchOpportunity(String name) {
		waitForclickability(identifyElement("xpath", properties.getProperty("OpportunitiesPage.searchbox.xpath")));
		type(identifyElement("xpath", properties.getProperty("OpportunitiesPage.searchbox.xpath")),name);
		pressEnter(identifyElement("xpath", properties.getProperty("OpportunitiesPage.searchbox.xpath")));
		return this;
	}
	
	public OpportunitiesPage_test selectOpportunity() throws InterruptedException {
		Thread.sleep(5000);
		//click(identifyElement("xpath", properties.getProperty("OpportunitiesPage.Refresh.xpath")));
		//waitForclickability(identifyElement("xpath", properties.getProperty("OpportunitiesPage.searchresults.xpath")));
		click(identifyElement("xpath", properties.getProperty("OpportunitiesPage.searchresults.xpath")));
		return this;
	}
	
	public OpportunitiesPage_test editOpportunity() {
		//waitForclickability(identifyElement("xpath", properties.getProperty("OpportunitiesPage.searchresults.xpath")));
		click(identifyElement("xpath", properties.getProperty("OpportunitiesPage.Edit.xpath")));
		return this;
	}
	
	public OpportunitiesPage_test modifyDate() {
		Calendar calendar=new GregorianCalendar();
		calendar.add(Calendar.DATE, 1);
		//click(identifyElement("xpath", properties.getProperty("OpportunitiesPage.clickOnCalendar.xpath")));
		type(identifyElement("xpath", properties.getProperty("OpportunitiesPage.clickOnCalendar.xpath")),new SimpleDateFormat("MM/dd/yyy").format(calendar.getTime()));
		return this;
	}
	
	public OpportunitiesPage_test clickOnStage() throws InterruptedException {
		clickUsinJavaScriptExecutor(identifyElement("xpath", properties.getProperty("OpportunitiesPage.Stage.xpath")));
		//Thread.sleep(3000);
		//click(identifyElement("xpath", properties.getProperty("OpportunitiesPage.Stagevalue.xpath")));
		return this;
	}
	
	public OpportunitiesPage_test selectStage() {
		click(identifyElement("xpath", properties.getProperty("OpportunitiesPage.Stagevalue.xpath")));
		return this;
	}
	
	public OpportunitiesPage_test typeDescription(String description) {
		type(identifyElement("xpath", properties.getProperty("OpportunitiesPage.Stagevalue.xpath")),description);
		return this;
	}
	
	public OpportunitiesPage_test validateStage(String output) throws InterruptedException {
		//waitForPresence(By.xpath(properties.getProperty("OpportunitiesPage.validateStage.xpath")));
		Thread.sleep(4000);
		System.out.println(getText(identifyElement("xpath", properties.getProperty("OpportunitiesPage.validateStage.xpath"))));
		assert true==verifyFullText(identifyElement("xpath", properties.getProperty("OpportunitiesPage.validateStage.xpath")), output);
		return this;
	}
	
	public OpportunitiesPage_test deleteOpportunity() {
		click(identifyElement("xpath", properties.getProperty("OpportunitiesPage.Delete.xpath")));
		return this;
	}
	
	public OpportunitiesPage_test confirmDeleteOpportunity() {
		click(identifyElement("xpath", properties.getProperty("OpportunitiesPage.confirmDelete.xpath")));
		return this;
	}
	
	public OpportunitiesPage_test validateDeletion(String output) throws InterruptedException {
		Thread.sleep(4000);
		System.out.println(getText(identifyElement("xpath", properties.getProperty("OpportunitiesPage.validateDeletion.xpath"))));
		assert true==verifyFullText(identifyElement("xpath", properties.getProperty("OpportunitiesPage.validateDeletion.xpath")), output);
		return this;
	}
}