package Cucumber_framework.Cucumber_framework.cucumberoptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Cucumber_framework/Cucumber_framework/features",
glue = "Cucumber_framework/Cucumber_framework/stepdefinitions",
plugin= {"pretty","html:target/cucumber.html","json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
tags="@Checkout or @SearchProducts",
monochrome = false,
dryRun = false)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
