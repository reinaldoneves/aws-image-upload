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
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Naldo", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Letiere Leite", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Moacir Santos", null));
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
