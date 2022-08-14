package com.ostapiuk.core.driver;

import com.ostapiuk.core.properties.ConfigProperties;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URL;
import java.util.Objects;

public enum DriverProviderFactory {
    CHROME {
        @Override
        public WebDriver create() {
            String driverName = System.getProperty("os.name").toLowerCase().contains("win") ? ConfigProperties.getWindowsDriverNameProperty()
                    : ConfigProperties.getLinuxDriverNameProperty();
            URL realData = getClass().getClassLoader().getResource(driverName);
            System.setProperty("webdriver.chrome.driver", Objects.requireNonNull(realData).getPath());
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            return new ChromeDriver(options);
        }
    }, FIREFOX {
        @Override
        public WebDriver create() {
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            return new FirefoxDriver();
        }
    };

    public abstract WebDriver create();
}


