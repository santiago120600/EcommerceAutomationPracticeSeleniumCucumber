package Cucumber_framework.Cucumber_framework.stepdefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		testContextSetup.wait = new WebDriverWait(testContextSetup.driver, Duration.ofSeconds(5));
		WebElement searchBar = testContextSetup.wait.until(ExpectedConditions.visibilityOf(
				testContextSetup.driver.findElement(By.xpath("//input[@type='search']")
						)));
		searchBar.sendKeys(shortName);
		sleep(2);
		List<WebElement> products = testContextSetup.driver.findElements(By.xpath("//div[@class='product']")); 
		testContextSetup.productsLandingPage = new String[products.size()];
		for(int i = 0; i < products.size();i++) {
			testContextSetup.productsLandingPage[i] = getProductName( 
					testContextSetup.driver.findElement(By.xpath(".//h4[@class='product-name']")).getText()).trim();
		}
	}
	
	public String getProductName(String product) {
		return product.split(" ")[0];
	}
	
	public void sleep(int second) {
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
