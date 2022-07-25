package com.ostapiuk.business.po;

import com.ostapiuk.core.decorator.elements.Button;
import com.ostapiuk.core.driver.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteDashboardPage extends BasePage {

    @FindBy(xpath = "//button[text()='Delete']")
    private Button deleteButton;

    @FindBy(css = "[class*='modalLayout__modal-window']")
    private WebElement dashboardSection;

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public boolean isDeleteDashboardDisplayed() {
        Wait.waitOnElementToBeVisible(dashboardSection);
        return dashboardSection.isDisplayed();
    }
}
