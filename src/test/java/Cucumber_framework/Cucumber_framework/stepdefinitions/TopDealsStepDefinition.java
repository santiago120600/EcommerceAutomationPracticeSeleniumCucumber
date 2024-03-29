package Cucumber_framework.Cucumber_framework.stepdefinitions;

import org.testng.Assert;

import Cucumber_framework.Cucumber_framework.pageobjects.TopDealsPage;
import Cucumber_framework.Cucumber_framework.utils.TestContextSetup;
import io.cucumber.java.en.Then;

public class TopDealsStepDefinition {
	
	TestContextSetup testContextSetup;
	TopDealsPage topDealsPage;
	
	public TopDealsStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		 topDealsPage = testContextSetup.factory.getDealsPage();
	}

	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) {
		topDealsPage.switchToWindow("offers");
		topDealsPage.searchProduct(shortName);
		testContextSetup.productsTopDealsPage = topDealsPage.getListedProductsName();
	}
	
	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_matches() {
		Assert.assertTrue(testContextSetup.base.compareArrays(testContextSetup.productsLandingPage, testContextSetup.productsTopDealsPage));
	}
	
}
