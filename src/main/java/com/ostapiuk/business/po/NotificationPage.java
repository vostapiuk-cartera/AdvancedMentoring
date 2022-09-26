package com.ostapiuk.business.po;

import com.ostapiuk.core.decorator.elements.TextField;
import com.ostapiuk.core.driver.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationPage extends BasePage {

    @FindBy(css = "[class|='notificationItem__message-container']")
    private WebElement root;

    @FindBy(css = "[class|='notificationItem__message-container'] p")
    private TextField text;

    public boolean isNotificationDisplayed() {
        Wait.waitOnElementToBeVisible(root);
        return root.isDisplayed();
    }

    public String getNotificationText() {
        return text.getText();
    }

    public void closeNotification() {
        root.click();
    }
}
