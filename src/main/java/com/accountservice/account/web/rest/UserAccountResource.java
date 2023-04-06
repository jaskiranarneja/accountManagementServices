package com.accountservice.account.web.rest;

import com.accountservice.account.base.response.BaseResponse;
import com.accountservice.account.base.response.ErrorDetails;
import com.accountservice.account.constants.AccountServiceConstants;
import com.accountservice.account.service.UserAccountService;
import com.accountservice.account.service.dto.AccountUpdateRequest;
import com.accountservice.account.service.dto.UserAccountRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(AccountServiceConstants.BASE_PATH)
public class UserAccountResource {

    private final UserAccountService accountService;

    /**
     * To create account
     *
     * @param createAccountRequest input request
     * @param result               binding result
     * @return response
     * @throws HttpClientErrorException for rest API error when location not found
     */
    @PostMapping(AccountServiceConstants.CREATE_ACCOUNT)
    public BaseResponse<UserAccountRequest> createUserAccount(
            @RequestBody @Valid UserAccountRequest createAccountRequest, BindingResult result) throws HttpClientErrorException {
        if (result.hasErrors()) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setErrorCode(HttpStatus.BAD_REQUEST.value());
            String message = result.getFieldErrors()
                    .stream()
                    .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                    .collect(Collectors.joining("; "));
            errorDetails.setErrorMessage(message);
            return new BaseResponse<>(errorDetails);
        }

        if (createAccountRequest.getPostalCode().length() != 5) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setErrorCode(HttpStatus.BAD_REQUEST.value());
            errorDetails.setErrorMessage(AccountServiceConstants.POSTAL_CODE_MESSAGE);
            return new BaseResponse<>(errorDetails);
        }
        return new BaseResponse<>(accountService.createUserAccount(createAccountRequest));
    }

    /**
     * to update account information
     *
     * @param updateAccountRequest input request
     * @param result               binding result
     * @return response
     * @throws HttpClientErrorException for rest API error when location not found
     */
    @PutMapping(AccountServiceConstants.UPDATE_ACCOUNT)
    public BaseResponse<UserAccountRequest> updateUserAccount(
            @RequestBody @Valid AccountUpdateRequest updateAccountRequest, BindingResult result) throws HttpClientErrorException {
        if (result.hasErrors()) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setErrorCode(HttpStatus.BAD_REQUEST.value());
            String message = result.getFieldErrors()
                    .stream()
                    .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                    .collect(Collectors.joining("; "));

            errorDetails.setErrorMessage(message);
            return new BaseResponse<>(errorDetails);
        }

        if (updateAccountRequest.getPostalCode().length() != 5) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setErrorCode(HttpStatus.BAD_REQUEST.value());
            errorDetails.setErrorMessage(AccountServiceConstants.POSTAL_CODE_MESSAGE);
            return new BaseResponse<>(errorDetails);
        }
        return new BaseResponse<>(accountService.updateUserAccount(updateAccountRequest));
    }
}
