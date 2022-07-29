package com.ostapiuk;

import com.ostapiuk.business.bo.LogInBO;
import com.ostapiuk.business.bo.UserActionsBO;
import com.ostapiuk.business.validator.UserActionsValidator;
import com.ostapiuk.core.driver.DriverProvider;
import com.ostapiuk.core.properties.ConfigProperties;
import com.ostapiuk.core.providers.DataObjectsProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserActionsWithDashboardTest extends BaseTest {

    LogInBO logInBO;
    UserActionsBO userActionsBO;
    UserActionsValidator userActionsValidator;

    @BeforeMethod
    public void initializeFields() {
        DriverProvider.getDriver().get(ConfigProperties.getBaseSecureUrlProperty());
        logInBO = new LogInBO();
        userActionsBO = new UserActionsBO();
        userActionsValidator = new UserActionsValidator();
    }

    @Test(timeOut = 300000)
    public void verifyUserActionsWithDashboard() {
        logInBO.logIn(DataObjectsProvider.getSingleUser().getEmail(), DataObjectsProvider.getSingleUser().getPassword());
        userActionsBO.createNewDashboard();
        userActionsValidator.verifyDashboardIsAdded();
        userActionsBO.updateDashboard();
        userActionsValidator.verifyDashboardIsUpdated();
        userActionsBO.deleteDashboard();
        userActionsValidator.verifyDashboardIsDeleted();
    }
}