package com.github.cassiusbessa.vision.user.dataaccess.account;

import com.github.cassiusbessa.vision.common.dataaccess.account.entities.AccountDataBaseEntity;
import com.github.cassiusbessa.vision.common.dataaccess.account.repository.AccountJpaRepository;
import com.github.cassiusbessa.vision.user.application.service.ports.output.AccountRepository;
import com.github.cassiusbessa.vision.user.domain.core.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountRepoImpl implements AccountRepository {

    private final AccountJpaRepository accountJpaRepository;

    private final AccountDataMapper accountDataMapper;

    @Autowired
    public AccountRepoImpl(AccountJpaRepository accountJpaRepository, AccountDataMapper accountDataMapper) {
        this.accountJpaRepository = accountJpaRepository;
        this.accountDataMapper = accountDataMapper;
    }
    @Override
    public Optional<Account> findByEmail(String email) {
        return accountJpaRepository.findByEmail(email).map(accountDataMapper::accountDbEntityToAccountDomain);
    }

    @Override
    public void save(Account account) {

        accountJpaRepository.save(accountDataMapper.accountDomainToAccountDbEntity(account));

    }
}
