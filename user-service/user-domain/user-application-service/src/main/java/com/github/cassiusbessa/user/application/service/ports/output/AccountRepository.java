package com.github.cassiusbessa.user.application.service.ports.output;

import java.util.Optional;

import com.github.cassiusbessa.user.domain.core.Account;

public interface AccountRepository {

    Optional<Account> findByEmail(String email);

    void save(Account account);

}
