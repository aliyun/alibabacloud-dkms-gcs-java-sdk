package com.aliyun.dkms.gcs.sdk.example;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.DecryptRequest;
import com.aliyun.dkms.gcs.sdk.models.DecryptResponse;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EnvelopeDecryptSample {
// 填写您在专属KMS应用管理获取的ClientKey文件路径
    //private static String clientKeyFile = "<your client key file path>";

    // 或者，填写您在专属KMS应用管理获取的ClientKey文件内容
    private static String clientKeyContent = "<your client key content>";

    // 填写您在专属KMS应用管理创建ClientKey时输入的PKCS12加密口令
    private static String password = "<your client key password>";

    // 填写您的专属KMS实例服务地址(不包括协议头https://)
    private static String endpoint = "<your crypto service address>";

    // 填写您在专属专属KMS创建的主密钥Id
    private static String keyId = "<your cmk id>";

    // 专属KMS Client对象
    private static Client client = null;
    private static final int GCM_TAG_LENGTH = 16;

    public static void main(String[] args) {
        // 1.创建专属KMS Client对象并初始化
        Config config = new Config().setProtocol("https")
                .setClientKeyContent(clientKeyContent)
                .setPassword(password)
                .setEndpoint(endpoint)
                // 验证服务端证书，这里需要设置为您的服务端证书路径
                .setCaFilePath("<path/to/yourCaCert>");
                // 或者，设置为您的服务端证书内容
                //.setCa("<your-ca-certificate-content");
        try {
            client = new Client(config);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // 2.存储中读取封信加密持久化对象
        // 获取数据密钥明文，调用专属KMS解密数据密钥密文
        EnvelopeEncryptSample.EnvelopeCipherPersistObject envelopeCipherPersistObject = getEnvelopeCipherPersistObject();
        byte[] dataKeyIv = envelopeCipherPersistObject.getDataKeyIV(); // 由专属KMS生成的加密初始向量，解密数据密钥需要传入
        byte[] encryptedDataKey = envelopeCipherPersistObject.getEncryptedDataKey(); // 待解密数据密钥密文，由专属KMS生成
        byte[] plainDataKey = null;
        try {
            DecryptRequest decryptRequest = new DecryptRequest()
                    .setKeyId(keyId)
                    .setCiphertextBlob(encryptedDataKey)
                    .setIv(dataKeyIv);
            // 如需忽略服务端证书，可使用此处注释代码方式调用
            //RuntimeOptions runtimeOptions = new RuntimeOptions();
            //runtimeOptions.setIgnoreSSL(true);
            //DecryptResponse decryptResponse = client.decryptWithOptions(decryptRequest, runtimeOptions);
            DecryptResponse decryptResponse = client.decrypt(decryptRequest);
            plainDataKey = decryptResponse.getPlaintext();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // 3.使用数据密钥明文在本地进行解密, 下面是以AES-256 GCM模式为例
        byte[] iv = envelopeCipherPersistObject.getIv(); // 本地加密时使用的初始向量, 解密数据需要传入
        byte[] cipherText = envelopeCipherPersistObject.getCipherText(); // 待解密密文
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(plainDataKey, "AES");
            GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);
            byte[] decryptedData = cipher.doFinal(cipherText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static EnvelopeEncryptSample.EnvelopeCipherPersistObject getEnvelopeCipherPersistObject() {
        // TODO 用户需要在此处代码进行替换，从存储中读取封信加密持久化对象
        return new EnvelopeEncryptSample.EnvelopeCipherPersistObject();
    }

}