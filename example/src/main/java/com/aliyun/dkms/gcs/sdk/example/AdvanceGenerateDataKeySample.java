package com.aliyun.dkms.gcs.sdk.example;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.*;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Base64;

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
public class AdvanceGenerateDataKeySample {

    // 加密服务实例Client对象
    private static Client client = null;

    public static void main(String[] args) {
        try {
            // 构建加密服务实例Client对象
            initClient();

            // 使用加密服务实例生成数据密钥
            advanceGenerateDataKeySample();

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

    // 高级生成数据密钥示例
    private static void advanceGenerateDataKeySample() {
        String keyId = "<your-key-id>";
        Integer numberOfBytes = 32;//your number of bytes
        String aad = "<your-aad-base64>";
        AdvanceGenerateDataKeyContext context = advanceGenerateDataKeySample(keyId, numberOfBytes, Base64.getDecoder().decode(aad));
        System.out.println("ciphertext:" + Base64.getEncoder().encodeToString(context.getCiphertextBlob()));
    }

    // 高级生成数据密钥调用示例
    private static AdvanceGenerateDataKeyContext advanceGenerateDataKeySample(String keyId, Integer numberOfBytes, byte[] aad) {
        // 构建请求
        AdvanceGenerateDataKeyRequest request = new AdvanceGenerateDataKeyRequest();
        request.setKeyId(keyId);
        request.setNumberOfBytes(numberOfBytes);
        request.setAad(aad);
        try {
            // 调用高级生成数据密钥接口
            // 如需忽略服务端证书，可使用此处注释代码方式调用
            //RuntimeOptions runtimeOptions = new RuntimeOptions();
            //runtimeOptions.setIgnoreSSL(true);
            //EncryptResponse response = client.advanceGenerateDataKeyWithOptions(request, runtimeOptions);
            AdvanceGenerateDataKeyResponse response = client.advanceGenerateDataKey(request);
            System.out.printf("KeyId: %s%n", response.getKeyId());
            System.out.printf("Plaintext: %s%n", response.getPlaintext());
            System.out.printf("CiphertextBlob: %s%n", Arrays.toString(response.getCiphertextBlob()));
            System.out.printf("Iv: %s%n", Arrays.toString(response.getIv()));
            return new AdvanceGenerateDataKeyContext(response.getKeyId(), response.getCiphertextBlob(), response.getIv(), response.getPlaintext(), response.getAlgorithm(), response.getKeyVersionId());
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

    /**
     * The advance generate data key may be stored.
     */
    static class AdvanceGenerateDataKeyContext implements Serializable {
        public String keyId;
        public byte[] ciphertextBlob;
        public byte[] iv;
        public byte[] plaintext;
        public String algorithm;
        public String keyVersionId;

        public AdvanceGenerateDataKeyContext() {
        }

        public AdvanceGenerateDataKeyContext(String keyId, byte[] ciphertextBlob, byte[] iv, byte[] plaintext, String algorithm, String keyVersionId) {
            this.keyId = keyId;
            this.ciphertextBlob = ciphertextBlob;
            this.iv = iv;
            this.plaintext = plaintext;
            this.algorithm = algorithm;
            this.keyVersionId = keyVersionId;
        }

        public String getKeyId() {
            return keyId;
        }

        public void setKeyId(String keyId) {
            this.keyId = keyId;
        }

        public byte[] getIv() {
            return iv;
        }

        public void setIv(byte[] iv) {
            this.iv = iv;
        }

        public byte[] getPlaintext() {
            return plaintext;
        }

        public void setPlaintext(byte[] plaintext) {
            this.plaintext = plaintext;
        }

        public String getAlgorithm() {
            return algorithm;
        }

        public void setAlgorithm(String algorithm) {
            this.algorithm = algorithm;
        }

        public String getKeyVersionId() {
            return keyVersionId;
        }

        public void setKeyVersionId(String keyVersionId) {
            this.keyVersionId = keyVersionId;
        }

        public byte[] getCiphertextBlob() {
            return ciphertextBlob;
        }

        public void setCiphertextBlob(byte[] ciphertextBlob) {
            this.ciphertextBlob = ciphertextBlob;
        }
    }
}
