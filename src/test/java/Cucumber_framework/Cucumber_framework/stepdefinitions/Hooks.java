package Cucumber_framework.Cucumber_framework.stepdefinitions;

import Cucumber_framework.Cucumber_framework.utils.TestContextSetup;
import io.cucumber.java.After;

public class Hooks {
	
	TestContextSetup testContextSetup;
	 
	
	public Hooks(TestContextSetup testContextSetup) {
		super();
		this.testContextSetup = testContextSetup;
	}


	@After
	public void tearDown() {
		testContextSetup.base.driver.quit();
	}
}
