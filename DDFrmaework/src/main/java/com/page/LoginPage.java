package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
			@FindBy(css="input[id='email']")
			WebElement useremail;
			
			@FindBy(css="input[id='pass']")
			WebElement password;
			
			@FindBy(xpath="//input[@type='submit']")
			WebElement loginBtn;
			
			@FindBy(xpath="//i[contains(@class,'fb_logo.img.sp_d0NYpM4xxw4.sx_7d33da')]")
			
			WebElement crmLogo;

			public LoginPage(){
				PageFactory.initElements(driver, this);
			}
			
			//Actions:
			public String validateLoginPageTitle(){
				return driver.getTitle();
			}
			
			public boolean validateCRMImage(){
				return crmLogo.isDisplayed();
			}
			
			public HomePage login(String un, String pwd){
				useremail.sendKeys(un);
				password.sendKeys(pwd);
				loginBtn.click();
				//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
				    	//JavascriptExecutor js = (JavascriptExecutor)driver;
				    	//js.executeScript("arguments[0].click();", loginBtn);
				    	
				return new HomePage();
			}
			
			

}
