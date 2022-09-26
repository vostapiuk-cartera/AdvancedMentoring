package com.ostapiuk.business.validator;

import com.ostapiuk.business.model.enums.TestData;
import com.ostapiuk.business.po.DashboardPage;
import com.ostapiuk.business.po.HomePage;
import com.ostapiuk.business.po.LaunchesPage;
import com.ostapiuk.business.po.NotificationPage;
import com.ostapiuk.core.logger.Log;
import org.testng.asserts.SoftAssert;

public class DataPresenceValidator {
    NotificationPage notificationPage;
    DashboardPage dashboardPage;
    HomePage homePage;
    LaunchesPage launchesPage;
    SoftAssert softAssert;

    public DataPresenceValidator() {
        notificationPage = new NotificationPage();
        dashboardPage = new DashboardPage();
        homePage = new HomePage();
        launchesPage = new LaunchesPage();
        softAssert = new SoftAssert();
    }

    public void verifyLaunchContainsData(String launchName) {
        for (TestData data : TestData.values()) {
            Log.log("Verify column " + data);
            softAssert.assertTrue(launchesPage.hasPresentColumnWithData(launchName, data.locator), "Column " + data + " is not present in table for launch #" + launchName);
        }
        softAssert.assertAll();
    }

    public void verifyLaunchSuiteContainsData() {
        for (TestData data : TestData.values()) {
            Log.log("Verify column " + data);
            softAssert.assertTrue(launchesPage.hasPresentColumnInHeader(data.name), "Column " + data + " is not present in table header");
        }
        softAssert.assertAll();
    }

    public void verifyLaunchHasFilledFields(String launchName) {
        for (TestData data : TestData.values()) {
            if (data.isRequired) {
                Log.log("Verify column " + data);
                softAssert.assertTrue(launchesPage.hasPresentValueInColumn(launchName, data.locator), "Column " + data + " has not filled value in table for launch #" + launchName);
            }
        }
        softAssert.assertAll();
    }
}
