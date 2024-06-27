package com.github.cassiusbessa.vision.user.application.service.dtos;

public class ProfileUpdatedResponse {

    private final String message;

    public ProfileUpdatedResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
