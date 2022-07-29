package com.ostapiuk.core.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenshotUtils {

    public static void getScreenshot(WebDriver driver, String testName) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenName = testName + DateFormatUtils.format(new Date(),"yyyy-MM-dd-hh-mm") + ".png";
        try {
            FileUtils.copyFile(scrFile, new File("screen\\"+screenName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
