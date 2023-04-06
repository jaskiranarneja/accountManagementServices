package com.accountservice.account.util;

public class AccountUtility {

    public static Integer generateSecurityPin() {
        return (int) Math.floor(Math.random() * (9999 - 1000 + 1) + 1000);
    }
}
