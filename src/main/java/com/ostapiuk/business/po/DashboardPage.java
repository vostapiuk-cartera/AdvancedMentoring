package com.ostapiuk.business.po;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.ostapiuk.core.decorator.elements.Button;
import com.ostapiuk.core.decorator.elements.Link;
import com.ostapiuk.core.exception.WidgetNumberException;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage extends BasePage {

    @FindBy(css = "[class*='pageLayout__page-header'] [class*='pageBreadcrumbs'] span")
    private Link headerLink;

    @FindBy(xpath = "//span[text()='Edit']")
    private Button editButton;

    @FindBy(xpath = "//span[text()='Delete']")
    private Button deleteButton;

    private final ElementsCollection widgets = $$(".react-grid-item");

    public String getHeaderLinkTitle() {
        return headerLink.getText();
    }

    public void clickEditDashboardButton() {
        editButton.click();
    }

    public void clickDeleteDashboardButton() {
        deleteButton.click();
    }

    public SelenideElement getWidgetByNumber(int number) {
        if (number > widgets.size() - 1) {
            throw new WidgetNumberException("Widget is not present, chose another one");
        }
        return widgets.get(number);
    }

    public SelenideElement getWidgetResizeButton(SelenideElement widget) {
        return widget.$(".react-resizable-handle");
    }

    public SelenideElement getWidgetContentItem(SelenideElement widget) {
        return widget.$("[class*='widget__widget--']");
    }
}
