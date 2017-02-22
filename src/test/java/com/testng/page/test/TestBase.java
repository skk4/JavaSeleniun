package com.testng.page.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.testng.utl.ConfigurationSettings;
import com.testng.utl.DriverFactory;

public abstract class TestBase {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    protected WebDriver driver = null;
    protected ITestContext testContext = null;

    /**
     * 用于硬性的等待
     * @param seconds
     */
    public void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @BeforeClass(alwaysRun = true)
    public void setUpTestBase(ITestContext testContext) {
        try{
            driver = DriverFactory.getInstance().getDriver();
            this.testContext = testContext;
            testContext.setAttribute(ConfigurationSettings.SELENIUM_DRIVER, driver);
         } catch(Exception e ) {
             quitDriver();
             Assert.fail("SetUp failed.", e);
         }
    }    
    
    /*未加截屏
    @BeforeClass(alwaysRun = true)
    public void setUpTestBase(ITestContext testContext) {
        try{
            driver = DriverFactory.getInstance().getDriver();
         } catch(Exception e ) {
             quitDriver();
             Assert.fail("SetUp failed.", e);
         }
    }

*/
    @AfterClass
    public void quitDriver() {
        /*
    	try{
            if(driver != null)
                driver.quit();
        }   finally {
            driver = null;
        }
        */
    	driver.quit();
    }

}