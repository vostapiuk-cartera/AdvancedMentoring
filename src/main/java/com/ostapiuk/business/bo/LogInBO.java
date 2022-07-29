package com.ostapiuk.business.bo;

import com.ostapiuk.business.po.LoginPage;
import com.ostapiuk.core.logger.Log;

public class LogInBO {
    private LoginPage loginPage;

    public LogInBO() {
        loginPage = new LoginPage();
    }

    public void logIn(String userEmail, String userPassword) {
        Log.log("Authorising user with email: " + userEmail);
        loginPage.enterEmail(userEmail);
        Log.log("Authorising user with password: " + userPassword);
        loginPage.enterPassword(userPassword);
        loginPage.clickLoginButton();
    }
}
