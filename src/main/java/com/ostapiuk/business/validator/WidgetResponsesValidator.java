package com.ostapiuk.business.validator;

import com.ostapiuk.business.model.api.widget.WidgetCreationResponse;
import com.ostapiuk.business.model.api.widget.WidgetDeletionResponse;
import com.ostapiuk.business.model.api.widget.WidgetModificationResponse;
import org.testng.Assert;

public class WidgetResponsesValidator {

    public void verifyWidgetCreationResponse(WidgetCreationResponse widgetCreationResponse, Integer widgetId, Integer dashboardId) {
        Assert.assertNotNull(widgetCreationResponse.getMessage(), "Id is null");
        Assert.assertEquals(widgetCreationResponse.getMessage(), "Widget with ID = '" + widgetId + "' was successfully added to the dashboard with ID = '" + dashboardId + "'", "Wrong Message text");
    }

    public void verifyWidgetModificationResponse(WidgetModificationResponse widgetModificationResponse, Integer dashboardId) {
        Assert.assertNotNull(widgetModificationResponse.getMessage(), "Message is null");
        Assert.assertEquals(widgetModificationResponse.getMessage(), "Dashboard with ID = '" + dashboardId + "' successfully updated", "Wrong Message text");
    }

    public void verifyWidgetDeletionResponse(WidgetDeletionResponse widgetDeletionResponse, Integer widgetId, Integer dashboardId) {
        Assert.assertNotNull(widgetDeletionResponse.getMessage(), "Message is null");
        Assert.assertEquals(widgetDeletionResponse.getMessage(), "Widget with ID = '" + widgetId + "' was successfully removed from the dashboard with ID = '" + dashboardId + "'", "Wrong Message text");
    }
}
