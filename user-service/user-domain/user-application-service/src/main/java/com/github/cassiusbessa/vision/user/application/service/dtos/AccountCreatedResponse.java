package com.github.cassiusbessa.vision.user.application.service.dtos;

public class AccountCreatedResponse {

    private final String message;

    public AccountCreatedResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
