package com.messenger.repos;

import com.messenger.model.Profile;
import com.messenger.model.TextMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ProfilesRepository extends CrudRepository<Profile, UUID>{
}