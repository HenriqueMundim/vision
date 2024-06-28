package com.github.cassiusbessa.vision.user.dataaccess.account;

import com.github.cassiusbessa.vision.common.dataaccess.account.entities.AccountDataBaseEntity;
import com.github.cassiusbessa.vision.common.domain.core.valueobjects.AccountId;
import com.github.cassiusbessa.vision.common.domain.core.valueobjects.AccountLevel;
import com.github.cassiusbessa.vision.common.domain.core.valueobjects.Email;
import com.github.cassiusbessa.vision.common.domain.core.valueobjects.Password;
import com.github.cassiusbessa.vision.user.domain.core.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDataMapper {

    public Account accountDbEntityToAccountDomain(AccountDataBaseEntity accountDb) {

        Email email = new Email(accountDb.getEmail());
        Password password = new Password(accountDb.getPassword());
        AccountId accountId = new AccountId(accountDb.getId());
        return new Account(accountId, email, password, AccountLevel.FREE);
    }

    public AccountDataBaseEntity accountDomainToAccountDbEntity(Account account) {
        AccountDataBaseEntity accountDb = new AccountDataBaseEntity();
        accountDb.setId(account.getId().getValue());
        accountDb.setEmail(account.getEmail().getValue());
        accountDb.setPassword(account.getPassword().getValue());
        return accountDb;
    }
}
