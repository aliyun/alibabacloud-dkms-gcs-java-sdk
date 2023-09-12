package com.aliyun.dkms.gcs.sdk.example;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.DecryptRequest;
import com.aliyun.dkms.gcs.sdk.models.DecryptResponse;
import com.aliyun.dkms.gcs.sdk.models.GenerateDataKeyPairRequest;
import com.aliyun.dkms.gcs.sdk.models.GenerateDataKeyPairResponse;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class GenerateDataKeyPairKeySignVerifySample {
    private final static String KEY_FORMAT_DER = "DER";
    private final static String KEY_FORMAT_PEM = "PEM";
    // 专属kms实例Client对象
    private static Client client = null;

    public static void main(String[] args) {

        try {
            // 构建加密服务实例Client对象
            initClient();
            //调用GenerateDataKeyPair接口生成公私钥
            String keyFormat = KEY_FORMAT_DER;
            GenerateDataKeyPairResponse generateDataKeyPairResponse = generateDataKeyPair(keyFormat);
            //保存签名以及密钥等信息
            KeyPairInfo keyPairInfo = saveKeyPairInfo(generateDataKeyPairResponse, keyFormat);

            //签名
            byte[] privateKeyCiphertextBlob = Base64.getDecoder().decode(keyPairInfo.getPrivateKeyCiphertextBlob());
            //解密私钥密文
            byte[] iv = Base64.getDecoder().decode(keyPairInfo.getIv());
            byte[] privateKeyPlaintext = decryptPrivateKey(keyPairInfo.getKeyId(), privateKeyCiphertextBlob, iv);
            byte[] message = "your-message".getBytes(StandardCharsets.UTF_8);
            byte[] privateKey = privateKeyPlaintext;
            if (keyPairInfo.getKeyFormat().equals(KEY_FORMAT_PEM)) {
                privateKey = Base64.getDecoder().decode(trimPrivateKey(new String(privateKeyPlaintext, StandardCharsets.UTF_8)));
            }
            String signature = sign(message, privateKey);

            //验签
            byte[] publicKey = Base64.getDecoder().decode(keyPairInfo.getPublicKey());
            if (keyPairInfo.getKeyFormat().equals(KEY_FORMAT_PEM)) {
                publicKey = Base64.getDecoder().decode(trimPublicKey(new String(publicKey, StandardCharsets.UTF_8)));
            }
            boolean verify = verify(message, Base64.getDecoder().decode(signature), publicKey);
            System.out.println(verify);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static GenerateDataKeyPairResponse generateDataKeyPair(String keyFormat) throws Exception {
        String keyId = "your-keyId";
        String keyPairSpec = "your-keyPairSpec";
        String algorithm = "your-algorithm";
        return generateDataKeyPair(keyFormat, keyId, keyPairSpec, algorithm);
    }

    private static byte[] decryptPrivateKey(String keyId, byte[] privateCiphertextBlob, byte[] iv) throws Exception {
        DecryptResponse decryptResponse = decrypt(keyId, privateCiphertextBlob, iv);
        return decryptResponse.getPlaintext();
    }

    private static KeyPairInfo saveKeyPairInfo(GenerateDataKeyPairResponse generateDataKeyPairResponse, String keyFormat) {
        KeyPairInfo keyPairInfo = new KeyPairInfo().setKeyPairSpec(generateDataKeyPairResponse.getKeyPairSpec())
                .setKeyId(generateDataKeyPairResponse.getKeyId())
                .setPrivateKeyCiphertextBlob(Base64.getEncoder().encodeToString(generateDataKeyPairResponse.getPrivateKeyCiphertextBlob()))
                .setPublicKey(Base64.getEncoder().encodeToString(generateDataKeyPairResponse.getPublicKey()))
                .setIv(Base64.getEncoder().encodeToString(generateDataKeyPairResponse.getIv()))
                .setAlgorithm(generateDataKeyPairResponse.getAlgorithm()).setKeyFormat(keyFormat);
        //TODO 此处可以持久化公钥及私钥密文等信息
        return keyPairInfo;
    }

    /**
     * 去除私钥冗余字符
     * @param privateKey
     * @return
     */
    public static String trimPrivateKey(String privateKey) {
        String prefix = "-----BEGIN PRIVATE KEY-----";
        String suffix = "-----END PRIVATE KEY-----";
        if (privateKey != null) {
            privateKey = privateKey.replace(prefix, "");
            privateKey = privateKey.replace(suffix, "");
            privateKey = privateKey.replaceAll("\\n", "");
        }
        return privateKey;
    }

    /**
     * 去除公钥冗余字符
     * @param publicKey
     * @return
     */
    public static String trimPublicKey(String publicKey) {
        String prefix = "-----BEGIN PUBLIC KEY-----";
        String suffix = "-----END PUBLIC KEY-----";
        if (publicKey != null) {
            publicKey = publicKey.replace(prefix, "");
            publicKey = publicKey.replace(suffix, "");
            publicKey = publicKey.replaceAll("\\n", "");
        }
        return publicKey;
    }

    /**
     * RSA签名
     *
     * @param data   待签名数据
     * @param priKey 私钥
     * @return 签名
     * @throws Exception
     */
    public static String sign(byte[] data, byte[] priKey) throws Exception {
        //创建PKCS8编码密钥规范
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(priKey);
        //返回转换指定算法的KeyFactory对象
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        //根据PKCS8编码密钥规范产生私钥对象
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        //用指定算法产生签名对象Signature
        Signature signature = Signature.getInstance("SHA1withRSA");
        //用私钥初始化签名对象Signature
        signature.initSign(privateKey);
        //将待签名的数据传送给签名对象
        signature.update(data);
        //返回签名结果字节数组
        byte[] sign = signature.sign();
        //返回Base64编码后的字符串
        return Base64.getEncoder().encodeToString(sign);
    }

    /**
     * RSA校验数字签名
     *
     * @param data   待校验数据
     * @param sign   数字签名
     * @param pubKey 公钥
     * @return boolean 校验成功返回true，失败返回false
     */
    public static boolean verify(byte[] data, byte[] sign, byte[] pubKey) throws Exception {
        //返回转换指定算法的KeyFactory对象
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        //创建X509编码密钥规范
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(pubKey);
        //根据X509编码密钥规范产生公钥对象
        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
        //用指定算法产生签名对象Signature
        Signature signature = Signature.getInstance("SHA1withRSA");
        //用公钥初始化签名对象,用于验证签名
        signature.initVerify(publicKey);
        //更新签名内容
        signature.update(data);
        //得到验证结果
        return signature.verify(sign);
    }

    /**
     * 构建加密服务实例Client对象
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
        // 验证服务端证书，这里需要设置为您的服务端证书路径
        config.setCaFilePath("<path/to/yourCaCert>");
        // 或者，设置为您的服务端证书内容
        //config.setCa("<your-ca-certificate-content");
        client = new Client(config);
    }

    public static GenerateDataKeyPairResponse generateDataKeyPair(String keyFormat,  String keyId, String keyPairSpec, String algorithm) throws Exception {
        GenerateDataKeyPairRequest request = new GenerateDataKeyPairRequest()
                .setKeyFormat(keyFormat)
                .setKeyId(keyId)
                .setKeyPairSpec(keyPairSpec)
                .setAlgorithm(algorithm);
        return client.generateDataKeyPair(request);
    }

    public static DecryptResponse decrypt(String keyId, byte[] ciphertextBlob, byte[] iv) throws Exception {
        DecryptRequest request = new DecryptRequest()
                .setKeyId(keyId)
                .setCiphertextBlob(ciphertextBlob)
                .setIv(iv);
        return client.decrypt(request);
    }

    static class KeyPairInfo implements Serializable {
        public String keyId;
        public String iv;
        public String keyPairSpec;
        public String privateKeyCiphertextBlob;
        public String publicKey;
        public String algorithm;
        public String keyFormat;

        public String getKeyId() {
            return keyId;
        }

        public KeyPairInfo setKeyId(String keyId) {
            this.keyId = keyId;
            return this;
        }

        public String getIv() {
            return iv;
        }

        public KeyPairInfo setIv(String iv) {
            this.iv = iv;
            return this;
        }

        public String getKeyPairSpec() {
            return keyPairSpec;
        }

        public KeyPairInfo setKeyPairSpec(String keyPairSpec) {
            this.keyPairSpec = keyPairSpec;
            return this;
        }

        public String getPrivateKeyCiphertextBlob() {
            return privateKeyCiphertextBlob;
        }

        public KeyPairInfo setPrivateKeyCiphertextBlob(String privateKeyCiphertextBlob) {
            this.privateKeyCiphertextBlob = privateKeyCiphertextBlob;
            return this;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public KeyPairInfo setPublicKey(String publicKey) {
            this.publicKey = publicKey;
            return this;
        }

        public String getAlgorithm() {
            return algorithm;
        }

        public KeyPairInfo setAlgorithm(String algorithm) {
            this.algorithm = algorithm;
            return this;
        }

        public String getKeyFormat() {
            return keyFormat;
        }

        public KeyPairInfo setKeyFormat(String keyFormat) {
            this.keyFormat = keyFormat;
            return this;
        }
    }
}
