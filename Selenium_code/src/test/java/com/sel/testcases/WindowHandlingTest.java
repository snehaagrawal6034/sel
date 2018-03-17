package com.sel.testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sel.Selenium_code.base.TestBase;

public class WindowHandlingTest {
	public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.naukri.com/");
		//WebDriver driver = TestBase.setUp();

		String mainwindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();

		Iterator<String> itr = windows.iterator();
		{
			while (itr.hasNext()) {
				String childwindow = itr.next();
				if (!mainwindow.equalsIgnoreCase(childwindow)) {
					driver.switchTo().window(childwindow);
					System.out.println(childwindow);
				}
			}
			driver.switchTo().window(mainwindow);

		}
	}
}
