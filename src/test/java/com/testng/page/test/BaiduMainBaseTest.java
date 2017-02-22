package com.testng.page.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.page.BaiduMainPage;

public class BaiduMainBaseTest extends TestBase {

    BaiduMainPage page = null;

    @BeforeMethod
    public void initPage() {
        String path = "http://www.baidu.com/";
        page = new BaiduMainPage(driver);
        page.openAndWait(path);
        PageFactory.initElements(driver, page);
    }

    @Test
    public void testSearch(){
        String text="apple";
        page.SearchText(text);
        sleep(15);
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains(text));
        System.out.println(page.getCurrentUrl());
    }

    @Test
    public void testnews(){
        System.out.println(page.getCurrentUrl());

        page.clickNewsIndex();
        page.sleep(15);
        System.out.println(page.getCurrentUrl());
        Assert.assertTrue(page.getCurrentUrl().contains("news.baidu.com"));
    }
    
    @AfterClass
    
    public void close(){
    	quitDriver();
    }

}