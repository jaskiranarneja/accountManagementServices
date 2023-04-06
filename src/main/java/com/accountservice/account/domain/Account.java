package com.accountservice.account.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue
    @Column(name = "accountid", length = 6)
    private UUID accountId;

    @Column(name = "email")
    private String email;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "postalcode", length = 5)
    private String postalCode;

    @Column(name = "age")
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AccountStatus status;

    @Column(name = "place")
    private String place;

    @Column(name = "state")
    private String state;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "securitypin", length = 4)
    private Integer securityPin;
}
