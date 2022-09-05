package com.ostapiuk.core.driver;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Wait {

    private Wait() {
        throw new IllegalStateException("Utility class");
    }

    public static void waitOnElementToBeClickable(WebElement webElement) {
        DriverWaitProvider.getInstance().until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitOnElementToBeVisible(WebElement webElement) {
        DriverWaitProvider.getInstance().until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitOnElementUntilClick(WebElement webElement) {
        DriverWaitProvider.getInstance()
                .ignoring(StaleElementReferenceException.class)
                .until(driver -> {
                    webElement.click();
                    return true;
                });
    }
}