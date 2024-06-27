package com.github.cassiusbessa.vision.common.dataaccess.tag.repository;

import com.github.cassiusbessa.vision.common.dataaccess.account.entities.AccountDataBaseEntity;
import com.github.cassiusbessa.vision.common.dataaccess.tag.entities.TagDataBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TagJpaRepository extends JpaRepository<TagDataBaseEntity, UUID>{

}
