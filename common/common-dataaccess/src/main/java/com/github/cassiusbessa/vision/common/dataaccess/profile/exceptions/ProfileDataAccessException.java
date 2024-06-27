package com.github.cassiusbessa.vision.common.dataaccess.profile.exceptions;

public class ProfileDataAccessException extends RuntimeException {
    public ProfileDataAccessException(String message) {
        super(message);
    }

    public ProfileDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
