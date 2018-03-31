package com.ddf;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.page.HomePage;
import com.page.LoginPage;
import com.util.TestUtil;

public class LoginPageTesting extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	String sheetName = "LoginData";

	public LoginPageTesting() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Facebook - log in or sign up");
	}

	@Test(priority=2)
	public void crmLogoImageTest(){ 
		boolean flag = loginPage.validateCRMImage(); 
		Assert.assertTrue(flag); }
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	 
	   @Test(priority=3, dataProvider="getTestData")
	  public void loginTest(String emailid, String password){
		        homePage =loginPage.login(emailid, password);
	 }
	
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
