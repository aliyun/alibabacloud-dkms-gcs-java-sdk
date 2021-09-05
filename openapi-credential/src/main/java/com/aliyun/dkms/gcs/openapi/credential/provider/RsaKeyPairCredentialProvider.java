package com.aliyun.dkms.gcs.openapi.credential.provider;

import com.aliyun.dkms.gcs.openapi.credential.auth.AlibabaCloudCredentials;
import com.aliyun.dkms.gcs.openapi.credential.auth.RsaKeyPairCredentials;

public class RsaKeyPairCredentialProvider implements AlibabaCloudCredentialsProvider {
    private AlibabaCloudCredentials credentials;

    public RsaKeyPairCredentialProvider(AlibabaCloudCredentials credentials) {
        this.credentials = credentials;
    }

    public RsaKeyPairCredentialProvider(String keyId, String privateKey) {
        this.credentials = new RsaKeyPairCredentials(keyId, privateKey);
    }

    @Override
    public AlibabaCloudCredentials getCredentials() {
        return credentials;
    }
}
