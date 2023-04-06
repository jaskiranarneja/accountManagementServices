package com.accountservice.account.service.dto;

import com.accountservice.account.domain.AccountStatus;
import com.accountservice.account.util.MaskStringValueSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserAccountResponse {
    private String email;

    private String name;

    private Country country;

    private String postalCode;

    private Integer age;

    private AccountStatus status;

    private String place;

    private String state;

    private String longitude;

    private String latitude;

    private UUID accountId;

    @JsonSerialize(using = MaskStringValueSerializer.class)
    private String securityPin;

}
