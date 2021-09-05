package com.aliyun.dkms.gcs.openapi.credential.provider;

import com.aliyun.dkms.gcs.openapi.credential.auth.AlibabaCloudCredentials;

public interface AlibabaCloudCredentialsProvider {
    AlibabaCloudCredentials getCredentials();
}
