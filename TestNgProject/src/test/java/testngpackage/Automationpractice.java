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

public class Automationpractice {

	public String baseUrl = "http://automationpractice.com/index.php";
	WebDriver driver;
	
	@Test
	//@Test(groups= {"b"},dependsOnMethods="launchbrowser")
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
		System.out.println("I m in method g");

	}

	@BeforeMethod
	//@Test(priority=0,groups= { "a","b" })
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void tearDown() {
		System.out.println("after method AP");
		driver.quit();
	}




}
