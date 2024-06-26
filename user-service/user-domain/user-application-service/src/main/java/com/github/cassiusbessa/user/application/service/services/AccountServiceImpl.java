package com.github.cassiusbessa.user.application.service.services;

import com.github.cassiusbessa.user.application.service.dtos.AccountCreateCommand;
import com.github.cassiusbessa.user.application.service.dtos.AccountCreatedResponse;
import com.github.cassiusbessa.user.application.service.dtos.LoginCredentials;
import com.github.cassiusbessa.user.application.service.dtos.LoginResponse;
import com.github.cassiusbessa.user.application.service.mapper.AccountDataMapper;
import com.github.cassiusbessa.user.application.service.ports.input.AccountService;
import com.github.cassiusbessa.user.application.service.ports.output.AccountRepository;
import com.github.cassiusbessa.user.application.service.ports.output.ProfileRepository;
import com.github.cassiusbessa.user.application.service.services.crypto.CryptoService;
import com.github.cassiusbessa.user.domain.core.Account;
import com.github.cassiusbessa.vision.common.domain.core.valueobjects.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CryptoService cryptoService;
    private final AccountDataMapper accountDataMapper;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, CryptoService cryptoService, AccountDataMapper accountDataMapper) {
        this.accountRepository = accountRepository;
        this.cryptoService = cryptoService;
        this.accountDataMapper = accountDataMapper;
    }
    @Override
    public AccountCreatedResponse createAccount(AccountCreateCommand command) {
        log.info("Creating account with email: {}", command.getEmail());

        Account account = accountDataMapper.createAccountCommandToAccount(command);

        account.validate();
        if (!account.getFailureMessages().isEmpty()) {
            log.error("Account creation failed: {}", account.getFailureMessagesAsString());
            return new AccountCreatedResponse(account.getFailureMessagesAsString());
        }

        accountRepository.save(account);
        log.info("Account created successfully");
        return new AccountCreatedResponse("Account created successfully");
    }

    @Override
    public LoginResponse login(LoginCredentials credentials) {
        log.info("Logging in with email: {}", credentials.getEmail());

        Optional<Account> account = accountRepository.findByEmail(credentials.getEmail());
        if (account.isEmpty()) {
            log.error("Account not found with email: {}", credentials.getEmail());
            return new LoginResponse(null, "Invalid credentials");
        }

        if (!cryptoService.matches(credentials.getPassword(), account.get().getPassword().getValue())) {
            log.error("Invalid password for account with email: {}", credentials.getEmail());
            return new LoginResponse(null, "Invalid credentials");
        }

        log.info("Logged in successfully with email: {}", credentials.getEmail());
        return new LoginResponse("token", "Logged in successfully");
    }
}
