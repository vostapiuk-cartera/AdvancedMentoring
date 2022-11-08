package com.ostapiuk.business.bo;

import com.ostapiuk.business.po.SignInPage;
import com.ostapiuk.core.logger.Log;

public class LogInBO {
    private SignInPage loginPage;

    public LogInBO() {
        loginPage = new SignInPage();
    }

    public void logIn(String userEmail, String userPassword) {
        Log.log("Authorising user with email: " + userEmail);
        loginPage.enterEmail(userEmail);
        Log.log("Authorising user with password: " + userPassword);
        loginPage.enterPassword(userPassword);
        loginPage.clickLoginButton();
    }
}
