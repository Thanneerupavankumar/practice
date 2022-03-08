package com.mphasis.selenium.SeleniumDemo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLocatorByName {
	
	private WebDriver driver;
	private String url;
	
	 @BeforeMethod
	  public void beforeMethod() {
		  System.setProperty("webdriver.chrome.driver","C:/Users/PAVAN KUMAR/chromedriver.exe");
		  driver=new ChromeDriver();
		  url="https://studio.code.org/users/sign_up";
		  driver.navigate().to(url);
		  driver.manage().window().maximize();
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.close();
	  }
  @Test
  public void testByNameStrategy() throws InterruptedException{
	  WebElement emailele=driver.findElement(By.name("user[email]"));
	  emailele.sendKeys("pavan@gmail.com");
	  
	  WebElement pwd=driver.findElement(By.name("user[password]"));
	  pwd.sendKeys("pavan");
	  
	  driver.findElement(By.name("user[password_confirmation]")).sendKeys("pavan");
	  driver.findElement(By.className("submit")).click();
	  
	  String excepted="has already been taken";
	  String actual=driver.findElement(By.className("error")).getText();
	  assertEquals(actual,excepted);
	  Thread.sleep(2000);
	  
  }
}
