package com.accountservice.account.service.dto;

import com.accountservice.account.constants.AccountServiceConstants;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountLocation {
    @NotNull(message = AccountServiceConstants.COUNTRY_MESSAGE)
    private Country country;

    @NotNull(message = AccountServiceConstants.POSTAL_CODE_MESSAGE)
    @NotEmpty(message = AccountServiceConstants.POSTAL_CODE_MESSAGE)
    private String postalCode;
    private String place;

    private String state;

    private String longitude;

    private String latitude;
}
