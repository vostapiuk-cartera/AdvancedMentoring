package com.ostapiuk.business.bo;

import com.ostapiuk.business.model.UserEntity;
import com.ostapiuk.business.po.HomePage;
import com.ostapiuk.business.po.SignInPage;
import com.ostapiuk.core.logger.Log;

public class LogInBO {
    private SignInPage loginPage;
    private HomePage homePage;

    public LogInBO() {
        loginPage = new SignInPage();
        homePage = new HomePage();
    }

    public void logIn(UserEntity user) {
        Log.log("Authorising user with email: " + user.getEmail());
        loginPage.enterEmail(user.getEmail());
        Log.log("Authorising user with password: " + user.getPassword());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickLoginButton();
    }

    public void logOut() {
        Log.log("Click on user icon");
        homePage.clickOnAvatar();
        Log.log("Click Logout link from dropdown");
        homePage.clickOnLogoutLink();
    }
}
