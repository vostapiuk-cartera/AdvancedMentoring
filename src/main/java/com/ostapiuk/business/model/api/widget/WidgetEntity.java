package com.ostapiuk.business.model.api.widget;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class WidgetEntity {
    AddWidgetEntity addWidget;
    String widgetType;
}
