package com.ostapiuk.core.driver;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Wait {

    private static final int EXPLICIT_WAIT = 30;
    private static final int POLLING_TIME = 10;

    private Wait() {
        throw new IllegalStateException("Utility class");
    }

    public static void waitOnElementToBeClickable(WebElement webElement) {
        DriverWaitProvider.getInstance().until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitOnElementToAppear(SelenideElement webElement) {
        webElement.waitUntil(Condition.appear, EXPLICIT_WAIT, POLLING_TIME);
    }

    public static void waitOnElementToBeVisible(WebElement webElement) {
        DriverWaitProvider.getInstance().until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitOnElementToBeVisible(SelenideElement webElement) {
        webElement.shouldBe(Condition.visible, Duration.ofSeconds(EXPLICIT_WAIT)).shouldNotBe(Condition.hidden);
    }

    public static void waitOnElementUntilClick(WebElement webElement) {
        DriverWaitProvider.getInstance()
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .until(driver -> {
                    webElement.click();
                    return true;
                });
    }
}