package com.qa.test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleWindows {
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
		String parent = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> I1 = s1.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				Thread.sleep(2000);
				System.out.println(driver.switchTo().window(child_window).getTitle());
				for (String handle1 : driver.getWindowHandles()) {
					System.out.println(handle1);
					driver.switchTo().window(handle1);
					Thread.sleep(2000);
				}
			}
		}
	}

	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
	}
}
