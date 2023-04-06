package com.accountservice.account.client;

import com.accountservice.account.constants.AccountServiceConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class AccountClient {
    private final RestTemplate restTemplate;

    @Autowired
    public AccountClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    /**
     * @param country
     * @param postalCode
     * @return
     * @throws HttpClientErrorException
     */
    public String getLocation(String country, String postalCode) throws HttpClientErrorException {

        String locationURL
                = AccountServiceConstants.LOCATION_API_PATH + country + AccountServiceConstants.PATH_SEPARATOR + postalCode;
        ResponseEntity<String> response
                = restTemplate.getForEntity(locationURL, String.class);
        return response.getBody();
    }
}
