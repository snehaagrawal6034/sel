package com.sel.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;		
import org.testng.annotations.Test;

import com.sel.Selenium_code.base.TestBase;

public class JavascriptExecutorTest {

	public static void main(String args[]) {
	        	
	        		
	        //Launching the Site.		
	        WebDriver driver=TestBase.setUp();
	      //Creating the JavascriptExecutor interface object by Type casting		
	        JavascriptExecutor js = (JavascriptExecutor)driver;	
			
	        WebElement login=driver.findElement(By.cssSelector(".login"));
	        login.click();
	       
	        WebElement email=driver.findElement(By.cssSelector("input#email_create"));
	        email.sendKeys("sneha.agrawal4306@gmail.com");
	        //click action
	        WebElement submit=driver.findElement(By.cssSelector("button[id='SubmitCreate']"));
	        js.executeScript("arguments[0].click();", submit);
	        //alert popup                     
	        js.executeScript("alert('Welcome to registration page');");   
	        driver.switchTo().alert().accept();
	        js.executeScript("window.scrollBy(0,500)");
	        String text=("return  document.getElementById(\"customer_firstname\").innerText").toString();
		       System.out.println(text);
	        //refresh browser
	        js.executeScript("history.go(0)");
	        //get inner text of webpage
	     
	       String domainname=js.executeScript("return document.domain").toString();
	        System.out.println(domainname);
	        String windowloc=js.executeScript("return window.location").toString();
	        System.out.println(windowloc);
	        String windowheight=js.executeScript("return window.innerHeight").toString();
	        System.out.println(windowheight);
	        js.executeScript("window.location = 'http://facebook.com/'");
	      //  System.out.println(windownav);
	        
	    		
	    }		
}
