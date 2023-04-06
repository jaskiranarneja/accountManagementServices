package com.accountservice.account.domain;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum AccountStatus {
    @JsonEnumDefaultValue
    Requested,
    Active,
    Inactive
}
