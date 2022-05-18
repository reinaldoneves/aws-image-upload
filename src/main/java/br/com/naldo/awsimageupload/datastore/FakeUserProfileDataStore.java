package br.com.naldo.awsimageupload.datastore;

import br.com.naldo.awsimageupload.profile.UserProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class FakeUserProfileDataStore {

    public static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Naldo", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "James Hetfield", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Kirk Hammett", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Lars Ulrich", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Robert Trujillo", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Steve Vai", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "John Bonham", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "John Paul Jones", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Jimmy Page", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Robert Plant", null));
    }

}
