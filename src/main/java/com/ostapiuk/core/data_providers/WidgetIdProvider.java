package com.ostapiuk.core.data_providers;

import com.ostapiuk.business.model.api.widget.ContentEntity;
import com.ostapiuk.core.client.ReportPortalAPIClient;

import java.util.Arrays;
import java.util.Optional;

public class WidgetIdProvider {

    private static final String PROJECT_NAME = "superadmin_personal";

    public static Integer getExistingWidgetId(String projectName) {
        ContentEntity[] content = new ReportPortalAPIClient().getWidgetForProject(projectName).getContent();
        Optional<ContentEntity> widget = Arrays.stream(content).findFirst();
        return widget.map(ContentEntity::getId).orElse(null);
    }

    public static Integer getExistingWidgetId() {
        ContentEntity[] content = new ReportPortalAPIClient().getWidgetForProject(PROJECT_NAME).getContent();
        Optional<ContentEntity> widget = Arrays.stream(content).findFirst();
        return widget.map(ContentEntity::getId).orElse(null);
    }
}
