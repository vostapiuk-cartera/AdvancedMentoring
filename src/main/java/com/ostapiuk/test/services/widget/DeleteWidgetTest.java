package com.ostapiuk.test.services.widget;

import com.ostapiuk.business.model.api.widget.WidgetDeletionResponse;
import com.ostapiuk.business.validator.WidgetResponsesValidator;
import com.ostapiuk.core.client.ReportPortalAPIClient;
import com.ostapiuk.core.data_providers.UsersProvider;
import com.ostapiuk.core.properties.ConfigProperties;
import com.ostapiuk.core.utils.IdFile;
import com.ostapiuk.core.utils.IdSource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteWidgetTest {

    private WidgetResponsesValidator widgetResponsesValidator;
    private Integer dashboardId;
    private String widgetId;
    private String projectName;

    @BeforeClass
    public void initializeFields() {
        widgetResponsesValidator = new WidgetResponsesValidator();
        IdSource idSource = new IdSource();
        dashboardId = idSource.readIdFromFile(IdFile.DASHBOARD_FILE);
        projectName = UsersProvider.getSingleUser().getEmail() + "_personal";
        widgetId = ConfigProperties.getWidgetIdProperty();
    }

    @Test
    public void verifyDashboardDeletion() {
        WidgetDeletionResponse widgetDeletionResponse = new ReportPortalAPIClient()
                .deleteWidgetById(projectName, dashboardId, widgetId);
        widgetResponsesValidator.verifyWidgetDeletionResponse(widgetDeletionResponse, widgetId, dashboardId);
    }

}
