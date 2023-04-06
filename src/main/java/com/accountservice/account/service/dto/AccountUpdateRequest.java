package com.accountservice.account.service.dto;

import com.accountservice.account.constants.AccountServiceConstants;
import com.accountservice.account.domain.AccountStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountUpdateRequest {

    @Email(regexp = AccountServiceConstants.EMAIL_REGEX_EXPRESSION, message = AccountServiceConstants.EMAIL_INVALID_MESSAGE)
    private String email;

    @Size(max = 20, message = AccountServiceConstants.NAME_INVALID_SIZE)
    private String name;

    private Country country;

    private String postalCode;

    private Integer age;

    private AccountStatus status;

}
