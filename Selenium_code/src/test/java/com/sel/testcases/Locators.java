package com.sel.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sel.Selenium_code.base.TestBase;

public class Locators {

	public static void main(String args[]) {
		WebDriver driver = TestBase.setUp();

		// finding element through locator xpath
		WebElement search = driver.findElement(By.xpath("//input[@id='search_query_top']"));
		search.sendKeys("dress");
		// finding element through locator css
		WebElement login = driver.findElement(By.cssSelector(".login"));
		login.click();

		WebElement email = driver.findElement(By.cssSelector("input#email_create"));
		email.sendKeys("sneha.agrawal4306@gmail.com");

		WebElement submit = driver.findElement(By.cssSelector("button[id='SubmitCreate']"));
		submit.click();

		// finding element through locator id -- not working
		// WebElement fname =
		// driver.findElement(By.cssSelector("input[id='customer_firstname']"));
		// fname.sendKeys("sneha");
		// finding element through locator name -- not working
		// WebElement lname = driver.findElement(By.name("customer_lastname"));
		// lname.sendKeys("agrawal");
		// finding element through lintext
		WebElement link = driver.findElement(By.linkText("Women"));
		link.click();

		// locating hidden elements

		List<WebElement> dress = driver.findElements(By.cssSelector("a[title='Dresses']"));
		int count = dress.size();
		System.out.println(+count);
		for (int i = 0; i < count; i++) {
			int x = dress.get(i).getLocation().getX();
			if (x != 0) {
				dress.get(i).click();
			}

		}

	}
}
