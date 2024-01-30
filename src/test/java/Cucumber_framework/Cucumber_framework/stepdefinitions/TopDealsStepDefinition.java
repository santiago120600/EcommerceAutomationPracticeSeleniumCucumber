package Cucumber_framework.Cucumber_framework.stepdefinitions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Cucumber_framework.Cucumber_framework.utils.TestContextSetup;
import io.cucumber.java.en.Then;

public class TopDealsStepDefinition {
	
	TestContextSetup testContextSetup;
	
	public TopDealsStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) {
		WebElement topDealsLink =  testContextSetup.wait.until(ExpectedConditions.visibilityOf(
				testContextSetup.driver.findElement(By.linkText("Top Deals")
						)));
		topDealsLink.click();
		switchToWindow("offers");
		WebElement searchBar = testContextSetup.wait.until(ExpectedConditions.visibilityOf(
				testContextSetup.driver.findElement(By.id("search-field")
						)));
		searchBar.sendKeys(shortName);
		List<WebElement> products = testContextSetup.driver.findElements(By.xpath("//tr//td[1]"));
		testContextSetup.productsTopDealsPage = new String[products.size()];
		for(int i = 0; i < products.size();i++) {
			testContextSetup.productsTopDealsPage[i] = products.get(i).getText().trim();
		}
	}
	
	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_matches() {
		Assert.assertTrue(compareArrays(testContextSetup.productsLandingPage, testContextSetup.productsTopDealsPage));
		testContextSetup.driver.quit();
	}
	
	public boolean compareArrays(String[] arr1,String[] arr2) {
		return new HashSet<String>(Arrays.asList(arr1)).equals(new HashSet<String>(Arrays.asList(arr2)));
	}
	
	public void switchToWindow(String urlContains) {
		for(String winHandle : testContextSetup.driver.getWindowHandles()){
			if (testContextSetup.driver.switchTo().window(winHandle).getCurrentUrl().contains(urlContains)) {
				break;
			}
		}
	}
}
