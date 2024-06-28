package com.github.cassiusbessa.vision.common.dataaccess.profile.repository;

import com.github.cassiusbessa.vision.common.dataaccess.profile.entities.ProfileDataBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfileJpaRepository extends JpaRepository<ProfileDataBaseEntity, UUID>{

}
