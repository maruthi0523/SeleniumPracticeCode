package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadFiles {
	private WebDriver driver;
	private String baseUrl;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "..//SeleniumPracticeCode//Driver//chromedriver");
		driver = new ChromeDriver();
		baseUrl = "http://www.naukri.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void dropdown() throws Exception {
		driver.get(baseUrl);
		
		//WebElement downloadButton = driver.findElement(By.id("messenger-download"));
		//String sourceLocation = downloadButton.getAttribute("href");
		//String wget_command = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + sourceLocation;
	}

	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
	}
}
