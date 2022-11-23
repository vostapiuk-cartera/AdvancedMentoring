package com.ostapiuk.business.validator;

import com.ostapiuk.business.model.api.dashboard.DashboardCreationResponse;
import com.ostapiuk.business.model.api.dashboard.DashboardDeletionResponse;
import com.ostapiuk.business.model.api.dashboard.DashboardModificationResponse;
import org.testng.Assert;

public class DashboardResponsesValidator {

    public void verifyDashboardCreationResponse(DashboardCreationResponse dashboardCreationResponse) {
        Assert.assertNotNull(dashboardCreationResponse.getId(), "Id is null");
    }

    public void verifyDashboardModificationResponse(DashboardModificationResponse dashboardModificationResponse, Integer dashboardId) {
        Assert.assertNotNull(dashboardModificationResponse.getMessage(), "Message is null");
        Assert.assertEquals(dashboardModificationResponse.getMessage(), "Dashboard with ID = '" + dashboardId + "' successfully updated", "Wrong Message text");
    }

    public void verifyDashboardDeletionResponse(DashboardDeletionResponse dashboardDeletionResponse, Integer dashboardId) {
        Assert.assertNotNull(dashboardDeletionResponse.getMessage(), "Message is null");
        Assert.assertEquals(dashboardDeletionResponse.getMessage(), "Dashboard with ID = '" + dashboardId + "' successfully deleted.", "Wrong Message text");
    }
}
