package com.ostapiuk.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class JsonEntity {

    private DataEntity data;

    private List<UserEntity> users;
}
