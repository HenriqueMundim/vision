package com.github.cassiusbessa.vision.common.dataaccess.account.exceptions;

public class AccountDataAccessException extends RuntimeException {
    public AccountDataAccessException(String message) {
        super(message);
    }

    public AccountDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
