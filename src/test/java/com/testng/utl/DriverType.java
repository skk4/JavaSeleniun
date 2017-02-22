package com.testng.utl;


import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public enum DriverType {
    InternetExplorer {

        @Override
        public WebDriver getDriver() {

            if (!StringUtils.isEmpty(ConfigurationSettings.WEBDRIVER_IE_DRIVER_PATH)) {
                System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,ConfigurationSettings.WEBDRIVER_IE_DRIVER_PATH);
            }

            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
            ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);

            return new InternetExplorerDriver(ieCapabilities);
        }
    },
    Firefox {
        @Override
        public WebDriver getDriver() {
            return new FirefoxDriver();
        }
    },
    Chrome {
        @Override
        public WebDriver getDriver() {

            if (!StringUtils.isEmpty(ConfigurationSettings.WEBDRIVER_CHROME_DRIVER_PATH)) {
                System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,ConfigurationSettings.WEBDRIVER_CHROME_DRIVER_PATH);
            }
            return new ChromeDriver();
        }
    };
    public abstract WebDriver getDriver();
}