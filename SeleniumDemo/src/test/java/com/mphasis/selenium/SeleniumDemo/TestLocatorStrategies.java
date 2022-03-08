package com.mphasis.selenium.SeleniumDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestLocatorStrategies {
	
	private WebDriver driver;
	private String url;
  @Test
  public void testFindById() throws InterruptedException{
	  WebElement nameEle=driver.findElement(By.id("firstName"));
	  nameEle.sendKeys("pavan");
	  
	  WebElement lastnameEle=driver.findElement(By.id("lastName"));
	  lastnameEle.sendKeys("kumar");
	  
	  WebElement emailele=driver.findElement(By.id("userEmail"));
	  emailele.sendKeys("pavan@gmail.com");
	  
	  Thread.sleep(4000);
	  
	  WebElement radioMale=driver.findElement(By.id("gender-radio-1"));
	  
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  js.executeScript("arguments[0].click()", radioMale);
	 // radioMale.click();
	  
	  WebElement phoneele=driver.findElement(By.id("userNumber"));
	  phoneele.sendKeys("123456789"); 
	  
	  WebElement date=driver.findElement(By.id("dateOfBirthInput"));
	  date.sendKeys("05 Feb 2000");
	  date.sendKeys(Keys.ESCAPE);
	  
	  driver.findElement(By.id("subjectInput")).sendKeys("xyz");
      //Thread.sleep(9000);
      
      WebElement chkbox1 = driver.findElement(By.id("hobbies-checkbox-1"));
      //chkbox1.click();
      
      js =(JavascriptExecutor) driver;
      js.executeScript("arguments[0].click()", chkbox1);
      
      Thread.sleep(3000);
      
      js.executeScript("window.scroll(0,380)");
      WebElement fileele=driver.findElement(By.id("uploadPicture"));
      System.out.println(fileele.getAttribute("type"));
      
      fileele.sendKeys("C:/Users/PAVAN KUMAR/chromedriver.exe");
	 // fileele.click();
      
      //js.executeScript("arguments[0].click()", fileele);
	  Thread.sleep(9000);

  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:/Users/PAVAN KUMAR/chromedriver.exe");
	  driver=new ChromeDriver();
	  url="https://demoqa.com/automation-practice-form";
	  driver.navigate().to(url);
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
