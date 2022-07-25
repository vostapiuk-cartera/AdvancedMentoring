package com.ostapiuk.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserEntity {

    private String email;

    private String password;

    private boolean expected;
}
