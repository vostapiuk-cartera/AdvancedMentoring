package com.ostapiuk.business.po;

import com.ostapiuk.core.decorator.elements.Button;
import com.ostapiuk.core.driver.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "[class^=layout__page-container--]")
    private WebElement pageView;

    @FindBy(css = "[href*='settings']")
    private Button settingsButton;

    @FindBy(css = "[href*='launches']")
    private Button launchesButton;

    @FindBy(css = "div[class^='addDashboardButton'] button")
    private Button addDashboardButton;

    @FindBy(css = "[class*='gridRow__grid-row'] a")
    private List<WebElement> dashboards;

    public boolean waitOnPageViewDisplay() {
        Wait.waitOnElementToBeVisible(pageView);
        return pageView.isDisplayed();
    }

    public void clickSettingsButton() {
        settingsButton.click();
    }

    public void clickLaunchesButton() {
        launchesButton.click();
    }

    public void clickAddDashboardButton() {
        addDashboardButton.clickAfterWait();
    }

    public boolean isInDashboardList(String dashboardName) {
        return dashboards.stream()
                .noneMatch(el -> el.getText().equals(dashboardName));
    }
}
