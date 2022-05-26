package br.com.naldo.awsimageupload.bucket;

public enum BucketName {

    PROFILE_IMAGE("naldosbucket-image-upload-321");

    private String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
