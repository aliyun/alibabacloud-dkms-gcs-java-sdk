package com.aliyun.dkms.gcs.sdk.example;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.*;
import com.aliyun.tea.TeaException;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 这是使用KMS实例API <a href="https://help.aliyun.com/zh/kms/developer-reference/advanceencrypt">AdvanceEncrypt</a> 和 <a href="https://help.aliyun.com/zh/kms/developer-reference/advancedecrypt">AdvanceDecrypt</a> 对数据进行加密和密钥的一个示例。
 * 说明：
 * 1. 待加密/解密的数据需要通过网络从客户端传输到KMS实例。单次加解密的数据量越大，网络传输失败可能性越大，网络传输所需时间越长，KMS实例对数据进行加解密所需时间也越长。
 * 2. 建议单次加密或解密的数据不超过6KiB。如果是单次需要加密更大量数据的场景建议使用<a href="https://help.aliyun.com/zh/kms/use-cases/use-envelope-encryption">信封加密</a>方案。
 * This is a sample to show how to use KMS Instance API <a href="https://help.aliyun.com/zh/kms/developer-reference/advancegeneratedatakey">AdvanceGenerateDataKey</a> to generate a data-key and use <a href="https://help.aliyun.com/zh/kms/developer-reference/advancedecrypt">AdvanceDecrypt</a> to decrypt the data-key from ciphertextBlob.
 * Note：
 * 1. The data to be encrypted/decrypted would be transferred from the client to KMS instance through network.
 * 2. The size of data to be encrypted/decrypted should not be larger than 6KiB. If you need to encrypt/decrypt larger data in one time, we suggest you use <a href="https://www.alibabacloud.com/help/en/kms/use-cases/use-envelope-encryption">envelope encryption</a>.
 */
public class AdvanceEncryptAdvanceDecryptSample {
    private static Client client = null; // KMS实例SDK客户端对象

    public static void main(String[] args) {
        try {
            // 1. 初始化KMS实例SDK
            initClient();

            // 2. 调用AdvanceEncrypt对数据进行加密，保存加密后的数据密文和使用的aad。
            String keyId = "<your-key-id-or-alias>"; // Set the key to use. Note: The key should be a symmetric key.
            byte[] plaintext = "<your-plaintext-data>".getBytes(StandardCharsets.UTF_8); // Set the plaintext data to be encrypted.
            byte[] aad = "<your-aad>".getBytes(StandardCharsets.UTF_8); // set the aad parameter on your need. if you don't need to use aad , let it be null or ignore it.

            final AdvanceEncryptContext advanceEncryptContext = advanceEncryptSample(keyId, plaintext, aad);
            // You should save the ciphertextBlob and your aad to storage. In this sample, we use a AdvanceEncryptContext to save them.

            // 3. 调用AdvanceDecrypt对密文数据进行解密。
            byte[] decipheredPlaintext = advanceDecryptSample(advanceEncryptContext); // 解密结果

            // In this sample, do a check to make sure the two plaintexts are equal.
            if (!Arrays.equals(plaintext, decipheredPlaintext)) {
                System.err.println("It should not happen: plaintexts are not equal.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化KMS实例SDK。
     * Initialize the KMS Instance SDK
     *
     * @throws Exception
     */
    public static void initClient() throws Exception {
        Config config = new Config();
        config.setProtocol("https");
        config.setEndpoint("<your-endpoint>"); // 设置KMS实例Endpoint
        config.setClientKeyFile("<your-client-key-file>"); // 设置client key文件地址
        // config.setClientKeyContent("<your-client-key-content>"); // 或设置client key文件的内容
        config.setPassword("<your-password>"); // 设置client key 保护密码
        config.setCaFilePath("<path/to/yourCaCert>");// 设置KMS实例的CA证书，可通过文件路径
        //config.setCa("<your-ca-certificate-content"); // 或者设置服务端证书内容

        client = new Client(config);
    }

    /**
     * 使用 <a href="https://help.aliyun.com/zh/kms/developer-reference/advanceencrypt">AdvanceEncrypt</a>进行数据加密的示例。
     * KMS默认采用GCM加密模式。
     *
     * @param keyId     keyId 参数，可使用密钥Id或别名
     * @param plaintext 需要加密的数据
     * @param aad       用户可根据使用的需要设置GCM加密模式的AAD参数。如果不需要使用，请设置为null或不设置。
     * @return AdvanceEncrypt密文数据上下文（本示例采用AdvanceEncryptContext），包含密文数据（ciphertextBlob）和相关参数密文（AAD）。
     */
    private static AdvanceEncryptContext advanceEncryptSample(String keyId, byte[] plaintext, byte[] aad) {
        AdvanceEncryptRequest request = new AdvanceEncryptRequest();
        request.setKeyId(keyId);
        request.setPlaintext(plaintext);
        request.setAad(aad);
        try {
            AdvanceEncryptResponse response = client.advanceEncrypt(request);
            return new AdvanceEncryptContext(response.getCiphertextBlob(), aad);
        } catch (TeaException e) {
            System.out.printf("code: %s%n", e.getCode());
            System.out.printf("message: %s%n", e.getMessage());
            System.out.printf("requestId: %s%n", e.getData().get("requestId"));
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.printf("advance encrypt err: %s%n", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 调用 AdvanceDecrypt 的示例。
     *
     * @param advanceEncryptContext AdvanceEncrypt密文数据上下文（本示例采用AdvanceEncryptContext），包含密文数据（ciphertextBlob）和相关参数密文（AAD）。
     * @return 解密后得到的明文数据。
     */
    private static byte[] advanceDecryptSample(final AdvanceEncryptContext advanceEncryptContext) {
        // 构建高级解密请求对象
        AdvanceDecryptRequest request = new AdvanceDecryptRequest();
        request.setCiphertextBlob(advanceEncryptContext.getCiphertextBlob());
        request.setAad(advanceEncryptContext.getAad());
        try {
            AdvanceDecryptResponse response = client.advanceDecrypt(request);
            System.out.printf("RequestId: %s%n", response.getRequestId());
            return response.getPlaintext();
        } catch (TeaException e) {
            System.out.printf("code: %s%n", e.getCode());
            System.out.printf("message: %s%n", e.getMessage());
            System.out.printf("requestId: %s%n", e.getData().get("requestId"));
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.printf("advance decrypt err: %s%n", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 保存密文数据和相关参数（aad）的示例。
     * A sample for storing ciphertext and related parameters (aad).
     */
    static class AdvanceEncryptContext implements Serializable {
        private byte[] ciphertextBlob;

        private byte[] aad;

        public AdvanceEncryptContext() {
        }

        public AdvanceEncryptContext(byte[] ciphertextBlob) {
            this.ciphertextBlob = ciphertextBlob;
        }

        public AdvanceEncryptContext(byte[] ciphertextBlob, byte[] aad) {
            this.ciphertextBlob = ciphertextBlob;
            this.aad = aad;
        }

        public byte[] getCiphertextBlob() {
            return ciphertextBlob;
        }

        public void setCiphertextBlob(byte[] ciphertextBlob) {
            this.ciphertextBlob = ciphertextBlob;
        }

        public byte[] getAad() {
            return aad;
        }

        public void setAad(byte[] aad) {
            this.aad = aad;
        }
    }
}