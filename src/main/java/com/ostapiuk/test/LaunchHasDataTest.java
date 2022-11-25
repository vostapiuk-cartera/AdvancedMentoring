package com.ostapiuk.test;

import com.ostapiuk.business.bo.LogInBO;
import com.ostapiuk.business.bo.NavigationBO;
import com.ostapiuk.business.validator.DataPresenceValidator;
import com.ostapiuk.core.data_providers.LaunchesProvider;
import com.ostapiuk.core.data_providers.UsersProvider;
import com.ostapiuk.core.driver.DriverProvider;
import com.ostapiuk.core.logger.Log;
import com.ostapiuk.core.properties.ConfigProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaunchHasDataTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverProvider.getDriver().get(ConfigProperties.getBaseUrlProperty());
    }

    @Test(timeOut = 300000, dataProvider = "providePortalLaunches", dataProviderClass = LaunchesProvider.class)
    public void verifyLaunchHasData(String launchName) {
        LogInBO logInBO = new LogInBO();
        NavigationBO navigationBO = new NavigationBO();
        DataPresenceValidator dataPresenceValidator = new DataPresenceValidator();
        Log.log("Verify launch #" + launchName + " has data");
        logInBO.logIn(UsersProvider.getSingleUser());
        navigationBO.openLaunchesTable();
        dataPresenceValidator.verifyLaunchContainsData(launchName);
    }

    @Test(timeOut = 300000, dataProvider = "providePortalLaunches", dataProviderClass = LaunchesProvider.class)
    public void verifyLaunchHasFilledFields(String launchName) {
        LogInBO logInBO = new LogInBO();
        NavigationBO navigationBO = new NavigationBO();
        DataPresenceValidator dataPresenceValidator = new DataPresenceValidator();
        Log.log("Verify launch #" + launchName + " has filled fields");
        logInBO.logIn(UsersProvider.getSingleUser());
        navigationBO.openLaunchesTable();
        dataPresenceValidator.verifyLaunchHasFilledFields(launchName);
    }

    @AfterMethod
    public void logOut() {
        DriverProvider.quit();
    }
}
