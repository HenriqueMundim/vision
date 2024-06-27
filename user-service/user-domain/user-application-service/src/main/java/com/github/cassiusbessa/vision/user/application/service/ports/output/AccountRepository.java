package com.github.cassiusbessa.vision.user.application.service.ports.output;

import java.util.Optional;

import com.github.cassiusbessa.vision.user.domain.core.Account;

public interface AccountRepository {

    Optional<Account> findByEmail(String email);

    void save(Account account);

}
