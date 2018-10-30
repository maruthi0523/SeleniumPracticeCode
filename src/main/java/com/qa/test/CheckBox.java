package com.qa.test;

		import org.openqa.selenium.By;		
		import org.openqa.selenium.WebDriver;		
		import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;		

		public class CheckBox {	
			private WebDriver driver;
			private String baseUrl;
		
		   	 	@BeforeTest	
		    	public void setUp() throws Exception {
		   	 	System.setProperty("webdriver.chrome.driver", "..//SeleniumPracticeCode//Driver//chromedriver");
				driver = new ChromeDriver();
				baseUrl = "http://demo.guru99.com/test/login.html";
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}				
		        @Test	
		        public void checkbox() throws Exception {
		        /*driver.get(baseUrl);
		       WebElement email = driver.findElement(By.id("email"));								
		        WebElement password = driver.findElement(By.name("passwd"));							
		        email.sendKeys("abcd@gmail.com");					
		        password.sendKeys("abcdefghlkjl");				     				    		
		        // email.clear();	     
		        //  password.clear();		 							
		        WebElement login = driver.findElement(By.id("SubmitLogin")).click();									        		
		        email.sendKeys("abcd@gmail.com");					
		        password.sendKeys("abcdefghlkjl");					
		        login.click();	*/							
		        driver.get(baseUrl);					
		        driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");							
		        driver.findElement(By.name("passwd")).sendKeys("abcdefghlkjl");							
		        driver.findElement(By.id("SubmitLogin")).submit();					 
		        driver.get("http://demo.guru99.com/test/radio.html");					
		        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));							
		        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));							
		        radio1.click();			   		
		        radio2.click();			
		     	WebElement option1 = driver.findElement(By.id("vfb-6-0"));							
                option1.click();			
 if (option1.isSelected()) {					
		         					
		        }
 else {			
		         					
		        }		
		         	
		   /*     driver.get("http://demo.guru99.com/test/facebook.html");					
		        WebElement chkFBPersist = driver.findElement(By.id("persist_box"));							
		        for (int i=0; i<2; i++) {											
		            chkFBPersist.click (); 	
		        }*/
		        							
		        }	
		        @AfterTest
		        public void terminateBrowser() {
					driver.quit(); 		
		    }		
		}
	
	   									
	    		
	    	
	      				
	         
	        	
	      

