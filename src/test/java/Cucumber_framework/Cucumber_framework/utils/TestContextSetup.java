package Cucumber_framework.Cucumber_framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class TestContextSetup {
	public WebDriver driver;
	public Wait<WebDriver> wait;
	public String[] productsLandingPage;
	public String[] productsTopDealsPage;
}
