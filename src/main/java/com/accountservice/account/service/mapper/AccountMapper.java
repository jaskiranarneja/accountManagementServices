package com.accountservice.account.service.mapper;

import com.accountservice.account.domain.Account;
import com.accountservice.account.service.dto.UserAccountRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends EntityMapper<UserAccountRequest, Account> {
}