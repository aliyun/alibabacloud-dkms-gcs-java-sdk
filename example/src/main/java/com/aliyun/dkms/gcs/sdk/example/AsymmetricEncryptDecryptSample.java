package com.aliyun.dkms.gcs.sdk.example;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.DecryptResponse;
import com.aliyun.dkms.gcs.sdk.models.EncryptResponse;
import com.aliyun.tea.TeaException;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class AsymmetricEncryptDecryptSample {

    // 专属kms实例Client对象
    private static Client client = null;

    public static void main(String[] args) {

        try {
            // 构建加密服务实例Client对象
            initClient();

            // 使用专属kms实例进行加解密示例
            asymmetricEncryptDecrypt();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化Client
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
     * 使用专属kms实例进行加解密示例
     */
    public static void asymmetricEncryptDecrypt() {
        String keyId = "<your-key-id>";
        String plaintext = "<your-plaintext>";
        //使用专属kms进行非对称加密
        final EncryptResponse encryptResponse = asymmetricEncrypt(keyId, plaintext);
        //使用专属kms进行非对称解密
        asymmetricDecrypt(encryptResponse.getKeyId(), encryptResponse.getCiphertextBlob(),encryptResponse.getAlgorithm());

    }

    /**
     * 使用专属kms进行非对称加密
     * @param keyId
     * @param plaintext
     * @return
     */
    public static EncryptResponse asymmetricEncrypt(String keyId, String plaintext) {
        com.aliyun.dkms.gcs.sdk.models.EncryptRequest encryptRequest = new com.aliyun.dkms.gcs.sdk.models.EncryptRequest();
        encryptRequest.setKeyId(keyId);
        encryptRequest.setPlaintext(plaintext.getBytes(StandardCharsets.UTF_8));
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            EncryptResponse encryptResponse = client.encryptWithOptions(encryptRequest, runtimeOptions);
            System.out.printf("KeyId: %s%n", encryptResponse.getKeyId());
            System.out.printf("CiphertextBlob: %s%n", Arrays.toString(encryptResponse.getCiphertextBlob()));
            System.out.printf("RequestId: %s%n", encryptResponse.getRequestId());
            return encryptResponse;
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("code: %s%n", ((TeaException) e).getCode());
                System.out.printf("message: %s%n", ((TeaException) e).getMessage());
                System.out.printf("requestId: %s%n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("encrypt err: %s%n", e.getMessage());
            }
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用专属kms进行非对称解密
     * @param keyId
     * @param ciphertextBlob
     * @param algorithm
     */
    public static void asymmetricDecrypt(String keyId, byte[] ciphertextBlob, String algorithm) {
        com.aliyun.dkms.gcs.sdk.models.DecryptRequest decryptRequest = new com.aliyun.dkms.gcs.sdk.models.DecryptRequest();
        decryptRequest.setKeyId(keyId);
        decryptRequest.setCiphertextBlob(ciphertextBlob);
        decryptRequest.setAlgorithm(algorithm);
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            DecryptResponse decryptResponse = client.decryptWithOptions(decryptRequest, runtimeOptions);
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
