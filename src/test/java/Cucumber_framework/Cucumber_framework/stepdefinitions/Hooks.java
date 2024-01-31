package Cucumber_framework.Cucumber_framework.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Cucumber_framework.Cucumber_framework.utils.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {

	TestContextSetup testContextSetup;

	public Hooks(TestContextSetup testContextSetup) {
		super();
		this.testContextSetup = testContextSetup;
	}

	@AfterStep
	public void takeScraenshotOnFailure(Scenario scenario) {
		WebDriver driver = testContextSetup.base.webDriverManager();
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "screenshot");
		}
	}

	@After
	public void tearDown() {
		testContextSetup.base.driver.quit();
	}
}
