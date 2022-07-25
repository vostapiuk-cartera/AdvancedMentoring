package com.ostapiuk.business.po;

import com.ostapiuk.core.decorator.elements.Button;
import com.ostapiuk.core.decorator.elements.Link;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy(css = "[class*='pageLayout__page-header'] [class*='pageBreadcrumbs'] span")
    private Link headerLink;

    @FindBy(xpath = "//span[text()='Edit']")
    private Button editButton;

    @FindBy(xpath = "//span[text()='Delete']")
    private Button deleteButton;

    public String getHeaderLinkTitle() {
        return headerLink.getText();
    }

    public void clickEditDashboardButton() {
        editButton.click();
    }

    public void clickDeleteDashboardButton() {
        deleteButton.click();
    }
}
