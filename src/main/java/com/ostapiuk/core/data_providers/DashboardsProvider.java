package com.ostapiuk.core.data_providers;

import com.ostapiuk.business.model.api.dashboard.DashboardEntity;
import com.ostapiuk.core.properties.DataProperties;
import org.testng.annotations.DataProvider;

public class DashboardsProvider {

    @DataProvider(name = "provideDashboard")
    public static Object[][] getNewDashboardData() {
        return new Object[][]{
                {getDashboard(DataProperties.getDashboardDescription(), DataProperties.getDashboardName(), DataProperties.getDashboardShareValue())}
        };
    }

    @DataProvider(name = "provideUpdatedDashboard")
    public static Object[][] getUpdatedDashboardData() {
        return new Object[][]{
                {getDashboard(DataProperties.getDashboardDescription(), DataProperties.getDashboardNewName(), DataProperties.getDashboardShareValue())},
                {getDashboard(DataProperties.getDashboardNewDescription(), DataProperties.getDashboardName(), DataProperties.getDashboardShareValue())},
                {getDashboard(DataProperties.getDashboardDescription(), DataProperties.getDashboardName(), DataProperties.getDashboardNewShareValue())}
        };
    }

    public static DashboardEntity getDashboard(String description, String name, Boolean share) {
        return DashboardEntity.builder()
                .description(description)
                .name(name)
                .share(share)
                .build();
    }
}
