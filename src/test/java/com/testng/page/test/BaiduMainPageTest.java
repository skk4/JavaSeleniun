package com.testng.page.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.page.BaiduMainPage;

public class BaiduMainPageTest{

    protected WebDriver driver = null;

    protected BaiduMainPage page = null;

    @BeforeClass
    public void init() {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void initPage() {
        String path = "http://www.baidu.com/";
        driver.get(path);
        page = new BaiduMainPage(driver);
        PageFactory.initElements(driver, page);
    }

    @Test
    public void testSearch() throws InterruptedException{
        String text="apple";
        page.SearchText(text);
        Thread.sleep(5000);
        Assert.assertTrue(driver.getTitle().contains(text));
        System.out.println(page.getCurrentUrl());
    }

    @Test
    public void testnews(){
        page.clickNewsIndex();
        page.sleep(2);
        System.out.println(page.getCurrentUrl());
        Assert.assertTrue(page.getCurrentUrl().contains("news.baidu.com"));
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}