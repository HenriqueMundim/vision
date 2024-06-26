package com.github.cassiusbessa.user.application.service.ports.output;

import com.github.cassiusbessa.user.domain.core.Profile;

import java.util.Optional;
import java.util.UUID;

public interface ProfileRepository {

    Optional<Profile> findByProfileId(UUID accountId);

    Optional<Profile> findByAccountId(UUID accountId);

    void save(Profile profile);

    void update(Profile profile);
}
