package Cucumber_framework.Cucumber_framework.stepdefinitions;

import org.testng.Assert;

import Cucumber_framework.Cucumber_framework.pageobjects.LandingPage;
import Cucumber_framework.Cucumber_framework.utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LandingPageStepDefinition {

	TestContextSetup testContextSetup;
	LandingPage landingPage;

	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		landingPage = testContextSetup.factory.getLandingPage();
	}

	@Given("User in on GreenCart Landing page")
	public void user_in_on_green_cart_landing_page() {
		Assert.assertEquals(landingPage.getCurrentUrl(), "https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	@When("user searched with shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
		landingPage.searchProduct(shortName);
		testContextSetup.productsLandingPage = landingPage.getListedProductsName();
	}
	
	@When("clicked on Top Deals")
	public void clicked_on_top_deals() {
		landingPage.clickTopDealsLink();
	}
	
	@Then("add {int} items to cart")
	public void add_items_to_cart(int numberOfProducts) {
		landingPage.addItemsToCart(numberOfProducts);
		testContextSetup.productsLandingPage = landingPage.getListedProductsFullName();
	}
	
	@Then("navigate to checkout page")
	public void navigate_to_checkout_page() {
		landingPage.navigateToCheckout();
	}

}
