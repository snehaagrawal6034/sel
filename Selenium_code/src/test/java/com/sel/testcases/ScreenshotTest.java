package com.sel.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sel.Selenium_code.base.TestBase;
import com.sel.utility.Utility;

public class ScreenshotTest {
	static WebDriver driver;
	//private static ITestResult result;

	public static void main(String args[]) throws IOException {
		driver = TestBase.setUp();

		WebElement login=driver.findElement(By.cssSelector(".login"));
        login.click();
        
		Utility.captureScreenshot(driver, "login");
	}
}
