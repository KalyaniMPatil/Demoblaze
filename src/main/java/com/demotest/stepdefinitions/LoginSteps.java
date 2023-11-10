package com.demotest.stepdefinitions;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import com.demotest.base.Keywords;
import com.demotest.locators.Locator;
import com.demotest.pages.LoginPage;
import com.demotest.utilities.WaitFor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {
	private static final Logger LOG = Logger.getLogger(LoginSteps.class);
	Keywords keyword = new Keywords();
	LoginPage login= new LoginPage();
	WaitFor wait= new WaitFor();
	@Given("User on the Login page")
		public void launchAppUrl() {
		login.lauchURL();
		login.clickLogInTab();
	}
	
	@When("User entered username and password")
	public void login_with_valid_credentials() {
		login.enterUserName(Locator.loginUsername);
		login.enterPssword(Locator.loginPassword);
	}
	
	@When("User entered blank credentials for login")
	public void login_with_blank_credentials() {
		login.enterUserName(Locator.loginBlankCredential);
		login.enterPssword(Locator.loginBlankCredential);
	}
	
	@When("User entered blank username for login")
	public void login_with_blank_username() {
		login.enterUserName(Locator.loginBlankCredential);
		login.enterPssword(Locator.loginPassword);
	}
	
	@When("User entered blank password for login")
	public void login_with_blank_password() {
		login.enterUserName(Locator.loginUsername);
		login.enterPssword(Locator.loginBlankCredential);
	}
	
	@Then("User should logged in successfully")
	public void checking_login_function() {
		wait.elementToBePresentInList(login.Login_Button);
		login.clickLogInBtn();
		Assert.assertTrue(login.Logout_tab.isEnabled());	
	}
	
	@Then("User should get an error for login")
	public void checking_login_function_error() {
		wait.elementToBePresentInList(login.Login_Button);
		login.clickLogInBtn();
		Alert a= TestBase.driver.switchTo().alert();
		String actualMsg=a.getText();
		LOG.info(actualMsg);
		Assert.assertEquals(actualMsg, Locator.logInBlankCredentials);
	}
	
	/*@Then("User should logged out successfully")
	public void checking_logout_function(){
		login.checkLogoutTab();
		TestBase.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String logoutURL=TestBase.driver.getCurrentUrl();
		LOG.info(logoutURL);
		Assert.assertEquals(logoutURL, login.logoutURL());
	}*/
}
