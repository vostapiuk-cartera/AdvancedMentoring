package com.ostapiuk.test.services.widget;

import com.ostapiuk.business.model.api.widget.UpdatedWidgetEntity;
import com.ostapiuk.business.model.api.widget.WidgetModificationResponse;
import com.ostapiuk.business.validator.WidgetResponsesValidator;
import com.ostapiuk.core.client.ReportPortalAPIClient;
import com.ostapiuk.core.data_providers.UsersProvider;
import com.ostapiuk.core.data_providers.WidgetsProvider;
import com.ostapiuk.core.utils.FilePath;
import com.ostapiuk.core.utils.IdFile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ModifyWidgetTest {

    private WidgetResponsesValidator widgetResponsesValidator;
    private Integer dashboardId;
    private String projectName;

    @BeforeClass
    public void initializeFields() {
        widgetResponsesValidator = new WidgetResponsesValidator();
        IdFile idFile = new IdFile();
        dashboardId = idFile.readIdFromFile(FilePath.DASHBOARD_FILE);
        projectName = UsersProvider.getSingleUser().getEmail() + "_personal";
    }

    @Test(dataProvider = "provideUpdatedWidget", dataProviderClass = WidgetsProvider.class)
    public void verifyWidgetModification(UpdatedWidgetEntity widget) {
        WidgetModificationResponse widgetModificationResponse = new ReportPortalAPIClient()
                .modifyWidgetById(widget, projectName, dashboardId);
        widgetResponsesValidator.verifyWidgetModificationResponse(widgetModificationResponse, dashboardId);
    }

}
