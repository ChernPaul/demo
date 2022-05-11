package com.messenger.model;

import com.messenger.utils.Helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProfileContext implements Serializable {


    private ProfileContext() {
        this.profiles = null;
    }

    private List<Profile> profiles;
    private static class SingletonHolder {
        private final static ProfileContext instance = new ProfileContext();
    }

    public static ProfileContext getInstance() {
        return SingletonHolder.instance;
    }




    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public void removeProfileByID(UUID profileId){
        this.getProfiles().removeIf(profile -> profile.getProfileUUID().equals(profileId));
    }


    public void pushBack(Profile profile) {
        profiles.add(profile);
    }

    public List<UUID> getProfilesUUIDByName(String name, double percentage) {
        List<UUID> result = new ArrayList<>();
        for (Profile profile: this.profiles) {
            String profileName = profile.getProfileName();
            double curPercentage = (double) Helper.StrCompare(profileName, name) / name.length();
            if (curPercentage > percentage)
                result.add(profile.getProfileUUID());
        }
        return result;
    }


    public Profile getProfileByUUID(UUID id) {
        for (Profile profile: this.getProfiles()) {
            if (profile.getProfileUUID().equals(id)) {
                return profile;
            }
        }
        return null;
    }


    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        result.append("ConversationContext {").append('\n');
        for (int i = 0; i < profiles.size(); i++) {
            result.append(profiles.get(i).toString()).append('\n').append(" }");
        }
        return result.toString();
    }

}