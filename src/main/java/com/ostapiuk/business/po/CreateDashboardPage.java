package com.ostapiuk.business.po;

import com.ostapiuk.core.decorator.elements.Button;
import com.ostapiuk.core.decorator.elements.TextField;
import com.ostapiuk.core.driver.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateDashboardPage extends BasePage {

    @FindBy(css = "[class*='modalField'] input[type='text']")
    private TextField nameField;

    @FindBy(tagName = "textarea")
    private TextField descriptionField;

    @FindBy(xpath = "//button[text()='Add']")
    private Button addButton;

    @FindBy(xpath = "//button[text()='Update']")
    private Button updateButton;

    @FindBy(css = "[class*='modalLayout__modal-window']")
    private WebElement dashboardSection;

    public void enterName(String name) {
        nameField.typeText(name);
    }

    public void enterDescription(String description) {
        descriptionField.typeText(description);
    }

    public void clickAddButton() {
        addButton.click();
    }

    public void clickUpdateButton() {
        updateButton.click();
    }

    public boolean isCreateDashboardDisplayed() {
        Wait.waitOnElementToBeVisible(dashboardSection);
        return dashboardSection.isDisplayed();
    }
}
