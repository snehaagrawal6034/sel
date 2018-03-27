package testngpackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Facebook {

	public String baseUrl = "http://automationpractice.com/index.php";
	WebDriver driver;

	/* @Test(groups = { "a","b" }) */

	//@Test(priority=1,groups= { "a"})
	@Test(groups= {"b"},dependsOnMethods="launchbrowser")
	public void g() {
		List<WebElement> dress = driver.findElements(By.cssSelector("a[title='Dresses']"));
		int count = dress.size();
		// System.out.println(+count);
		for (int i = 0; i < count; i++) {
			int x = dress.get(i).getLocation().getX();
			if (x != 0) {
				dress.get(i).click();
			}
		}
		Select sel = new Select(driver.findElement(By.cssSelector("select[id='selectProductSort']")));
		// sel.selectByIndex(1);
		// sel.selectByVisibleText("Price: Highest first");
		sel.selectByValue("price:asc");
		WebElement elecount1 = sel.getFirstSelectedOption();
		System.out.println(elecount1.getText());
		List<WebElement> elecount = sel.getOptions();
		System.out.println(elecount.size());
		int size = elecount.size();
		for (int i = 0; i < size; i++) {
			String val = elecount.get(i).getText();

			System.out.println("" + val);
		}
		sel.selectByVisibleText("Price: Highest first");

		// below line throws erroe You may only deselect options of a multi-select
		// sel.deselectByVisibleText("Price: Highest first");

	}

	//@BeforeMethod
	@Test(priority=0,groups= { "a","b" })
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

	@BeforeTest
	public void beforeTest() {

	}

	@AfterTest
	public void afterTest() {
		System.out.println("after test");
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
