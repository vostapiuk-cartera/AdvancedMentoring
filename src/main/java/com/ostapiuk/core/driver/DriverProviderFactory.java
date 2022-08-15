package com.ostapiuk.core.driver;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum DriverProviderFactory {
    CHROME {
        @Override
        public WebDriver create() {
//            new ChromeDriverLoader().loadChromeDriver();
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            ChromeOptions options = new ChromeOptions().setHeadless(true);
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


