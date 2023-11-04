package com.demotest.pages;

import org.openqa.selenium.WebElement;
import com.demotest.locators.Locator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.demotest.stepdefinitions.TestBase;

public class LoginPage {
	
	@FindBy(css="a#login2")
	public WebElement Login_tab;
	
	@FindBy(css="input#loginusername")
	public WebElement Login_Username;
	
	@FindBy(css="input#loginpassword")
	public WebElement Login_Password;
	
	@FindBy(css="#logInModal > div > div > div:nth-of-type(3) > button:nth-of-type(2)")
	public WebElement Login_Button;
	
	@FindBy(css="#logInModal > div > div > div:nth-of-type(3) > button:first-of-type")
	public WebElement Login_Close;
	
	@FindBy(css="a#logout2")
	public WebElement Logout_tab;
	
	@FindBy(css="a#nameofuser")
	public WebElement User_name;
	
	public LoginPage() {
		PageFactory.initElements(TestBase.driver, this);
	} 
		
	public void lauchURL() {
		TestBase.driver.get(Locator.URL);

	}
	public void clickLogInTab() {
		Login_tab.click();
	}
	
	public void enterUserName(String username) {
		Login_Username.sendKeys(username);
	}
	
	public void enterPssword(String passw) {
		Login_Password.sendKeys(passw);
	}
	
	public void clickLogInBtn() {
		Login_Button.click();
	}
	
	public void clickCloseBtn() {
		Login_Close.click();
	}
	
	public void checkLogoutTab()	{
		Logout_tab.click();
	}
	
}
