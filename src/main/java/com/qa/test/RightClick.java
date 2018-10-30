package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RightClick {
	public String baseUrl = "https://artoftesting.com/";
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", "..//SeleniumPracticeCode//Driver//chromedriver");
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@Test
	public void verifyHomepageTitle() throws InterruptedException {
		String expectedTitle = "Learn automation with free automation testing tutorial";
		// String actualTitle = driver.getTitle();
		// Assert.assertEquals(actualTitle, expectedTitle);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = driver
				.findElement(By.xpath("//a[@href='https://artoftesting.com/software-testing-tutorial.html']"));
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
		// Thread.sleep(1000);
		actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(element).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build()
				.perform();
		 Thread.sleep(2000);
	}

	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
	}

}
