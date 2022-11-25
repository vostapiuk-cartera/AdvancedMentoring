package com.ostapiuk.business.model.api.widget;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentEntity {
    String description;
    String owner;
    boolean share;
    Integer id;
    String name;
    String widgetType;
    ContentParametersEntity contentParameters;

    public ContentEntity(String owner, boolean share, Integer id, String name, String widgetType, ContentParametersEntity contentParameters) {
        this.owner = owner;
        this.share = share;
        this.id = id;
        this.name = name;
        this.widgetType = widgetType;
        this.contentParameters = contentParameters;
    }
}
