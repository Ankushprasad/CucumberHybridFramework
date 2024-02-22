package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtills;

public class LoginPage {

	WebDriver driver;
	private ElementUtills elementutills;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementutills=new ElementUtills(driver);
	}
	 @FindBy(id="input-email")
	 private WebElement emailField;
	 
	 @FindBy(id="input-password")
	 private WebElement passwordField;
	 
	 @FindBy(xpath="//input[@value='Login']")
	 private WebElement loginButton;
	 
	 @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	 private WebElement warningMessage;
	 
	 public void enterEmailAddress(String emailText) {
		 elementutills.typeTextIntoElement(emailField, emailText, 15);
		 
	 }
	 public void enterPassword(String passText) {
		 elementutills.typeTextIntoElement(passwordField, passText, 15);
		 
	 }
	 public AccountPage clickOnLoginButton() {
		 elementutills.clickOnElement(loginButton, 15);
		 return new AccountPage(driver);
	 }
	 public String getWarningMessage() {
		 return warningMessage.getText();
	 }
}
