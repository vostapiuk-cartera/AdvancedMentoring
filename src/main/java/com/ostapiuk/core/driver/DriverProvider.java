package com.ostapiuk.core.driver;

import com.ostapiuk.core.properties.ConfigProperties;
import org.openqa.selenium.WebDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class DriverProvider {
    private static WebDriver driver = null;

    private DriverProvider() {
    }

    public static WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            driver = DriverProviderFactory.CHROME.create();
            setTimeout();
        }
        return driver;
    }

    public static WebDriver getBrowserDriver(String browser) {
        if (Objects.isNull(driver)) {
            if (browser.equals("chrome")) {
                driver = DriverProviderFactory.CHROME.create();
            } else if (browser.equals("firefox")) {
                driver = DriverProviderFactory.FIREFOX.create();
            }
            setTimeout();
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
