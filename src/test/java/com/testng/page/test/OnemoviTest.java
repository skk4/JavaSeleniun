package com.testng.page.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OnemoviTest {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "//Applications//Google Chrome.app//Contents//MacOS//chromedriver");
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://onemovi.gray.yoya.com");
	  Thread.sleep(3000);
	  driver.findElement(By.id("username")).sendKeys("t-qiaohu-00001");
	  driver.findElement(By.id("password")).sendKeys("123456");
	  driver.findElement(By.id("login_button")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.linkText("基础管理")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id='member_department_list']/div/div[1]/span/span[2]/a[1][@class='doAdd']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id("dept_name")).sendKeys("222");
	  Thread.sleep(3000);
	  driver.findElement(By.id("subBtn")).click();
	  Thread.sleep(3000);
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {

	  
  }

  @AfterTest
  public void afterTest() {
	
  }

}
