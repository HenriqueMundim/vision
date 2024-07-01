package com.github.cassiusbessa.vision.application.rest;

import com.github.cassiusbessa.vision.user.application.service.dtos.AccountCreateCommand;
import com.github.cassiusbessa.vision.user.application.service.dtos.AccountCreatedResponse;
import com.github.cassiusbessa.vision.user.application.service.ports.input.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/users", produces = "application/json", consumes = "application/json", headers = "Accept=application/json")
public class UserController {

    private final AccountService accountService;

    @Autowired
    public UserController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping()
    public ResponseEntity<AccountCreatedResponse> createAccount(@RequestBody AccountCreateCommand accountCreateCommand) {
        log.info("Creating account");
        AccountCreatedResponse accountCreatedResponse = accountService.createAccount(accountCreateCommand);
        return ResponseEntity.ok(accountCreatedResponse);
    }

    @GetMapping()
    public ResponseEntity<String> getAccount() {
        log.info("Getting account");
        return ResponseEntity.ok("Account");
    }
}
