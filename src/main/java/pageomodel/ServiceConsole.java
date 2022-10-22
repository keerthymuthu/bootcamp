package pageomodel;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import week1.BaseClass;

public class ServiceConsole extends BaseClass{
	
	public ServiceConsole(RemoteWebDriver driver,Properties properties) {
		this.driver=driver;
		this.properties=properties;
	}
	
	public ServiceConsole clickOnNavigationDropDown() throws InterruptedException {
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']//lightning-primitive-icon")).click();
		Thread.sleep(5000);
		return this;
	}
	
	public ServiceConsole clickOnFiles() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Files']")).click();
		Thread.sleep(5000);
		return this;
	}
	
	public ServiceConsole clickOnDropDown() throws InterruptedException {
		//driver.findElement(By.xpath("//tbody//tr[1]//td[4]//a")).click();
		driver.findElement(By.xpath("//span[@title='TestFile_Muthu']//ancestor::tr//following-sibling::td//a[@role='button']")).click();
		Thread.sleep(5000);
		return this;
	}
	
	public ServiceConsole clickOnPublicLink() {
		driver.findElement(By.xpath("//a[@title='Public Link']")).click();
		return this;
	}
	
	public ServiceConsole verifyLinkDisabled() throws InterruptedException {
		//WebElement ele_newlink=driver.findElement(By.xpath("//input[starts-with(@id,'input')]//parent::div"));
		WebElement ele_newlink=driver.findElement(By.xpath("//label[text()='Public link URL']//parent::lightning-input"));
		System.out.println("Attribute: "+ele_newlink.getAttribute("readonly"));
		assertEquals(ele_newlink.getAttribute("readonly"),"true");
		return this;
	}
	
	public ServiceConsole closeModalWindow() throws InterruptedException {
		driver.findElement(By.xpath("//button[@title='Close this window']//lightning-primitive-icon")).click();
		Thread.sleep(5000);
		return this;
	}
	
	public ServiceConsole clickOnDownload() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='Download']")).click();
		Thread.sleep(5000);
		return this;
	}
	
	public ServiceConsole moveFile() throws IOException, InterruptedException {
		File src=new File("C:\\Users\\ADMIN\\Downloads\\TestFile_Muthu.txt");
		File dest=new File("./data/TestFile_Muthu.txt");
		FileUtils.copyFile(src, dest);
		Thread.sleep(5000);
		return this;
	}
	
	public ServiceConsole clickOnShare() {
		driver.findElement(By.xpath("//a[@title='Share']")).click();
		return this;
	}
	
	public ServiceConsole clickOnShareWithInputBox() {
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Search People')]")).click();
		return this;
	}
	
	public ServiceConsole selectUserDsouza() {
		driver.findElement(By.xpath("//a[@role='option']")).click();
		return this;
	}
	
	public ServiceConsole validateErrorMsg(String message) {
		String msg=driver.findElement(By.xpath("//li[@class='form-element__help']")).getText();
		System.out.println(msg);
		assert msg.equals(message);
		return this;
	}
	
	public ServiceConsole clickOnuploadFiles() throws InterruptedException, AWTException {
		WebElement upFiles=driver.findElement(By.xpath("//a[@title='Upload Files']"));
		upFiles.click();
		Thread.sleep(5000);
		//upFiles.sendKeys("C:\\Users\\ADMIN\\Downloads\\Login.txt");
		//driver.findElement(By.xpath("//a[@title='Upload Files']")).sendKeys("C:\\Users\\ADMIN\\Downloads\\Login.txt");
		StringSelection ss=new StringSelection("C:\\Users\\ADMIN\\Downloads\\uploadSample.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(5000);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		return this;
	}
	
	public ServiceConsole clickOnViewFileDetails() throws InterruptedException {
		//driver.findElement(By.xpath("//a[@title='View File Details']")).click();
		Thread.sleep(5000);
		WebElement ele=driver.findElement(By.xpath("(//a[@title='View File Details'])[2]"));
		driver.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		return this;
	}
	
	public ServiceConsole clickOnDeleteFile() throws InterruptedException {
		WebElement delete=driver.findElement(By.xpath("(//a[@title='Delete'])[2]"));
		driver.executeScript("arguments[0].click();", delete);
		Thread.sleep(5000);
		return this;
	}
	
	public ServiceConsole confirmDelete() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		Thread.sleep(3000);
		return this;
	}
	
	public ServiceConsole clickOnUploadedFileDropDown() throws InterruptedException {
		//driver.findElement(By.xpath("//tbody//tr[1]//td[4]//a")).click();
		Thread.sleep(5000);
		WebElement ele=driver.findElement(By.xpath("//span[@title='uploadSample']//ancestor::tr//following-sibling::td//a[@role='button']"));
		//driver.findElement(By.xpath("//span[@title='uploadSample']//ancestor::tr//following-sibling::td//a[@role='button']")).click();
		driver.executeScript("arguments[0].click();", ele);
		Thread.sleep(5000);
		return this;
	}
	
	public ServiceConsole verifyFileName(String filename) {
		System.out.println("File Name: "+driver.findElement(By.xpath("//div[text()='File']//following-sibling::div//span")).getText());
		assertEquals(driver.findElement(By.xpath("//div[text()='File']//following-sibling::div//span")).getText(),filename);
		return this;
	}
	
	public ServiceConsole veriyExtension(String ext) {
		System.out.println("Extension: "+driver.findElement(By.xpath("//span[text()='File Extension']//following-sibling::div//span")).getText());
		assertEquals(driver.findElement(By.xpath("//span[text()='File Extension']//following-sibling::div//span")).getText(),ext);
		return this;
	}
	
	public ServiceConsole closeFileWindow() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(@title,'Close uploadSample')]//lightning-primitive-icon")).click();
		Thread.sleep(2000);
		return this;
	}
	
	public ServiceConsole clickOnFileWindowTab() {
		driver.findElement(By.xpath("//a[@title='Files']")).click();
		return this;
	}
	
	public ServiceConsole validateToastMessage() {
		String toastMessage=driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println(toastMessage);
		return this;
	}
}
