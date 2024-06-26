package com.github.cassiusbessa.user.application.service.ports.input;

import com.github.cassiusbessa.user.application.service.dtos.AccountCreateCommand;
import com.github.cassiusbessa.user.application.service.dtos.AccountCreatedResponse;
import com.github.cassiusbessa.user.application.service.dtos.LoginCredentials;
import com.github.cassiusbessa.user.application.service.dtos.LoginResponse;

public interface AccountService {

    AccountCreatedResponse createAccount(AccountCreateCommand command);

    LoginResponse login(LoginCredentials credentials);
}
