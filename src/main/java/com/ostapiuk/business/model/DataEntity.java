package com.ostapiuk.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataEntity {
    private String portalVersion;

    private String successLogin;

    private String dashboardName;

    private String dashboardDescription;

    private Boolean dashboardShareValue;

    private String dashboardNewName;

    private String dashboardNewDescription;

    private Boolean dashboardNewShareValue;

    private String widgetType;

    private String widgetNewType;
}
