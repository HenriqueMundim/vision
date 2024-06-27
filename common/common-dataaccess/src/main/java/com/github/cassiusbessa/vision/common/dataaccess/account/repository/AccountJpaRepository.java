package com.github.cassiusbessa.vision.common.dataaccess.account.repository;

import com.github.cassiusbessa.vision.common.dataaccess.account.entities.AccountDataBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountJpaRepository extends JpaRepository<AccountDataBaseEntity, UUID>{

}
