package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DisabledElements {
	WebDriver driver;
    String baseUrl;
    @BeforeMethod
    public void setup () throws Exception {
    System.setProperty("webdriver.chrome.driver", "..//SeleniumPracticeCode//Driver//chromedriver");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(baseUrl);
    }
    @Test
		public void test() {
    		WebElement e1 = driver.findElement(By.id("gs_htif0"));
    		System.out.println("E1 is Enable?" +e1.isEnabled());
    		
    		WebElement e2 = driver.findElement(By.id("gs_taif0"));
    		System.out.println("E2 is Enable? "+e2.isEnabled());
    		
    		WebElement e3 = driver.findElement(By.id("lst-ib"));
    		System.out.println("E3 is Enable? " +e3.isEnabled());
		
	}
		@AfterMethod
		public void terminateBrowser() throws Exception {
			Thread.sleep(2000);
			driver.quit();
		}
		
}
