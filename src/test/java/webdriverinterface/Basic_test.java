package webdriverinterface;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic_test implements WebDriverService_test{
	
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

	@Override
	public WebElement identifyElement(String locType, String locValue) {
		// TODO Auto-generated method stub
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

	@Override
	public void type(WebElement ele, String value) {
		// TODO Auto-generated method stub
		ele.clear();
		ele.sendKeys(value);
	}

	@Override
	public void click(WebElement ele) {
		// TODO Auto-generated method stub
		ele.click();
	}

	@Override
	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		return ele.getText();
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
	public boolean verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		boolean condition=false;
		System.out.println(ele.getText());
		if(getText(ele).contains(expectedText)) {
			condition=true;
			System.out.println(getText(ele)+" : "+condition);
		}
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
		ele.sendKeys(Keys.ENTER);
	}

	@Override
	public void typeUsingJavaScriptExecutor(WebElement ele, String text) {
		// TODO Auto-generated method stub
		driver.executeScript("arguments[0].value='"+text+"';", ele);
	}

	@Override
	public boolean verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		boolean condition=false;
		if(ele.isDisplayed())
			condition=true;
		return condition; 
	}
}