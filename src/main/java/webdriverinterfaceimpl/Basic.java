package webdriverinterfaceimpl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

public class Basic implements WebDriverService{

	public static ChromeDriver driver;
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
	
	public WebElement identifyElement(String locType, String locValue) {
		switch (locType) {
		case "id": return driver.findElement(By.id(locValue)); 
		case "name": return driver.findElement(By.name(locValue));
		case "class": return driver.findElement(By.className(locValue));
		case "link" : return driver.findElement(By.linkText(locValue));
		case "xpath": return driver.findElement(By.xpath(locValue));
		default: break;
		}
		return null;
	}
	
	public void type(WebElement ele, String value) {
		ele.clear();
		ele.sendKeys(value);
	}

	public void click(WebElement ele) {
		// TODO Auto-generated method stub
		ele.click();
		
	}

	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		return ele.getText();
	}


	public boolean verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		return false;
	}

	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean verifyFullText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		boolean condition=false;
		if(getText(ele).equals(expectedText))
			condition=true;
		return condition;
	}

	@Override
	public void clickUsinJavaScriptExecutor(WebElement ele) {
		// TODO Auto-generated method stub
		driver.executeScript("arguments[0].click();", ele);
		
	}

	@Override
	public void waitForclickability(WebElement ele) {
		// TODO Auto-generated method stub
		new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.elementToBeClickable(ele));
	}

	@Override
	public void waitForPresence(By locator) {
		// TODO Auto-generated method stub
		new WebDriverWait(driver,Duration.ofSeconds(400)).until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}