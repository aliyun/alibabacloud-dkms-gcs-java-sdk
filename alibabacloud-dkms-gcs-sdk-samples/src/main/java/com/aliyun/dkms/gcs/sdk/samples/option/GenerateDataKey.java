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


import java.util.Arrays;

public class GenerateDataKey {

    public static void main(String[] args) {
        generateDataKeyKmsSample();
        generateDataKeyDKmsSample();
    }

    /**
     * 共享kms生成数据密钥sample
     */
    public static void generateDataKeyKmsSample() {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<your-access-key-id>", "<your-access-key-secret>");
        /** use STS Token
         DefaultProfile profile = DefaultProfile.getProfile(
         "<your-region-id>",           // The region ID
         "<your-access-key-id>",       // The AccessKey ID of the RAM account
         "<your-access-key-secret>",   // The AccessKey Secret of the RAM account
         "<your-sts-token>");          // STS Token
         **/
        IAcsClient client = new DefaultAcsClient(profile);

        GenerateDataKeyRequest request = new GenerateDataKeyRequest();
        request.setKeyId("<your-key-id>");
        try {
            GenerateDataKeyResponse response = client.getAcsResponse(request);
            System.out.printf("KeyId: %s%n", response.getKeyId());
            System.out.printf("KeyVersionId: %s%n", response.getKeyVersionId());
            System.out.printf("CiphertextBlob: %s%n", response.getCiphertextBlob());
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
     * 专属kms生成数据密钥sample
     */
    public static void generateDataKeyDKmsSample() {
        Config config = new Config();
        config.setProtocol("https");
        config.setClientKeyFile("<your-client-key-file>");
        config.setPassword("<your-password>");
        config.setEndpoint("<your-endpoint>");
        try {
            Client client = new Client(config);
            generateDataKey(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void generateDataKey(Client client) {
        String keyId = "<your-key-id>";
        Integer numberOfbytes = 32;

        com.aliyun.dkms.gcs.sdk.models.GenerateDataKeyRequest generateDataKeyRequest = new com.aliyun.dkms.gcs.sdk.models.GenerateDataKeyRequest();
        generateDataKeyRequest.setKeyId(keyId);
        generateDataKeyRequest.setNumberOfBytes(numberOfbytes);

        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;

        try {
            com.aliyun.dkms.gcs.sdk.models.GenerateDataKeyResponse generateDataKeyResponse = client.generateDataKeyWithOptions(generateDataKeyRequest, runtimeOptions);
            System.out.println("================generateDataKey================");
            System.out.printf("Plaintext: %s%n", Arrays.toString(generateDataKeyResponse.getPlaintext()));
            System.out.printf("CiphertextBlob: %s%n", Arrays.toString(generateDataKeyResponse.getCiphertextBlob()));
            System.out.printf("RequestId: %s%n", generateDataKeyResponse.getRequestId());
            System.out.println("================generateDataKey================");
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("Code: %s%n", ((TeaException) e).getCode());
                System.out.printf("Message: %s%n", ((TeaException) e).getMessage());
                System.out.printf("HttpCode: %s%n", ((TeaException) e).getData().get("httpCode"));
                System.out.printf("HostId: %s%n", ((TeaException) e).getData().get("hostId"));
                System.out.printf("RequestId: %s%n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("generateDataKey errMsg: %s%n", e.getMessage());
            }
            e.printStackTrace();
        }
    }
}