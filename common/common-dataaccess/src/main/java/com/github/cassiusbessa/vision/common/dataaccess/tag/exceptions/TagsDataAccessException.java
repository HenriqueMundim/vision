package com.github.cassiusbessa.vision.common.dataaccess.tag.exceptions;

public class TagsDataAccessException extends RuntimeException {
    public TagsDataAccessException(String message) {
        super(message);
    }

    public TagsDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
