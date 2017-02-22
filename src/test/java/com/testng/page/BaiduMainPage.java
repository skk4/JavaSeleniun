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
     * �����ı�input
     */
    @FindBy(how=How.ID,using="kw")
    WebElement inputbox;

    /**
     * ��ѯ��ť
     */
    @FindBy(how=How.ID, using="su")
    WebElement submitbox;

    /**
     * ��������
     */
    @FindBy(linkText="����")
    WebElement newsIndex;

    /**
     * ����������ı�
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