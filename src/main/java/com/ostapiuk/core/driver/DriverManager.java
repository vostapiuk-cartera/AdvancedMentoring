package com.ostapiuk.core.driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.ScreenShooter;
import com.ostapiuk.core.listener.Highlighter;
import com.ostapiuk.core.properties.ConfigProperties;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.WebDriverRunner.addListener;

public class DriverManager {

    public static void setUpDriver() {
        if (!WebDriverRunner.hasWebDriverStarted()) {
            Configuration.timeout = 5000;
            startMaximized = true;
            pageLoadStrategy = "normal";
            String type = ConfigProperties.getDriverTypeProperty();
            baseUrl = ConfigProperties.getBaseSecureUrlProperty();
            switch (type) {
                case "chrome":
                    browser = "chrome";
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-web-security");
                    browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    break;
                case "firefox":
                    browser = "firefox";
                    break;
            }
            addListener(new Highlighter());
            screenshots = true;
            reportsFolder = "test-result/reports";
            ScreenShooter.captureSuccessfulTests = true;
        }
    }
}
