package com.sel.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.sel.Selenium_code.base.TestBase;

public class SelectTest {

	public static void main(String args[]) {

		WebDriver driver = TestBase.setUp();

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
		sel.deselectByVisibleText("Price: Highest first");
	}
}