package com.accountservice.account.base.response;

public class BaseResponse<T> {

    private final T response;
    private ErrorDetails errorDetails;

    public BaseResponse(T t) {
        this.response = t;
    }

    public BaseResponse() {
        this.response = null;
    }

    public BaseResponse(ErrorDetails errorDetails) {
        this.response = null;
        this.errorDetails = errorDetails;
    }

    public T getResponse() {
        return response;
    }

    public ErrorDetails getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(ErrorDetails errorDetails) {
        this.errorDetails = errorDetails;
    }
}
