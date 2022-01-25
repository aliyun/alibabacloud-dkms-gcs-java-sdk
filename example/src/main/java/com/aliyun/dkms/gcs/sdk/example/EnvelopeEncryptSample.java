package com.aliyun.dkms.gcs.sdk.example;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.GenerateDataKeyRequest;
import com.aliyun.dkms.gcs.sdk.models.GenerateDataKeyResponse;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class EnvelopeEncryptSample {
    // 填写您在专属KMS应用管理获取的ClientKey文件路径
    //private static String clientKeyFile = "<your client key file path>";

    // 或者，填写您在专属KMS应用管理获取的ClientKey文件内容
    private static String clientKeyContent = "<your client key file path>";

    // 填写您在专属KMS应用管理创建ClientKey时输入的PKCS12加密口令
    private static String password = "<your client key password>";

    // 填写您的专属KMS实例服务地址(不包括协议头https://)
    private static String endpoint = "<your crypto service address>";

    // 填写您在专属专属KMS创建的主密钥Id
    private static String keyId = "<your cmk id>";

    // 专属KMS Client对象
    private static Client client = null;
    private static final int GCM_IV_LENGTH = 12;
    private static final int GCM_TAG_LENGTH = 16;

    public static void main(String[] args) {
        // 1.创建专属KMS Client对象并初始化
        Config config = new Config().setProtocol("https")
                .setClientKeyContent(clientKeyContent)
                .setPassword(password)
                .setEndpoint(endpoint);
        try {
            client = new Client(config);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // 2.获取数据密钥，下面以Aliyun_AES_256密钥为例进行说明，数据密钥长度32字节
        GenerateDataKeyRequest generateDataKeyRequest = new GenerateDataKeyRequest()
                .setKeyId(keyId) // 生成数据密钥的主密钥Id
                .setNumberOfBytes(32); // 生成的数据密钥的长度
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        byte[] plainDataKey = null; // 专属KMS返回的数据密钥明文, 加密本地数据使用
        byte[] encryptedDataKey = null; // 专属KMS返回的数据密钥密文，解密本地数据密文时，先将数据密钥密文解密后使用
        byte[] dataKeyIV = null;// 由专属KMS生成的加密初始向量，解密数据密钥密文时需要传入
        try {
            GenerateDataKeyResponse generateDataKeyResponse = client.generateDataKeyWithOptions(generateDataKeyRequest, runtimeOptions);
            plainDataKey = generateDataKeyResponse.getPlaintext();
            encryptedDataKey = generateDataKeyResponse.getCiphertextBlob();
            dataKeyIV = generateDataKeyResponse.getIv();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // 3.使用专属KMS返回的数据密钥明文在本地对数据进行加密，下面以AES-256 GCM模式为例
        byte[] data = "<your plaintext data >".getBytes(StandardCharsets.UTF_8);
        byte[] iv = null; // 加密初始向量，解密时也需要传入
        byte[] cipherText = null; // 密文
        try {
            iv = new byte[GCM_IV_LENGTH];
            SecureRandom random = new SecureRandom();
            random.nextBytes(iv);

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(plainDataKey, "AES");
            GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);
            cipherText = cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // 4.输出密文，密文输出或持久化由用户根据需要进行处理，下面示例仅展示将密文输出到一个对象的情况
        // 假如CipherText是需要输出的密文对象，至少需要包括以下四个内容:
        // (1) dataKeyIV: 由专属KMS生成的加密初始向量，解密数据密钥密文时需要传入
        // (2) encryptedDataKey: 专属KMS返回的数据密钥密文
        // (3) iv: 加密初始向量
        // (4) cipherText: 密文数据
        EnvelopeCipherPersistObject outCipherText = new EnvelopeCipherPersistObject()
                .setDataKeyIV(dataKeyIV)
                .setEncryptedDataKey(encryptedDataKey)
                .setIv(iv)
                .setCipherText(cipherText);
    }

    public static class EnvelopeCipherPersistObject implements Serializable {
        private byte[] dataKeyIV;
        private byte[] encryptedDataKey;
        private byte[] iv;
        private byte[] cipherText;

        public EnvelopeCipherPersistObject setDataKeyIV(byte[] dataKeyIV) {
            this.dataKeyIV = dataKeyIV;
            return this;
        }

        public byte[] getDataKeyIV() {
            return dataKeyIV;
        }

        public EnvelopeCipherPersistObject setEncryptedDataKey(byte[] encryptedDataKey) {
            this.encryptedDataKey = encryptedDataKey;
            return this;
        }

        public byte[] getEncryptedDataKey() {
            return encryptedDataKey;
        }

        public EnvelopeCipherPersistObject setIv(byte[] iv) {
            this.iv = iv;
            return this;
        }

        public byte[] getIv() {
            return iv;
        }

        public EnvelopeCipherPersistObject setCipherText(byte[] cipherText) {
            this.cipherText = cipherText;
            return this;
        }

        public byte[] getCipherText() {
            return cipherText;
        }
    }
}
