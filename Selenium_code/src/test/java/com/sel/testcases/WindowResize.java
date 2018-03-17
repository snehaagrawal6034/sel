package com.sel.testcases;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import com.sel.Selenium_code.base.TestBase;

public class WindowResize {

	public static void main(String args[]) {
		WebDriver driver=TestBase.setUp();
		/*
		 * Throwing exception
		 * driver.manage().window().getSize();
		System.out.println(((Dimension) driver.manage().window()).getHeight());
		System.out.println(((Dimension) driver.manage().window()).getWidth());
	*/
	driver.manage().window().setSize(new Dimension(50,50) );
		
		driver.close();
	}

}
