package com.ostapiuk.business.po;

import com.ostapiuk.core.decorator.elements.Button;
import com.ostapiuk.core.driver.Wait;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

public class SettingsPage extends BasePage {

    @FindBy(css = "div[class^='formField'] div[class^='inputDropdown__dropdown-container']")
    private List<WebElement> dropdown;

    @FindBy(xpath = "//*[contains(@class,'inputDropdown__opened')]//*[contains(@class,'inputDropdownOption__dropdown-option') and not(contains(@class,'inputDropdownOption__disabled')) and not(contains(@class,'inputDropdownOption__hidden'))]")
    private List<WebElement> dropdownOption;

    @FindBy(css = "div[class*='inputDropdown__opened']")
    private WebElement activeDropdown;

    @FindBy(css = "button[type='submit']")
    private Button submitButton;

    private SecureRandom random = new SecureRandom();

    public WebElement getRandomDropdown() {
        return dropdown.get(random.nextInt(dropdown.size()));
    }

    public String getDropdownValue(WebElement dropdown) {
        return dropdown.getText();
    }

    public void clickRandomDropdown() {
        dropdown.get(random.nextInt(dropdown.size())).click();
    }

    public void clickDropdown(WebElement dropdown) {
        dropdown.click();
    }

    public void selectNewRandomDropdownOption(String old) {
        Wait.waitOnElementToBeVisible(activeDropdown);
        Optional<WebElement> newOption = dropdownOption.stream()
                .filter(el -> !el.getText().equals(old))
                .findFirst();
        if (newOption.isEmpty()) {
            throw new NotFoundException();
        }
        newOption.get()
                .click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
