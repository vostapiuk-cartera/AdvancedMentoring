package com.ostapiuk.business.model.api.widget;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ContentParametersEntity {
    ContentFieldsEntity[] contentFields;
    Integer itemsCount;
}
