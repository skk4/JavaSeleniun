package com.testng.utl;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ScreenShotListener extends TestListenerAdapter {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    protected ITestContext testContext = null;

     public String getTestName(ITestResult it){        
            return  it.getTestClass().getName() +"."+ it.getName()+it.getEndMillis();   
        }


    @Override
    public void onStart(ITestContext testContext) {
        this.testContext = testContext;
        super.onStart(testContext);
    }


    @Override
    public void onFinish(ITestContext testContext) {
        this.testContext = null;
        super.onFinish(testContext);
    }


    @Override
    public void onTestSuccess(ITestResult tr) {
        logger.info("TestSuccess:" + getTestName(tr));
        String path = ConfigurationSettings.SCREENSHOT_SUCESS_PATH + "/" + getTestName(tr)+".png";
        WebDriver driver = (WebDriver) testContext.getAttribute(ConfigurationSettings.SELENIUM_DRIVER);
        ScreenShotUtil.ScreenShoter(driver, path);
        super.onTestSuccess(tr);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        logger.info("TestFailure:"+ getTestName(tr));
        String path = ConfigurationSettings.SCREENSHOT_ERROR_PATH + "/" + getTestName(tr)+".png";
        WebDriver driver = (WebDriver) testContext.getAttribute(ConfigurationSettings.SELENIUM_DRIVER);
        ScreenShotUtil.ScreenShoter(driver, path);
        super.onTestFailure(tr);
    }

}