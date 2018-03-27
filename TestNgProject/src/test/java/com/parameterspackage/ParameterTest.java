package com.parameterspackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	WebDriver driver;

	@Test
	@Parameters({ "browser", "url", "emailid", "pass" })
	// @Parameters({ "browser", "url" })
	public void flipkartLoginTest(String browser, String url, String emailid, String pass) {
		// public void flipkartLoginTest(String browser, String url) {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get(url);
		// To log in flipkart
		WebElement ele = driver.findElement(By.partialLinkText("Login"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		
		
		//driver.findElement(By.partialLinkText("Login")).click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);	
		driver.findElement(By.cssSelector("input[class='_2zrpKA']")).sendKeys(emailid);
		driver.findElement(By.cssSelector("input[class='_2zrpKA _3v41xv']")).sendKeys(pass);
		driver.findElement(By.cssSelector("button[class='_2AkmmA _1LctnI _7UHT_c']")).click();
		// driver.findElement(By.cssSelector(".fk-input.login-form-input.user-pwd")).sendKeys(pass);
		// driver.findElement(By.cssSelector(".submit-btn.login-btn.btn")).click();
		
		//Actions act=new Actions(driver);
		//act.moveToElement(driver.findElement(By.cssSelector("input[class='._2zrpKA']"))).sendKeys("emailid").build().perform();

		
	}
}
