package webdriverinterface;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic_test extends Reporter implements WebDriverService_test {
	
	public ChromeDriver driver;
	public String dataSheetName;
	
	public void init(String url) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
	}

	@Override
	public WebElement identifyElement(String locType, String locValue) {
		// TODO Auto-generated method stub
		try {
		switch (locType) {
		case "id": return driver.findElement(By.id(locValue)); 
		case "name": return driver.findElement(By.name(locValue));
		case "class": return driver.findElement(By.className(locValue));
		case "link" : return driver.findElement(By.linkText(locValue));
		case "xpath": return driver.findElement(By.xpath(locValue));
		default: break;
		}
		}
		catch(NoSuchElementException e) {
			captureStep("Element not "+locValue+" found","FAIL");
		}
		catch(StaleElementReferenceException e) {
			captureStep("Element not attached to the DOM"+locType, "FAIL");
		}
		catch(InvalidSelectorException e) {
			captureStep("Invalid Selector "+locType, "FAIL");
		}
		catch(ElementClickInterceptedException e) {
			captureStep("Element Click intercepted "+locType, "FAIL");
		}
		return null;
	}

	@Override
	public void type(WebElement ele, String value) {
		// TODO Auto-generated method stub
		try {
		ele.clear();
		ele.sendKeys(value);
		captureStep(value+" entered successfully", "PASS");
		}
		catch(InvalidElementStateException e) {
			captureStep(value+" could not be entered in the field","FAIL");
			e.printStackTrace();
		}
	}

	@Override
	public void click(WebElement ele) {
		// TODO Auto-generated method stub
		try {
		ele.click();
		captureStep("Element was clicked", "PASS");
		}
		catch(InvalidElementStateException e) {
			captureStep(ele.getText()+" could not be entered in the field","FAIL");
			e.printStackTrace();
		}
		catch(WebDriverException e) {
			captureStep("Unknown exception occured", "FAIL");
		}
	}

	@Override
	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		String text="";
		try {
			text=ele.getText();
			captureStep(text+" was captured.","PASS");
			}
		catch(WebDriverException e) {
			captureStep("Unknown exception occured", "FAIL");
		}
		return text;
	}

	@Override
	public boolean verifyFullText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		boolean condition=false;
		try {
		if(getText(ele).equals(expectedText)) {
			condition=true;
			captureStep("The "+getText(ele)+" matches with the "+expectedText, "PASS");
		}
		else
			captureStep("The "+getText(ele)+" does not match with the "+expectedText, "FAIL");
		}
		catch(WebDriverException e) {
			captureStep("Unknown exception", "FAIL");
		}
		return condition;
	}

	@Override
	public boolean verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		boolean condition=false;
		try {
		System.out.println(getText(ele));
		if(getText(ele).contains(expectedText)) {
			condition=true;
			System.out.println(getText(ele)+" : "+condition);
			captureStep(expectedText+" is a part of "+getText(ele),"PASS");
		}
		else
			captureStep(expectedText+" not a part of "+getText(ele),"FAIL");
		}
		catch(WebDriverException e) {
			captureStep("Unknown exception occured","FAIL");
		}
		return condition;
	}

	@Override
	public void clickUsinJavaScriptExecutor(WebElement ele) {
		// TODO Auto-generated method stub
		try {
		driver.executeScript("arguments[0].click();", ele);
		captureStep(ele.getText()+" clicked","PASS");
		}
		catch(InvalidElementStateException e) {
			captureStep(ele.getText()+" could not be entered in the field","FAIL");
			e.printStackTrace();
		}
		catch(WebDriverException e) {
			captureStep("Unknown exception occured", "FAIL");
		}
		
	}

	@Override
	public void waitForclickability(WebElement ele) {
		// TODO Auto-generated method stub
		new WebDriverWait(driver, Duration.ofSeconds(4000)).until(ExpectedConditions.elementToBeClickable(ele));
	}

	@Override
	public void waitForPresence(By locator) {
		// TODO Auto-generated method stub
		new WebDriverWait(driver,Duration.ofSeconds(4000)).until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	@Override
	public void pressEnter(WebElement ele) {
		// TODO Auto-generated method stub
		try {
		ele.sendKeys(Keys.ENTER);
		captureStep("Enter key pressed", "PASS");
		}
		catch(WebDriverException e) {
			captureStep("Unknown error occured","FAIL");
		}
	}

	@Override
	public void typeUsingJavaScriptExecutor(WebElement ele, String text) {
		// TODO Auto-generated method stub
		try {
		driver.executeScript("arguments[0].value='"+text+"';", ele);
		captureStep(text+" entered successfully", "PASS");
	}
	catch(InvalidElementStateException e) {
		captureStep(text+" could not be entered in the field","FAIL");
		e.printStackTrace();
	}
	}

	@Override
	public boolean verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		boolean condition=false;
		try {
		if(ele.isDisplayed()) {
			condition=true;
			captureStep("Element is displayed","PASS");
		}
		}
		catch(WebDriverException e) {
			captureStep("Unknown exception","FAIL");
		}
		return condition; 
	}

	@Override
	public double takeSnap() {
		// TODO Auto-generated method stub
		double fileName=Math.random();
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("./reports/images/"+fileName+".png"));
		} catch (WebDriverException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileName;
	}
	
	
}