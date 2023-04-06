package com.accountservice.account.service.impl;

import com.accountservice.account.client.AccountClient;
import com.accountservice.account.constants.AccountServiceConstants;
import com.accountservice.account.domain.Account;
import com.accountservice.account.domain.AccountStatus;
import com.accountservice.account.exception.BaseException;
import com.accountservice.account.repository.AccountRepository;
import com.accountservice.account.service.UserAccountService;
import com.accountservice.account.service.dto.AccountUpdateRequest;
import com.accountservice.account.service.dto.UserAccountRequest;
import com.accountservice.account.service.mapper.AccountMapper;
import com.accountservice.account.service.mapper.AccountUpdateMapper;
import com.accountservice.account.util.AccountUtility;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private AccountUpdateMapper updateMapper;

    @Autowired
    private AccountClient accountClient;

    @Override
    public UserAccountRequest createUserAccount(UserAccountRequest accountRequest) {
        Account existingEmail = accountRepository.findByEmail(accountRequest.getEmail());
        if (existingEmail != null) {
            throw new BaseException(AccountServiceConstants.EMAIL_EXISTS_MESSAGE, null);
        }
        JsonNode root;
        try {
            String response = accountClient.getLocation(accountRequest.getCountry().toString(), accountRequest.getPostalCode());
            ObjectMapper mapper = new ObjectMapper();
            root = mapper.readTree(response);
        } catch (Exception ex) {
            throw new BaseException(ex.getMessage(), null);
        }
        JsonNode places = root.path(AccountServiceConstants.LOCATION_PLACES_KEY);
        JsonNode placeName = places.findValue(AccountServiceConstants.LOCATION_PLACE_NAME_KEY);
        JsonNode state = places.findValue(AccountServiceConstants.LOCATION_STATE_KEY);
        JsonNode longitude = places.findValue(AccountServiceConstants.LOCATION_LONGITUDE_KEY);
        JsonNode latitude = places.findValue(AccountServiceConstants.LOCATION_LATITUDE_KEY);

        accountRequest.setPlace(placeName.asText());
        accountRequest.setState(state.asText());
        accountRequest.setLongitude(longitude.asText());
        accountRequest.setLatitude(latitude.asText());
        accountRequest.setStatus(AccountStatus.Requested);
        accountRequest.setSecurityPin(AccountUtility.generateSecurityPin());
        Account newAccount = accountRepository.save(accountMapper.toEntity(accountRequest));
        log.info(AccountServiceConstants.LOG_ACCOUNT_CREATED);
        return accountMapper.toDto(newAccount);
    }

    @Override
    public UserAccountRequest updateUserAccount(AccountUpdateRequest accountRequest) {
        Account existingEmail = accountRepository.findByEmail(accountRequest.getEmail());
        if (existingEmail == null) {
            throw new BaseException(AccountServiceConstants.EMAIL_EXISTS_MESSAGE, null);
        }
        JsonNode root;
        try {
            String response = accountClient.getLocation(accountRequest.getCountry().toString(), accountRequest.getPostalCode());
            ObjectMapper mapper = new ObjectMapper();
            root = mapper.readTree(response);
        } catch (Exception ex) {
            throw new BaseException(ex.getMessage(), null);
        }
        JsonNode places = root.path(AccountServiceConstants.LOCATION_PLACES_KEY);
        JsonNode placeName = places.findValue(AccountServiceConstants.LOCATION_PLACE_NAME_KEY);
        JsonNode state = places.findValue(AccountServiceConstants.LOCATION_STATE_KEY);
        JsonNode longitude = places.findValue(AccountServiceConstants.LOCATION_LONGITUDE_KEY);
        JsonNode latitude = places.findValue(AccountServiceConstants.LOCATION_LATITUDE_KEY);

        Account existingAccount = accountRepository.findByEmail(accountRequest.getEmail());
        existingAccount.setPlace(placeName.asText());
        existingAccount.setState(state.asText());
        existingAccount.setLongitude(longitude.asText());
        existingAccount.setLatitude(latitude.asText());
        updateMapper.updateCustomerFromDto(accountRequest, existingAccount);
        Account account = accountRepository.save(existingAccount);
        log.info(AccountServiceConstants.LOG_ACCOUNT_UPDATED);
        return accountMapper.toDto(account);
    }
}
