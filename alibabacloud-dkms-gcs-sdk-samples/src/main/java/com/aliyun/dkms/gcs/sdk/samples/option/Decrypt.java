package com.aliyun.dkms.gcs.sdk.samples.option;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.tea.TeaException;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.kms.model.v20160120.*;
import com.aliyuncs.profile.DefaultProfile;


import java.nio.charset.StandardCharsets;

public class Decrypt {

    public static void main(String[] args) {
        decryptKmsSample();
        decryptDKmsSample();
    }

    /**
     * 共享kms解密sample
     */
    public static void decryptKmsSample() {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<your-access-key-id>", "<your-access-key-secret>");
        /** use STS Token
         DefaultProfile profile = DefaultProfile.getProfile(
         "<your-region-id>",           // The region ID
         "<your-access-key-id>",       // The AccessKey ID of the RAM account
         "<your-access-key-secret>",   // The AccessKey Secret of the RAM account
         "<your-sts-token>");          // STS Token
         **/
        IAcsClient client = new DefaultAcsClient(profile);

        DecryptRequest request = new DecryptRequest();
        request.setCiphertextBlob("<your-ciphertext-blob>");

        try {
            DecryptResponse response = client.getAcsResponse(request);
            System.out.printf("KeyId: %s%n", response.getKeyId());
            System.out.printf("KeyVersionId: %s%n", response.getKeyVersionId());
            System.out.printf("Plaintext: %s%n", response.getPlaintext());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
    }

    /**
     * 专属kms解密sample
     */
    public static void decryptDKmsSample() {
        Config config = new Config();
        config.setProtocol("https");
        config.setClientKeyFile("<your-client-key-file>");
        config.setPassword("<your-password>");
        config.setEndpoint("<your-endpoint>");
        try {
            Client client = new Client(config);
            decrypt(client);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void decrypt(Client client) {
        String keyId = "<your-key-id>";
        com.aliyun.dkms.gcs.sdk.models.DecryptRequest decryptRequest = new com.aliyun.dkms.gcs.sdk.models.DecryptRequest();
        decryptRequest.setKeyId(keyId);
        decryptRequest.setIv("<your-encrypt-response-iv>".getBytes());
        decryptRequest.setCiphertextBlob("<your-encrypt-response-ciphertext-blob>".getBytes());
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            com.aliyun.dkms.gcs.sdk.models.DecryptResponse decryptResponse = client.decryptWithOptions(decryptRequest, runtimeOptions);
            System.out.printf("KeyId: %s%n", decryptResponse.getKeyId());
            System.out.printf("Plaintext: %s%n", new String(decryptResponse.getPlaintext(), StandardCharsets.UTF_8));
            System.out.printf("RequestId: %s%n", decryptResponse.getRequestId());
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("code: %s%n", ((TeaException) e).getCode());
                System.out.printf("message: %s%n", ((TeaException) e).getMessage());
                System.out.printf("requestId: %s%n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("encrypt err: %s%n", e.getMessage());
            }
            e.printStackTrace();
        }
    }
}