package com.aliyun.dkms.gcs.sdk.example;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.*;
import com.aliyun.tea.TeaException;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;


class DkmsClientTest {
    private static String clientKeyContent = "client key content";
    private static String clientKeyPassword = "client key password";
    private static String endpoint = "crypto service address";
    private static Client client;

    private static void encrypt() {
        String encryptionKeyId = "CmkId";
        byte[] plaintext = "<your origin data to encrypt>".getBytes(StandardCharsets.UTF_8);

        EncryptRequest encryptRequest = new EncryptRequest();
        encryptRequest.setKeyId(encryptionKeyId);
        encryptRequest.setPlaintext(plaintext);
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            //EncryptResponse encryptResponse = client.encrypt(encryptRequest);
            EncryptResponse encryptResponse = client.encryptWithOptions(encryptRequest, runtimeOptions);
            // 密文数据
            byte[] ciphertextBlob = encryptResponse.getCiphertextBlob();
            // Cipher初始向量，用于解密数据
            byte[] iv = encryptResponse.getIv();
            System.out.println("================encrypt================");
            System.out.printf("KeyId: %s%n", encryptResponse.getKeyId());
            System.out.printf("CiphertextBlob: %s%n", Arrays.toString(ciphertextBlob));
            System.out.printf("Iv: %s%n", Arrays.toString(iv));
            System.out.printf("RequestId: %s%n", encryptResponse.getRequestId());
            System.out.println("================encrypt================");
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("Code: %s%n", ((TeaException) e).getCode());
                System.out.printf("Message: %s%n", ((TeaException) e).getMessage());
                System.out.printf("HttpCode: %s%n", ((TeaException) e).getData().get("httpCode"));
                System.out.printf("HostId: %s%n", ((TeaException) e).getData().get("hostId"));
                System.out.printf("RequestId: %s%n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("encrypt errMsg: %s%n", e.getMessage());
            }
            e.printStackTrace();
        }
    }

    private static void decrypt() {
        String encryptionKeyId = "CmkId";
        byte[] ciphertextBlob = "<your cipher data to decrypt>".getBytes(StandardCharsets.UTF_8);
        String algorithm = "encrypt algorithm";
        byte[] iv = "<IV value>".getBytes(StandardCharsets.UTF_8);

        DecryptRequest decryptRequest = new DecryptRequest();
        decryptRequest.setKeyId(encryptionKeyId);
        decryptRequest.setCiphertextBlob(ciphertextBlob);
        decryptRequest.setAlgorithm(algorithm);
        decryptRequest.setIv(iv);
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            //DecryptResponse decryptResponse = client.decrypt(decryptRequest);
            DecryptResponse decryptResponse = client.decryptWithOptions(decryptRequest, runtimeOptions);
            System.out.println("================decrypt================");
            System.out.printf("KeyId: %s%n", decryptResponse.getKeyId());
            System.out.printf("Plaintext: %s%n", new String(decryptResponse.getPlaintext()));
            System.out.printf("RequestId: %s%n", decryptResponse.getRequestId());
            System.out.println("================decrypt================");
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("Code: %s\n", ((TeaException) e).getCode());
                System.out.printf("Message: %s\n", ((TeaException) e).getMessage());
                System.out.printf("HttpCode: %s\n", ((TeaException) e).getData().get("httpCode"));
                System.out.printf("HostId: %s\n", ((TeaException) e).getData().get("hostId"));
                System.out.printf("RequestId: %s\n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("decrypt errMsg: %s%n", e.getMessage());
            }
            e.printStackTrace();
        }
    }

    private static void hmac() {
        String hmacKeyId = "CmkId";
        String message = "message";

        HmacRequest hmacRequest = new HmacRequest();
        hmacRequest.setKeyId(hmacKeyId);
        hmacRequest.setMessage(message.getBytes(StandardCharsets.UTF_8));
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            //HmacResponse hmacResponse = client.hmac(hmacRequest);
            HmacResponse hmacResponse = client.hmacWithOptions(hmacRequest, runtimeOptions);
            byte[] signature = hmacResponse.getSignature();
            System.out.println("================hmac================");
            System.out.printf("KeyId: %s%n", hmacResponse.getKeyId());
            System.out.printf("Signature: %s%n", Arrays.toString(signature));
            System.out.printf("RequestId: %s%n", hmacResponse.getRequestId());
            System.out.println("================hmac================");
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("Code: %s%n", ((TeaException) e).getCode());
                System.out.printf("Message: %s%n", ((TeaException) e).getMessage());
                System.out.printf("HttpCode: %s%n", ((TeaException) e).getData().get("httpCode"));
                System.out.printf("HostId: %s%n", ((TeaException) e).getData().get("hostId"));
                System.out.printf("RequestId: %s%n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("hmac errMsg: %s%n", e.getMessage());
            }
            e.printStackTrace();
        }
    }

    private static void sign() {
        String signKeyId = "CmkId";
        String algorithm = "RSA_PKCS1_SHA_256";
        // TODO 待签名数据摘要或预处理数据
        byte[] digest = "<the digest or sm2-signature-pretreatment-value of the plaintext to sign>".getBytes(StandardCharsets.UTF_8);
        // 待签名数据类型，RAW-原始消息，DIGEST-摘要
        String messageType = "DIGEST";

        SignRequest signRequest = new SignRequest();
        signRequest.setKeyId(signKeyId);
        signRequest.setAlgorithm(algorithm);
        signRequest.setMessage(digest);
        signRequest.setMessageType(messageType);
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            //SignResponse signResponse = client.sign(signRequest);
            SignResponse signResponse = client.signWithOptions(signRequest, runtimeOptions);
            // 签名值
            byte[] signature = signResponse.getSignature();
            System.out.println("================sign================");
            System.out.printf("KeyId: %s%n", signResponse.getKeyId());
            System.out.printf("Signature: %s%n", Arrays.toString(signature));
            System.out.printf("RequestId: %s%n", signResponse.getRequestId());
            System.out.println("================sign================");
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("Code: %s%n", ((TeaException) e).getCode());
                System.out.printf("Message: %s%n", ((TeaException) e).getMessage());
                System.out.printf("HttpCode: %s%n", ((TeaException) e).getData().get("httpCode"));
                System.out.printf("HostId: %s%n", ((TeaException) e).getData().get("hostId"));
                System.out.printf("RequestId: %s%n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("sign errMsg: %s%n", e.getMessage());
            }
            e.printStackTrace();
        }
    }

    private static void verify() {
        String signKeyId = "CmkId";
        String algorithm = "RSA_PKCS1_SHA_256";
        // TODO 待签名数据摘要或预处理数据
        byte[] digest = "<the digest or sm2-signature-pretreatment-value of the plaintext to sign>".getBytes(StandardCharsets.UTF_8);
        // 待签名数据类型，RAW-原始消息，DIGEST-摘要
        String messageType = "DIGEST";
        // 待验证签名值
        // TODO fix the follow signature value
        byte[] signature = "<the signature value>".getBytes(StandardCharsets.UTF_8);

        VerifyRequest verifyRequest = new VerifyRequest();
        verifyRequest.setKeyId(signKeyId);
        verifyRequest.setAlgorithm(algorithm);
        verifyRequest.setMessage(digest);
        verifyRequest.setMessageType(messageType);
        verifyRequest.setSignature(signature);
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            //VerifyResponse verifyResponse = client.verify(verifyRequest);
            VerifyResponse verifyResponse = client.verifyWithOptions(verifyRequest, runtimeOptions);
            System.out.println("================verify================");
            System.out.printf("KeyId: %s%n", verifyResponse.getKeyId());
            System.out.printf("Value: %s%n", verifyResponse.getValue());
            System.out.printf("RequestId: %s%n", verifyResponse.getRequestId());
            System.out.println("================verify================");
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("Code: %s%n", ((TeaException) e).getCode());
                System.out.printf("Message: %s%n", ((TeaException) e).getMessage());
                System.out.printf("HttpCode: %s%n", ((TeaException) e).getData().get("httpCode"));
                System.out.printf("HostId: %s%n", ((TeaException) e).getData().get("hostId"));
                System.out.printf("RequestId: %s%n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("verify errMsg: %s%n", e.getMessage());
            }
            e.printStackTrace();
        }
    }

    private static void generateRandom() {
        Integer length = 16;
        GenerateRandomRequest generateRandomRequest = new GenerateRandomRequest();
        generateRandomRequest.setLength(length);
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            //GenerateRandomResponse generateRandomResponse = client.generateRandom(generateRandomRequest);
            GenerateRandomResponse generateRandomResponse = client.generateRandomWithOptions(generateRandomRequest, runtimeOptions);
            System.out.println("================generateRandom================");
            System.out.printf("Random: %s%n", Arrays.toString(generateRandomResponse.getRandom()));
            System.out.printf("RequestId: %s%n", generateRandomResponse.getRequestId());
            System.out.println("================generateRandom================");
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("Code: %s%n", ((TeaException) e).getCode());
                System.out.printf("Message: %s%n", ((TeaException) e).getMessage());
                System.out.printf("HttpCode: %s%n", ((TeaException) e).getData().get("httpCode"));
                System.out.printf("HostId: %s%n", ((TeaException) e).getData().get("hostId"));
                System.out.printf("RequestId: %s%n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("generateRandom errMsg: %s%n", e.getMessage());
            }
            e.printStackTrace();
        }
    }

    private static void generateDataKey() {
        String keyId = "CmkId";
        Integer numberOfbytes = 32;

        GenerateDataKeyRequest generateDataKeyRequest = new GenerateDataKeyRequest();
        generateDataKeyRequest.setKeyId(keyId);
        generateDataKeyRequest.setNumberOfBytes(numberOfbytes);

        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;

        try {
            //GenerateDataKeyResponse generateDataKeyResponse = client.generateDataKey(generateDataKeyRequest);
            GenerateDataKeyResponse generateDataKeyResponse = client.generateDataKeyWithOptions(generateDataKeyRequest, runtimeOptions);
            System.out.println("================generateDataKey================");
            System.out.printf("Plaintext: %s%n", Arrays.toString(generateDataKeyResponse.getPlaintext()));
            System.out.printf("CiphertextBlob: %s%n", Arrays.toString(generateDataKeyResponse.getCiphertextBlob()));
            System.out.printf("RequestId: %s%n", generateDataKeyResponse.getRequestId());
            System.out.println("================generateDataKey================");
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("Code: %s%n", ((TeaException) e).getCode());
                System.out.printf("Message: %s%n", ((TeaException) e).getMessage());
                System.out.printf("HttpCode: %s%n", ((TeaException) e).getData().get("httpCode"));
                System.out.printf("HostId: %s%n", ((TeaException) e).getData().get("hostId"));
                System.out.printf("RequestId: %s%n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("generateDataKey errMsg: %s%n", e.getMessage());
            }
            e.printStackTrace();
        }
    }

    private static void getPublicKey() {
        String keyId = "CmkId";

        GetPublicKeyRequest getPublicKeyRequest = new GetPublicKeyRequest();
        getPublicKeyRequest.setKeyId(keyId);

        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;

        try {
            //GetPublicKeyResponse getPublicKeyResponse = client.getPublicKey(getPublicKeyRequest);
            GetPublicKeyResponse getPublicKeyResponse = client.getPublicKeyWithOptions(getPublicKeyRequest, runtimeOptions);
            System.out.println("================getPublicKey================");
            System.out.printf("KeyId: %s%n", getPublicKeyResponse.getKeyId());
            System.out.printf("PublicKey: %s%n", getPublicKeyResponse.getPublicKey());
            System.out.printf("RequestId: %s%n", getPublicKeyResponse.getRequestId());
            System.out.println("================getPublicKey================");
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("Code: %s%n", ((TeaException) e).getCode());
                System.out.printf("Message: %s%n", ((TeaException) e).getMessage());
                System.out.printf("HttpCode: %s%n", ((TeaException) e).getData().get("httpCode"));
                System.out.printf("HostId: %s%n", ((TeaException) e).getData().get("hostId"));
                System.out.printf("RequestId: %s%n", ((TeaException) e).getData().get("requestId"));
            } else {
                System.out.printf("getPublicKey errMsg: %s%n", e.getMessage());
            }
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Config config = new Config();
        config.setProtocol("https");
        config.setClientKeyContent(clientKeyContent);
        config.setPassword(clientKeyPassword);
        config.setEndpoint(endpoint);
        try {
            client = new Client(config);
            //加密测试
            encrypt();
            //解密测试
            decrypt();
            //Hmac测试
            hmac();
            //签名测试
            sign();
            //验签测试
            verify();
            //生成随机数测试
            generateRandom();
            //生成数据密钥测试
            generateDataKey();
            //获取公钥测试
            getPublicKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}