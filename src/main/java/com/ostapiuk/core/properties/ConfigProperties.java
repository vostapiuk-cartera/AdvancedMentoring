package com.ostapiuk.core.properties;

import java.util.Objects;

import static com.ostapiuk.core.utils.PropertySource.getProperty;

public class ConfigProperties {

    private ConfigProperties() {
        throw new IllegalStateException("Utility class");
    }

    public static int getImplicitWaitProperty() {
        return Integer.parseInt(Objects.requireNonNull(getProperty("implicit_wait")));
    }

    public static int getPageLoadWaitProperty() {
        return Integer.parseInt(Objects.requireNonNull(getProperty("page_load_wait")));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(Objects.requireNonNull(getProperty("explicit_wait")));
    }

    public static String getBaseUrlProperty() {
        return getProperty("base_url");
    }

    public static String getBaseSecureUrlProperty() {
        return getProperty("base_secure_url");
    }

    public static String getBaseApiUrlProperty() {
        return getProperty("base_api_url");
    }

    public static String getDataSourceProperty() {
        return getProperty("data_source");
    }

    public static String getDriverUrlProperty() {
        return getProperty("driver_url");
    }

    public static String getDriverNameProperty() {
        return getProperty("driver_name");
    }

    public static String getDriverPathProperty() {
        return getProperty("driver_path");
    }
}
