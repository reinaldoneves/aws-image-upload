package br.com.naldo.awsimageupload.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
public class UserProfileService {

    private final UserProfileDataAccessService userProfileDataAccessService;

    @Autowired
    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService) {
        this.userProfileDataAccessService = userProfileDataAccessService;
    }

    List<UserProfile> getUserProfiles(){
        return userProfileDataAccessService.getUserProfiles();
    }

    /***
     * Go to Front end and implement that stuff
     * https://youtu.be/i-hoSg8iRG0?t=2960
     * @param userProfileId
     * @param file
     */
    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
        //TODO: 1 - Check if image isnt empty

        //TODO 2 - Check if is an image

        //TODO 3 - Check if user exists in database

        //TODO 4 - Grab some metadata from file if any

        //TODO 5 - Store image to S3 and update database with s3 image link/url

    }
}
