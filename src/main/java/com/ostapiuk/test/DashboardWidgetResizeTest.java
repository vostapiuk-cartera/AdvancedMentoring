package com.ostapiuk.test;

import com.codeborne.selenide.testng.ScreenShooter;
import com.ostapiuk.business.bo.LogInBO;
import com.ostapiuk.business.bo.NavigationBO;
import com.ostapiuk.business.bo.ResizeBO;
import com.ostapiuk.business.validator.WidgetResizeValidator;
import com.ostapiuk.core.data_providers.UsersProvider;
import com.ostapiuk.core.driver.DriverManager;
import org.openqa.selenium.Point;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@Listeners({ScreenShooter.class})
public class DashboardWidgetResizeTest {

    ResizeBO resizeBO;
    WidgetResizeValidator resizeValidator;

    @BeforeTest
    public void beforeTest() {
        DriverManager.setUpDriver();
    }

    @BeforeClass
    public void initializeFields() {
        open("/");
        resizeBO = new ResizeBO();
        resizeValidator = new WidgetResizeValidator();
        new LogInBO().logIn(UsersProvider.getSingleUser().getEmail(), UsersProvider.getSingleUser().getPassword());
        new NavigationBO().openDashboard();
    }

    @Test
    public void verifyResizeIsSaved() {
        int widgetNumber = 1;
        Point sizeBefore = resizeBO.getWidgetPosition(widgetNumber);
        resizeBO.resizeWidget(widgetNumber);
        Point sizeAfter = resizeBO.getWidgetPosition(widgetNumber);
        resizeValidator.verifyWidgetIsResized(sizeBefore, sizeAfter);
    }

    @Test
    public void verifyOtherWidgetMovesWhileResize() {
        int widgetNumber = 0;
        int otherWidgetNumber = 1;
        Point sizeBefore = resizeBO.getWidgetPosition(otherWidgetNumber);
        resizeBO.resizeWidget(widgetNumber);
        Point sizeAfter = resizeBO.getWidgetPosition(otherWidgetNumber);
        resizeValidator.verifyWidgetIsResized(sizeBefore, sizeAfter);
    }

    @Test
    public void verifyWidgetContentChangesWhileResize() {
        int widgetNumber = 2;
        Point sizeBefore = resizeBO.getWidgetContentSize(widgetNumber);
        resizeBO.resizeWidget(widgetNumber);
        Point sizeAfter = resizeBO.getWidgetContentSize(widgetNumber);
        resizeValidator.verifyWidgetIsResized(sizeBefore, sizeAfter);
    }

    @AfterClass
    public void tearDown() {
        closeWebDriver();
    }
}