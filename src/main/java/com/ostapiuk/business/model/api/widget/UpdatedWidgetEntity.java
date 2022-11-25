package com.ostapiuk.business.model.api.widget;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class UpdatedWidgetEntity {
    String description;
    String name;
    Boolean share;
    UpdateWidgetEntity[] updateWidgets;
}
