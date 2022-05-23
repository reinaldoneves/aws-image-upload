package br.com.naldo.awsimageupload.profile;

import br.com.naldo.awsimageupload.bucket.BucketName;
import br.com.naldo.awsimageupload.filestore.FileStore;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.springframework.http.MediaType.IMAGE_GIF;
import static org.springframework.http.MediaType.IMAGE_PNG;

@Service
public class UserProfileService {

    private final UserProfileDataAccessService userProfileDataAccessService;
    private final FileStore fileStore;

    @Autowired
    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService, FileStore fileStore) {
        this.userProfileDataAccessService = userProfileDataAccessService;
        this.fileStore = fileStore;
    }

    List<UserProfile> getUserProfiles(){
        System.out.println("\nCrap debugging");
        System.out.println("\n ######################### \n Getting all user profiles");
        return userProfileDataAccessService.getUserProfiles();
    }

    /***
     * Go to Front end and implement that stuff
     * https://youtu.be/i-hoSg8iRG0?t=2960
     * @param userProfileId
     * @param file
     *
     * TODO: Continuar daqui https://youtu.be/i-hoSg8iRG0?t=5374
     */
    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {

        System.out.println("\nCrap debugging");
        System.out.println("\n ######################### \n Uploading user profile image");

        //TODO: 1 - Check if image isnt empty
        isThisFileEmpty(file);

        //TODO 2 - Check if is an image
        isThisFileAnImage(file);

        //TODO 3 - Check if user exists in database
        UserProfile user = getUserProfile(userProfileId);

        //TODO 4 - Grab some metadata from file if any
        Map<String, String> metadata = extractMetadata(file);

        //TODO 5 - Store image to S3 and update database with s3 image link/url
        String path = String.format("%s/%s",
                BucketName.PROFILE_IMAGE.getBucketName(),
                user.getUserProfileId());

        String filename = String.format("%s-%s", file.getName(),
                UUID.randomUUID());

        try {
            fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }

    private Map<String, String> extractMetadata(MultipartFile file) {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        return metadata;
    }

    private UserProfile getUserProfile(UUID userProfileId) {
        return userProfileDataAccessService
                .getUserProfiles()
                .stream()
                .filter(userProfile ->
                        userProfile
                                .getUserProfileId()
                                .equals(userProfileId))
                .findFirst().orElseThrow(() -> new IllegalStateException(String.format("UserProfile %s not found", userProfileId)));
    }

    private void isThisFileAnImage(MultipartFile file) {
        if(!Arrays.asList(ContentType.IMAGE_JPEG.getMimeType(), ContentType.IMAGE_PNG.getMimeType(), ContentType.IMAGE_GIF.getMimeType())
                .contains(file.getContentType()))
            throw new IllegalStateException("Image must be jpeg, png or gif [" + file.getContentType() + "]");
    }

    private void isThisFileEmpty(MultipartFile file) {
        if(file.isEmpty()) throw new IllegalStateException("Cannot upload empty file [ " + file.getSize() + " ]");
    }
}
