package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtills {
	WebDriver driver;
	
	public ElementUtills(WebDriver driver) {
		this.driver=driver;
	}
 
	public void clickOnElement(WebElement element, long durationInSeconds) {
		WebElement webelement = waitForElement(element,durationInSeconds);
		webelement.click();
	}
	
	public void typeTextIntoElement(WebElement element,String typetext, long durationInSeconds) {
		
		WebElement webelement = waitForElement(element,durationInSeconds);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(typetext);
	}
	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		WebElement webelement = null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		 webelement=wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webelement;
		
	}
}
