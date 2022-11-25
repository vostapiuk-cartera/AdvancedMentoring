package com.ostapiuk.test.services.dashboard;

import com.ostapiuk.business.model.api.dashboard.DashboardDeletionResponse;
import com.ostapiuk.business.validator.DashboardResponsesValidator;
import com.ostapiuk.core.client.ReportPortalAPIClient;
import com.ostapiuk.core.data_providers.UsersProvider;
import com.ostapiuk.core.utils.FilePath;
import com.ostapiuk.core.utils.IdFile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteDashboardTest {

    private DashboardResponsesValidator dashboardResponsesValidator;
    private IdFile idFile;
    private Integer dashboardId;
    private String projectName;

    @BeforeClass
    public void initializeFields() {
        dashboardResponsesValidator = new DashboardResponsesValidator();
        idFile = new IdFile();
        dashboardId = idFile.readIdFromFile(FilePath.DASHBOARD_FILE);
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
        idFile.clearFile(FilePath.DASHBOARD_FILE);
    }

}
