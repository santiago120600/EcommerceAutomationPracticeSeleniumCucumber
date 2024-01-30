package Cucumber_framework.Cucumber_framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopDealsPage extends BasePageObject{
	
	private By searchBar = By.id("search-field");
	private By productsNameCol = By.xpath("//tr//td[1]");

	public TopDealsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void searchProduct(String product) {
		waitForVisibilityOf(searchBar);
		type(searchBar, product);
	}
	
	public String[] getListedProductsName() {		
		List<WebElement> products = getListedProducts();
		String[] productsName = new String[products.size()];
		for(int i = 0; i < products.size();i++) {
			productsName[i] = products.get(i).getText().trim();
		}
		return productsName;
	}
	
	private List<WebElement> getListedProducts(){
		return findAll(productsNameCol); 		
	}
	
}
