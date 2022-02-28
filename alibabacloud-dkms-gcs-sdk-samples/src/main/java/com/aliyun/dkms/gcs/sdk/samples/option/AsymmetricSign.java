package com.aliyun.dkms.gcs.sdk.samples.option;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.SignRequest;
import com.aliyun.dkms.gcs.sdk.models.SignResponse;
import com.aliyun.tea.TeaException;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.kms.model.v20160120.*;
import com.aliyuncs.profile.DefaultProfile;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

public class AsymmetricSign {

    public static void main(String[] args) {
        asymmetricSignKmsSample();
        asymmetricSignDKmsSample();

    }

    public static void asymmetricSignKmsSample() {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<your-access-key-id>", "<your-access-key-secret>");

        /** use STS Token
         DefaultProfile profile = DefaultProfile.getProfile(
         "<your-region-id>",           // The region ID
         "<your-access-key-id>",       // The AccessKey ID of the RAM account
         "<your-access-key-secret>",   // The AccessKey Secret of the RAM account
         "<your-sts-token>");          // STS Token
         **/
        IAcsClient client = new DefaultAcsClient(profile);

        AsymmetricSignRequest request = new AsymmetricSignRequest();
        request.setKeyId("<your-key-id>");
        request.setKeyVersionId("<your-key-version-id>");
        request.setAlgorithm("<your-algorithm>");
        request.setDigest("<your-digest>");
        try {
            AsymmetricSignResponse response = client.getAcsResponse(request);
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
     * 专属kms非对称生成签名sample
     */
    public static void asymmetricSignDKmsSample() {
        Config config = new Config();
        config.setProtocol("https");
        config.setClientKeyFile("<your-client-key-file>");
        config.setPassword("<your-password>");
        config.setEndpoint("<your-endpoint>");

        try {
            Client client = new Client(config);
            asymmetricSign(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SignResponse asymmetricSign(Client client) throws Exception {
        //用于签名的密钥Id
        String keyId = "<your-key-id>";
        //签名算法
        String algorithm = "<your-algorithm>";
        //用于签名的消息
        byte[] digest = getDigest("<your-message>");
        // 待签名数据类型，RAW-原始消息，DIGEST-摘要
        String messageType = "DIGEST";
        SignRequest signRequest = new SignRequest();
        signRequest.setKeyId(keyId);
        signRequest.setAlgorithm(algorithm);
        signRequest.setMessage(digest);
        signRequest.setMessageType(messageType);
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            SignResponse signResponse = client.signWithOptions(signRequest, runtimeOptions);

            System.out.println("================sign================");
            //用于签名/验签的密钥Id,验签时需使用到此参数
            System.out.printf("KeyId: %s%n", signResponse.getKeyId());
            //签名值,验签时需使用到此参数
            System.out.printf("Signature: %s%n", Arrays.toString(signResponse.getSignature()));
            //算法,验签时需使用到此参数
            System.out.printf("Algorithm: %s%n", signResponse.getAlgorithm());
            //待签名数据类型，RAW-原始消息，DIGEST-摘要,验签时需使用到此参数
            System.out.printf("MessageType: %s%n", signResponse.getMessageType());
            System.out.println("================sign================");
            return signResponse;
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("Code: %s%n", ((TeaException) e).getCode());
                System.out.printf("Message: %s%n", ((TeaException) e).getMessage());
                System.out.printf("HttpCode: %s%n", ((TeaException) e).getData().get("httpCode"));
                System.out.printf("HostId: %s%n", ((TeaException) e).getData().get("hostId"));
                System.out.printf("RequestId: %s%n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("sign errMsg: %s%n", e.getMessage());
            }
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] getDigest(String message) throws Exception {
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        return sha256.digest(message.getBytes(StandardCharsets.UTF_8));
    }
}