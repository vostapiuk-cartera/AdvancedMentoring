package com.ostapiuk.business.validator;

import com.ostapiuk.business.po.DashboardPage;
import com.ostapiuk.business.po.HomePage;
import com.ostapiuk.business.po.NotificationPage;
import com.ostapiuk.core.properties.DataProperties;
import org.testng.Assert;

public class UserActionsValidator {
    NotificationPage notificationPage;
    DashboardPage dashboardPage;
    HomePage homePage;

    public UserActionsValidator() {
        notificationPage = new NotificationPage();
        dashboardPage = new DashboardPage();
        homePage = new HomePage();
    }

    public void verifyDashboardIsAdded() {
        Assert.assertTrue(notificationPage.isNotificationDisplayed(), "Notification about dashboard creation is not displayed");
        Assert.assertEquals(dashboardPage.getHeaderLinkTitle(), DataProperties.getDashboardName(), "Dashboard with new name is not created");
    }

    public void verifyDashboardIsUpdated() {
        Assert.assertTrue(notificationPage.isNotificationDisplayed(), "Notification about dashboard update is not displayed");
        Assert.assertEquals(dashboardPage.getHeaderLinkTitle(), DataProperties.getDashboardNewName(), "Dashboard with updated name is not created");
    }

    public void verifyDashboardIsDeleted() {
        Assert.assertTrue(notificationPage.isNotificationDisplayed(), "Notification about dashboard creation is not displayed");
        Assert.assertTrue(homePage.isInDashboardList(DataProperties.getDashboardNewName()), "Dashboard is still in list and isn't deleted");
    }

    public void verifyGeneralSettingAreSaved() {
        Assert.assertTrue(notificationPage.isNotificationDisplayed(), "Notification about saved settings is not displayed");
    }
}
