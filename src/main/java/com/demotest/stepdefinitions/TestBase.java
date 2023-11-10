package com.demotest.stepdefinitions;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.demotest.config.Configuration;
import com.demotest.utilities.InvalidBrowserNameError;
import com.demotest.stepdefinitions.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class TestBase {
	private static final Logger LOG = Logger.getLogger(TestBase.class);
	public static RemoteWebDriver driver;
	public Configuration config;

	public static RemoteWebDriver getDriver() {
		return driver;
	}

	@Before
	public void setUp() throws MalformedURLException {

		config = new Configuration();
		if (config.getExecutionMode().equalsIgnoreCase("local")) {
			LOG.info("Executing suite on local");
			if(config.getBrowserName().equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			}else if(config.getBrowserName().equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			}else if(config.getBrowserName().equalsIgnoreCase("ie")) {
				driver = new InternetExplorerDriver();
			}else {
				throw new InvalidBrowserNameError(config.getBrowserName());
			}
		} else {
			LOG.info("Executing suite on grid");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			//firefoxOptions.setCapability("browserVersion", "115");
			//firefoxOptions.setCapability("platformName", "Windows");
			firefoxOptions.setCapability("se:name", "My simple test");
			firefoxOptions.setCapability("se:sampleMetadata", "Sample metadata value");

			driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444"), firefoxOptions);
		}
		
	}

	@After
	public void tearDown(Scenario scenario) throws Exception {
		boolean failed= scenario.isFailed();
		if(failed)
		{
			Date currentdate= new Date();
			String screenshotfilename= currentdate.toString().replace(" ", "-").replace(":", "-");
			File screenshotfile=((TakesScreenshot)TestBase.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotfile, new File("C:\\Users\\Shree\\eclipse-workspace\\AutomationFramework\\com.demotest\\src\\test\\resources\\Screenshots\\"+ screenshotfilename +".png"));
			LOG.info("screenshot captured");
		}
		driver.quit();
		LOG.info("All Browsers are closed");
	}
}
