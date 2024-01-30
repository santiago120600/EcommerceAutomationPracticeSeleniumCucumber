package Cucumber_framework.Cucumber_framework.utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class TestBase {
	
	public WebDriver driver;

	public WebDriver webDriverManager() {
		Properties prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Global.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String browser = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		if (driver == null) {			
			BrowserDriverFactory factory = new BrowserDriverFactory(browser);
			driver = factory.createDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
	}
}
