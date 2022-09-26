package com.ostapiuk.business.po;

import com.ostapiuk.core.driver.DriverProvider;
import com.ostapiuk.core.driver.Wait;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LaunchesPage extends BasePage {

    private static final String LAUNCH_LINK_SELECTOR = "[class^='itemInfo__edit-number']>[href$='%s']";
    private static final String TABLE_COLUMN_SELECTOR = "//*[starts-with(@class, 'headerCell__title') and text()='%s']";
    private static final String LAUNCH_SELECTOR = "[class^='gridRow__grid-row-wrapper'][data-id='%s']";
    private static final String LAUNCH_COLUMN_SELECTOR = "[class^='launchSuiteGrid__%s']";
    private static final String COLUMN_VALUE_SELECTOR = "[class^='executionStatistics__execution-statistics']>a";

    @FindBy(css = "[class^='grid__']")
    private WebElement root;

    @SneakyThrows
    public void waitOnLaunchTableDisplay() {
        Wait.waitOnElementToBeVisible(root);
    }

    public void clickOnLaunchWithName(String launchName) {
        WebElement launch = DriverProvider.getDriver().findElement(By.cssSelector(String.format(LAUNCH_LINK_SELECTOR, launchName)));
        launch.click();
    }

    public boolean hasPresentColumnWithData(String launchName, String data) {
        return getColumnByName(launchName, data).isDisplayed();
    }

    public boolean hasPresentColumnInHeader(String data) {
        return DriverProvider.getDriver().findElement(By.xpath(String.format(TABLE_COLUMN_SELECTOR, data))).isDisplayed();
    }

    public boolean hasPresentValueInColumn(String launchName, String data) {
        WebElement columnValue = getColumnByName(launchName, data).findElement(By.cssSelector(COLUMN_VALUE_SELECTOR));
        return !columnValue.getText().isEmpty() && isNumeric(columnValue.getText());
    }

    public WebElement getColumnByName(String launchName, String data) {
        WebElement launch = DriverProvider.getDriver().findElement(By.cssSelector(String.format(LAUNCH_SELECTOR, launchName)));
        return launch.findElement(By.cssSelector(String.format(LAUNCH_COLUMN_SELECTOR, data)));
    }

    public boolean isNumeric(String value) {
        if (value == null) {
            return false;
        }
        return value.chars().allMatch(Character::isDigit);
    }
}
