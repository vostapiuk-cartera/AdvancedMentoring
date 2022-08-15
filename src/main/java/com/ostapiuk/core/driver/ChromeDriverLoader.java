package com.ostapiuk.core.driver;

import com.ostapiuk.core.exception.ChromeDriverFileException;
import com.ostapiuk.core.properties.ConfigProperties;
import com.ostapiuk.core.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ChromeDriverLoader {

    public void loadChromeDriver() {
        String driverName = isWindows() ? ConfigProperties.getWindowsDriverNameProperty() : ConfigProperties.getLinuxDriverNameProperty();
        InputStream stream = ChromeDriverLoader.class.getResourceAsStream(driverName);
        File driverFile = new File("driver");
        driverFile.setExecutable(true);
        try {
            FileUtils.unzipFile(driverFile, stream, driverName, isWindows());
        } catch (IOException e) {
            throw new ChromeDriverFileException("Chrome driver file cannot be found and unzipped", e);
        }
        System.setProperty("webdriver.chrome.driver", driverFile.getPath() + "/" + driverName);
    }

    public boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }
}
