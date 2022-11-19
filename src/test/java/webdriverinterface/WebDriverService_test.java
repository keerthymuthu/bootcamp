package webdriverinterface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface WebDriverService_test {
	public WebElement identifyElement(String locType,String locValue);
	public void type(WebElement ele, String value) ;
	public void click(WebElement ele);
	public String getText(WebElement ele);
	public boolean verifyFullText(WebElement ele, String expectedText);
	public boolean verifyPartialText(WebElement ele,String expectedText);
	public boolean verifyDisplayed(WebElement ele);
	public void clickUsinJavaScriptExecutor(WebElement ele);
	public void waitForclickability(WebElement ele);
	public void waitForPresence(By locator);
	public void pressEnter(WebElement ele);
	public void typeUsingJavaScriptExecutor(WebElement ele,String text);
}
