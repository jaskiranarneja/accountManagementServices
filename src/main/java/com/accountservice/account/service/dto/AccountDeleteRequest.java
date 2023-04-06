package com.accountservice.account.service.dto;

import com.accountservice.account.constants.AccountServiceConstants;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDeleteRequest {
    @NotNull(message = AccountServiceConstants.ACCOUNT_ID_MESSAGE)
    private UUID accountId;

    @NotNull(message = AccountServiceConstants.SECURITY_PIN_MESSAGE)
    private Integer securityPin;

}
