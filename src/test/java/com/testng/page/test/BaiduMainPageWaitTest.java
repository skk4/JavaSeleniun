package com.testng.page.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.page.BaiduMainPage;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class BaiduMainPageWaitTest{

    protected WebDriver driver = null;

    protected Selenium  selenium = null;

    protected BaiduMainPage page = null;

    @BeforeClass
    public void init() {
       // System.setProperty("webdriver.ie.driver","lib\\IEDriverServer.exe");

       // DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
       // ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);

        /**
         * <b>WebDriverBackedSelenium </b>
         * Allows for WebDriver and Selenium to live side-by-side.<br/>
         * Provides a simple mechanism for a managed migration from the 
         * existing Selenium API to WebDriver's.<br/>
         * Does not require the standalone Selenium RC server to be run.<br/>
         */
       // driver = new InternetExplorerDriver(ieCapabilities);
    	 //driver = new FirefoxDriver();
    	driver = new ChromeDriver();
    }

    @BeforeMethod
    public void initPage() {
        String path = "http://www.baidu.com/";
        page = new BaiduMainPage(driver);

        selenium = new WebDriverBackedSelenium(driver,path);

    //  selenium.open(path);
        driver.get(path);

        selenium.waitForPageToLoad("5000");

        PageFactory.initElements(driver, page);
    }
    
    
    @Test
    public void testSearch(){
        String text="apple";
        page.SearchText(text);
        page.sleep(5);
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

    /**
     * After creating a WebDriverBackedSelenium instance with a given Driver, 
     * one does not have to call start() - as the creation of the Driver already started the session.
     * At the end of the test, stop() should be called instead of the Driver's quit() method.
     *
     * @see <a href="https://code.google.com/p/selenium/wiki/SeleniumEmulation">Selenium Emulation  Wiki</a>
     */
    @AfterClass
    public void quit() {
        try{
            selenium.stop();
            if(driver != null)
                driver.quit();
        }   finally {
            driver = null;
        }
    }
}