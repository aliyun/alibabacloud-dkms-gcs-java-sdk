package com.aliyun.dkms.gcs.openapi.credential.auth;

public abstract class Signer {
    private static final Signer SHA256_WITH_RSA_SIGNER = new SHA256withRSASigner();

    public static Signer getSigner(AlibabaCloudCredentials credentials) {
        if (credentials instanceof RsaKeyPairCredentials) {
            return SHA256_WITH_RSA_SIGNER;
        }else {
            throw new IllegalArgumentException("Only support rsa key pair credential now.");
        }
    }

    public abstract String signString(String stringToSign, AlibabaCloudCredentials credentials);

    public abstract String signString(String stringToSign, String accessKeySecret);

    public abstract String getSignerName();

    public abstract String getSignerVersion();

    public abstract String getSignerType();

}
