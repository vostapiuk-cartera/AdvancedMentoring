package com.ostapiuk.business.po;

import com.ostapiuk.core.decorator.wrapper.CustomFieldDecorator;
import com.ostapiuk.core.driver.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver webDriver;

    public BasePage() {
        webDriver = DriverProvider.getDriver();
        PageFactory.initElements(new CustomFieldDecorator(webDriver), this);
    }
}
