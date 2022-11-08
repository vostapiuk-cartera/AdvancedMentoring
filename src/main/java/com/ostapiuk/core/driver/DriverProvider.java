package com.ostapiuk.core.driver;

import com.codeborne.selenide.Selenide;
import com.ostapiuk.core.properties.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class DriverProvider {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    static {
        System.setProperty(ConfigProperties.getDriverNameProperty(), ConfigProperties.getDriverPathProperty());
    }

    private DriverProvider() {
    }

    public static WebDriver getDriver() {
        return Selenide.webdriver().object();
    }

    public static void quit() {
        if (Objects.nonNull(driver.get())) {
            driver.get().quit();
            driver.set(null);
        }
    }

    private static void setTimeout() {
        driver.get()
                .manage()
                .timeouts()
                .implicitlyWait(ConfigProperties.getImplicitWaitProperty(), TimeUnit.SECONDS)
                .pageLoadTimeout(ConfigProperties.getPageLoadWaitProperty(), TimeUnit.SECONDS);
        driver.get()
                .manage()
                .window()
                .maximize();
    }
}
