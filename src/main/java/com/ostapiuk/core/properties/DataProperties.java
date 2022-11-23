package com.ostapiuk.core.properties;

import com.ostapiuk.business.model.DataEntity;
import com.ostapiuk.core.utils.JsonParser;

import java.util.Objects;

public class DataProperties {

    public static DataEntity getDataEntity() {
        return Objects.requireNonNull(JsonParser.getJsonEntity()).getData();
    }

    public static String getPortalVersion() {
        return getDataEntity().getPortalVersion();
    }

    public static String getSuccessLogin() {
        return getDataEntity().getSuccessLogin();
    }

    public static String getDashboardName() {
        return getDataEntity().getDashboardName();
    }

    public static String getDashboardDescription() {
        return getDataEntity().getDashboardDescription();
    }

    public static Boolean getDashboardShareValue() {
        return getDataEntity().getDashboardShareValue();
    }

    public static String getDashboardNewName() {
        return getDataEntity().getDashboardNewName();
    }

    public static String getDashboardNewDescription() {
        return getDataEntity().getDashboardNewDescription();
    }

    public static Boolean getDashboardNewShareValue() {
        return getDataEntity().getDashboardNewShareValue();
    }

    public static String getWidgetType() {
        return getDataEntity().getWidgetType();
    }

    public static String getWidgetNewType() {
        return getDataEntity().getWidgetNewType();
    }

    private DataProperties() {
        throw new IllegalStateException("Utility class");
    }
}
