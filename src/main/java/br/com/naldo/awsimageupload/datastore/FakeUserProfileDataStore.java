package br.com.naldo.awsimageupload.datastore;

import br.com.naldo.awsimageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {

    public static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.fromString("fb41bb7d-c65f-433a-9421-d00f45d0ba0a"), "Naldo", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("841123bb-a1e0-48ea-8754-6f89472b192b"), "Letieres Leite", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("719a74a8-922a-4540-8c43-340d214d95f6"), "Moacir Santos", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Pixinguinha", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Jacob do Bandolim", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Raphael Rabello", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "John Bonham", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Altamiro Carrilho", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Stravinsky", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Guinga", null));
    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }

}
