package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtills;

public class HomePage {
 
	WebDriver driver;
	private ElementUtills elementutills;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementutills=new ElementUtills(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	public void clickOnMyAccount() {
		elementutills.clickOnElement(myAccountDropMenu, 15);
		
	}
	public LoginPage selectLoginOption() {
		elementutills.clickOnElement(loginOption, 15);
		return new LoginPage(driver);
	}
}
