package com.accountservice.account.service.dto;

import com.accountservice.account.constants.AccountServiceConstants;
import com.accountservice.account.domain.AccountStatus;
import com.accountservice.account.util.Mask;
import com.accountservice.account.util.MaskStringValueSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountRequest {
    @NotNull(message = AccountServiceConstants.EMAIL_MESSAGE)
    @NotEmpty(message = AccountServiceConstants.EMAIL_MESSAGE)
    @Email(regexp = AccountServiceConstants.EMAIL_REGEX_EXPRESSION, message = AccountServiceConstants.EMAIL_INVALID_MESSAGE)
    private String email;

    @NotNull(message = AccountServiceConstants.NAME_MESSAGE)
    @NotEmpty(message = AccountServiceConstants.NAME_MESSAGE)
    @Size(max = 20, message = AccountServiceConstants.NAME_INVALID_SIZE)
    private String name;

    @NotNull(message = AccountServiceConstants.COUNTRY_MESSAGE)
    private Country country;

    @NotNull(message = AccountServiceConstants.POSTAL_CODE_MESSAGE)
    @NotEmpty(message = AccountServiceConstants.POSTAL_CODE_MESSAGE)
    private String postalCode;

    private Integer age;

    private AccountStatus status;

    private String place;

    private String state;

    private String longitude;

    private String latitude;

    private UUID accountId;

    @JsonSerialize(using = MaskStringValueSerializer.class)
    @Mask
    private Integer securityPin;

}
