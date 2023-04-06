package com.accountservice.account.util;

public enum Category {
    @Mask
    CATEGORY1,
    @Mask(value = "*** This value of this attribute is masked for security reason ***")
    CATEGORY2,
    CATEGORY3
}
