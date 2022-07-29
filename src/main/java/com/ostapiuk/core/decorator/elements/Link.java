package com.ostapiuk.core.decorator.elements;

import com.ostapiuk.core.decorator.BaseElement;
import com.ostapiuk.core.driver.Wait;
import com.ostapiuk.core.logger.Log;
import org.openqa.selenium.WebElement;

public class Link extends BaseElement {

    public Link(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        Log.log("Clicking on link with location: " + webElement.getLocation());
        Wait.waitOnElementToBeClickable(webElement);
        webElement.click();
    }

    public boolean isDisplayed() {
        Log.log("Checking is link element displayed");
        return webElement.isDisplayed();
    }

    public String getText() {
        Log.log("Checking is link element displayed");
        return webElement.getAttribute("title");
    }
}
