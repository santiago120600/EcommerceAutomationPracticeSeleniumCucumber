package Cucumber_framework.Cucumber_framework.cucumberoptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failed_scenarios.txt",
glue = "Cucumber_framework/Cucumber_framework/stepdefinitions",
plugin= {"pretty","html:target/cucumber.html","json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
monochrome = false)
public class FailedTestRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
