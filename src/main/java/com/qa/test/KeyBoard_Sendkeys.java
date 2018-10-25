package com.qa.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KeyBoard_Sendkeys {
	private WebDriver driver;
	private String baseUrl;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","..//SeleniumPracticeCode//Driver//chromedriver");
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/p/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void testKeyPress() throws Exception {
		driver.get(baseUrl);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("//a[contains(@href,'sign_in')]")).sendKeys(Keys.ENTER);
		 driver.findElement(By.id("user_email")).sendKeys("admin@email.com");
		action.sendKeys(Keys.TAB).build().perform();
		driver.findElement(By.id("user_password")).sendKeys("Password@123");
		action.sendKeys(Keys.ENTER).build().perform();
	}
	@AfterTest
	public void tearDown() throws Exception {
		
	}

}
