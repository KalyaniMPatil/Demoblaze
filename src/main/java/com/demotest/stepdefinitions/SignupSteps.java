package com.demotest.stepdefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import com.demotest.base.Keywords;
import com.demotest.locators.Locator;
import com.demotest.pages.SignUpPage;
import com.demotest.utilities.WaitFor;
import com.demotest.utilities.ExcelReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupSteps {
	private static final Logger LOG = Logger.getLogger(LoginSteps.class);
	Keywords keyword = new Keywords();
	SignUpPage signup= new SignUpPage();
	WaitFor wait= new WaitFor();
	
	@Given("User on the Signup page")
	public void launchAppUrl() {
	signup.lauchURL();
	signup.clickSignupTab();
	}
	
	@When("User entered valid username and password")
	public void enter_valid_credentials(){
		signup.enterUserName(Locator.signupUsername);
		signup.enterPssword(Locator.signupPassword);
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
		wait.elementToBePresentInList(signup.Signup_Button);
		signup.clickSignupBtn();
		wait.alertToBePresent();
		String actualMsg= TestBase.driver.switchTo().alert().getText();
		LOG.info(actualMsg);
		Assert.assertEquals(actualMsg, Locator.signupSuccessful);
	}
	
	@Then("User should get an error for signup")
	public void checking_signup_function_error(){
		wait.elementToBePresentInList(signup.Signup_Button);
		signup.clickSignupBtn();
		String actualMsg= TestBase.driver.switchTo().alert().getText();
		LOG.info(actualMsg);
		Assert.assertEquals(actualMsg, Locator.signupError);
	}
	
	@When("^User user enters valid email id (.+)$")
    public void user_enters_valid_email_id(String email) {
		signup.enterUserName(email);
		
    }

    @And("^Enters valid password (.+)$")
    public void enters_valid_password(String password) {
    	signup.enterPssword(password);
    }
	
	/*@When("User enter sheetname {string} and rownumber {int}")
	public void signup_with_ddt(String Sheetname, int RowNumber) {
		ExcelReader reader = new ExcelReader();
		String excelPath= "C:\\Users\\Shree\\eclipse-workspace\\AutomationFramework\\com.demotest\\src\\main\\resources\\TestData\\signupdata.xlsx";
		List<Map<String, String>> testdata=reader.getdata(excelPath, Sheetname);
		signup.enterUserName(testdata.get(RowNumber).get("username"));
		signup.enterPssword(testdata.get(RowNumber).get("password"));
		
		if(username!=null || password!=null)
		{
			signup.enterPssword(password);
			signup.enterUserName(username);
		}
	}*/
}
