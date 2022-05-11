package com.messenger.model;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "profile_id")
    private UUID profileUUID;
    @Column(name = "profile_name")
    private String profileName;
    @Column(name = "profile_info")
    private String profileDescription;

    public Profile(){
        profileUUID = null;
        profileName = null;
        profileDescription = null;
    }

    public Profile(UUID profileUUID, String profileName, String profileDescription){
        this.profileUUID = profileUUID;
        this.profileName = profileName;
        this.profileDescription = profileDescription;
    }


    public UUID getProfileUUID() {
        return profileUUID;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileUUID(UUID profileUUID) {
        this.profileUUID = profileUUID;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

}
