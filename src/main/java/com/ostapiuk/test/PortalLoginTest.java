package com.ostapiuk.test;

import com.ostapiuk.business.bo.LogInBO;
import com.ostapiuk.business.validator.LogInValidator;
import com.ostapiuk.core.driver.DriverProvider;
import com.ostapiuk.core.properties.ConfigProperties;
import com.ostapiuk.core.data_providers.UsersProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PortalLoginTest extends BaseTest {

    @BeforeMethod
    public void initializeFields() {
        DriverProvider.getDriver().get(ConfigProperties.getBaseUrlProperty());
    }

    @Test(timeOut = 300000, dataProvider = "providePortalUsers", dataProviderClass = UsersProvider.class)
    public void verifyLogin(String userEmail, String userPassword, boolean expectedResult) {
        LogInBO logInBO = new LogInBO();
        logInBO.logIn(userEmail, userPassword);
        LogInValidator logInValidator = new LogInValidator();
        logInValidator.verifyLogin(expectedResult);
    }

    @AfterMethod
    public void logOut() {
        DriverProvider.quit();
    }
}
