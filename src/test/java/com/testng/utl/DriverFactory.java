package com.testng.utl;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {
    private static DriverType DEFAULT_DRIVER_TYPE = DriverType.Firefox;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    private static DriverFactory instance = null;

    static {
        instance = new DriverFactory();
    }

    public static DriverFactory getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        DriverType type = DEFAULT_DRIVER_TYPE;
        try {
            type = Enum.valueOf(DriverType.class, ConfigurationSettings.WEBDRIVER_TYPE);
        }
        catch (Exception ex) {
            logger.warn("Parse WebDriver.Type failed, use default driver type: " + DEFAULT_DRIVER_TYPE.name());
            logger.debug(ex.getMessage(), ex);
        }
        return type.getDriver();
    }
}