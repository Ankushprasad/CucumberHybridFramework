package StepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtill;

public class Login {
	
    WebDriver driver;
    private LoginPage loginpage;
    private AccountPage accountpage;
	
	@Given("User has navigated to Login page")
	public void User_has_navigated_to_Login_page() {
		driver=DriverFactory.getDriver();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
		loginpage=homepage.selectLoginOption();
		
		
	}
	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailtext) {
	 
	   loginpage.enterEmailAddress(emailtext);
	}

	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String passText) {
	    loginpage.enterPassword(passText);
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		accountpage=loginpage.clickOnLoginButton();
	   
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
	    
		Assert.assertTrue(accountpage.displayStatusOfEditYourAccountInformationOption());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		
		loginpage.enterEmailAddress(CommonUtill.getEmailWithTimeStamp());
		
	}

	@And("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidpasstxtbox) {
		loginpage.enterPassword(invalidpasstxtbox); 
		
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
	    Assert.assertTrue(loginpage.getWarningMessage().contains("No match for E-Mail Address and/or Password."));
	   
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		
		loginpage.enterEmailAddress("");
	}

	@And("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		loginpage.enterPassword("");
	}


}
