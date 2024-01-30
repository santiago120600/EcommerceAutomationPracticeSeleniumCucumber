package Cucumber_framework.Cucumber_framework.stepdefinitions;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GreenCartStepDefinition {
	WebDriver driver;
	Wait<WebDriver> wait;
	String[] productsLandingPage;
	String[] productsTopDealsPage;
	
	@Given("User in on GreenCart Landing page")
	public void user_in_on_green_cart_landing_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
	}
	@When("user searched with shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement searchBar = wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("//input[@type='search']")
						)));
		searchBar.sendKeys(shortName);
		sleep(2);
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='product']")); 
		productsLandingPage = new String[products.size()];
		for(int i = 0; i < products.size();i++) {
			productsLandingPage[i] = getProductName( 
					driver.findElement(By.xpath(".//h4[@class='product-name']")).getText()).trim();
		}
	}
	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) {
		WebElement topDealsLink =  wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.linkText("Top Deals")
						)));
		topDealsLink.click();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		WebElement searchBar = wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.id("search-field")
						)));
		searchBar.sendKeys(shortName);
		List<WebElement> products = driver.findElements(By.xpath("//tr//td[1]"));
		productsTopDealsPage = new String[products.size()];
		for(int i = 0; i < products.size();i++) {
			productsTopDealsPage[i] = products.get(i).getText().trim();
		}
	}
	
	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_matches() {
		Assert.assertTrue(compareArrays(productsLandingPage, productsTopDealsPage));
		driver.quit();
	}
	
	public boolean compareArrays(String[] arr1,String[] arr2) {
		return new HashSet<String>(Arrays.asList(arr1)).equals(new HashSet<String>(Arrays.asList(arr2)));
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
