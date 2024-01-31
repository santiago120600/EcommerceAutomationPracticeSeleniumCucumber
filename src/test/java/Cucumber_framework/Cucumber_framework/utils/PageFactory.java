package Cucumber_framework.Cucumber_framework.utils;

import org.openqa.selenium.WebDriver;

import Cucumber_framework.Cucumber_framework.pageobjects.CheckoutPage;
import Cucumber_framework.Cucumber_framework.pageobjects.LandingPage;
import Cucumber_framework.Cucumber_framework.pageobjects.TopDealsPage;

public class PageFactory {
	
	private WebDriver driver;
	private LandingPage landingPage;
	private TopDealsPage dealsPage;
	private CheckoutPage checkoutPage;
	
	public PageFactory(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver);
		return landingPage;
	}

	public TopDealsPage getDealsPage() {
		dealsPage = new TopDealsPage(driver);
		return dealsPage;
	}
	
	public CheckoutPage getCheckoutPage() {
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}

}
