package com.qa.test;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadFile {
	private WebDriver driver;
	private String baseUrl;

	@BeforeMethod
	public void before() throws Exception {
		baseUrl = "https://www.gmail.com/";
		driver = new FirefoxDriver();;

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
    @Test
	public void uploadfile() throws Exception{
		driver.findElement(By.id("identifierId")).sendKeys("maruthi.g@cloudnowtech.com");
		driver.findElement(By.className("RveJvd snByac")).click();
		driver.findElement(By.className("whsOnd zHQkBf")).sendKeys(""); // Enter your password
		driver.findElement(By.className("RveJvd snByac")).click();
				//EnterPassword.enterPassword(driver); // Comment this
				//driver.findElement(By.id("signIn")).click();
				driver.findElement(By.className("T-I J-J5-Ji T-I-KE L3")).click();
				driver.findElement(By.id(":og")).sendKeys("maruthi.g@cloudnowtech.com");
				driver.findElement(By.id(":ny")).sendKeys("Test File Upload");
				WebElement fileInput = driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']"));
				fileInput.click(); 
	}
	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
}
}
