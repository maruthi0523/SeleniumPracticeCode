package com.qa.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.HttpClientBuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class DownloadFile {
	 WebDriver driver;
	File folder;
	@BeforeMethod
	public void setup() throws IOException {
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		System.setProperty("webdriver.chrome.driver", "..//SeleniumPracticeCode//Driver//chromedriver");
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/download");
		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", folder.getAbsolutePath());

		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);

	}

	@Test
	public void downloadfile() throws Exception {
	
        String link = driver.findElement(By.cssSelector(".example a:nth-of-type(1)")).getAttribute("href");

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpHead request = new HttpHead(link);
        HttpResponse response = httpClient.execute(request);
        String contentType = response.getFirstHeader("Content-Type").getValue();
        int contentLength = Integer.parseInt(response.getFirstHeader("Content-Length").getValue());

        assertThat(contentType, is("application/octet-stream"));
        assertThat(contentLength, is(not(0)));
    }	

	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
}

