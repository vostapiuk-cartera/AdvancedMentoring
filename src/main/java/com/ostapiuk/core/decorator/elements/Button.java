package com.ostapiuk.core.decorator.elements;

import com.ostapiuk.core.decorator.BaseElement;
import com.ostapiuk.core.driver.Wait;
import com.ostapiuk.core.logger.Log;
import org.openqa.selenium.WebElement;

public class Button extends BaseElement {

    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        Log.log("Clicking on button with location: " + webElement.getLocation());
        Wait.waitOnElementToBeClickable(webElement);
        webElement.click();
    }

    public void clickAfterWait() {
        Log.log("Clicking on button after wait");
        Wait.waitOnElementUntilClick(webElement);
    }
}
