package com.sel.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoAlertPresentException;	
import org.openqa.selenium.Alert;

public class AlertTest {
	
	public static void main(String[] args) throws NoAlertPresentException,InterruptedException  {									
		// declaration and instantiation of objects/variables
					System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
					WebDriver driver = new ChromeDriver();
				
	// Alert Message handling
                    		
        driver.get("http://demo.guru99.com/test/delete_customer.php");			
                            		
     	      	
        driver.findElement(By.name("cusid")).sendKeys("53920");					
        driver.findElement(By.name("submit")).submit();			
        		
        // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= driver.switchTo().alert().getText();		
        		
        // Displaying alert message		
        System.out.println(alertMessage);	
        Thread.sleep(5000);
        		
        // Accepting alert		
       // alert.accept();		
        alert.dismiss();
    }	

}
