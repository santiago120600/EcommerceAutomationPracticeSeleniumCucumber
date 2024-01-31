package Cucumber_framework.Cucumber_framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePageObject {

	By productNameCol = By.xpath("//td[2]");
	By applyButton = By.cssSelector(".promoBtn");
	By placeOrderButton = By.xpath("//button[text()='Place Order']");

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public String[] getListedProductsName() {
		List<WebElement> products = getListedProducts();
		String[] productsName = new String[products.size()];
		for (int i = 0; i < products.size(); i++) {
			productsName[i] = getText(products.get(i));
		}
		return productsName;
	}

	private List<WebElement> getListedProducts() {
		sleep(1);
		List<WebElement> products = findAll(productNameCol);
		if (!products.isEmpty()) {
			products.remove(0);
		}
		return products;
	}

	public boolean isApplyButtonDisplayed() {
		return find(applyButton).isDisplayed();
	}

	public boolean isPlaceOrderButtonDisplayed() {
		return find(placeOrderButton).isDisplayed();
	}

}
