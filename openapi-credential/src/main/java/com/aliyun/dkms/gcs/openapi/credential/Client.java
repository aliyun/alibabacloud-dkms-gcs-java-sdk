// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.openapi.credential;

import com.aliyun.dkms.gcs.openapi.credential.auth.AlibabaCloudCredentials;
import com.aliyun.dkms.gcs.openapi.credential.auth.Signer;
import com.aliyun.dkms.gcs.openapi.credential.provider.AlibabaCloudCredentialsProvider;
import com.aliyun.dkms.gcs.openapi.credential.provider.RsaKeyPairCredentialProvider;
import com.aliyun.dkms.gcs.openapi.credential.utils.KeyStoreUtils;
import com.aliyun.dkms.gcs.openapi.credential.models.*;
import com.aliyun.dkms.gcs.openapi.util.JsonUtils;
import com.aliyun.tea.utils.StringUtils;

import java.util.Base64;

public class Client {
    private AlibabaCloudCredentialsProvider credentialsProvider;

    public Client(Config config) throws Exception {
        if ("rsa_key_pair".equals(config.type)) {
            if (!StringUtils.isEmpty(config.clientKeyContent)) {
                ClientKey clientKey = JsonUtils.parseJson(config.clientKeyContent, ClientKey.class);
                byte[] privateKeyData = Base64.getDecoder().decode(clientKey.getPrivateKeyData());
                String privateKeyPem = KeyStoreUtils.getPrivateKeyPemFromPk12(privateKeyData, config.getPassword());
                this.credentialsProvider = new RsaKeyPairCredentialProvider(clientKey.getKeyId(), privateKeyPem);
            } else if (!StringUtils.isEmpty(config.clientKeyFile)) {
                ClientKey clientKey = JsonUtils.readObject(config.clientKeyFile, ClientKey.class);
                if (clientKey == null) {
                    throw new IllegalArgumentException(String.format("read client key file failed: %s", config.clientKeyFile));
                }
                byte[] privateKeyData = Base64.getDecoder().decode(clientKey.getPrivateKeyData());
                String privateKeyPem = KeyStoreUtils.getPrivateKeyPemFromPk12(privateKeyData, config.getPassword());
                this.credentialsProvider = new RsaKeyPairCredentialProvider(clientKey.getKeyId(), privateKeyPem);
            } else {
                this.credentialsProvider = new RsaKeyPairCredentialProvider(config.accessKeyId, config.privateKey);
            }
        } else {
            throw new IllegalArgumentException("Only support rsa key pair credential provider now.");
        }
    }

    public void setCredentialsProvider(AlibabaCloudCredentialsProvider credentialsProvider) {
        this.credentialsProvider = credentialsProvider;
    }

    public String getAccessKeyId() throws Exception {
        return this.credentialsProvider.getCredentials().getAccessKeyId();
    }

    public String getAccessKeySecret() throws Exception {
        return this.credentialsProvider.getCredentials().getAccessKeySecret();
    }

    public String getSignature(String strToSign) throws Exception {
        AlibabaCloudCredentials credentials = this.credentialsProvider.getCredentials();
        Signer signer = Signer.getSigner(credentials);
        return signer.signString(strToSign, credentials.getAccessKeySecret());
    }
}
