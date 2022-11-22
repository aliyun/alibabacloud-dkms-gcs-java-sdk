package com.aliyun.dkms.gcs.sdk.example;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.SignRequest;
import com.aliyun.dkms.gcs.sdk.models.SignResponse;
import com.aliyun.dkms.gcs.sdk.models.VerifyRequest;
import com.aliyun.dkms.gcs.sdk.models.VerifyResponse;
import com.aliyun.tea.TeaException;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * 专属kms Sha256非对称签名验签示例
 */
public class Sha256AsymmetricSignVerifySample {
    // 专属kms实例Client对象
    private static Client client = null;

    public static void main(String[] args) {

        try {
            // 构建加密服务实例Client对象
            initClient();

            // 使用专属kms实例进行签名和验签
            asymmetricSignVerify();

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    /**
     * 使用专属kms实例进行签名和验签
     *
     * @throws Exception
     */
    public static void asymmetricSignVerify() throws Exception {
        String keyId = "<your-key-id>";
        String algorithm = "<your-algorithm>";
        String message = "<your-message>";
        // 待签名数据类型，RAW-原始消息，DIGEST-摘要
        String messageType = "DIGEST";

        //使用专属kms对message进行签名
        final SignContext signContext = asymmetricSign(keyId, algorithm, message, messageType);
        //使用专属kms对message进行验证签名
        asymmetricVerify(signContext, message);
    }

    /**
     * 使用专属kms对message进行签名
     *
     * @param keyId
     * @param algorithm
     * @param message
     * @param messageType
     * @return
     * @throws Exception
     */
    public static SignContext asymmetricSign(String keyId, String algorithm, String message, String messageType) throws Exception {

        SignRequest signRequest = new SignRequest();
        signRequest.setKeyId(keyId);
        signRequest.setAlgorithm(algorithm);
        signRequest.setMessage(getDigest(message));
        signRequest.setMessageType(messageType);
        try {
            // 如需忽略服务端证书，可使用此处注释代码方式调用
            //RuntimeOptions runtimeOptions = new RuntimeOptions();
            //runtimeOptions.setIgnoreSSL(true);
            //SignResponse signResponse = client.signWithOptions(signRequest, runtimeOptions);
            SignResponse signResponse = client.sign(signRequest);
            // 签名值
            byte[] signature = signResponse.getSignature();
            System.out.println("================sign================");
            System.out.printf("KeyId: %s%n", signResponse.getKeyId());
            System.out.printf("Signature: %s%n", Arrays.toString(signature));
            System.out.println("================sign================");
            return new SignContext(signResponse.getKeyId(), signResponse.getSignature(), signResponse.getAlgorithm(), signResponse.getMessageType());
        } catch (TeaException e) {
            System.out.printf("Code: %s%n", ((TeaException) e).getCode());
            System.out.printf("Message: %s%n", ((TeaException) e).getMessage());
            System.out.printf("HttpCode: %s%n", ((TeaException) e).getData().get("httpCode"));
            System.out.printf("HostId: %s%n", ((TeaException) e).getData().get("hostId"));
            System.out.printf("RequestId: %s%n", ((TeaException) e).getData().get("requestId"));
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.printf("sign errMsg: %s%n", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用专属kms对message进行验证签名
     *
     * @param signContext
     * @throws Exception
     */
    public static void asymmetricVerify(final SignContext signContext, String message) throws Exception {
        VerifyRequest verifyRequest = new VerifyRequest();
        verifyRequest.setKeyId(signContext.getKeyId());
        verifyRequest.setAlgorithm(signContext.getAlgorithm());
        verifyRequest.setMessage(getDigest(message));
        verifyRequest.setMessageType(signContext.getMessageType());
        verifyRequest.setSignature(signContext.getSignature());
        try {
            // 如需忽略服务端证书，可使用此处注释代码方式调用
            //RuntimeOptions runtimeOptions = new RuntimeOptions();
            //runtimeOptions.setIgnoreSSL(true);
            //VerifyResponse verifyResponse = client.verifyWithOptions(verifyRequest, runtimeOptions);
            VerifyResponse verifyResponse = client.verify(verifyRequest);
            System.out.println("================verify================");
            System.out.printf("KeyId: %s%n", verifyResponse.getKeyId());
            System.out.printf("Value: %s%n", verifyResponse.getValue());
            System.out.println("================verify================");
        } catch (TeaException e) {
            System.out.printf("Code: %s%n", ((TeaException) e).getCode());
            System.out.printf("Message: %s%n", ((TeaException) e).getMessage());
            System.out.printf("HttpCode: %s%n", ((TeaException) e).getData().get("httpCode"));
            System.out.printf("HostId: %s%n", ((TeaException) e).getData().get("hostId"));
            System.out.printf("RequestId: %s%n", ((TeaException) e).getData().get("requestId"));
            e.printStackTrace();
        } catch (Exception e) {
            System.out.printf("verify errMsg: %s%n", e.getMessage());
            e.printStackTrace();
        }
    }

    private static byte[] getDigest(String message) throws Exception {
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        return sha256.digest(message.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * The sign context may be stored.
     */
    static class SignContext implements Serializable {
        public String keyId;
        public byte[] signature;
        /**
         * Use default algorithm value,if the value is not set.
         */
        public String algorithm;
        public String messageType;

        public SignContext() {
        }

        public SignContext(String keyId, byte[] signature, String algorithm, String messageType) {
            this.keyId = keyId;
            this.signature = signature;
            this.algorithm = algorithm;
            this.messageType = messageType;
        }

        public String getKeyId() {
            return keyId;
        }

        public void setKeyId(String keyId) {
            this.keyId = keyId;
        }

        public byte[] getSignature() {
            return signature;
        }

        public void setSignature(byte[] signature) {
            this.signature = signature;
        }

        public String getAlgorithm() {
            return algorithm;
        }

        public void setAlgorithm(String algorithm) {
            this.algorithm = algorithm;
        }

        public String getMessageType() {
            return messageType;
        }

        public void setMessageType(String messageType) {
            this.messageType = messageType;
        }
    }
}
