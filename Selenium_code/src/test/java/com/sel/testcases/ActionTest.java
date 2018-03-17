package com.sel.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.sel.Selenium_code.base.TestBase;

public class ActionTest {
	
	public static void main(String args[]) {
		
		WebDriver driver=TestBase.setUp();
		 WebElement search=driver.findElement(By.xpath("//input[@id='search_query_top']"));
	      
		/*Actions act=new Actions(driver);
		Action seriesofact=act.moveToElement(search).click().keyDown(search,Keys.SHIFT).
				sendKeys("dress").keyUp(search,Keys.SHIFT).doubleClick(search).
				contextClick().build();
		seriesofact.perform();*/
		
		Actions act1=new Actions(driver);
		Action seriesofact1=act1.moveToElement(search).click().keyDown(search,Keys.SHIFT).
				sendKeys("dress").keyUp(search,Keys.SHIFT).clickAndHold().release().build();
		seriesofact1.perform();
	}

}
