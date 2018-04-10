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

public class AutomationPractice1 {
	public String baseUrl = "http://automationpractice.com/index.php";
	WebDriver driver;

@BeforeMethod
	// @Test(priority=1,groups= { "a","b" })
	// @Test(groups= { "a","b" })
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// @Test(enabled=false)
	// @Test(expectedExceptions=ArithmeticException.class,groups= { "a","b"
	// },dependsOnMethods="launchbrowser")

	@Test(priority = 0)
	// (groups= { "a","b" },dependsOnMethods="launchbrowser")
	
	public void f() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement login = driver.findElement(By.cssSelector(".login"));
		login.click();
		WebElement email = driver.findElement(By.cssSelector("input#email_create"));
		email.sendKeys("sneha.agrawal6034@gmail.com");

		WebElement submit = driver.findElement(By.cssSelector("button[id='SubmitCreate']"));
		submit.click();
		System.out.println("AutomationPractice1: I m in method f");

	}

	
	// (dependsOnMethods="launchbrowser",groups= { "a","b" })
	@Test
	public void e() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
		//driver.navigate().back();
		System.out.println("i am in javascript");
		// get inner text of webpage

		String domainname = js.executeScript("return document.domain").toString();
		System.out.println(domainname);
		String windowloc = js.executeScript("return window.location").toString();
		System.out.println(windowloc);
		String windowheight = js.executeScript("return window.innerHeight").toString();
		System.out.println(windowheight);
		// js.executeScript("window.location = 'http://facebook.com/'");
		System.out.println("AutomationPractice1: I m in method e");

	}

	@BeforeTest(alwaysRun=true)
	public void beforeMethod() {

		System.out.println("AutomationPractice1: before test");
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		System.out.println("AutomationPractice1: after method");
		driver.quit();
	}


	@BeforeClass(alwaysRun=true)
	public void beforeClass() {
		System.out.println("before class");
	}

	@AfterClass(alwaysRun=true)
	public void afterClass() {
		System.out.println("after class");
	}

	@AfterTest(alwaysRun=true)
	public void terminateBrowser() {

	}

	@BeforeSuite(alwaysRun=true)
	public void beforeSuite() {
		System.out.println("before suite");
	}

	@AfterSuite(alwaysRun=true)
	public void afterSuite() {

		System.out.println("after suite");
	}

}
