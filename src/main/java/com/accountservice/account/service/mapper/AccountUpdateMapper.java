package com.accountservice.account.service.mapper;

import com.accountservice.account.domain.Account;
import com.accountservice.account.service.dto.AccountUpdateRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface AccountUpdateMapper extends EntityMapper<AccountUpdateRequest, Account> {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCustomerFromDto(AccountUpdateRequest dto, @MappingTarget Account entity);
}