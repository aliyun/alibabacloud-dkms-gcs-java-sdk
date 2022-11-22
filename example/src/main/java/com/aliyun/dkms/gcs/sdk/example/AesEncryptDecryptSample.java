package com.aliyun.dkms.gcs.sdk.example;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.DecryptRequest;
import com.aliyun.dkms.gcs.sdk.models.DecryptResponse;
import com.aliyun.dkms.gcs.sdk.models.EncryptRequest;
import com.aliyun.dkms.gcs.sdk.models.EncryptResponse;
import com.aliyun.tea.TeaException;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * ClientKey传参支持以下三种方式：
 * 1、通过指定ClientKey.json文件路径方式
 * 示例：
 * String clientKeyFile = "<your client key file path>";
 * String password = "<your client key password>";
 * Config cfg = new Config();
 * cfg.setClientKeyFile(clientKeyFile);
 * cfg.setPassword(password);
 * <p>
 * 2、通过指定ClientKey内容方式
 * 示例：
 * String clientKeyContent = "<your client key content>";
 * String password = "<your client key password>";
 * Config cfg = new Config();
 * cfg.setClientKeyContent(clientKeyContent);
 * cfg.setPassword(password);
 * <p>
 * 3、通过指定私钥和AccessKeyId
 * 示例：
 * String accessKeyId = "<your client key KeyId>";
 * String privateKey = "<parse from your client key PrivateKeyData>";
 * Config cfg = new Config();
 * cfg.setAccessKeyId(accessKeyId);
 * cfg.setPrivateKey(privateKey);
 */
public class AesEncryptDecryptSample {

    // 加密服务实例Client对象
    private static Client client = null;

    public static void main(String[] args) {
        try {
            // 构建加密服务实例Client对象
            initClient();

            // 使用加密服务实例进行加解密示例
            encryptDecryptSample();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initClient() throws Exception {
        // 构建加密服务实例Client配置
        Config config = new Config();
        config.setProtocol("https");
        config.setClientKeyFile("<your-client-key-file>");
        config.setPassword("<your-password>");
        config.setEndpoint("<your-endpoint>");
        // 验证服务端证书，这里需要设置为您的服务端证书路径
        config.setCaFilePath("<path/to/yourCaCert>");
        // 或者，设置为您的服务端证书内容
        //config.setCa("<your-ca-certificate-content");
        client = new Client(config);
    }

    // 加解密示例
    private static void encryptDecryptSample() {
        String keyId = "<your-key-id>";
        String plaintext = "<your-plaintext>";
        final AesEncryptContext aesEncryptContext = encryptSample(keyId, plaintext);
        String decryptResult = decryptSample(aesEncryptContext);
        if (!plaintext.equals(decryptResult)) {
            System.out.println("Decrypt data not match the plaintext");
        }
    }

    // 加密示例
    private static AesEncryptContext encryptSample(String keyId, String plaintext) {
        // 构建加密请求
        EncryptRequest encryptRequest = new EncryptRequest();
        encryptRequest.setKeyId(keyId);
        encryptRequest.setPlaintext(plaintext.getBytes(StandardCharsets.UTF_8));
        try {
            // 调用加密接口进行加密
            // 如需忽略服务端证书，可使用此处注释代码方式调用
            //RuntimeOptions runtimeOptions = new RuntimeOptions();
            //runtimeOptions.setIgnoreSSL(true);
            //EncryptResponse encryptResponse = client.encryptWithOptions(encryptRequest, runtimeOptions);
            EncryptResponse encryptResponse = client.encrypt(encryptRequest);
            System.out.printf("KeyId: %s%n", encryptResponse.getKeyId());
            System.out.printf("CiphertextBlob: %s%n", Arrays.toString(encryptResponse.getCiphertextBlob()));
            System.out.printf("Iv: %s%n", Arrays.toString(encryptResponse.getIv()));
            return new AesEncryptContext(encryptResponse.getKeyId(), encryptResponse.getCiphertextBlob(), encryptResponse.getIv(), encryptResponse.getAlgorithm());
        } catch (TeaException e) {
            System.out.printf("code: %s%n", ((TeaException) e).getCode());
            System.out.printf("message: %s%n", e.getMessage());
            System.out.printf("requestId: %s%n", ((TeaException) e).getData().get("requestId"));
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.printf("encrypt err: %s%n", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 解密示例
    private static String decryptSample(final AesEncryptContext aesEncryptContext) {
        // 构建解密请求对象
        DecryptRequest decryptRequest = new DecryptRequest();
        decryptRequest.setKeyId(aesEncryptContext.getKeyId());
        decryptRequest.setCiphertextBlob(aesEncryptContext.getCiphertextBlob());
        decryptRequest.setAlgorithm(aesEncryptContext.getAlgorithm());
        decryptRequest.setIv(aesEncryptContext.getIv());
        try {
            // 调用解密接口进行解密
            // 如需忽略服务端证书，可使用此处注释代码方式调用
            //RuntimeOptions runtimeOptions = new RuntimeOptions();
            //runtimeOptions.setIgnoreSSL(true);
            //DecryptResponse decryptResponse = client.decryptWithOptions(decryptRequest, runtimeOptions);
            DecryptResponse decryptResponse = client.decrypt(decryptRequest);
            System.out.printf("KeyId: %s%n", decryptResponse.getKeyId());
            System.out.printf("Plaintext: %s%n", new String(decryptResponse.getPlaintext()));
            System.out.printf("RequestId: %s%n", decryptResponse.getRequestId());
            return new String(decryptResponse.getPlaintext());
        } catch (TeaException e) {
            System.out.printf("code: %s%n", ((TeaException) e).getCode());
            System.out.printf("message: %s%n", e.getMessage());
            System.out.printf("requestId: %s%n", ((TeaException) e).getData().get("requestId"));
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.printf("decrypt err: %s%n", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * The aes encrypt context may be stored.
     */
    static class AesEncryptContext implements Serializable {
        public String keyId;
        public byte[] ciphertextBlob;
        public byte[] iv;
        /**
         * Use default algorithm value,if the value is not set.
         */
        public String algorithm;

        public AesEncryptContext() {
        }

        public AesEncryptContext(String keyId, byte[] ciphertextBlob, byte[] iv, String algorithm) {
            this.keyId = keyId;
            this.ciphertextBlob = ciphertextBlob;
            this.iv = iv;
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

        public byte[] getIv() {
            return iv;
        }

        public void setIv(byte[] iv) {
            this.iv = iv;
        }

        public String getAlgorithm() {
            return algorithm;
        }

        public void setAlgorithm(String algorithm) {
            this.algorithm = algorithm;
        }

    }
}