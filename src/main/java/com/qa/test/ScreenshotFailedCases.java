    package com.qa.test;
	import java.io.File;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.Assert;
    import org.testng.ITestResult;
	import org.testng.annotations.AfterMethod;
    import org.testng.annotations.BeforeMethod;
    import org.testng.annotations.Test;

	public class ScreenshotFailedCases {
		
		static WebDriver driver;
		static String baseUrl;
		
		@BeforeMethod
		public static void captureScreen() throws Exception{
			System.setProperty("webdriver.chrome.driver", "..//SeleniumPracticeCode//Driver//chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			baseUrl="http://elmsnew.hbfxlabs.com/";			
		}
		@Test  
		
		public void screenShot(){
			
			try{
	            driver.get(baseUrl);
				driver.findElement(By.id("emailId")).sendKeys("admin@gmail.com");
					driver.findElement(By.id("password")).sendKeys("Passoword123");
					Thread.sleep(2000);
					String actual = driver.findElement(By.className("form-control-error")).getText();
					Assert.assertEquals(actual, "Password must be includes one UpperCase, LowerCase, Number/Special Chars required");
					
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		
			@AfterMethod
			 public void tearDown(ITestResult result)
			  {
				  System.out.println("in teardown");
				  System.out.println(result.getStatus());
				  System.out.println(result.getName());
				  
			  if(ITestResult.FAILURE==result.getStatus())
			  {
			  try 
			  {
			  TakesScreenshot ts=(TakesScreenshot)driver;

			  File source=ts.getScreenshotAs(OutputType.FILE);

			  String dest = "/home/css/Downloads/downloadfloder" +result.getName()+".png";
			  File destination = new File(dest);
			  FileUtils.copyFile(source, destination);

			  System.out.println("Screenshot taken");
			  } 
			  catch (Exception e)
			  {

			  System.out.println("Exception while taking screenshot "+e.getMessage());
			  } 

			  }
			  
			  driver.quit();
			  }	

		}
