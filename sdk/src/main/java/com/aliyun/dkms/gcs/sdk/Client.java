// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk;

import com.aliyun.tea.*;
import com.aliyun.dkms.gcs.sdk.models.*;

public class Client extends com.aliyun.dkms.gcs.openapi.Client {

    public Client(com.aliyun.dkms.gcs.openapi.models.Config config) throws Exception {
        super(config);
    }


    /**
     * 调用Encrypt接口将明文加密为密文
     * @param request
     * @return EncryptResponse
     */
    public EncryptResponse encrypt(EncryptRequest request) throws Exception {
        com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime = new com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions();
        return this.encryptWithOptions(request, runtime);
    }

    /**
     * 带运行参数调用Encrypt接口将明文加密为密文
     * @param request
     * @param runtime
     * @return EncryptResponse
     */
    public EncryptResponse encryptWithOptions(EncryptRequest request, com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedEncryptRequest(reqBody);
        java.util.Map<String, Object> responseEntity = com.aliyun.teautil.Common.assertAsMap(this.doRequest("Encrypt", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.requestHeaders));
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseEncryptResponse(com.aliyun.teautil.Common.assertAsBytes(responseEntity.get("bodyBytes")));
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("KeyId", respMap.get("KeyId")),
            new TeaPair("CiphertextBlob", respMap.get("CiphertextBlob")),
            new TeaPair("Iv", respMap.get("Iv")),
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("Algorithm", respMap.get("Algorithm")),
            new TeaPair("PaddingMode", respMap.get("PaddingMode")),
            new TeaPair("responseHeaders", responseEntity.get("responseHeaders"))
        ), new EncryptResponse());
    }

    /**
     * 调用Decrypt接口将密文解密为明文
     * @param request
     * @return DecryptResponse
     */
    public DecryptResponse decrypt(DecryptRequest request) throws Exception {
        com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime = new com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions();
        return this.decryptWithOptions(request, runtime);
    }

    /**
     * 带运行参数调用Decrypt接口将密文解密为明文
     * @param request
     * @param runtime
     * @return DecryptResponse
     */
    public DecryptResponse decryptWithOptions(DecryptRequest request, com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedDecryptRequest(reqBody);
        java.util.Map<String, Object> responseEntity = com.aliyun.teautil.Common.assertAsMap(this.doRequest("Decrypt", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.requestHeaders));
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseDecryptResponse(com.aliyun.teautil.Common.assertAsBytes(responseEntity.get("bodyBytes")));
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("KeyId", respMap.get("KeyId")),
            new TeaPair("Plaintext", respMap.get("Plaintext")),
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("Algorithm", respMap.get("Algorithm")),
            new TeaPair("PaddingMode", respMap.get("PaddingMode")),
            new TeaPair("responseHeaders", responseEntity.get("responseHeaders"))
        ), new DecryptResponse());
    }

    /**
     * 调用Sign接口使用非对称密钥进行签名
     * @param request
     * @return SignResponse
     */
    public SignResponse sign(SignRequest request) throws Exception {
        com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime = new com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions();
        return this.signWithOptions(request, runtime);
    }

    /**
     * 带运行参数调用Sign接口使用非对称密钥进行签名
     * @param request
     * @param runtime
     * @return SignResponse
     */
    public SignResponse signWithOptions(SignRequest request, com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedSignRequest(reqBody);
        java.util.Map<String, Object> responseEntity = com.aliyun.teautil.Common.assertAsMap(this.doRequest("Sign", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.requestHeaders));
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseSignResponse(com.aliyun.teautil.Common.assertAsBytes(responseEntity.get("bodyBytes")));
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("KeyId", respMap.get("KeyId")),
            new TeaPair("Signature", respMap.get("Signature")),
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("Algorithm", respMap.get("Algorithm")),
            new TeaPair("MessageType", respMap.get("MessageType")),
            new TeaPair("responseHeaders", responseEntity.get("responseHeaders"))
        ), new SignResponse());
    }

    /**
     * 调用Verify接口使用非对称密钥进行验签
     * @param request
     * @return VerifyResponse
     */
    public VerifyResponse verify(VerifyRequest request) throws Exception {
        com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime = new com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions();
        return this.verifyWithOptions(request, runtime);
    }

    /**
     * 带运行参数调用Verify接口使用非对称密钥进行验签
     * @param request
     * @param runtime
     * @return VerifyResponse
     */
    public VerifyResponse verifyWithOptions(VerifyRequest request, com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedVerifyRequest(reqBody);
        java.util.Map<String, Object> responseEntity = com.aliyun.teautil.Common.assertAsMap(this.doRequest("Verify", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.requestHeaders));
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseVerifyResponse(com.aliyun.teautil.Common.assertAsBytes(responseEntity.get("bodyBytes")));
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("KeyId", respMap.get("KeyId")),
            new TeaPair("Value", respMap.get("Value")),
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("Algorithm", respMap.get("Algorithm")),
            new TeaPair("MessageType", respMap.get("MessageType")),
            new TeaPair("responseHeaders", responseEntity.get("responseHeaders"))
        ), new VerifyResponse());
    }

    /**
     * 调用GenerateRandom接口生成一个随机数
     * @param request
     * @return GenerateRandomResponse
     */
    public GenerateRandomResponse generateRandom(GenerateRandomRequest request) throws Exception {
        com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime = new com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions();
        return this.generateRandomWithOptions(request, runtime);
    }

    /**
     * 带运行参数调用GenerateRandom接口生成一个随机数
     * @param request
     * @param runtime
     * @return GenerateRandomResponse
     */
    public GenerateRandomResponse generateRandomWithOptions(GenerateRandomRequest request, com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedGenerateRandomRequest(reqBody);
        java.util.Map<String, Object> responseEntity = com.aliyun.teautil.Common.assertAsMap(this.doRequest("GenerateRandom", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.requestHeaders));
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseGenerateRandomResponse(com.aliyun.teautil.Common.assertAsBytes(responseEntity.get("bodyBytes")));
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("Random", respMap.get("Random")),
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("responseHeaders", responseEntity.get("responseHeaders"))
        ), new GenerateRandomResponse());
    }

    /**
     * 调用GenerateDataKey接口生成数据密钥
     * @param request
     * @return GenerateDataKeyResponse
     */
    public GenerateDataKeyResponse generateDataKey(GenerateDataKeyRequest request) throws Exception {
        com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime = new com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions();
        return this.generateDataKeyWithOptions(request, runtime);
    }

    /**
     * 带运行参数调用GenerateDataKey接口生成数据密钥
     * @param request
     * @param runtime
     * @return GenerateDataKeyResponse
     */
    public GenerateDataKeyResponse generateDataKeyWithOptions(GenerateDataKeyRequest request, com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedGenerateDataKeyRequest(reqBody);
        java.util.Map<String, Object> responseEntity = com.aliyun.teautil.Common.assertAsMap(this.doRequest("GenerateDataKey", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.requestHeaders));
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseGenerateDataKeyResponse(com.aliyun.teautil.Common.assertAsBytes(responseEntity.get("bodyBytes")));
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("KeyId", respMap.get("KeyId")),
            new TeaPair("Iv", respMap.get("Iv")),
            new TeaPair("Plaintext", respMap.get("Plaintext")),
            new TeaPair("CiphertextBlob", respMap.get("CiphertextBlob")),
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("Algorithm", respMap.get("Algorithm")),
            new TeaPair("responseHeaders", responseEntity.get("responseHeaders"))
        ), new GenerateDataKeyResponse());
    }

    /**
     * 调用GetPublicKey接口获取指定非对称密钥的公钥
     * @param request
     * @return GetPublicKeyResponse
     */
    public GetPublicKeyResponse getPublicKey(GetPublicKeyRequest request) throws Exception {
        com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime = new com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions();
        return this.getPublicKeyWithOptions(request, runtime);
    }

    /**
     * 带运行参数调用GetPublicKey接口获取指定非对称密钥的公钥
     * @param request
     * @param runtime
     * @return GetPublicKeyResponse
     */
    public GetPublicKeyResponse getPublicKeyWithOptions(GetPublicKeyRequest request, com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedGetPublicKeyRequest(reqBody);
        java.util.Map<String, Object> responseEntity = com.aliyun.teautil.Common.assertAsMap(this.doRequest("GetPublicKey", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.requestHeaders));
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseGetPublicKeyResponse(com.aliyun.teautil.Common.assertAsBytes(responseEntity.get("bodyBytes")));
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("KeyId", respMap.get("KeyId")),
            new TeaPair("PublicKey", respMap.get("PublicKey")),
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("responseHeaders", responseEntity.get("responseHeaders"))
        ), new GetPublicKeyResponse());
    }

    /**
     * 调用GetSecretValue接口通过KMS实例网关获取凭据值
     * @param request
     * @return GetSecretValueResponse
     */
    public GetSecretValueResponse getSecretValue(GetSecretValueRequest request) throws Exception {
        com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime = new com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions();
        return this.getSecretValueWithOptions(request, runtime);
    }

    /**
     * 带运行参数调用GetSecretValue接口通过KMS实例网关获取凭据值
     * @param request
     * @param runtime
     * @return GetSecretValueResponse
     */
    public GetSecretValueResponse getSecretValueWithOptions(GetSecretValueRequest request, com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedGetSecretValueRequest(reqBody);
        java.util.Map<String, Object> responseEntity = com.aliyun.teautil.Common.assertAsMap(this.doRequest("GetSecretValue", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.requestHeaders));
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseGetSecretValueResponse(com.aliyun.teautil.Common.assertAsBytes(responseEntity.get("bodyBytes")));
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("SecretName", respMap.get("SecretName")),
            new TeaPair("SecretType", respMap.get("SecretType")),
            new TeaPair("SecretData", respMap.get("SecretData")),
            new TeaPair("SecretDataType", respMap.get("SecretDataType")),
            new TeaPair("VersionStages", respMap.get("VersionStages")),
            new TeaPair("VersionId", respMap.get("VersionId")),
            new TeaPair("CreateTime", respMap.get("CreateTime")),
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("LastRotationDate", respMap.get("LastRotationDate")),
            new TeaPair("NextRotationDate", respMap.get("NextRotationDate")),
            new TeaPair("ExtendedConfig", respMap.get("ExtendedConfig")),
            new TeaPair("AutomaticRotation", respMap.get("AutomaticRotation")),
            new TeaPair("RotationInterval", respMap.get("RotationInterval")),
            new TeaPair("responseHeaders", responseEntity.get("responseHeaders"))
        ), new GetSecretValueResponse());
    }

    /**
     * 调用AdvanceEncrypt接口将明文高级加密为密文
     * @param request
     * @return AdvanceEncryptResponse
     */
    public AdvanceEncryptResponse advanceEncrypt(AdvanceEncryptRequest request) throws Exception {
        com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime = new com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions();
        return this.advanceEncryptWithOptions(request, runtime);
    }

    /**
     * 带运行参数调用AdvanceEncrypt接口将明文高级加密为密文
     * @param request
     * @param runtime
     * @return AdvanceEncryptResponse
     */
    public AdvanceEncryptResponse advanceEncryptWithOptions(AdvanceEncryptRequest request, com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedAdvanceEncryptRequest(reqBody);
        java.util.Map<String, Object> responseEntity = com.aliyun.teautil.Common.assertAsMap(this.doRequest("AdvanceEncrypt", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.requestHeaders));
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseAdvanceEncryptResponse(com.aliyun.teautil.Common.assertAsBytes(responseEntity.get("bodyBytes")));
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("KeyId", respMap.get("KeyId")),
            new TeaPair("CiphertextBlob", respMap.get("CiphertextBlob")),
            new TeaPair("Iv", respMap.get("Iv")),
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("Algorithm", respMap.get("Algorithm")),
            new TeaPair("PaddingMode", respMap.get("PaddingMode")),
            new TeaPair("KeyVersionId", respMap.get("KeyVersionId")),
            new TeaPair("responseHeaders", responseEntity.get("responseHeaders"))
        ), new AdvanceEncryptResponse());
    }

    /**
     * 调用AdvanceDecrypt接口将密文高级解密为明文
     * @param request
     * @return AdvanceDecryptResponse
     */
    public AdvanceDecryptResponse advanceDecrypt(AdvanceDecryptRequest request) throws Exception {
        com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime = new com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions();
        return this.advanceDecryptWithOptions(request, runtime);
    }

    /**
     * 带运行参数调用AdvanceDecrypt接口将密文高级解密为明文
     * @param request
     * @param runtime
     * @return AdvanceDecryptResponse
     */
    public AdvanceDecryptResponse advanceDecryptWithOptions(AdvanceDecryptRequest request, com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedAdvanceDecryptRequest(reqBody);
        java.util.Map<String, Object> responseEntity = com.aliyun.teautil.Common.assertAsMap(this.doRequest("AdvanceDecrypt", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.requestHeaders));
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseAdvanceDecryptResponse(com.aliyun.teautil.Common.assertAsBytes(responseEntity.get("bodyBytes")));
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("KeyId", respMap.get("KeyId")),
            new TeaPair("Plaintext", respMap.get("Plaintext")),
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("Algorithm", respMap.get("Algorithm")),
            new TeaPair("PaddingMode", respMap.get("PaddingMode")),
            new TeaPair("KeyVersionId", respMap.get("KeyVersionId")),
            new TeaPair("responseHeaders", responseEntity.get("responseHeaders"))
        ), new AdvanceDecryptResponse());
    }

    /**
     * 调用AdvanceGenerateDataKey接口高级生成数据密钥
     * @param request
     * @return AdvanceGenerateDataKeyRequest
     */
    public AdvanceGenerateDataKeyResponse advanceGenerateDataKey(AdvanceGenerateDataKeyRequest request) throws Exception {
        com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime = new com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions();
        return this.advanceGenerateDataKeyWithOptions(request, runtime);
    }

    /**
     * 带运行参数调用AdvanceGenerateDataKey接口高级生成数据密钥
     * @param request
     * @param runtime
     * @return AdvanceGenerateDataKeyRequest
     */
    public AdvanceGenerateDataKeyResponse advanceGenerateDataKeyWithOptions(AdvanceGenerateDataKeyRequest request, com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedAdvanceGenerateDataKeyRequest(reqBody);
        java.util.Map<String, Object> responseEntity = com.aliyun.teautil.Common.assertAsMap(this.doRequest("AdvanceGenerateDataKey", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.requestHeaders));
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseAdvanceGenerateDataKeyResponse(com.aliyun.teautil.Common.assertAsBytes(responseEntity.get("bodyBytes")));
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("KeyId", respMap.get("KeyId")),
            new TeaPair("Iv", respMap.get("Iv")),
            new TeaPair("Plaintext", respMap.get("Plaintext")),
            new TeaPair("CiphertextBlob", respMap.get("CiphertextBlob")),
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("Algorithm", respMap.get("Algorithm")),
            new TeaPair("KeyVersionId", respMap.get("KeyVersionId")),
            new TeaPair("responseHeaders", responseEntity.get("responseHeaders"))
        ), new AdvanceGenerateDataKeyResponse());
    }
}
