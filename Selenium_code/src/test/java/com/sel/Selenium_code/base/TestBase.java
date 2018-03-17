package com.sel.Selenium_code.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;

	public static WebDriver setUp() {

		if (driver == null) {

			// declaration and instantiation of objects/variables
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			String baseUrl = "http://automationpractice.com/index.php";
			driver.get(baseUrl);
			driver.manage().window().maximize();
		}
		return driver;
	}

	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}
}
