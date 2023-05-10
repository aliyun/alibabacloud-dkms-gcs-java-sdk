package com.aliyun.dkms.gcs.sdk.example;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.*;
import com.aliyun.tea.TeaException;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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
public class AdvanceEncryptAdvanceDecryptSample {

    // 加密服务实例Client对象
    private static Client client = null;

    public static void main(String[] args) {
        try {
            // 构建加密服务实例Client对象
            initClient();

            // 使用加密服务实例进行高级加解密示例
            advanceEncryptAdvanceDecryptSample();

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
        // 验证服务端证书，这里需要设置为您的服务端证书路径
        client = new Client(config);
    }

    // 高级加解密示例
    private static void advanceEncryptAdvanceDecryptSample() {
        String keyId = "<your-key-id>";
        String plaintext = "<your-plaintext>";
        final AdvanceEncryptContext advanceEncryptContext = advanceEncryptSample(keyId, plaintext);
        String result = advanceDecryptSample(advanceEncryptContext);
        if (!plaintext.equals(result)) {
            System.out.println("Advance decrypt data not match the plaintext");
        }
    }

    // 高级加密示例
    private static AdvanceEncryptContext advanceEncryptSample(String keyId, String plaintext) {
        // 构建高级加密请求
        AdvanceEncryptRequest request = new AdvanceEncryptRequest();
        request.setKeyId(keyId);
        request.setPlaintext(plaintext.getBytes(StandardCharsets.UTF_8));
        try {
            // 调用高级加密接口进行加密
            // 如需忽略服务端证书，可使用此处注释代码方式调用
            //RuntimeOptions runtimeOptions = new RuntimeOptions();
            //runtimeOptions.setIgnoreSSL(true);
            //AdvanceEncryptResponse response = client.advanceEncryptWithOptions(request, runtimeOptions);
            AdvanceEncryptResponse response = client.advanceEncrypt(request);
            System.out.printf("KeyId: %s%n", response.getKeyId());
            System.out.printf("CiphertextBlob: %s%n", Arrays.toString(response.getCiphertextBlob()));
            System.out.printf("Iv: %s%n", Arrays.toString(response.getIv()));
            return new AdvanceEncryptContext(response.getCiphertextBlob());
        } catch (TeaException e) {
            System.out.printf("code: %s%n", ((TeaException) e).getCode());
            System.out.printf("message: %s%n", e.getMessage());
            System.out.printf("requestId: %s%n", ((TeaException) e).getData().get("requestId"));
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.printf("advance encrypt err: %s%n", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 高级解密示例
    private static String advanceDecryptSample(final AdvanceEncryptContext advanceEncryptContext) {
        // 构建高级解密请求对象
        AdvanceDecryptRequest request = new AdvanceDecryptRequest();
        request.setCiphertextBlob(advanceEncryptContext.getCiphertextBlob());
        try {
            // 调用高级解密接口进行解密
            // 如需忽略服务端证书，可使用此处注释代码方式调用
            //RuntimeOptions runtimeOptions = new RuntimeOptions();
            //runtimeOptions.setIgnoreSSL(true);
            //AdvanceDecryptResponse response = client.advanceDecryptWithOptions(request, runtimeOptions);
            AdvanceDecryptResponse response = client.advanceDecrypt(request);
            System.out.printf("KeyId: %s%n", response.getKeyId());
            System.out.printf("Plaintext: %s%n", new String(response.getPlaintext()));
            System.out.printf("RequestId: %s%n", response.getRequestId());
            return new String(response.getPlaintext());
        } catch (TeaException e) {
            System.out.printf("code: %s%n", ((TeaException) e).getCode());
            System.out.printf("message: %s%n", e.getMessage());
            System.out.printf("requestId: %s%n", ((TeaException) e).getData().get("requestId"));
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.printf("advance decrypt err: %s%n", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * The advance encrypt context may be stored.
     */
    static class AdvanceEncryptContext implements Serializable {
        public byte[] ciphertextBlob;

        public AdvanceEncryptContext() {
        }

        public AdvanceEncryptContext(byte[] ciphertextBlob) {
            this.ciphertextBlob = ciphertextBlob;
        }

        public byte[] getCiphertextBlob() {
            return ciphertextBlob;
        }

        public void setCiphertextBlob(byte[] ciphertextBlob) {
            this.ciphertextBlob = ciphertextBlob;
        }
    }
}