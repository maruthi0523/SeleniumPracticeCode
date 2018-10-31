package com.qa.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptAlerts {
	 WebDriver driver;
	 String baseUrl;
	
		
		@BeforeMethod
		public void alerts() 
		{
		System.setProperty("webdriver.chrome.driver", "..//SeleniumPracticeCode//Driver//chromedriver");
		 driver = new ChromeDriver();
		baseUrl ="http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/";
		driver.manage().window().maximize();
		}
		// This step will result in an alert on screen
		
		@Test
		public void clickalert() throws InterruptedException  {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//*[@id='content']/p[4]/button")).click();
		Thread.sleep(2000);

		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		System.out.println("Alert text is " + alertText);
		simpleAlert.accept();
		}
	
        @AfterMethod
        public void terminateBrowser() {
	     
	     driver.quit();
      }

    }


