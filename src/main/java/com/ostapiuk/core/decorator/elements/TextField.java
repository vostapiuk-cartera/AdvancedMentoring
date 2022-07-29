package com.ostapiuk.core.decorator.elements;

import com.ostapiuk.core.decorator.BaseElement;
import com.ostapiuk.core.driver.Wait;
import com.ostapiuk.core.logger.Log;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TextField extends BaseElement {

    public TextField(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String text) {
        Log.log("Typing textField value: " + text);
        Wait.waitOnElementToBeVisible(webElement);
        webElement.sendKeys(text);
    }

    public void typeAndEnter(String text) {
        Log.log("Typing and entering textField value: " + text);
        Wait.waitOnElementToBeClickable(webElement);
        webElement.clear();
        webElement.sendKeys(text);
        webElement.sendKeys(Keys.ENTER);
    }

    public void click() {
        Log.log("Clicking on textField with location: " + webElement.getLocation());
        Wait.waitOnElementToBeClickable(webElement);
        webElement.click();
    }

    public String getText() {
        Log.log("Getting text from textField with location: " + webElement.getLocation());
        return webElement.getText();
    }

    public String getAttribute(String attribute) {
        Log.log("Getting attribute from textField with location: " + webElement.getLocation());
        return webElement.getAttribute(attribute);
    }
}
