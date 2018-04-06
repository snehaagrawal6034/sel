package testngpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Flipkart {

	WebDriver driver;
	String username = "sneha.agrawal6034@gmail.com";
	String password = "chinki04";

	// This method is to navigate flipkart URL
	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://www.flipkart.com");
	}

	@Test
	public void login() {

		WebElement element = driver.findElement(By.partialLinkText("Login"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		WebElement email = driver.findElement(By.cssSelector("input[class='_2zrpKA']"));
		Actions action = new Actions(driver);
		action.moveToElement(email).sendKeys(username).build().perform();
		WebElement password1 = driver.findElement(By.cssSelector("input[type='password']"));
		password1.sendKeys(password);
		driver.findElement(By.cssSelector("._2AkmmA._1LctnI._7UHT_c")).click();
		System.out.println("I m in method login");
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("after method fk");
		driver.quit();
	}


}
