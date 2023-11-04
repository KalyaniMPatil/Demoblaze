package com.demotest.stepdefinitions;

import org.apache.log4j.Logger;
import org.testng.Assert;
import com.demotest.base.Keywords;
import com.demotest.locators.Locator;
import com.demotest.pages.SignUpPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupSteps {
	private static final Logger LOG = Logger.getLogger(LoginSteps.class);
	Keywords keyword = new Keywords();
	SignUpPage signup= new SignUpPage();
	
	@Given("User on the Signup page")
	public void launchAppUrl() {
	signup.lauchURL();
	signup.clickSignupTab();
	}
	
	@When("User entered valid username and password")
	public void enter_valid_credentials() throws InterruptedException {
		signup.enterUserName(Locator.signupUsername);
		signup.enterPssword(Locator.signupPassword);
		Thread.sleep(3000);	
	}
	
	@When("User entered blank credentials for signup")
	public void signup_with_blank_credentials() {
		signup.enterUserName(Locator.signupBlankCredential);
		signup.enterPssword(Locator.signupBlankCredential);
	}
	
	@When("User entered blank password for signup")
	public void signup_with_blank_password() {
		signup.enterUserName(Locator.signupUsername);
		signup.enterPssword(Locator.signupBlankCredential);
	}
	
	@When("User entered blank username for signup")
	public void signup_with_blank_username() {
		signup.enterUserName(Locator.signupBlankCredential);
		signup.enterPssword(Locator.signupPassword);
	}
	
	@Then("User should get signup success message")
	public void checking_signup_with_valid_credentials() throws InterruptedException {
		signup.clickSignupBtn();
		Thread.sleep(3000);
		String actualMsg= TestBase.driver.switchTo().alert().getText();
		LOG.info(actualMsg);
		Assert.assertEquals(actualMsg, Locator.signupSuccessful);
	}
	
	@Then("User should get an error for signup")
	public void checking_signup_function_error() throws InterruptedException {
		signup.clickSignupBtn();
		Thread.sleep(3000);
		String actualMsg= TestBase.driver.switchTo().alert().getText();
		LOG.info(actualMsg);
		Assert.assertEquals(actualMsg, Locator.signupError);
	}
	
	@When("^User enter \"(.*)\" and Password \"(.*)\"$")
	public void signup_with_ddt(String username, String password) {
		signup.enterUserName(username);
		signup.enterPssword(password);
	}
}
