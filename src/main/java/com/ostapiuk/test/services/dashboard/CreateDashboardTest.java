package com.ostapiuk.test.services.dashboard;

import com.ostapiuk.business.model.api.dashboard.DashboardCreationResponse;
import com.ostapiuk.business.model.api.dashboard.DashboardEntity;
import com.ostapiuk.business.validator.DashboardResponsesValidator;
import com.ostapiuk.core.client.ReportPortalAPIClient;
import com.ostapiuk.core.data_providers.DashboardsProvider;
import com.ostapiuk.core.data_providers.UsersProvider;
import com.ostapiuk.core.utils.IdFile;
import com.ostapiuk.core.utils.IdSource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateDashboardTest {

    private DashboardResponsesValidator dashboardResponsesValidator;
    private IdSource idSource;
    private String projectName;

    @BeforeClass
    public void initializeFields() {
        dashboardResponsesValidator = new DashboardResponsesValidator();
        idSource = new IdSource();
        projectName = UsersProvider.getSingleUser().getEmail() + "_personal";
    }

    @Test(dataProvider = "provideDashboard", dataProviderClass = DashboardsProvider.class)
    public void verifyDashboardCreation(DashboardEntity dashboard) {
        DashboardCreationResponse dashboardCreationResponse = new ReportPortalAPIClient()
                .createDashboard(dashboard, projectName);
        dashboardResponsesValidator.verifyDashboardCreationResponse(dashboardCreationResponse);

        idSource.writeIdToFile(dashboardCreationResponse.getId(), IdFile.DASHBOARD_FILE);
    }
}
