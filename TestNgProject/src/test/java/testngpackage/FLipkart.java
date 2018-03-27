package testngpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FLipkart {
	public String baseUrl = "http://automationpractice.com/index.php";
	WebDriver driver;

	//@BeforeMethod
	//@Test(priority=1,groups= { "a","b" })
	@Test(groups= { "a","b" })
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	//@Test(enabled=false)
	//@Test(expectedExceptions=ArithmeticException.class,groups= { "a","b" },dependsOnMethods="launchbrowser")
	
	@Test(groups= { "a","b" },dependsOnMethods="launchbrowser")
	public void f() {
	//	int a=0;
	//	int b=6/a;

		// finding element through locator xpath
		// WebElement search =
		// driver.findElement(By.xpath("//input[@id='search_query_top']"));
		// search.sendKeys("dress");
		// finding element through locator css
		
        driver.navigate().back();
		WebElement login = driver.findElement(By.cssSelector(".login"));
		login.click();

		WebElement email = driver.findElement(By.cssSelector("input#email_create"));
		email.sendKeys("sneha.agrawal6034@gmail.com");

		WebElement submit = driver.findElement(By.cssSelector("button[id='SubmitCreate']"));
		submit.click();

	}

	@Test(dependsOnMethods="launchbrowser",groups= { "a","b" })
	public void e() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement login = driver.findElement(By.cssSelector(".login"));
		login.click();

		WebElement email = driver.findElement(By.cssSelector("input#email_create"));
		email.sendKeys("sneha.agrawal4306@gmail.com");
		// click action
		WebElement submit = driver.findElement(By.cssSelector("button[id='SubmitCreate']"));
		js.executeScript("arguments[0].click();", submit);
		// alert popup
		js.executeScript("alert('Welcome to registration page');");
		driver.switchTo().alert().accept();
		js.executeScript("window.scrollBy(0,500)");
		String text = ("return  document.getElementById(\"customer_firstname\").innerText").toString();
		System.out.println(text);
		// refresh browser
		js.executeScript("history.go(0)");
		driver.navigate().back();
		// get inner text of webpage

		String domainname = js.executeScript("return document.domain").toString();
		System.out.println(domainname);
		String windowloc = js.executeScript("return window.location").toString();
		System.out.println(windowloc);
		String windowheight = js.executeScript("return window.innerHeight").toString();
		System.out.println(windowheight);
		//js.executeScript("window.location = 'http://facebook.com/'");

	}

	@BeforeTest
	public void beforeMethod() {

		System.out.println("before test");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("after method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("before class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("after class");
	}

	@AfterTest
	public void terminateBrowser() {

	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite");
	}

	@AfterSuite
	public void afterSuite() {

		System.out.println("after suite");
	}

}
