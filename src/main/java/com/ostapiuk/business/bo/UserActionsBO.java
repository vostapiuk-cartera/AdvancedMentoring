package com.ostapiuk.business.bo;

import com.ostapiuk.business.po.*;
import com.ostapiuk.core.properties.DataProperties;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class UserActionsBO {
    NotificationPage notificationPage;
    SettingsPage settingsPage;
    HomePage homePage;
    LogInBO logInBO;
    CreateDashboardPage createDashboardPage;
    DashboardPage dashboardPage;

    public UserActionsBO() {
        logInBO = new LogInBO();
        settingsPage = new SettingsPage();
        homePage = new HomePage();
        notificationPage = new NotificationPage();
        createDashboardPage = new CreateDashboardPage();
        dashboardPage = new DashboardPage();
    }

    public void openGeneralSettings() {
        homePage.isPageViewDisplayed();
        homePage.clickSettingsButton();
    }

    public void changeGeneralSettings() {
        WebElement dropdown = settingsPage.getRandomDropdown();
        String oldValue = settingsPage.getDropdownValue(dropdown);
        settingsPage.clickDropdown(dropdown);
        settingsPage.selectNewRandomDropdownOption(oldValue);
        String newValue = settingsPage.getDropdownValue(dropdown);
        settingsPage.clickSubmitButton();
        Assert.assertNotEquals(newValue, oldValue, "General option setting is not changed");
    }

    public void createNewDashboard() {
        homePage.clickAddDashboardButton();
        createDashboardPage.isCreateDashboardDisplayed();
        createDashboardPage.enterName(DataProperties.getDashboardName());
        createDashboardPage.enterDescription(DataProperties.getDashboardDescription());
        createDashboardPage.clickAddButton();
    }

    public void updateDashboard() {
        dashboardPage.clickEditDashboardButton();
        createDashboardPage.isCreateDashboardDisplayed();
        createDashboardPage.enterName(DataProperties.getDashboardNewName());
        createDashboardPage.clickUpdateButton();
    }

    public void deleteDashboard() {
        dashboardPage.clickDeleteDashboardButton();
        DeleteDashboardPage deleteDashboardPage = new DeleteDashboardPage();
        deleteDashboardPage.isDeleteDashboardDisplayed();
        deleteDashboardPage.clickDeleteButton();
    }
}
