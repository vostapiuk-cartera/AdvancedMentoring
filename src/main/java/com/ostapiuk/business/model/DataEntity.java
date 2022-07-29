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

    private String dashboardNewName;
}
