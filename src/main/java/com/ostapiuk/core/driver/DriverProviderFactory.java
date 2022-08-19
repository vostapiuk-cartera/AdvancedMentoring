package com.ostapiuk.core.driver;

import com.ostapiuk.core.exception.DriverDockerException;
import com.ostapiuk.core.properties.ConfigProperties;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public enum DriverProviderFactory {
    CHROME {
        @Override
        public WebDriver create() {
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            try {
                return new RemoteWebDriver(new URL(ConfigProperties.getDriverUrlProperty()), options);
            } catch (MalformedURLException e) {
                throw new DriverDockerException("Driver can't be run from docker", e);
            }
        }
    }, FIREFOX {
        @Override
        public WebDriver create() {
            FirefoxOptions options = new FirefoxOptions();
            try {
                return new RemoteWebDriver(new URL(ConfigProperties.getDriverFirefoxUrlProperty()), options);
            } catch (MalformedURLException e) {
                throw new DriverDockerException("Driver can't be run from docker", e);
            }
        }
    };

    public abstract WebDriver create();
}


