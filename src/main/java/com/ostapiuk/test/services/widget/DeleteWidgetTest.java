package com.ostapiuk.test.services.widget;

import com.ostapiuk.business.model.api.widget.WidgetDeletionResponse;
import com.ostapiuk.business.validator.WidgetResponsesValidator;
import com.ostapiuk.core.client.ReportPortalAPIClient;
import com.ostapiuk.core.data_providers.UsersProvider;
import com.ostapiuk.core.data_providers.WidgetIdProvider;
import com.ostapiuk.core.utils.FilePath;
import com.ostapiuk.core.utils.IdFile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteWidgetTest {

    private WidgetResponsesValidator widgetResponsesValidator;
    private Integer dashboardId;
    private Integer widgetId;
    private String projectName;

    @BeforeClass
    public void initializeFields() {
        widgetResponsesValidator = new WidgetResponsesValidator();
        IdFile idFile = new IdFile();
        dashboardId = idFile.readIdFromFile(FilePath.DASHBOARD_FILE);
        projectName = UsersProvider.getSingleUser().getEmail() + "_personal";
        widgetId = WidgetIdProvider.getExistingWidgetId(projectName);
    }

    @Test
    public void verifyWidgetDeletion() {
        WidgetDeletionResponse widgetDeletionResponse = new ReportPortalAPIClient()
                .deleteWidgetById(projectName, dashboardId, widgetId);
        widgetResponsesValidator.verifyWidgetDeletionResponse(widgetDeletionResponse, widgetId, dashboardId);
    }

}
