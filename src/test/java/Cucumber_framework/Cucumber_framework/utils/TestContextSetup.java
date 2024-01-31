package Cucumber_framework.Cucumber_framework.utils;

import org.openqa.selenium.WebDriver;

public class TestContextSetup {
	public WebDriver driver;
	public String[] productsLandingPage;
	public String[] productsTopDealsPage;
	public PageFactory factory;
	public TestBase base;
	public String[] productsCheckoutPage;
	
	public TestContextSetup() {
		base = new TestBase();
		factory = new PageFactory(base.webDriverManager());
	}
	
}
