package com.demotest.stepdefinitions;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.demotest.base.Keywords;
import com.demotest.locators.Locator;
import com.demotest.pages.ContactPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactSteps {
	private static final Logger LOG = Logger.getLogger(ContactSteps.class);
	Keywords keyword = new Keywords();
	ContactPage contact= new ContactPage();
	
	@Given("User on the Contact page")
	public void launchAppUrl() {
		contact.lauchURL();
		contact.clickContactTab();
	}
	
	@When("User entered valid Email Name and Message")
	public void enter_valid_credentials_for_contact() {
		contact.enterContactEmail(Locator.contactEmail);
		contact.enterContactName(Locator.contactName);
		contact.enterMessage(Locator.contactMsg);
		TestBase.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@When("Email Name and Message credentials are Blank")
	public void enter_blank_credentials_for_contact() {
		contact.enterContactEmail(Locator.contactBlankCredential);
		contact.enterContactName(Locator.contactBlankCredential);
		contact.enterMessage(Locator.contactBlankCredential);
		TestBase.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@When("User entered contact name message and keep email field blank")
	public void enter_blank_email_credentials_for_contact() {
		contact.enterContactEmail(Locator.contactBlankCredential);
		contact.enterContactName(Locator.contactName);
		contact.enterMessage(Locator.contactMsg);
		TestBase.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@When("User entered contact email message and keep name field blank")
	public void enter_blank_name_credentials_for_contact() {
		contact.enterContactEmail(Locator.contactEmail);
		contact.enterContactName(Locator.contactBlankCredential);
		contact.enterMessage(Locator.contactMsg);
		TestBase.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@When("User entered contact email name and keep message field blank")
	public void enter_blank_msg_credentials_for_contact() {
		contact.enterContactEmail(Locator.contactEmail);
		contact.enterContactName(Locator.contactName);
		contact.enterMessage(Locator.contactBlankCredential);
		TestBase.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Then("User should get thank you message for contacting")
	public void checking_contact_with_valid_credentials(){
		contact.clickSendMsgBtn();
		TestBase.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String actualMsg= TestBase.driver.switchTo().alert().getText();
		LOG.info(actualMsg);
		Assert.assertEquals(actualMsg, Locator.contactSuccessMsg);
	}
	
	@Then("User should get Error Message for blank details")
	public void checking_contact_with_blank_credentials(){
		contact.clickSendMsgBtn();
		TestBase.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String actualMsg= TestBase.driver.switchTo().alert().getText();
		LOG.info(actualMsg);
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actualMsg, Locator.contactErrorMsg);
	}
	
	
}
