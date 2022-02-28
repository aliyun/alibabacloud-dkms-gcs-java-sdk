package com.aliyun.dkms.gcs.sdk.example;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.SignRequest;
import com.aliyun.dkms.gcs.sdk.models.SignResponse;
import com.aliyun.dkms.gcs.sdk.models.VerifyRequest;
import com.aliyun.dkms.gcs.sdk.models.VerifyResponse;
import com.aliyun.tea.TeaException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

public class AsymmetricSignVerifySample {
    // 专属kms实例Client对象
    private static Client client = null;

    public static void main(String[] args) {

        try {
            // 构建加密服务实例Client对象
            initClient();

            // 使用专属kms实例进行签名和验签
            asymmetricSignVerify();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  构建加密服务实例Client对象
     * @throws Exception
     */
    public static void initClient() throws Exception {
        // 构建加密服务实例Client配置
        Config config = new Config();
        config.setProtocol("https");
        config.setClientKeyFile("<your-client-key-file>");
        config.setPassword("<your-password>");
        config.setEndpoint("<your-endpoint>");
        client = new Client(config);
    }

    /**
     * 使用专属kms实例进行签名和验签
     * @throws Exception
     */
    public static void asymmetricSignVerify() throws Exception {
        String keyId = "<your-key-id>";
        String algorithm = "<your-algorithm>";
        String message = "<your-message>";
        // 待签名数据类型，RAW-原始消息，DIGEST-摘要
        String messageType = "DIGEST";

        //使用专属kms对message进行签名
        final SignResponse signResponse = asymmetricSign(keyId, algorithm, message, messageType);
        //使用专属kms对message进行验证签名
        asymmetricVerify(signResponse.getKeyId(), signResponse.getAlgorithm(), message, signResponse.getMessageType(), signResponse.getSignature());
    }

    /**
     * 使用专属kms对message进行签名
     * @param keyId
     * @param algorithm
     * @param message
     * @param messageType
     * @return
     * @throws Exception
     */
    public static SignResponse asymmetricSign(String keyId, String algorithm, String message, String messageType) throws Exception {

        SignRequest signRequest = new SignRequest();
        signRequest.setKeyId(keyId);
        signRequest.setAlgorithm(algorithm);
        signRequest.setMessage(getDigest(message));
        signRequest.setMessageType(messageType);
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            SignResponse signResponse = client.signWithOptions(signRequest, runtimeOptions);
            // 签名值
            byte[] signature = signResponse.getSignature();
            System.out.println("================sign================");
            System.out.printf("KeyId: %s%n", signResponse.getKeyId());
            System.out.printf("Signature: %s%n", Arrays.toString(signature));
            System.out.printf("RequestId: %s%n", signResponse.getRequestId());
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
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用专属kms对message进行验证签名
     * @param keyId
     * @param algorithm
     * @param message
     * @param messageType
     * @param signature
     * @throws Exception
     */
    public static void asymmetricVerify(String keyId, String algorithm, String message, String messageType, byte[] signature) throws Exception {
        VerifyRequest verifyRequest = new VerifyRequest();
        verifyRequest.setKeyId(keyId);
        verifyRequest.setAlgorithm(algorithm);
        verifyRequest.setMessage(getDigest(message));
        verifyRequest.setMessageType(messageType);
        verifyRequest.setSignature(signature);
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            VerifyResponse verifyResponse = client.verifyWithOptions(verifyRequest, runtimeOptions);
            System.out.println("================verify================");
            System.out.printf("KeyId: %s%n", verifyResponse.getKeyId());
            System.out.printf("Value: %s%n", verifyResponse.getValue());
            System.out.printf("RequestId: %s%n", verifyResponse.getRequestId());
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
