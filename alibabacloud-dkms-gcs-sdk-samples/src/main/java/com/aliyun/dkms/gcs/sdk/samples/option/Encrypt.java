package com.aliyun.dkms.gcs.sdk.samples.option;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.tea.TeaException;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.kms.model.v20160120.*;
import com.aliyuncs.profile.DefaultProfile;


import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Encrypt {

    public static void main(String[] args) {
        encryptKmsSample();
        encryptDKmsSample();
    }

    /**
     * 共享kms对称加密sample
     */
    public static void encryptKmsSample() {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<your-access-key-id>", "<your-access-key-secret>");

        /** use STS Token
         DefaultProfile profile = DefaultProfile.getProfile(
         "<your-region-id>",           // The region ID
         "<your-access-key-id>",       // The AccessKey ID of the RAM account
         "<your-access-key-secret>",   // The AccessKey Secret of the RAM account
         "<your-sts-token>");          // STS Token
         **/
        IAcsClient client = new DefaultAcsClient(profile);

        EncryptRequest request = new EncryptRequest();
        request.setKeyId("<your-key-id>");
        request.setPlaintext("<your-plain-text>");
        try {
            EncryptResponse response = client.getAcsResponse(request);
            System.out.printf("KeyId: %s%n", response.getKeyId());
            System.out.printf("KeyVersionId: %s%n", response.getKeyVersionId());
            System.out.printf("CiphertextBlob: %s%n", response.getCiphertextBlob());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
    }

    /**
     * 专属kms对称加密sample
     */
    public static void encryptDKmsSample() {
        Config config = new Config();
        config.setProtocol("https");
        config.setClientKeyFile("<your-client-key-file>");
        config.setPassword("<your-password>");
        config.setEndpoint("<your-endpoint>");
        // 验证服务端证书，这里需要设置为您的服务端证书路径
        config.setCaFilePath("<path/to/yourCaCert>");
        // 或者，设置为您的服务端证书内容
        //config.setCa("<your-ca-certificate-content");
        try {
            Client client = new Client(config);
            encrypt(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static com.aliyun.dkms.gcs.sdk.models.EncryptResponse encrypt(Client client) {
        String keyId = "<your-key-id>";
        String plaintext = "<your-plaintext>";
        com.aliyun.dkms.gcs.sdk.models.EncryptRequest encryptRequest = new com.aliyun.dkms.gcs.sdk.models.EncryptRequest();
        encryptRequest.setKeyId(keyId);
        encryptRequest.setPlaintext(plaintext.getBytes(StandardCharsets.UTF_8));
        try {
            // 如需忽略服务端证书，可使用此处注释代码方式调用
            //RuntimeOptions runtimeOptions = new RuntimeOptions();
            //runtimeOptions.setIgnoreSSL(true);
            //com.aliyun.dkms.gcs.sdk.models.EncryptResponse encryptResponse = client.encryptWithOptions(encryptRequest, runtimeOptions);
            com.aliyun.dkms.gcs.sdk.models.EncryptResponse encryptResponse = client.encrypt(encryptRequest);
            System.out.printf("KeyId: %s%n", encryptResponse.getKeyId());
            System.out.printf("CiphertextBlob: %s%n", Arrays.toString(encryptResponse.getCiphertextBlob()));
            System.out.printf("Iv: %s%n", Arrays.toString(encryptResponse.getIv()));
            System.out.printf("RequestId: %s%n", encryptResponse.getRequestId());
            return encryptResponse;
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
}