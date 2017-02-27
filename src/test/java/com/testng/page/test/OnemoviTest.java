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
	  driver.findElement(By.linkText("成员管理")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.id("add_user")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id='add_user_form']/div[4]/div[2]/label[2][@class='form-radio']")).click();
	  Thread.sleep(3000);
	  
	  //driver.findElement(By.xpath("//*[@id='member_department_list']/div/div[2]/span/span[2]/a[1][@class='doAdd']")).click();
	 // List<WebElement> wes=driver.findElements(By.xpath("//*[@id='member_department_list']/div/div[@class='group-name']/@title"));
	  /*
	  List<WebElement> wes=driver.findElements(By.xpath("//*[@id='member_department_list']/div/div/@title"));
	  WebElement target=null;
	  for(WebElement ws:wes){
		  if(ws.getText().trim().equalsIgnoreCase("行政部")){
			  target=ws;
			  break;
		  }
	  }
	  
	  Thread.sleep(3000);
	  target.findElement(By.xpath("/span[2]/a[1][@class='doAdd']")).click();
	 // driver.findElement(By.id("dept_name")).sendKeys("222");
	  //driver.findElement(By.id("subBtn")).click();
	  Thread.sleep(3000);
	  */
	  
  }
	  
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {

	  
  }

  @AfterTest
  public void afterTest() {
	
  }

}
