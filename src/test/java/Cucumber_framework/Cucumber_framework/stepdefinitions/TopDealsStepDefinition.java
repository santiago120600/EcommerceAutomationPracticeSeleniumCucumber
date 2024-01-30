package Cucumber_framework.Cucumber_framework.stepdefinitions;

import java.util.Arrays;
import java.util.HashSet;

import org.testng.Assert;

import Cucumber_framework.Cucumber_framework.pageobjects.TopDealsPage;
import Cucumber_framework.Cucumber_framework.utils.TestContextSetup;
import io.cucumber.java.en.Then;

public class TopDealsStepDefinition {
	
	TestContextSetup testContextSetup;
	
	public TopDealsStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) {
		TopDealsPage topDealsPage = new TopDealsPage(testContextSetup.driver);
		topDealsPage.switchToWindow("offers");
		topDealsPage.searchProduct(shortName);
		testContextSetup.productsTopDealsPage = topDealsPage.getListedProductsName();
	}
	
	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_matches() {
		Assert.assertTrue(compareArrays(testContextSetup.productsLandingPage, testContextSetup.productsTopDealsPage));
		testContextSetup.driver.quit();
	}
	
	public boolean compareArrays(String[] arr1,String[] arr2) {
		return new HashSet<String>(Arrays.asList(arr1)).equals(new HashSet<String>(Arrays.asList(arr2)));
	}

}
