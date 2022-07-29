package com.ostapiuk.business.po;

import com.ostapiuk.core.decorator.elements.Button;
import com.ostapiuk.core.decorator.elements.TextField;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "login")
    private TextField emailInput;

    @FindBy(name = "password")
    private TextField passwordInput;

    @FindBy(css = "button[type='submit']")
    private Button loginButton;

    public void enterEmail(String email) {
        emailInput.typeAndEnter(email);
    }

    public void enterPassword(String password) {
        passwordInput.typeAndEnter(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
