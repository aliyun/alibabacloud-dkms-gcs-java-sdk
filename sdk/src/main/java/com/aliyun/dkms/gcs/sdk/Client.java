// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk;

import com.aliyun.tea.*;
import com.aliyun.dkms.gcs.sdk.models.*;
import com.aliyun.dkms.gcs.openapi.util.models.*;
import com.aliyun.dkms.gcs.openapi.models.*;
public class Client extends com.aliyun.dkms.gcs.openapi.Client {

    public Client(Config config) throws Exception {
        super(config);
    }


    public EncryptResponse encryptWithOptions(EncryptRequest request, RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedEncryptRequest(reqBody);
        ResponseBody responseBody = this.doRequest("Encrypt", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.getRequestHeaders());
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseEncryptResponse(responseBody.getBodyBytes());
        EncryptResponse encryptResponse = TeaModel.toModel(TeaConverter.buildMap(
                new TeaPair("RequestId", respMap.get("RequestId")),
                new TeaPair("KeyId", respMap.get("KeyId")),
                new TeaPair("CiphertextBlob", respMap.get("CiphertextBlob")),
                new TeaPair("Iv", respMap.get("Iv")),
                new TeaPair("Algorithm", respMap.get("Algorithm")),
                new TeaPair("PaddingMode", respMap.get("PaddingMode"))
        ), new EncryptResponse());
        encryptResponse.setResponseHeaders(responseBody.getResponseHeaders());
        return encryptResponse;
    }

    public EncryptResponse encrypt(EncryptRequest request) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        return this.encryptWithOptions(request, runtime);
    }

    public DecryptResponse decryptWithOptions(DecryptRequest request, RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedDecryptRequest(reqBody);
        ResponseBody responseBody = this.doRequest("Decrypt", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.getRequestHeaders());
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseDecryptResponse(responseBody.getBodyBytes());
        DecryptResponse decryptResponse = TeaModel.toModel(TeaConverter.buildMap(
                new TeaPair("RequestId", respMap.get("RequestId")),
                new TeaPair("KeyId", respMap.get("KeyId")),
                new TeaPair("Plaintext", respMap.get("Plaintext")),
                new TeaPair("Algorithm", respMap.get("Algorithm")),
                new TeaPair("PaddingMode", respMap.get("PaddingMode"))
        ), new DecryptResponse());
        decryptResponse.setResponseHeaders(responseBody.getResponseHeaders());
        return decryptResponse;
    }

    public DecryptResponse decrypt(DecryptRequest request) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        return this.decryptWithOptions(request, runtime);
    }

    public HmacResponse hmacWithOptions(HmacRequest request, RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedHmacRequest(reqBody);
        ResponseBody responseBody = this.doRequest("Hmac", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.getRequestHeaders());
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseHmacResponse(responseBody.getBodyBytes());
        HmacResponse hmacResponse = TeaModel.toModel(TeaConverter.buildMap(
                new TeaPair("RequestId", respMap.get("RequestId")),
                new TeaPair("KeyId", respMap.get("KeyId")),
                new TeaPair("Signature", respMap.get("Signature"))
        ), new HmacResponse());
        hmacResponse.setResponseHeaders(responseBody.getResponseHeaders());
        return hmacResponse;
    }

    public HmacResponse hmac(HmacRequest request) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        return this.hmacWithOptions(request, runtime);
    }

    public SignResponse signWithOptions(SignRequest request, RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedSignRequest(reqBody);
        ResponseBody responseBody = this.doRequest("Sign", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.getRequestHeaders());
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseSignResponse(responseBody.getBodyBytes());
        SignResponse signResponse = TeaModel.toModel(TeaConverter.buildMap(
                new TeaPair("RequestId", respMap.get("RequestId")),
                new TeaPair("KeyId", respMap.get("KeyId")),
                new TeaPair("Signature", respMap.get("Signature")),
                new TeaPair("Algorithm", respMap.get("Algorithm")),
                new TeaPair("MessageType", respMap.get("MessageType"))
        ), new SignResponse());
        signResponse.setResponseHeaders(responseBody.getResponseHeaders());
        return signResponse;
    }

    public SignResponse sign(SignRequest request) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        return this.signWithOptions(request, runtime);
    }

    public VerifyResponse verifyWithOptions(VerifyRequest request, RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedVerifyRequest(reqBody);
        ResponseBody responseBody = this.doRequest("Verify", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.getRequestHeaders());
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseVerifyResponse(responseBody.getBodyBytes());
        VerifyResponse verifyResponse = TeaModel.toModel(TeaConverter.buildMap(
                new TeaPair("RequestId", respMap.get("RequestId")),
                new TeaPair("KeyId", respMap.get("KeyId")),
                new TeaPair("Value", respMap.get("Value")),
                new TeaPair("Algorithm", respMap.get("Algorithm")),
                new TeaPair("MessageType", respMap.get("MessageType"))
        ), new VerifyResponse());
        verifyResponse.setResponseHeaders(responseBody.getResponseHeaders());
        return verifyResponse;
    }

    public VerifyResponse verify(VerifyRequest request) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        return this.verifyWithOptions(request, runtime);
    }

    public GenerateRandomResponse generateRandomWithOptions(GenerateRandomRequest request, RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedGenerateRandomRequest(reqBody);
        ResponseBody responseBody = this.doRequest("GenerateRandom", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.getRequestHeaders());
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseGenerateRandomResponse(responseBody.getBodyBytes());
        GenerateRandomResponse generateRandomResponse = TeaModel.toModel(TeaConverter.buildMap(
                new TeaPair("RequestId", respMap.get("RequestId")),
                new TeaPair("Random", respMap.get("Random"))
        ), new GenerateRandomResponse());
        generateRandomResponse.setResponseHeaders(responseBody.getResponseHeaders());
        return generateRandomResponse;
    }

    public GenerateRandomResponse generateRandom(GenerateRandomRequest request) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        return this.generateRandomWithOptions(request, runtime);
    }

    public GenerateDataKeyResponse generateDataKeyWithOptions(GenerateDataKeyRequest request, RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedGenerateDataKeyRequest(reqBody);
        ResponseBody responseBody = this.doRequest("GenerateDataKey", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.getRequestHeaders());
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseGenerateDataKeyResponse(responseBody.getBodyBytes());
        GenerateDataKeyResponse generateDataKeyResponse = TeaModel.toModel(TeaConverter.buildMap(
                new TeaPair("RequestId", respMap.get("RequestId")),
                new TeaPair("KeyId", respMap.get("KeyId")),
                new TeaPair("Iv", respMap.get("Iv")),
                new TeaPair("Plaintext", respMap.get("Plaintext")),
                new TeaPair("CiphertextBlob", respMap.get("CiphertextBlob")),
                new TeaPair("Algorithm", respMap.get("Algorithm"))
        ), new GenerateDataKeyResponse());
        generateDataKeyResponse.setResponseHeaders(responseBody.getResponseHeaders());
        return generateDataKeyResponse;
    }

    public GenerateDataKeyResponse generateDataKey(GenerateDataKeyRequest request) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        return this.generateDataKeyWithOptions(request, runtime);
    }

    public GetPublicKeyResponse getPublicKeyWithOptions(GetPublicKeyRequest request, RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedGetPublicKeyRequest(reqBody);
        ResponseBody responseBody = this.doRequest("GetPublicKey", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.getRequestHeaders());
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseGetPublicKeyResponse(responseBody.getBodyBytes());
        GetPublicKeyResponse getPublicKeyResponse = TeaModel.toModel(TeaConverter.buildMap(
                new TeaPair("RequestId", respMap.get("RequestId")),
                new TeaPair("KeyId", respMap.get("KeyId")),
                new TeaPair("PublicKey", respMap.get("PublicKey"))
        ), new GetPublicKeyResponse());
        getPublicKeyResponse.setResponseHeaders(responseBody.getResponseHeaders());
        return getPublicKeyResponse;
    }

    public GetPublicKeyResponse getPublicKey(GetPublicKeyRequest request) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        return this.getPublicKeyWithOptions(request, runtime);
    }
}
