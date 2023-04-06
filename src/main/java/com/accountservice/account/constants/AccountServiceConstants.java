package com.accountservice.account.constants;

public class AccountServiceConstants {
    /**
     * Client side exposed APIs related constants
     */
    public static final String PATH_SEPARATOR = "/";
    public static final String VERSION = "v1";
    public static final String BASE_PATH = PATH_SEPARATOR + "api" + PATH_SEPARATOR + VERSION + PATH_SEPARATOR + "accountServices";

    public static final String CREATE_ACCOUNT = PATH_SEPARATOR + "createAccount";
    public static final String UPDATE_ACCOUNT = PATH_SEPARATOR + "updateAccount";

    public static final String LOCATION_API_PATH = "https://api.zippopotam.us/";

    /**
     * Validation messages
     */
    public static final String POSTAL_CODE_MESSAGE = "Please enter 5 digit postal code";
    public static final String EMAIL_MESSAGE = "Please provide an email";
    public static final String EMAIL_REGEX_EXPRESSION = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}";
    public static final String EMAIL_INVALID_MESSAGE = "Email is invalid";
    public static final String EMAIL_EXISTS_MESSAGE = "Email already exists";

    public static final String NAME_MESSAGE = "Please provide name";
    public static final String NAME_INVALID_SIZE = "Name size must be between 0 and 20";

    public static final String COUNTRY_MESSAGE = "Please provide country";

    public static final String LOCATION_PLACES_KEY = "places";
    public static final String LOCATION_PLACE_NAME_KEY = "place name";
    public static final String LOCATION_STATE_KEY = "state";
    public static final String LOCATION_LONGITUDE_KEY = "longitude";
    public static final String LOCATION_LATITUDE_KEY = "latitude";

    public static final String LOG_ACCOUNT_CREATED = "Account is created";
    public static final String LOG_ACCOUNT_UPDATED = "Account is updated";
}
