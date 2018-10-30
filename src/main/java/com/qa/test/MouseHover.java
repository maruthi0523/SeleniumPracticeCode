package com.qa.test;
    import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	//import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class MouseHover {
		private WebDriver driver;
		private String baseUrl;
        @BeforeTest
		public void setUp() throws Exception {
			System.setProperty("webdriver.chrome.driver","..//SeleniumPracticeCode//Driver//chromedriver");
			driver = new ChromeDriver();
			baseUrl = "http://the-internet.herokuapp.com/hovers";
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
			@Test
			public void testKeyPress() throws Exception {
		    driver.get(baseUrl);
		    Thread.sleep(2000);
		    Actions action = new Actions(driver);
		    WebElement element = driver.findElement(By.id("content"));
	        action.moveToElement(element).build().perform();
	        Thread.sleep(2000);
			}
			@AfterTest
			public void tearDown() throws Exception {
				
			}
				}

