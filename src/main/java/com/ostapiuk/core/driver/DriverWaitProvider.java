package com.ostapiuk.core.driver;

import com.ostapiuk.core.properties.ConfigProperties;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWaitProvider {
    private static WebDriverWait webDriverWait;
    private static final int EXPLICIT_WAIT = ConfigProperties.getExplicitWait();

    private DriverWaitProvider() {

    }

    public static WebDriverWait getInstance() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(DriverProvider.getDriver(), EXPLICIT_WAIT);
        }
        return webDriverWait;
    }
}
