package com.accountservice.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private int errorCode;

    public BaseException(int errorCode, String message, RuntimeException ex) {
        super(message, ex);
        this.errorCode = errorCode;
    }

    public BaseException(String message, RuntimeException ex) {
        super(message, ex);
    }

    public BaseException() {
        super();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

}
