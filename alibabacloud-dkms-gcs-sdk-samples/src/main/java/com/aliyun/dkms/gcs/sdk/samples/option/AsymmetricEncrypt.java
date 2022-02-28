package com.aliyun.dkms.gcs.sdk.samples.option;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.EncryptResponse;
import com.aliyun.tea.TeaException;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.kms.model.v20160120.*;
import com.aliyuncs.profile.DefaultProfile;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class AsymmetricEncrypt {

    public static void main(String[] args) {
        asymmetricEncryptKmsSample();
        asymmetricEncryptDKmsSample();
    }

    /**
     * 共享kms非对称加密sample
     */
    public static void asymmetricEncryptKmsSample() {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<your-access-key-id>", "<your-access-key-secret>");
        /** use STS Token
         DefaultProfile profile = DefaultProfile.getProfile(
         "<your-region-id>",           // The region ID
         "<your-access-key-id>",       // The AccessKey ID of the RAM account
         "<your-access-key-secret>",   // The AccessKey Secret of the RAM account
         "<your-sts-token>");          // STS Token
         **/
        IAcsClient client = new DefaultAcsClient(profile);

        AsymmetricEncryptRequest request = new AsymmetricEncryptRequest();
        request.setPlaintext("<your-plain-text>");
        request.setKeyId("<your-key-id>");
        request.setKeyVersionId("<your-key-version-id>");
        request.setAlgorithm("<your-algorithm>");
        try {
            AsymmetricEncryptResponse response = client.getAcsResponse(request);
            System.out.printf("CiphertextBlob: %s%n" , response.getCiphertextBlob());
            System.out.printf("KeyId: %s%n" , response.getKeyId());
            System.out.printf("KeyVersionId: %s%n" , response.getKeyVersionId());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
    }

    /**
     * 专属kms非对称加密sample
     */
    public static void asymmetricEncryptDKmsSample() {

        Config config = new Config();
        config.setProtocol("https");
        config.setClientKeyFile("<your-client-key-file>");
        config.setPassword("<your-password>");
        config.setEndpoint("<your-endpoint>");
        config.setProtocol("https");
        try {
            Client client = new Client(config);
            asymmetricEncrypt(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EncryptResponse asymmetricEncrypt(Client client) {
        String keyId = "<your-key-id>";
        String plaintext = "<your-plaintext>";
        com.aliyun.dkms.gcs.sdk.models.EncryptRequest encryptRequest = new com.aliyun.dkms.gcs.sdk.models.EncryptRequest();
        //用于加解密的密钥Id
        encryptRequest.setKeyId(keyId);
        //加密的明文数据字节数组
        encryptRequest.setPlaintext(plaintext.getBytes(StandardCharsets.UTF_8));
        RuntimeOptions runtimeOptions = new RuntimeOptions();
        runtimeOptions.ignoreSSL = true;
        try {
            EncryptResponse encryptResponse = client.encryptWithOptions(encryptRequest, runtimeOptions);
            //密钥Id,解密时需传入此参数
            System.out.printf("KeyId: %s%n", encryptResponse.getKeyId());
            //密文字节数组,解密时需传入此参数
            System.out.printf("CiphertextBlob: %s%n", Arrays.toString(encryptResponse.getCiphertextBlob()));
            //加密算法,解密时需传入此参数
            System.out.printf("Algorithm: %s%n", encryptResponse.getAlgorithm());
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