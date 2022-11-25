package com.ostapiuk.test.services.widget;

import com.ostapiuk.business.model.api.widget.WidgetCreationResponse;
import com.ostapiuk.business.model.api.widget.WidgetEntity;
import com.ostapiuk.business.validator.WidgetResponsesValidator;
import com.ostapiuk.core.client.ReportPortalAPIClient;
import com.ostapiuk.core.data_providers.UsersProvider;
import com.ostapiuk.core.data_providers.WidgetIdProvider;
import com.ostapiuk.core.data_providers.WidgetsProvider;
import com.ostapiuk.core.utils.FilePath;
import com.ostapiuk.core.utils.IdFile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateWidgetTest {

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

    @Test(dataProvider = "provideWidget", dataProviderClass = WidgetsProvider.class)
    public void verifyWidgetCreation(WidgetEntity widget) {
        WidgetCreationResponse widgetCreationResponse = new ReportPortalAPIClient()
                .createWidgetForDashboard(widget, projectName, dashboardId);
        widgetResponsesValidator.verifyWidgetCreationResponse(widgetCreationResponse, widgetId, dashboardId);
    }
}
