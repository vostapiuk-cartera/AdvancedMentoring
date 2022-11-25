package com.ostapiuk.test;

import com.ostapiuk.business.bo.LogInBO;
import com.ostapiuk.business.bo.NavigationBO;
import com.ostapiuk.business.bo.UserActionsBO;
import com.ostapiuk.business.validator.UserActionsValidator;
import com.ostapiuk.core.driver.DriverProvider;
import com.ostapiuk.core.properties.ConfigProperties;
import com.ostapiuk.core.data_providers.UsersProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserCanChangeGeneralSettingsTest extends BaseTest {

    LogInBO logInBO;
    NavigationBO navigationBO;
    UserActionsBO userActionsBO;
    UserActionsValidator userActionsValidator;

    @BeforeMethod
    public void initializeFields() {
        DriverProvider.getDriver().get(ConfigProperties.getBaseSecureUrlProperty());
        logInBO = new LogInBO();
        navigationBO = new NavigationBO();
        userActionsBO = new UserActionsBO();
        userActionsValidator = new UserActionsValidator();
    }

    @Test(timeOut = 300000)
    public void verifyUserCanChangeGeneralSettings() {
        logInBO.logIn(UsersProvider.getSingleUser());
        navigationBO.openGeneralSettings();
        userActionsBO.changeGeneralSettings();
        userActionsValidator.verifyGeneralSettingAreSaved();
    }
}
