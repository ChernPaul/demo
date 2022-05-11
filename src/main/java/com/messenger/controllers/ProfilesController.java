package com.messenger.controllers;
import com.messenger.model.*;
import com.messenger.repos.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.UUID;


@Controller
@RequestMapping("/profiles")
public class ProfilesController {

    @Autowired
    ProfilesRepository profilesRepository;
    private static class PathVariables{
        public static final String PROFILE_ID = "profile_id";
    }
    private static class Views{
        public static final String VIEW_PROFILE = "viewProfile";
    }

    private static class ModelAttributes{
        public static final String Profile = "profile";
    }

    private static class Endpoints{
        public static final String VIEW_PROFILE = "/{profile_id}/view";

    }



    @GetMapping("/{profile_id}/view")
    public String getProfileDataById(@PathVariable(PathVariables.PROFILE_ID)
                                              UUID profile_id, Model model) {
        Profile currentProfile = ProfileContext.getInstance().getProfileByUUID(profile_id);
        model.addAttribute(ModelAttributes.Profile, currentProfile);
        saveProfileData(currentProfile);
        return Views.VIEW_PROFILE;
    }



    public void saveProfileData(Profile profile) {
        profilesRepository.save(profile);
    }






}
