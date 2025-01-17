package com.github.cassiusbessa.vision.user.application.service.dtos;

import java.util.List;
import java.util.UUID;

public class ProfileUpdateCommand {

    private final UUID profileId;
    private final String name;
    private final String title;
    private final String description;
    private final List<UUID> technologies;
    private final UUID accountId;

    public ProfileUpdateCommand(UUID profileId, String name, String title, String description, List<UUID> technologies, UUID accountId) {
        this.profileId = profileId;
        this.name = name;
        this.title = title;
        this.description = description;
        this.technologies = technologies;
        this.accountId = accountId;
    }

    public UUID getProfileId() { return profileId; }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<UUID> getTechnologies() {
        return technologies;
    }

    public UUID getAccountId() {
        return accountId;
    }

}
