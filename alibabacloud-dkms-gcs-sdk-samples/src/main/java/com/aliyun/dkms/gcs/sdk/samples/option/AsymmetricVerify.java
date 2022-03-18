package com.aliyun.dkms.gcs.sdk.samples.option;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.VerifyRequest;
import com.aliyun.dkms.gcs.sdk.models.VerifyResponse;
import com.aliyun.tea.TeaException;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.kms.model.v20160120.*;
import com.aliyuncs.profile.DefaultProfile;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class AsymmetricVerify {
    public static void main(String[] args) {
        asymmetricVerifyKmsSample();
        asymmetricVerifyDKmsSample();

    }

    /**
     * 共享kms非对称签名验证sample
     */
    public static void asymmetricVerifyKmsSample() {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<your-access-key-id>", "<your-access-key-secret>");

        /** use STS Token
         DefaultProfile profile = DefaultProfile.getProfile(
         "<your-region-id>",           // The region ID
         "<your-access-key-id>",       // The AccessKey ID of the RAM account
         "<your-access-key-secret>",   // The AccessKey Secret of the RAM account
         "<your-sts-token>");          // STS Token
         **/
        IAcsClient client = new DefaultAcsClient(profile);

        AsymmetricVerifyRequest request = new AsymmetricVerifyRequest();
        request.setKeyId("<your-key-id>");
        request.setKeyVersionId("<your-key-version-id>");
        request.setAlgorithm("<your-algorithm>");
        request.setDigest("<your-digest>");
        request.setValue("<your-value>");

        try {
            AsymmetricVerifyResponse response = client.getAcsResponse(request);
            System.out.printf("KeyId: %s%n", response.getKeyId());
            System.out.printf("KeyVersionId: %s%n", response.getKeyVersionId());
            System.out.printf("Value: %s%n", response.getValue());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
    }

    /**
     * 专属kms非对称签名验证sample
     */
    public static void asymmetricVerifyDKmsSample() {
        Config config = new Config();
        config.setProtocol("https");
        config.setClientKeyFile("<your-client-key-file>");
        config.setPassword("<your-password>");
        config.setEndpoint("<your-endpoint>");
        try {
            Client client = new Client(config);
            asymmetricVerify(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void asymmetricVerify(Client client) throws Exception {
        String keyId = "<your-key-id>";
        String algorithm = "<your-algorithm>";
        byte[] digest = getDigest("<your-message>");
        // 待签名数据类型，RAW-原始消息，DIGEST-摘要
        String messageType = "DIGEST";
        // 待验证签名值
        byte[] signature = "<the signature value>".getBytes(StandardCharsets.UTF_8);
        VerifyRequest verifyRequest = new VerifyRequest();
        verifyRequest.setKeyId(keyId);
        verifyRequest.setAlgorithm(algorithm);
        verifyRequest.setMessage(digest);
        verifyRequest.setMessageType(messageType);
        verifyRequest.setSignature(signature);
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            VerifyResponse verifyResponse = client.verifyWithOptions(verifyRequest, runtimeOptions);
            System.out.println("================verify================");
            System.out.printf("KeyId: %s%n", verifyResponse.getKeyId());
            //验签结果
            System.out.printf("Value: %s%n", verifyResponse.getValue());
            System.out.println("================verify================");
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("Code: %s%n", ((TeaException) e).getCode());
                System.out.printf("Message: %s%n", ((TeaException) e).getMessage());
                System.out.printf("HttpCode: %s%n", ((TeaException) e).getData().get("httpCode"));
                System.out.printf("HostId: %s%n", ((TeaException) e).getData().get("hostId"));
                System.out.printf("RequestId: %s%n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("verify errMsg: %s%n", e.getMessage());
            }
            e.printStackTrace();
        }
    }

    private static byte[] getDigest(String message) throws Exception {
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        return sha256.digest(message.getBytes(StandardCharsets.UTF_8));
    }
}