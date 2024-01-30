package Cucumber_framework.Cucumber_framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends BasePageObject {

	private By searchBar = By.xpath("//input[@type='search']");
	private By productName = By.xpath(".//h4[@class='product-name']");
	private By productCards = By.xpath("//div[@class='product']");
	private By topDealsLink = By.linkText("Top Deals");

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	public void searchProduct(String productName) {
		type(searchBar, productName);
		sleep(2);
	}

	public String[] getListedProductsName() {
		List<WebElement> products = getListedProducts();
		String[] productsName = new String[products.size()];
		for (int i = 0; i < products.size(); i++) {
			productsName[i] = getProductName(getText(productName));
		}
		return productsName;
	}

	public void clickTopDealsLink() {
		click(topDealsLink);
	}

	private List<WebElement> getListedProducts() {
		return findAll(productCards);
	}

	public String getProductName(String product) {
		return product.split(" ")[0].trim();
	}

}
