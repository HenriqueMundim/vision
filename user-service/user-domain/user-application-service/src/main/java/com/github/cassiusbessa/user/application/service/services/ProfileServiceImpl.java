package com.github.cassiusbessa.user.application.service.services;

import com.github.cassiusbessa.user.application.service.dtos.*;
import com.github.cassiusbessa.user.application.service.mapper.ProfileDataMapper;
import com.github.cassiusbessa.user.application.service.ports.input.ProfileService;
import com.github.cassiusbessa.user.application.service.ports.output.ProfileRepository;
import com.github.cassiusbessa.user.domain.core.Profile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileDataMapper profileDataMapper;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository, ProfileDataMapper profileDataMapper) {
        this.profileRepository = profileRepository;
        this.profileDataMapper = profileDataMapper;
    }

    @Override
    public ProfileCreatedResponse createProfile(ProfileCreateCommand command) {
        log.info("Creating profile with name: {} to this account: {}", command.getName(), command.getAccountId());

        Profile foundProfile = profileRepository.findByAccountId(command.getAccountId()).orElse(null);
        if (foundProfile != null) {
            log.error("Profile already exists for this account: {}", command.getAccountId());
            return new ProfileCreatedResponse("Profile already exists for this account");
        }

        Profile profile = profileDataMapper.createProfileCommandToProfile(command);

        profile.validate();
        if (!profile.getFailureMessages().isEmpty()) {
            log.error("Profile creation failed: {}", profile.getFailureMessagesAsString());
            return new ProfileCreatedResponse(profile.getFailureMessagesAsString());
        }

        profileRepository.save(profile);
        log.info("Profile created successfully");
        return new ProfileCreatedResponse("Profile created successfully");
    }

    @Override
    public ProfileUpdatedResponse updateProfile(ProfileUpdateCommand command) {
        log.info("Updating profile with id: {}", command.getProfileId());

        Profile profile = profileDataMapper.updateProfileCommandToProfile(command);

        profile.validate();
        if (!profile.getFailureMessages().isEmpty()) {
            log.error("Profile update failed: {}", profile.getFailureMessagesAsString());
            return new ProfileUpdatedResponse(profile.getFailureMessagesAsString());
        }

        profileRepository.update(profile);
        log.info("Profile updated successfully");
        return new ProfileUpdatedResponse("Profile updated successfully");
    }

    @Override
    public LoadProfileResponse loadProfileById(LoadProfileByIdQuery query) {
        log.info("Loading profile with id: {}", query.getId());

        Profile profile = profileRepository.findByProfileId(query.getId()).orElse(null);
        if (profile != null) {
            log.info("Profile loaded by profile id successfully");
            return new LoadProfileResponse(profile, "Profile loaded successfully");
        }

        log.error("Profile not found with id: {}", query.getId());
        return new LoadProfileResponse(null, "Profile not found");
    }

    @Override
    public LoadProfileResponse loadProfileByAccountId(LoadProfileByAccountIdQuery query) {
        log.info("Loading profile with account id: {}", query.getId());

        Profile profile = profileRepository.findByAccountId(query.getId()).orElse(null);
        if (profile != null) {
            log.info("Profile loaded by account successfully");
            return new LoadProfileResponse(profile, "Profile loaded successfully");
        }

        log.error("Profile not found with account id: {}", query.getId());
        return new LoadProfileResponse(null, "Profile not found");
    }
}
