package com.github.cassiusbessa.vision.common.dataaccess.account.entities;

import com.github.cassiusbessa.vision.common.dataaccess.profile.entities.ProfileDataBaseEntity;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "accounts")
public class AccountDataBaseEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private ProfileDataBaseEntity profile;

    public AccountDataBaseEntity() {
    }

    public AccountDataBaseEntity(UUID id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ProfileDataBaseEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileDataBaseEntity profile) {
        this.profile = profile;
    }
}
