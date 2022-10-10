package com.ostapiuk.business.bo;

import com.ostapiuk.business.po.HomePage;
import com.ostapiuk.business.po.LaunchesPage;
import com.ostapiuk.business.po.NotificationPage;

public class NavigationBO {

    HomePage homePage;
    LaunchesPage launchesPage;
    NotificationPage notificationPage;

    public NavigationBO() {
        homePage = new HomePage();
        launchesPage = new LaunchesPage();
        notificationPage = new NotificationPage();
    }

    public void openGeneralSettings() {
        homePage.waitOnPageViewDisplay();
        homePage.clickSettingsButton();
    }

    public void openLaunchesTable() {
        notificationPage.closeNotification();
        homePage.waitOnPageViewDisplay();
        homePage.clickLaunchesButton();
        launchesPage.waitOnLaunchTableDisplay();
    }

    public void openLaunchesTestSuite(String suite) {
        openLaunchesTable();
        launchesPage.clickOnLaunchWithName(suite);
    }
}
