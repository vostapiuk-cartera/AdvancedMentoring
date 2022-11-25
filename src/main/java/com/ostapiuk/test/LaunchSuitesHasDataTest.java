package com.ostapiuk.test;

import com.ostapiuk.business.bo.LogInBO;
import com.ostapiuk.business.bo.NavigationBO;
import com.ostapiuk.business.validator.DataPresenceValidator;
import com.ostapiuk.core.driver.DriverProvider;
import com.ostapiuk.core.logger.Log;
import com.ostapiuk.core.properties.ConfigProperties;
import com.ostapiuk.core.data_providers.LaunchesProvider;
import com.ostapiuk.core.data_providers.UsersProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaunchSuitesHasDataTest extends BaseTest {

    @BeforeMethod
    public void initializeFields() {
        DriverProvider.getDriver().get(ConfigProperties.getBaseUrlProperty());
    }

    @Test(timeOut = 300000, dataProvider = "providePortalLaunches", dataProviderClass = LaunchesProvider.class, threadPoolSize = 1, invocationTimeOut = 20000)
    public void verifyLaunchSuiteHasData(String launchName) {
        LogInBO logInBO = new LogInBO();
        NavigationBO navigationBO = new NavigationBO();
        DataPresenceValidator dataPresenceValidator = new DataPresenceValidator();
        Log.log("Verify suite for launch #" + launchName + " has data");
        logInBO.logIn(UsersProvider.getSingleUser());
        navigationBO.openLaunchesTestSuite(launchName);
        dataPresenceValidator.verifyLaunchSuiteContainsData();
    }

    @AfterMethod
    public void logOut() {
        DriverProvider.quit();
    }
}
