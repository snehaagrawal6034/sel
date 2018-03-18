package com.sel.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTest {

	public static void main(String args[]) {
		WebDriver driver = null;

		if (driver == null) {

			// declaration and instantiation of objects/variables
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

		}
		// pageLoadTimeOut
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");

		// Explicit and Emplicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 20);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));

		boolean status = element.isDisplayed();

		if (status) {
			System.out.println("===== WebDriver is visible======");
		} else {
			System.out.println("===== WebDriver is not visible======");
		}

	}
}

// FluentWait
/*
 * FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
 * wait.pollingEvery(1, TimeUnit.SECONDS); wait.withTimeout(10,
 * TimeUnit.SECONDS); WebElement element = wait.until(new Function<WebDriver,
 * WebElement>() { public WebElement apply(WebDriver arg0) { WebElement ele =
 * arg0.findElement(By.xpath("//p[@id='demo']")); if
 * (ele.getAttribute("innerHTML").equalsIgnoreCase("WebDriver")) {
 * System.out.println("Value is " + ele.getAttribute("innerHTML")); return ele;
 * }
 * 
 * else { System.out.println("Value is " + ele.getAttribute("innerHTML"));
 * 
 * return null; } } }); System.out.println("Final visible status is >>>>> " +
 * element.isDisplayed());
 * 
 *      }
 * 
 * }
 */
