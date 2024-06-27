package com.github.cassiusbessa.vision.user.application.service.services;

import com.github.cassiusbessa.vision.user.application.service.dtos.AccountCreateCommand;
import com.github.cassiusbessa.vision.user.application.service.dtos.AccountCreatedResponse;
import com.github.cassiusbessa.vision.user.application.service.dtos.LoginCredentials;
import com.github.cassiusbessa.vision.user.application.service.dtos.LoginResponse;
import com.github.cassiusbessa.vision.user.application.service.mapper.AccountDataMapper;
import com.github.cassiusbessa.vision.user.application.service.ports.input.AccountService;
import com.github.cassiusbessa.vision.user.application.service.ports.output.AccountRepository;
import com.github.cassiusbessa.vision.user.application.service.services.crypto.CryptoService;
import com.github.cassiusbessa.common.application.service.TokenService;
import com.github.cassiusbessa.vision.user.domain.core.Account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;

@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CryptoService cryptoService;
    private final AccountDataMapper accountDataMapper;
    private final TokenService tokenService;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, CryptoService cryptoService, AccountDataMapper accountDataMapper, TokenService tokenService) {
        this.accountRepository = accountRepository;
        this.cryptoService = cryptoService;
        this.accountDataMapper = accountDataMapper;
        this.tokenService = tokenService;
    }
    @Override
    public AccountCreatedResponse createAccount(AccountCreateCommand command) {
        log.info("Creating account with email: {}", command.getEmail());

        Account foundAccount = accountRepository.findByEmail(command.getEmail()).orElse(null);
        if (foundAccount != null) {
            log.error("Account already exists with email: {}", command.getEmail());
            return new AccountCreatedResponse("Account already exists with email: " + command.getEmail());
        }

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
        return new LoginResponse(tokenService.generateToken(account.get().getId().getValue()), "Logged in successfully");
    }
}
