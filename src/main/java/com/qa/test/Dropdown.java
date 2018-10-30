package com.qa.test;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dropdown {
	private WebDriver driver;
	private String baseUrl;
    @BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","..//SeleniumPracticeCode//Driver//chromedriver");
		driver = new ChromeDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	    public void dropdown()  throws Exception {
		driver.get(baseUrl);
		WebElement selectelement = driver.findElement(By.id("carselect"));
	    Select dropdown = new Select(selectelement);
	    dropdown.selectByValue("honda");
		Thread.sleep(3000);
	}
	@AfterMethod                           
		public void terminateBrowser()
		{
		    driver.quit();
		}
	}
	


