package com.ostapiuk.core.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Wait {
    public static void waitOnElementToBeClickable(WebElement webElement) {
        DriverWaitProvider.getInstance().until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitOnElementToBeVisible(WebElement webElement) {
        DriverWaitProvider.getInstance().until(ExpectedConditions.visibilityOf(webElement));
    }
}