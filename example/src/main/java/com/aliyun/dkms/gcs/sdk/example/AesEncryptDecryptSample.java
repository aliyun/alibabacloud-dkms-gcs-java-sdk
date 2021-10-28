package com.aliyun.dkms.gcs.sdk.example;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.DecryptRequest;
import com.aliyun.dkms.gcs.sdk.models.DecryptResponse;
import com.aliyun.dkms.gcs.sdk.models.EncryptRequest;
import com.aliyun.dkms.gcs.sdk.models.EncryptResponse;
import com.aliyun.tea.TeaException;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;

/**
 * ClientKey传参支持以下三种方式：
 * 1、通过指定ClientKey.json文件路径方式
 * 示例：
 *      String clientKeyFile = "<your client key file path>";
 *      String password = "<your client key password>";
 *      Config cfg = new Config();
 *      cfg.setClientKeyFile(clientKeyFile);
 *      cfg.setPassword(password);
 *
 * 2、通过指定ClientKey内容方式
 * 示例：
 *      String clientKeyContent = "<your client key content>";
 *      String password = "<your client key password>";
 *      Config cfg = new Config();
 *      cfg.setClientKeyContent(clientKeyContent);
 *      cfg.setPassword(password);
 *
 * 3、通过指定私钥和AccessKeyId
 * 示例：
 *      String accessKeyId = "<your client key KeyId>";
 *      String privateKey = "<parse from your client key PrivateKeyData>";
 *      Config cfg = new Config();
 *      cfg.setAccessKeyId(accessKeyId);
 *      cfg.setPrivateKey(privateKey);
 *
 */
public class AesEncryptDecryptSample {
    // 填写您在KMS应用管理获取的ClientKey文件路径
    //private static String clientKeyFile = "<your client key file path>";

    // 或者，填写您在KMS应用管理获取的ClientKey文件内容
    private static String clientKeyContent = "<your client key content>";

    // 填写您在KMS应用管理创建ClientKey时输入的PKCS12加密口令
    private static String password = "<your client key password>";

    // 填写您的KeyStore应用接入私有地址
    private static String endpoint = "<your crypto service address>";

    // 填写您在KMS创建的主密钥Id
    private static String encryptionKeyId = "<your cmk id>";

    // 加解密算法
    private static String algorithm = "<your encrypt algorithm>";

    // 待加密明文
    private static String plaintext = "aes 256 encrypt and decrypt sample";

    // 主密钥是对称密钥时，加密接口返回值中的Iv
    private static byte[] iv = null;

    // 加密服务实例Client对象
    private static Client client = null;

    public static void main(String[] args) {
        // 构建加密服务实例Client配置
        Config config = new Config();
        config.setProtocol("https");
        //config.setClientKeyFile(clientKeyFile);
        config.setClientKeyContent(clientKeyContent);
        config.setPassword(password);
        config.setEndpoint(endpoint);

        try {
            // 构建加密服务实例Client对象
            client = new Client(config);

            // 使用加密服务实例进行加解密示例
            encryptDecryptSample();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 加解密示例
    private static void encryptDecryptSample() {
        byte[] ciphertext = encryptSample();
        String decryptResult = decryptSample(ciphertext);

        if (!plaintext.equals(decryptResult)) {
            System.out.println("Decrypt data not match the plaintext");
        }
    }

    // 加密示例
    private static byte[] encryptSample() {
        // 构建加密请求
        EncryptRequest encryptRequest = new EncryptRequest();
        encryptRequest.setKeyId(encryptionKeyId);
        encryptRequest.setPlaintext(plaintext.getBytes(StandardCharsets.UTF_8));
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;

        try {
            // 调用加密接口进行加密
            EncryptResponse encryptResponse = client.encryptWithOptions(encryptRequest, runtimeOptions);
            // 主密钥是对称密钥时，decrypt接口需要加密返回的Iv
            iv = encryptResponse.getIv();
            System.out.printf("KeyId: %s%n", encryptResponse.getKeyId());
            System.out.printf("CiphertextBlob: %s%n", new String(Hex.encode(encryptResponse.getCiphertextBlob())));
            System.out.printf("Iv: %s%n", new String(Hex.encode(encryptResponse.getIv())));
            System.out.printf("RequestId: %s%n", encryptResponse.getRequestId());
            return encryptResponse.getCiphertextBlob();
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
        return null;
    }

    // 解密示例
    private static String decryptSample(byte[] ciphertextBlob) {
        // 构建解密请求对象
        DecryptRequest decryptRequest = new DecryptRequest();
        decryptRequest.setKeyId(encryptionKeyId);
        decryptRequest.setCiphertextBlob(ciphertextBlob);
        decryptRequest.setAlgorithm(algorithm);
        decryptRequest.setIv(iv);
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;

        try {
            // 调用解密接口进行解密
            DecryptResponse decryptResponse = client.decryptWithOptions(decryptRequest, runtimeOptions);
            System.out.printf("KeyId: %s%n", decryptResponse.getKeyId());
            System.out.printf("Plaintext: %s%n", new String(decryptResponse.getPlaintext()));
            System.out.printf("RequestId: %s%n", decryptResponse.getRequestId());
            return new String(decryptResponse.getPlaintext());
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("code: %s%n", ((TeaException) e).getCode());
                System.out.printf("message: %s%n", ((TeaException) e).getMessage());
                System.out.printf("requestId: %s%n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("decrypt err: %s%n", e.getMessage());
            }
            e.printStackTrace();
        }
        return null;
    }
}
