package com.testng.page;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

/**
 * <p>The <b>Page Object</b> pattern represents the screens of your web app as a series of
 * objects.</p>
 * 
 * <p>PageObjects can be thought of as facing in two directions simultaneously.
 * Facing towards the developer of a test, they represent the services offered
 * by a particular page. Facing away from the developer, they should be the only
 * thing that has a deep knowledge of the structure of the HTML of a page (or
 * part of a page) It's simplest to think of the methods on a Page Object as
 * offering the "services" that a page offers rather than exposing the details
 * and mechanics of the page.</p>
 * 
 * @see <a href="http://code.google.com/p/webdriver/wiki/PageObjects">Page Objects Wiki</a>
 * 
 * @author xiesj
 */
public abstract class Page implements SearchContext{

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected WebDriver driver = null;

    public Page(WebDriver driver) {
        if (null == driver) {
            throw new IllegalArgumentException("WebDriver cannot be null.");
        }
        this.driver = driver;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    /**
     * 获得当前的地址
     * @return
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     *  获取某个元素
     */
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    /**
     * 获取符合
     */
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

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
    
    /**
     * 加载页面，并等待加载完成。
     * @param url
     */
    public void openAndWait(String url) {
        Selenium selenium = new WebDriverBackedSelenium(driver,url);
        driver.get(url);
        selenium.waitForPageToLoad("5000");
    }

    /**
     * 用于等待某个元素出现,软等待
     * @param by
     */
    public boolean wait(final By by){
        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver arg0) {
                return arg0.findElement(by).isDisplayed();
            }
        });
        return true;
    }

    /**
     * 处理页面上弹出的Alert()
     * @param option
     */
    public Alert getAlert(){
        sleep(2);
        Alert alert = driver.switchTo().alert();
        return alert;
    }

    /**
     * 模拟键盘箭头向下，然后回车。即，模拟下拉选中
     */
    public void KeyDownAndEnter(){
        sleep(1);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }

    /**
     * 模拟键盘回车
     */
    public void KeyEnter(){
        sleep(1);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    /**
     * 关闭当前页面，并将焦点放到打开的新页面
     */
    public void switchToNewPage(){
        sleep(1);
        String handleNew="";
        for (String handle : driver.getWindowHandles()) {
            handleNew=handle;
        }
        driver.close();
        sleep(1);
        driver.switchTo().window(handleNew);
    }

}