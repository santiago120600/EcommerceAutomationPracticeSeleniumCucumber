package Cucumber_framework.Cucumber_framework.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {
	
	protected WebDriver driver;
	
	public BasePageObject(WebDriver driver) {
		this.driver = driver;
	}

	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
	
	protected List<WebElement> findAll(By locator){
		return driver.findElements(locator);
	}
	
	public void sleep(int second) {
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void switchToWindow(String urlContains) {
		for(String winHandle : driver.getWindowHandles()){
			if (driver.switchTo().window(winHandle).getCurrentUrl().contains(urlContains)) {
				break;
			}
		}
	}
	
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 5;
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(condition);
	}

	protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
	}
	
	protected void click(By locator) {
		waitForVisibilityOf(locator, 5);
		find(locator).click();
	}
	
	protected void type(By locator, String text) {
		waitForVisibilityOf(locator, 5);
		find(locator).sendKeys(text);
	}
	
	protected String getText(By locator) {
		return find(locator).getText();
	}
	
}
