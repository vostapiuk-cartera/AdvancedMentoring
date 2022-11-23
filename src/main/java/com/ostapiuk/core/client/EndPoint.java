package com.ostapiuk.core.client;

public class EndPoint {

    public static final String CREATE_DASHBOARD = "/v1/{projectName}/dashboard";
    public static final String UPDATE_DASHBOARD = "/v1/{projectName}/dashboard/{id}";
    public static final String DELETE_DASHBOARD = UPDATE_DASHBOARD;

    public static final String CREATE_WIDGET = "/v1/{projectName}/dashboard/{id}/add";
    public static final String UPDATE_WIDGET = UPDATE_DASHBOARD;
    public static final String DELETE_WIDGET = "/v1/{projectName}/dashboard/{dashboardId}/{widgetId}";
}