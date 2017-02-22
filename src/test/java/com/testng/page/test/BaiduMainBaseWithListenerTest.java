package com.testng.page.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.testng.page.BaiduMainPage;
import com.testng.utl.ScreenShotListener;

@Listeners({ScreenShotListener.class})
public class BaiduMainBaseWithListenerTest extends TestBase {

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
        sleep(1);
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains(text));
        System.out.println(page.getCurrentUrl());
    }   
}  