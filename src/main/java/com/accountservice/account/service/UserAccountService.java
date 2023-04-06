package com.accountservice.account.service;

import com.accountservice.account.service.dto.AccountUpdateRequest;
import com.accountservice.account.service.dto.UserAccountRequest;

public interface UserAccountService {

    UserAccountRequest createUserAccount(UserAccountRequest accountRequest);

    UserAccountRequest updateUserAccount(AccountUpdateRequest createAccountRequest);
}
