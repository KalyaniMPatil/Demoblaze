package com.demotest.stepdefinitions;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;

import com.demotest.base.Keywords;
import com.demotest.locators.Locator;
import com.demotest.pages.SignUpPage;
import com.demotest.utilities.WaitFor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupDDT {
	
	/*SignUpPage signup= new SignUpPage();
	Keywords keyword= new Keywords();
	WaitFor wait= new WaitFor();
	private static final Logger LOG = Logger.getLogger(LoginSteps.class);
	
	@Given("User on the Signup page")
	public void launchAppUrl() {
	signup.lauchURL();
	signup.clickSignupTab();
	}
	
	@When("User enter sheetname {String} and rownumber {int}")
	public void signup_with_ddt(String Sheetname, int RowNumber) throws InterruptedException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\Shree\\eclipse-workspace\\AutomationFramework\\Meteorite\\src\\main\\resources\\TestData\\signupdata.xlsx");
		XSSFWorkbook book= new XSSFWorkbook(fis);
		XSSFSheet sheet= book.getSheet("signUp");
		int rowcount= sheet.getLastRowNum();
		for(int i=1; i<=rowcount; i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			String mail=celldata.getCell(0).getStringCellValue();
			String password=celldata.getCell(1).getStringCellValue();
			keyword.clear("css", "input#sign-username");
			keyword.enterText("css", "input#sign-username", mail);
			keyword.clear("css", "input#sign-password");
			keyword.enterText("css", "input#sign-password", password);
			System.out.println(mail+"\t"+password);
			keyword.click("css", "#signInModal > div > div > div:nth-of-type(3) > button:nth-of-type(2)");
			Thread.sleep(4000);
		}
	}
	
	@Then("User should get signup success message")
	public void checking_signup_with_valid_credentials() {
		wait.elementToBePresentInList(signup.Signup_Button);
		signup.clickSignupBtn();
		Alert a= TestBase.driver.switchTo().alert();
		String actualMsg= a.getText();
		LOG.info(actualMsg);
		Assert.assertEquals(actualMsg, Locator.signupSuccessful);
		a.accept();
		signup.clickCloseBtn();
	}*/
}
