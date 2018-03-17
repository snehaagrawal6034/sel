package com.sel.testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sel.Selenium_code.base.TestBase;

public class WindoeRough {
	static WebDriver driver;

	public static void main(String args[]) {

		 driver = TestBase.setUp();

		WebElement signin = driver.findElement(By.cssSelector(".login"));
		signin.click();

	
		String mainwindow = driver.getWindowHandle();
		//Set<String> window = driver.getWindowHandles();

		//Iterator<String> itr = window.iterator();
		
		//	while (itr.hasNext()) {
				//String childwindow = itr.next();
				//if (!mainwindow.equalsIgnoreCase(childwindow)) {
					//driver.switchTo().window(childwindow);
					WebElement email = driver.findElement(By.cssSelector("input#email_create"));
					email.sendKeys("sneha.agrawal4306@gmail.com");

					WebElement submit = driver.findElement(By.cssSelector("button[id='SubmitCreate']"));
					submit.click();
				//}
			//}
			driver.switchTo().window(mainwindow);

		
	}
}