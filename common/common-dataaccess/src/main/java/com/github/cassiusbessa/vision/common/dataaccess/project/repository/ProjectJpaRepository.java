package com.github.cassiusbessa.vision.common.dataaccess.project.repository;

import com.github.cassiusbessa.vision.common.dataaccess.project.entities.ProjectDataBaseEntity;
import com.github.cassiusbessa.vision.common.dataaccess.tag.entities.TagDataBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectJpaRepository extends JpaRepository<ProjectDataBaseEntity, UUID>{

}
