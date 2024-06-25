package com.github.cassiusbessa.vision.common.domain.core.valueobjects;

import com.github.cassiusbessa.vision.common.domain.core.exceptions.DomainException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Email {
    private final String value;

    public Email(String value) {
        if (!isValid(value)) {
            log.error("Invalid email {} in common domain", value);
            throw new DomainException("Invalid email");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex) && email.length() <= 100;
    }
}
