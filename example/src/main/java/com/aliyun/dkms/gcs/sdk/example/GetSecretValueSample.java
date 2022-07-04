package com.aliyun.dkms.gcs.sdk.example;

import com.aliyun.dkms.gcs.openapi.models.Config;
import com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions;
import com.aliyun.dkms.gcs.sdk.Client;
import com.aliyun.dkms.gcs.sdk.models.GetSecretValueRequest;
import com.aliyun.dkms.gcs.sdk.models.GetSecretValueResponse;
import com.aliyun.tea.TeaException;

/**
 * 专属kms获取凭据示例
 */
public class GetSecretValueSample {
    // 加密服务实例Client对象
    private static Client client = null;

    public static void main(String[] args) {
        try {
            // 构建加密服务实例Client对象
            initClient();

            String secretName = "<your-secret-name>";

            // 使用专属kms获取凭据示例
            getSecretValueSample(secretName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化Client
     * @throws Exception
     */
    public static void initClient() throws Exception {
        // 构建加密服务实例Client配置
        Config config = new Config();
        config.setProtocol("https");
        config.setClientKeyFile("<your-client-key-file>");
        config.setPassword("<your-password>");
        config.setEndpoint("<your-endpoint>");
        client = new Client(config);
    }

    /**
     * 使用专属kms获取凭据示例
     * @param secretName
     */
    private static void getSecretValueSample(String secretName) {
        GetSecretValueRequest request = new GetSecretValueRequest()
                .setSecretName(secretName);
        //如需跳过https认证，可使用此处注释代码方式调用
        //RuntimeOptions runtimeOptions = new RuntimeOptions();
        //runtimeOptions.ignoreSSL = true;
        try {
            //GetSecretValueResponse getSecretValueResponse = client.getSecretValueWithOptions(request, runtimeOptions);
            GetSecretValueResponse getSecretValueResponse = client.getSecretValue(request);
            System.out.printf("SecretName: %s%n", getSecretValueResponse.getSecretName());
            System.out.printf("SecretData: %s%n", getSecretValueResponse.getSecretData());
            System.out.printf("VersionStages: %s%n", getSecretValueResponse.getVersionStages());
            System.out.printf("RequestId: %s%n", getSecretValueResponse.getRequestId());
        } catch (Exception e) {
            if (e instanceof TeaException) {
                System.out.printf("Code: %s%n", ((TeaException) e).getCode());
                System.out.printf("Message: %s%n", ((TeaException) e).getMessage());
                System.out.printf("HttpCode: %s%n", ((TeaException) e).getData().get("httpCode"));
                System.out.printf("HostId: %s%n", ((TeaException) e).getData().get("hostId"));
                System.out.printf("RequestId: %s%n", ((TeaException) e).getData().get("requestId"));
            }
            e.printStackTrace();
        }
    }
}