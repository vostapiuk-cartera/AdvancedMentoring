package com.ostapiuk.test.services.dashboard;

import com.ostapiuk.business.model.api.dashboard.DashboardDeletionResponse;
import com.ostapiuk.business.validator.DashboardResponsesValidator;
import com.ostapiuk.core.client.ReportPortalAPIClient;
import com.ostapiuk.core.data_providers.UsersProvider;
import com.ostapiuk.core.utils.IdFile;
import com.ostapiuk.core.utils.IdSource;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteDashboardTest {

    private DashboardResponsesValidator dashboardResponsesValidator;
    private IdSource idSource;
    private Integer dashboardId;
    private String projectName;

    @BeforeClass
    public void initializeFields() {
        dashboardResponsesValidator = new DashboardResponsesValidator();
        idSource = new IdSource();
        dashboardId = idSource.readIdFromFile(IdFile.DASHBOARD_FILE);
        projectName = UsersProvider.getSingleUser().getEmail() + "_personal";
    }

    @Test
    public void verifyDashboardDeletion() {
        DashboardDeletionResponse dashboardDeletionResponse = new ReportPortalAPIClient()
                .deleteDashboardById(projectName, dashboardId);
        dashboardResponsesValidator.verifyDashboardDeletionResponse(dashboardDeletionResponse, dashboardId);
    }

    @AfterClass
    public void clearDashboardIdFile() {
        idSource.clearFile(IdFile.DASHBOARD_FILE);
    }

}
