package utility;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", 
glue = "com.demotest.stepdefinitions")
public class TestRunner extends AbstractTestNGCucumberTests{
	
}
