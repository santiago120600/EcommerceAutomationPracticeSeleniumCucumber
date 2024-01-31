package Cucumber_framework.Cucumber_framework.stepdefinitions;

import org.testng.Assert;

import Cucumber_framework.Cucumber_framework.pageobjects.CheckoutPage;
import Cucumber_framework.Cucumber_framework.utils.TestContextSetup;
import io.cucumber.java.en.Then;

public class CheckoutPageStepDefinition {

	TestContextSetup testContextSetup;
	CheckoutPage checkoutPage;

	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		super();
		this.testContextSetup = testContextSetup;
		checkoutPage = testContextSetup.factory.getCheckoutPage();
	}

	@Then("validate apply and place order buttons are displayed")
	public void validate_apply_and_place_order_buttons_are_displayed() {
		//search on bar
		testContextSetup.productsCheckoutPage = checkoutPage.getListedProductsName();
		Assert.assertTrue(testContextSetup.base.compareArrays(testContextSetup.productsLandingPage,
				testContextSetup.productsCheckoutPage));
		Assert.assertTrue(checkoutPage.isApplyButtonDisplayed());
		Assert.assertTrue(checkoutPage.isPlaceOrderButtonDisplayed());
	}
}
