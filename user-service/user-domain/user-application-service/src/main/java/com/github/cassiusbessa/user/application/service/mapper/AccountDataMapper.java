package com.github.cassiusbessa.user.application.service.mapper;

import com.github.cassiusbessa.user.application.service.dtos.AccountCreateCommand;
import com.github.cassiusbessa.user.application.service.services.crypto.CryptoService;
import com.github.cassiusbessa.user.domain.core.Account;
import com.github.cassiusbessa.vision.common.domain.core.valueobjects.AccountId;
import com.github.cassiusbessa.vision.common.domain.core.valueobjects.Email;
import com.github.cassiusbessa.vision.common.domain.core.valueobjects.Password;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

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
