package com.ostapiuk.business.model.api.dashboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class DashboardEntity {
    String description;
    String name;
    boolean share;
}
