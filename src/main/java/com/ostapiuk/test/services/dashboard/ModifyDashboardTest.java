package com.ostapiuk.test.services.dashboard;

import com.ostapiuk.business.model.api.dashboard.DashboardEntity;
import com.ostapiuk.business.model.api.dashboard.DashboardModificationResponse;
import com.ostapiuk.business.validator.DashboardResponsesValidator;
import com.ostapiuk.core.client.ReportPortalAPIClient;
import com.ostapiuk.core.data_providers.DashboardsProvider;
import com.ostapiuk.core.data_providers.UsersProvider;
import com.ostapiuk.core.utils.FilePath;
import com.ostapiuk.core.utils.IdFile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ModifyDashboardTest {

    private DashboardResponsesValidator dashboardResponsesValidator;
    private Integer dashboardId;
    private String projectName;

    @BeforeClass
    public void initializeFields() {
        dashboardResponsesValidator = new DashboardResponsesValidator();
        IdFile idFile = new IdFile();
        dashboardId = idFile.readIdFromFile(FilePath.DASHBOARD_FILE);
        projectName = UsersProvider.getSingleUser().getEmail() + "_personal";
    }

    @Test(dataProvider = "provideUpdatedDashboard", dataProviderClass = DashboardsProvider.class)
    public void verifyDashboardModification(DashboardEntity dashboard) {
        DashboardModificationResponse dashboardModificationResponse = new ReportPortalAPIClient()
                .modifyDashboardById(dashboard, projectName, dashboardId);
        dashboardResponsesValidator.verifyDashboardModificationResponse(dashboardModificationResponse, dashboardId);
    }

}
