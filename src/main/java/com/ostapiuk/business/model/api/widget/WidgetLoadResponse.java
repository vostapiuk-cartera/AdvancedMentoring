package com.ostapiuk.business.model.api.widget;

import lombok.Data;

@Data
public class WidgetLoadResponse {
    ContentEntity[] content;
    PageEntity page;
}
