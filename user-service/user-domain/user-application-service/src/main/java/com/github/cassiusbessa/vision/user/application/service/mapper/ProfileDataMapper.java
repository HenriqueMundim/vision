package com.github.cassiusbessa.vision.user.application.service.mapper;

import com.github.cassiusbessa.vision.user.application.service.dtos.ProfileCreateCommand;
import com.github.cassiusbessa.vision.user.application.service.dtos.ProfileUpdateCommand;
import com.github.cassiusbessa.vision.user.domain.core.Profile;
import com.github.cassiusbessa.vision.common.domain.core.valueobjects.AccountId;
import com.github.cassiusbessa.vision.common.domain.core.valueobjects.ProfileId;
import com.github.cassiusbessa.vision.common.domain.core.valueobjects.TagId;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ProfileDataMapper {

    public Profile createProfileCommandToProfile(ProfileCreateCommand command) {
        return Profile.builder()
                .withId(new ProfileId(UUID.randomUUID()))
                .withName(command.getName())
                .withTitle(command.getTitle())
                .withDescription(command.getDescription())
                .withAccountId(new AccountId(command.getAccountId()))
                .withTechnologies(Optional.ofNullable(command.getTechnologies())
                        .orElse(Collections.emptyList()).stream()
                        .map(TagId::new)
                        .collect(Collectors.toList()))
                .build();
    }

    public Profile updateProfileCommandToProfile(ProfileUpdateCommand command) {
        return Profile.builder()
                .withId(new ProfileId(command.getProfileId()))
                .withName(command.getName())
                .withTitle(command.getTitle())
                .withDescription(command.getDescription())
                .withAccountId(new AccountId(command.getAccountId()))
                .withTechnologies(Optional.ofNullable(command.getTechnologies())
                        .orElse(Collections.emptyList()).stream()
                        .map(TagId::new)
                        .collect(Collectors.toList()))
                .build();
    }
}

