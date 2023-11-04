package com.demotest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demotest.locators.Locator;
import com.demotest.stepdefinitions.TestBase;

public class ProductSearchPage {
	@FindBy(css="html > body > div:nth-of-type(5) > div > div:first-of-type > div > a:nth-of-type(2)")
	public WebElement Phones_Category;
	
	@FindBy(css="html > body > div:nth-of-type(5) > div > div:first-of-type > div > a:nth-of-type(3)")
	public WebElement Laptop_Category;
	
	@FindBy(css="html > body > div:nth-of-type(5) > div > div:first-of-type > div > a:nth-of-type(4)")
	public WebElement Monitors_Category;
	
	public ProductSearchPage() {
		PageFactory.initElements(TestBase.driver, this);
	} 
	
	public void lauchURL() {
		TestBase.driver.get(Locator.URL);
	}
	
	public void clickOnPhonesCategory() {
		Phones_Category.click();
	}
	
	public void clickOnLaptopsCategory() {
		Laptop_Category.click();
	}
	
	public void clickOnMonitorCategory() {
		Monitors_Category.click();
	}
	
}
