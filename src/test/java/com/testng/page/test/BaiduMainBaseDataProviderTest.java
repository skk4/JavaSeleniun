package com.testng.page.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.page.BaiduMainPage;
import com.testng.utl.SearchData;

public class BaiduMainBaseDataProviderTest extends TestBase {

    BaiduMainPage page = null;

    @BeforeMethod
    public void initPage() {
        String path = "http://www.baidu.com/";
        page = new BaiduMainPage(driver);
        page.openAndWait(path);
        PageFactory.initElements(driver, page);
    }

    @Test(dataProvider = "searchKey1", dataProviderClass = SearchData.class)
    public void testSearch(String text){
        page.SearchText(text);
        sleep(1);
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains(text));
        System.out.println(page.getCurrentUrl());
    }   
}  
