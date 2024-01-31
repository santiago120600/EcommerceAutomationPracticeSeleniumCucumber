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
	private By cartIcon = By.cssSelector(".cart-icon");
	private By proceedToCheckoutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	private By addToCartButton = By.xpath(".//button[text()='ADD TO CART']");
	private By plusIcon = By.xpath(".//a[@class='increment']");

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
	
	public String[] getListedProductsFullName() {
		List<WebElement> products = getListedProducts();
		String[] productsName = new String[products.size()];
		for (int i = 0; i < products.size(); i++) {
			productsName[i] = getText(productName);
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

	public void addItemsToCart(int quantity) {
		List<WebElement> products = getListedProducts();
		for (int i = 0; i < products.size(); i++) {
			for (int j = 0; j < (quantity-1); j++) {
				getPlusIcon(products.get(i)).click();
			}
		}
		click(addToCartButton);
	}
	
	public WebElement getPlusIcon(WebElement parent) {
		return findWithinParent(parent, plusIcon);
	}
	
	public void clickCartIcon() {
		click(cartIcon);
	}
	
	public void navigateToCheckout() {
		clickCartIcon();
		click(proceedToCheckoutButton);
	}
}
