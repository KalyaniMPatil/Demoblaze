package com.demotest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demotest.locators.Locator;
import com.demotest.stepdefinitions.TestBase;

public class ContactPage {
	@FindBy(css="#navbarExample > ul > li:nth-of-type(2) > a")
	public WebElement Contact_tab;
	
	@FindBy(css="input#recipient-email")
	public WebElement Contact_email;
	
	@FindBy(css="input#recipient-name")
	public WebElement Contact_name;
	
	@FindBy(css="textarea#message-text")
	public WebElement Contact_msg;
	
	@FindBy(css="#exampleModal > div > div > div:nth-of-type(3) > button:nth-of-type(2)")
	public WebElement Send_msg_Btn;
	
	@FindBy(css="#exampleModal > div > div > div:nth-of-type(3) > button:first-of-type")
	public WebElement Contact_close_Btn;
	
	public ContactPage() {
		PageFactory.initElements(TestBase.driver, this);
	} 
	
	public void lauchURL() {
		TestBase.driver.get(Locator.URL);
	}
	
	public void clickContactTab() {
		Contact_tab.click();
	}
	
	public void enterContactEmail(String email) {
		Contact_email.sendKeys(email);
	}
	
	public void enterContactName(String name) {
		Contact_name.sendKeys(name);
	}
	
	public void enterMessage(String msg) {
		Contact_msg.sendKeys(msg);
	}
	
	public void clickSendMsgBtn() {
		Send_msg_Btn.click();
	}
	
	public void clickCloseBtn() {
		Contact_close_Btn.click();
	}
}
