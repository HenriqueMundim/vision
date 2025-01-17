package com.github.cassiusbessa.vision.user.application.service.mapper;

import com.github.cassiusbessa.vision.user.application.service.dtos.AccountCreateCommand;
import com.github.cassiusbessa.vision.user.application.service.services.crypto.CryptoService;
import com.github.cassiusbessa.vision.user.domain.core.Account;
import com.github.cassiusbessa.vision.common.domain.core.valueobjects.Email;
import com.github.cassiusbessa.vision.common.domain.core.valueobjects.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AccountDataMapper {

    private final CryptoService cryptoService;

    @Autowired
    public AccountDataMapper(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    public Account createAccountCommandToAccount(AccountCreateCommand command) {
        return Account.builder()
                .withId(UUID.randomUUID())
                .withEmail(new Email(command.getEmail()))
                .withPassword(new Password(cryptoService.encrypt(command.getPassword())))
                .build();
    }
}
