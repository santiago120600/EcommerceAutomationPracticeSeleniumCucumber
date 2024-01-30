package Cucumber_framework.Cucumber_framework.cucumberoptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Cucumber_framework/Cucumber_framework/features",
glue = "Cucumber_framework/Cucumber_framework/stepdefinitions",
plugin= {"pretty","html:target/cucumber.html","json:target/cucumber.json"},
monochrome = true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
