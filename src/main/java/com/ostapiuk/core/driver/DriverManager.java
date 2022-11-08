package com.ostapiuk.core.driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.ScreenShooter;
import com.ostapiuk.core.listener.Highlighter;
import com.ostapiuk.core.properties.ConfigProperties;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.WebDriverRunner.addListener;

public class DriverManager {

    @SneakyThrows
    public static void setUpDriver() {
        if (!WebDriverRunner.hasWebDriverStarted()) {
            Configuration.timeout = 5000;
            startMaximized = true;
            pageLoadStrategy = "normal";
            String type = ConfigProperties.getDriverTypeProperty();
            baseUrl = ConfigProperties.getBaseSecureUrlProperty();
            switch (type) {
                case "chrome":
                    Configuration.remote = "http://localhost:4444/wd/hub";
                    Configuration.browser = "chrome";
                    Configuration.browserSize = "1920x1080";
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability("enableVNC", true);
                    capabilities.setCapability("enableVideo", true);
                    Configuration.browserCapabilities = capabilities;
                    break;
                case "firefox":
                    Configuration.remote = "http://localhost:4444/wd/hub";
                    Configuration.browser = "firefox";
                    Configuration.browserSize = "1920x1080";
                    DesiredCapabilities firefoxCapabilities = new DesiredCapabilities();
                    firefoxCapabilities.setCapability("enableVNC", true);
                    firefoxCapabilities.setCapability("enableVideo", true);
                    Configuration.browserCapabilities = firefoxCapabilities;
                    break;
            }
            addListener(new Highlighter());
            screenshots = true;
            reportsFolder = "test-result/reports";
            ScreenShooter.captureSuccessfulTests = true;
        }
    }
}
