package com.aliyun.dkms.gcs.sdk.example;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.AdvanceDecryptRequest;
import com.aliyun.dkms.gcs.sdk.models.AdvanceDecryptResponse;
import com.aliyun.dkms.gcs.sdk.models.AdvanceGenerateDataKeyRequest;
import com.aliyun.dkms.gcs.sdk.models.AdvanceGenerateDataKeyResponse;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.SecureRandom;

public class AdvanceEnvelopeEncryptDecryptSample {

    // KMS实例 Client对象
    private static Client client = null;
    //数据密钥长度32字节
    private static final int DATA_KEY_LENGTH = 32;
    private static final int GCM_IV_LENGTH = 12;
    private static final int GCM_TAG_LENGTH = 16;
    private static final String AES_ALGORITHM = "AES";
    private static final String AES_GCM_NO_PADDING_ALGORITHM = "AES/GCM/NoPadding";

    public static void main(String[] args) throws Exception {

        // 初始化KMS实例SDK
        initClient();
        //高级接口信封加密示例
        envelopeAdvanceEncryptSample();
        //高级接口信封解密示例
        envelopeAdvanceDecryptSample();
    }

    private static void envelopeAdvanceEncryptSample() throws Exception {

        // 1.获取数据密钥，下面以Aliyun_AES_256密钥为例进行说明
        String keyId = "yourKeyId";
        AdvanceGenerateDataKeyResponse response = advanceGenerateDataKey(keyId);
        // KMS实例返回的数据密钥明文, 加密本地数据使用
        byte[] plainDataKey = response.getPlaintext();
        //  KMS实例返回的数据密钥密文，解密本地数据密文时，先将数据密钥密文解密后使用
        byte[] encryptedDataKey = response.getCiphertextBlob();
        // 由KMS实例生成的加密初始向量，解密数据密钥密文时需要传入
        byte[] dataKeyIV = response.getIv();

        // 2.使用KMS实例返回的数据密钥明文在本地对数据进行加密，下面以AES-256 GCM模式为例
        String plaintext = "<your plaintext data >";
        // 加密初始向量，解密时也需要传入
        byte[] iv = generateIv(GCM_IV_LENGTH);
        // 密文
        byte[] cipherText = localEncrypt(plainDataKey, plaintext, iv, GCM_TAG_LENGTH);
        // 3.输出密文，密文输出或持久化由用户根据需要进行处理，下面示例仅展示将密文输出到一个对象的情况
        // 假如CipherText是需要输出的密文对象，至少需要包括以下四个内容:
        EnvelopeCipherPersistObject outCipherText = new EnvelopeCipherPersistObject()
                // (1) dataKeyIV: 由KMS实例生成的加密初始向量，解密数据密钥密文时需要传入
                .setDataKeyIV(dataKeyIV)
                // (2) encryptedDataKey: KMS实例返回的数据密钥密文
                .setEncryptedDataKey(encryptedDataKey)
                // (3) iv: 加密初始向量
                .setIv(iv)
                // (4) cipherText: 密文数据
                .setCipherText(cipherText);
        // 保存信封密文持久化对象
        saveEnvelopeCipherPersistObject(outCipherText);
    }

    private static void envelopeAdvanceDecryptSample() throws Exception {

        // 1.存储中读取封信加密持久化对象
        AdvanceEnvelopeEncryptDecryptSample.EnvelopeCipherPersistObject envelopeCipherPersistObject = getEnvelopeCipherPersistObject();
        // 由KMS实例生成的加密初始向量，解密数据密钥需要传入
        byte[] dataKeyIv = envelopeCipherPersistObject.getDataKeyIV();
        // 待解密数据密钥密文，由KMS实例生成
        byte[] encryptedDataKey = envelopeCipherPersistObject.getEncryptedDataKey();
        // 2.调用高级解密接口解密数据密钥密文
        AdvanceDecryptResponse response = advanceDecrypt(encryptedDataKey, dataKeyIv);
        // 数据密钥明文
        byte[] plainDataKey = response.getPlaintext();
        // 3.使用数据密钥明文在本地进行解密, 以AES-256 GCM模式为例
        byte[] decryptedData = localDecrypt(envelopeCipherPersistObject.getIv(), envelopeCipherPersistObject.getCipherText(), plainDataKey);
        // TODO 根据实际业务场景,使用解密后的密文数据,此处仅做打印处理
        System.out.println(new String(decryptedData, StandardCharsets.UTF_8));
    }

    public static void saveEnvelopeCipherPersistObject(EnvelopeCipherPersistObject outCipherText) {
        // TODO 自行保存输出的密文对象
    }

    private static byte[] localDecrypt(byte[] iv, byte[] cipherText, byte[] plainDataKey) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_GCM_NO_PADDING_ALGORITHM);
        SecretKeySpec keySpec = new SecretKeySpec(plainDataKey, AES_ALGORITHM);
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);
        return cipher.doFinal(cipherText);
    }

    public static EnvelopeCipherPersistObject getEnvelopeCipherPersistObject() {
        // TODO 用户需要在此处代码进行替换，从存储中读取封信加密持久化对象
        return new EnvelopeCipherPersistObject();
    }

    public static byte[] localEncrypt(byte[] dataKey, String plaintext, byte[] iv, int tagLength) throws Exception, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(AES_GCM_NO_PADDING_ALGORITHM);
        SecretKeySpec keySpec = new SecretKeySpec(dataKey, AES_ALGORITHM);
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(tagLength * 8, iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);
        return cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
    }

    public static byte[] generateIv(int ivLength) {
        byte[] iv = new byte[ivLength];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        return iv;
    }

    public static AdvanceGenerateDataKeyResponse advanceGenerateDataKey(String keyId) throws Exception {
        AdvanceGenerateDataKeyRequest generateDataKeyRequest = new AdvanceGenerateDataKeyRequest()
                // 生成数据密钥的主密钥Id
                .setKeyId(keyId)
                // 生成的数据密钥的长度
                .setNumberOfBytes(DATA_KEY_LENGTH);
        return client.advanceGenerateDataKey(generateDataKeyRequest);
    }

    public static AdvanceDecryptResponse advanceDecrypt(byte[] cipher, byte[] iv) throws Exception {
        AdvanceDecryptRequest decryptRequest = new AdvanceDecryptRequest()
                // 待解密密文
                .setCiphertextBlob(cipher)
                // 加密初始向量
                .setIv(iv);
        return client.advanceDecrypt(decryptRequest);
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
        // 设置忽略服务端证书,默认为false
        //config.setIgnoreSSL(true);
        client = new Client(config);
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