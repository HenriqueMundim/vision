package com.github.cassiusbessa.vision.common.dataaccess.project.exceptions;

public class ProjectDataAccessException extends RuntimeException {
    public ProjectDataAccessException(String message) {
        super(message);
    }

    public ProjectDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
