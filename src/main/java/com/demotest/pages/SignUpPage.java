package com.demotest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demotest.locators.Locator;
import com.demotest.stepdefinitions.TestBase;

public class SignUpPage {
	
	@FindBy(css="a#signin2")
	public WebElement Signup_tab;
	
	@FindBy(css="input#sign-username")
	public WebElement Signup_Username;
	
	@FindBy(css="input#sign-password")
	public WebElement Signup_Password;
	
	@FindBy(css="#signInModal > div > div > div:nth-of-type(3) > button:nth-of-type(2)")
	public WebElement Signup_Button;
	
	@FindBy(css="#signInModal > div > div > div:nth-of-type(3) > button:first-of-type")
	public WebElement Signup_Close;
	
	public SignUpPage() {
		PageFactory.initElements(TestBase.driver, this);
	} 
	
	public void lauchURL() {
		TestBase.driver.get(Locator.URL);

	}
	public void clickSignupTab() {
		Signup_tab.click();
	}
	
	public void enterUserName(String username) {
		Signup_Username.sendKeys(username);
	}
	
	public void enterPssword(String passw) {
		Signup_Password.sendKeys(passw);
	}
	
	public void clickSignupBtn() {
		Signup_Button.click();
	}
	
	public void clickCloseBtn() {
		Signup_Close.click();
	}
	
}
