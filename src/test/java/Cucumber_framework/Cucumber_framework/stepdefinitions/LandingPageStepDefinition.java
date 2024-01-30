package Cucumber_framework.Cucumber_framework.stepdefinitions;

import org.openqa.selenium.chrome.ChromeDriver;

import Cucumber_framework.Cucumber_framework.pageobjects.LandingPage;
import Cucumber_framework.Cucumber_framework.utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LandingPageStepDefinition {

	TestContextSetup testContextSetup;

	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Given("User in on GreenCart Landing page")
	public void user_in_on_green_cart_landing_page() {
		WebDriverManager.chromedriver().setup();
		testContextSetup.driver = new ChromeDriver();
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/");
	}

	@When("user searched with shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
		LandingPage landingPage = new LandingPage(testContextSetup.driver);
		landingPage.searchProduct(shortName);
		testContextSetup.productsLandingPage = landingPage.getListedProductsName();
		landingPage.clickTopDealsLink();
	}

}
