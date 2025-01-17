package com.github.cassiusbessa.vision.user.application.service.ports.input;

import com.github.cassiusbessa.vision.user.application.service.dtos.*;

public interface ProfileService {

    ProfileCreatedResponse createProfile(ProfileCreateCommand command);

    ProfileUpdatedResponse updateProfile(ProfileUpdateCommand command);

    LoadProfileResponse loadProfileById(LoadProfileByIdQuery query);

    LoadProfileResponse loadProfileByAccountId(LoadProfileByAccountIdQuery query);
}
