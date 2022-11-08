package com.ostapiuk.business.bo;

import com.codeborne.selenide.SelenideElement;
import com.ostapiuk.business.po.DashboardPage;
import com.ostapiuk.core.actions.ElementActions;
import com.ostapiuk.core.driver.Wait;
import org.openqa.selenium.Point;

public class ResizeBO {
    DashboardPage dashboardPage;

    public ResizeBO() {
        dashboardPage = new DashboardPage();
    }

    public Point getWidgetPosition(int widgetNumber) {
        return ElementActions.getSize(dashboardPage.getWidgetByNumber(widgetNumber));
    }

    public void resizeWidget(int widgetNumber) {
        SelenideElement widget = dashboardPage.getWidgetByNumber(widgetNumber);
        Wait.waitOnElementToBeVisible(widget);
        ElementActions.scrollByJS(widget);
        ElementActions.resize(dashboardPage.getWidgetResizeButton(widget));
    }

    public Point getWidgetContentSize(int widgetNumber) {
        SelenideElement widget = dashboardPage.getWidgetByNumber(widgetNumber);
        Wait.waitOnElementToBeVisible(widget);
        return ElementActions.getSize(dashboardPage.getWidgetContentItem(widget));
    }
}
