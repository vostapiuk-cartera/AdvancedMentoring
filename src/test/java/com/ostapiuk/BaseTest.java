package com.ostapiuk;

import com.ostapiuk.core.driver.DriverProvider;
import com.ostapiuk.core.listener.TestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class BaseTest {

    @AfterClass
    public void tearDown() {
        DriverProvider.quit();
    }
}
