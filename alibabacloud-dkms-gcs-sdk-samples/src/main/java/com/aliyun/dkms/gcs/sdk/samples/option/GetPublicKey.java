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


public class GetPublicKey {

    public static void main(String[] args) {
        getPublicKeyKmsSample();
        getPublicKeyDKmsSample();
    }

    /**
     * 共享kms获取公钥sample
     */
    public static void getPublicKeyKmsSample() {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<your-access-key-id>", "<your-access-key-secret>");

        /** use STS Token
         DefaultProfile profile = DefaultProfile.getProfile(
         "<your-region-id>",           // The region ID
         "<your-access-key-id>",       // The AccessKey ID of the RAM account
         "<your-access-key-secret>",   // The AccessKey Secret of the RAM account
         "<your-sts-token>");          // STS Token
         **/
        IAcsClient client = new DefaultAcsClient(profile);

        GetPublicKeyRequest request = new GetPublicKeyRequest();
        request.setKeyId("<your-key-id>");
        request.setKeyVersionId("<your-key-version-id>");
        try {
            GetPublicKeyResponse response = client.getAcsResponse(request);
            System.out.printf("KeyId: %s%n", response.getKeyId());
            System.out.printf("KeyVersionId: %s%n", response.getKeyVersionId());
            System.out.printf("PublicKey: %s%n", response.getPublicKey());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
    }

    /**
     * 专属kms获取公钥sample
     */
    public static void getPublicKeyDKmsSample() {
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
            getPublicKey(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getPublicKey(Client client) {
        String keyId = "<your-key-id>";
        com.aliyun.dkms.gcs.sdk.models.GetPublicKeyRequest getPublicKeyRequest = new com.aliyun.dkms.gcs.sdk.models.GetPublicKeyRequest();
        getPublicKeyRequest.setKeyId(keyId);

        try {
            // 如需忽略服务端证书，可使用此处注释代码方式调用
            //RuntimeOptions runtimeOptions = new RuntimeOptions();
            //runtimeOptions.setIgnoreSSL(true);
            //com.aliyun.dkms.gcs.sdk.models.GetPublicKeyResponse getPublicKeyResponse = client.getPublicKeyWithOptions(getPublicKeyRequest, runtimeOptions);
            com.aliyun.dkms.gcs.sdk.models.GetPublicKeyResponse getPublicKeyResponse = client.getPublicKey(getPublicKeyRequest);
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
}