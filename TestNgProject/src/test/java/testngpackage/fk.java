package testngpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class fk {

	WebDriver driver;
	String username = "sneha.agrawal6034@gmail.com"; // Change to your username and passwrod
	String password = "";

	// This method is to navigate flipkart URL
	@BeforeClass
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().to("https://www.flipkart.com");
	}

	// To log in flipkart
	@Test
	public void login() {
		try {

		driver.findElement(By.partialLinkText("Login")).click();
		WebElement element = driver.findElement(By.cssSelector("input[class='_2zrpKA']"));
		// WebElement element =
		// driver.findElement(By.cssSelector(".fk-input.login-form-input.user-email"));
		Actions action = new Actions(driver);

		// driver.findElement(
		// By.cssSelector("input[class='_2zrpKA']")).sendKeys(username);

		action.moveToElement(element).sendKeys(username).perform();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	// driver.findElement( By.cssSelector("input[class='._2zrpKA._3v41xv']"))
	// .sendKeys(password);
	/* driver.findElement(By.cssSelector(".submit-btn.login-btn.btn")).click(); */

	/*
	 * WebElement element =
	 * driver.findElement(By.cssSelector("input[class='_2zrpKA']"));
	 * JavascriptExecutor js =(JavascriptExecutor)driver;
	 * js.executeScript("window.scrollTo(0,"element.getLocation().x+")");
	 * element.click();
	 * 
	 * }
	 */

	@AfterClass
	public void quit() {
		// driver.close();
	}

}
