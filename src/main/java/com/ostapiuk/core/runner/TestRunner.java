package com.ostapiuk.core.runner;

import com.ostapiuk.test.PortalHealthCheckTest;
import com.ostapiuk.test.PortalLoginTest;
import com.ostapiuk.test.UserActionsWithDashboardTest;
import com.ostapiuk.test.UserCanChangeGeneralSettingsTest;
import org.testng.TestNG;

public class TestRunner {

    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[]{
                PortalHealthCheckTest.class,
                PortalLoginTest.class,
                UserActionsWithDashboardTest.class,
                UserCanChangeGeneralSettingsTest.class
        });
        testng.run();
    }
}
