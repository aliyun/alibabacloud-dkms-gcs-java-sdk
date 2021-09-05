package com.aliyun.dkms.gcs.openapi.credential.auth;

public class RsaKeyPairCredentials implements AlibabaCloudCredentials {
    private  String privateKeySecret;
    private  String keyId;

    public RsaKeyPairCredentials(String keyId, String privateKeySecret) {
        if (privateKeySecret != null) {
            this.keyId = keyId;
            this.privateKeySecret = privateKeySecret;
        } else {
            throw new IllegalArgumentException("You must provide a valid Private Key Secret.");
        }
    }

    public String getAccessKeyId() {
        return this.keyId;
    }

    public String getAccessKeySecret() {
        return this.privateKeySecret;
    }
}
