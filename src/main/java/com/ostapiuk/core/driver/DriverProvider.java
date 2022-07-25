package com.ostapiuk.core.driver;

import com.ostapiuk.core.properties.ConfigProperties;
import org.openqa.selenium.WebDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class DriverProvider {
    private static WebDriver driver = null;

    private DriverProvider() {
        driver = DriverProviderFactory.CHROME.create();
        setTimeout();
    }

    public static WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            new DriverProvider();
        }
        return driver;
    }

    public static void quit() {
        if (Objects.nonNull(driver)) {
            driver.quit();
            driver = null;
        }
    }

    private static void setTimeout() {
        driver.manage()
                .timeouts()
                .implicitlyWait(ConfigProperties.getImplicitWaitProperty(), TimeUnit.SECONDS)
                .pageLoadTimeout(ConfigProperties.getPageLoadWaitProperty(), TimeUnit.SECONDS);
        driver.manage()
                .window()
                .maximize();
    }
}
