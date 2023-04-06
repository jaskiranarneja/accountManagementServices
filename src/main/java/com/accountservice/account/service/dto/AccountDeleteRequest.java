package com.accountservice.account.service.dto;

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
    @NotNull(message = "Please provide an account id")
    private UUID accountId;

    @NotNull(message = "Please provide the security pin")
    private Integer securityPin;

}
