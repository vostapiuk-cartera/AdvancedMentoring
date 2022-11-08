package com.ostapiuk.business.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class SignInPage {

    private final SelenideElement emailInput = $(By.name("login"));

    private final SelenideElement passwordInput = element(By.name("password"));

    private final SelenideElement loginButton = $("button[type='submit']");

    public void enterEmail(String email) {
        emailInput.val(email);
    }

    public void enterPassword(String password) {
        passwordInput.val(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
