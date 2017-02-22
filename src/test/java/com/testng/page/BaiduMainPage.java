package com.testng.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BaiduMainPage extends Page{

    public BaiduMainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * 输入文本input
     */
    @FindBy(how=How.ID,using="kw")
    WebElement inputbox;

    /**
     * 查询按钮
     */
    @FindBy(how=How.ID, using="su")
    WebElement submitbox;

    /**
     * 新闻链接
     */
    @FindBy(linkText="新闻")
    WebElement newsIndex;

    /**
     * 输入待搜素文本
     * @param text
     */
    public void SearchText(String text) {
        inputbox.sendKeys(text);
        submitbox.click();
    }

    public void clickNewsIndex() {
        newsIndex.click();
    }
}