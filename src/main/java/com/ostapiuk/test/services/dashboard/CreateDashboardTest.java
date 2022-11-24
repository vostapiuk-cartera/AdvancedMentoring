package com.ostapiuk.test.services.dashboard;

import com.ostapiuk.business.model.api.dashboard.DashboardCreationResponse;
import com.ostapiuk.business.model.api.dashboard.DashboardEntity;
import com.ostapiuk.business.validator.DashboardResponsesValidator;
import com.ostapiuk.core.client.ReportPortalAPIClient;
import com.ostapiuk.core.data_providers.DashboardsProvider;
import com.ostapiuk.core.data_providers.UsersProvider;
import com.ostapiuk.core.utils.FilePath;
import com.ostapiuk.core.utils.IdFile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateDashboardTest {

    private DashboardResponsesValidator dashboardResponsesValidator;
    private IdFile idFile;
    private String projectName;

    @BeforeClass
    public void initializeFields() {
        dashboardResponsesValidator = new DashboardResponsesValidator();
        idFile = new IdFile();
        projectName = UsersProvider.getSingleUser().getEmail() + "_personal";
    }

    @Test(dataProvider = "provideDashboard", dataProviderClass = DashboardsProvider.class)
    public void verifyDashboardCreation(DashboardEntity dashboard) {
        DashboardCreationResponse dashboardCreationResponse = new ReportPortalAPIClient()
                .createDashboard(dashboard, projectName);
        dashboardResponsesValidator.verifyDashboardCreationResponse(dashboardCreationResponse);

        idFile.writeIdToFile(dashboardCreationResponse.getId(), FilePath.DASHBOARD_FILE);
    }
}
