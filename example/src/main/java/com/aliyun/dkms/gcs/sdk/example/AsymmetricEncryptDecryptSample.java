package com.aliyun.dkms.gcs.sdk.example;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.DecryptResponse;
import com.aliyun.dkms.gcs.sdk.models.EncryptResponse;
import com.aliyun.tea.TeaException;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 专属kms非对称加密解密示例
 */
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
     *
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
        final AsymmetricEncryptContext asymmetricEncryptContext = asymmetricEncrypt(keyId, plaintext);
        //使用专属kms进行非对称解密
        asymmetricDecrypt(asymmetricEncryptContext);

    }

    /**
     * 使用专属kms进行非对称加密
     *
     * @param keyId
     * @param plaintext
     * @return
     */
    public static AsymmetricEncryptContext asymmetricEncrypt(String keyId, String plaintext) {
        com.aliyun.dkms.gcs.sdk.models.EncryptRequest encryptRequest = new com.aliyun.dkms.gcs.sdk.models.EncryptRequest();
        encryptRequest.setKeyId(keyId);
        encryptRequest.setPlaintext(plaintext.getBytes(StandardCharsets.UTF_8));
        //如需跳过https认证，可使用此处注释代码方式调用
        //RuntimeOptions runtimeOptions = new RuntimeOptions();
        //runtimeOptions.ignoreSSL = true;
        try {
            EncryptResponse encryptResponse = client.encrypt(encryptRequest);
            //EncryptResponse encryptResponse = client.encryptWithOptions(encryptRequest, runtimeOptions);
            System.out.printf("KeyId: %s%n", encryptResponse.getKeyId());
            System.out.printf("CiphertextBlob: %s%n", Arrays.toString(encryptResponse.getCiphertextBlob()));
            return new AsymmetricEncryptContext(encryptResponse.getKeyId(), encryptResponse.getCiphertextBlob(), encryptResponse.getAlgorithm());
        } catch (TeaException e) {
            System.out.printf("code: %s%n", e.getCode());
            System.out.printf("message: %s%n", e.getMessage());
            System.out.printf("requestId: %s%n", e.getData().get("requestId"));
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            System.out.printf("encrypt err: %s%n", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用专属kms进行非对称解密
     *
     * @param asymmetricEncryptContext
     */
    public static void asymmetricDecrypt(final AsymmetricEncryptContext asymmetricEncryptContext) {
        com.aliyun.dkms.gcs.sdk.models.DecryptRequest decryptRequest = new com.aliyun.dkms.gcs.sdk.models.DecryptRequest();
        decryptRequest.setKeyId(asymmetricEncryptContext.getKeyId());
        decryptRequest.setCiphertextBlob(asymmetricEncryptContext.getCiphertextBlob());
        decryptRequest.setAlgorithm(asymmetricEncryptContext.getAlgorithm());
        //如需跳过https认证，可使用此处注释代码方式调用
        //RuntimeOptions runtimeOptions = new RuntimeOptions();
        //runtimeOptions.ignoreSSL = true;
        try {
            DecryptResponse decryptResponse = client.decrypt(decryptRequest);
            //DecryptResponse decryptResponse = client.decryptWithOptions(decryptRequest, runtimeOptions);
            System.out.printf("KeyId: %s%n", decryptResponse.getKeyId());
            System.out.printf("Plaintext: %s%n", new String(decryptResponse.getPlaintext(), StandardCharsets.UTF_8));
        } catch (TeaException e) {
            System.out.printf("code: %s%n", e.getCode());
            System.out.printf("message: %s%n", e.getMessage());
            System.out.printf("requestId: %s%n", e.getData().get("requestId"));
            e.printStackTrace();
        } catch (Exception e) {
            System.out.printf("encrypt err: %s%n", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * The asymmetric encrypt context may be stored.
     */
    static class AsymmetricEncryptContext implements Serializable {
        public String keyId;
        public byte[] ciphertextBlob;
        /**
         * Use default algorithm value,if the value is not set.
         */
        public String algorithm;

        public AsymmetricEncryptContext() {
        }

        public AsymmetricEncryptContext(String keyId, byte[] ciphertextBlob, String algorithm) {
            this.keyId = keyId;
            this.ciphertextBlob = ciphertextBlob;
            this.algorithm = algorithm;
        }

        public String getKeyId() {
            return keyId;
        }

        public void setKeyId(String keyId) {
            this.keyId = keyId;
        }

        public byte[] getCiphertextBlob() {
            return ciphertextBlob;
        }

        public void setCiphertextBlob(byte[] ciphertextBlob) {
            this.ciphertextBlob = ciphertextBlob;
        }

        public String getAlgorithm() {
            return algorithm;
        }

        public void setAlgorithm(String algorithm) {
            this.algorithm = algorithm;
        }
    }
}
