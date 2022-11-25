package com.ostapiuk.business.model.api.widget;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class UpdateWidgetEntity {
    Boolean share;
    Integer widgetId;
    WidgetPositionEntity widgetPosition;
    WidgetSizeEntity widgetSize;
    String widgetType;
}
