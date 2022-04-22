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
        ResponseEntity responseEntity = this.doRequest("Encrypt", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.getRequestHeaders());
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseEncryptResponse(responseEntity.getBodyBytes());
        EncryptResponse encryptResponse = TeaModel.toModel(TeaConverter.buildMap(
                new TeaPair("RequestId", respMap.get("RequestId")),
                new TeaPair("KeyId", respMap.get("KeyId")),
                new TeaPair("CiphertextBlob", respMap.get("CiphertextBlob")),
                new TeaPair("Iv", respMap.get("Iv")),
                new TeaPair("Algorithm", respMap.get("Algorithm")),
                new TeaPair("PaddingMode", respMap.get("PaddingMode"))
        ), new EncryptResponse());
        encryptResponse.setResponseHeaders(responseEntity.getResponseHeaders());
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
        ResponseEntity responseEntity = this.doRequest("Decrypt", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.getRequestHeaders());
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseDecryptResponse(responseEntity.getBodyBytes());
        DecryptResponse decryptResponse = TeaModel.toModel(TeaConverter.buildMap(
                new TeaPair("RequestId", respMap.get("RequestId")),
                new TeaPair("KeyId", respMap.get("KeyId")),
                new TeaPair("Plaintext", respMap.get("Plaintext")),
                new TeaPair("Algorithm", respMap.get("Algorithm")),
                new TeaPair("PaddingMode", respMap.get("PaddingMode"))
        ), new DecryptResponse());
        decryptResponse.setResponseHeaders(responseEntity.getResponseHeaders());
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
        ResponseEntity responseEntity = this.doRequest("Hmac", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.getRequestHeaders());
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseHmacResponse(responseEntity.getBodyBytes());
        HmacResponse hmacResponse = TeaModel.toModel(TeaConverter.buildMap(
                new TeaPair("RequestId", respMap.get("RequestId")),
                new TeaPair("KeyId", respMap.get("KeyId")),
                new TeaPair("Signature", respMap.get("Signature"))
        ), new HmacResponse());
        hmacResponse.setResponseHeaders(responseEntity.getResponseHeaders());
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
        ResponseEntity responseEntity = this.doRequest("Sign", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.getRequestHeaders());
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseSignResponse(responseEntity.getBodyBytes());
        SignResponse signResponse = TeaModel.toModel(TeaConverter.buildMap(
                new TeaPair("RequestId", respMap.get("RequestId")),
                new TeaPair("KeyId", respMap.get("KeyId")),
                new TeaPair("Signature", respMap.get("Signature")),
                new TeaPair("Algorithm", respMap.get("Algorithm")),
                new TeaPair("MessageType", respMap.get("MessageType"))
        ), new SignResponse());
        signResponse.setResponseHeaders(responseEntity.getResponseHeaders());
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
        ResponseEntity responseEntity = this.doRequest("Verify", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.getRequestHeaders());
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseVerifyResponse(responseEntity.getBodyBytes());
        VerifyResponse verifyResponse = TeaModel.toModel(TeaConverter.buildMap(
                new TeaPair("RequestId", respMap.get("RequestId")),
                new TeaPair("KeyId", respMap.get("KeyId")),
                new TeaPair("Value", respMap.get("Value")),
                new TeaPair("Algorithm", respMap.get("Algorithm")),
                new TeaPair("MessageType", respMap.get("MessageType"))
        ), new VerifyResponse());
        verifyResponse.setResponseHeaders(responseEntity.getResponseHeaders());
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
        ResponseEntity responseEntity = this.doRequest("GenerateRandom", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.getRequestHeaders());
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseGenerateRandomResponse(responseEntity.getBodyBytes());
        GenerateRandomResponse generateRandomResponse = TeaModel.toModel(TeaConverter.buildMap(
                new TeaPair("RequestId", respMap.get("RequestId")),
                new TeaPair("Random", respMap.get("Random"))
        ), new GenerateRandomResponse());
        generateRandomResponse.setResponseHeaders(responseEntity.getResponseHeaders());
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
        ResponseEntity responseEntity = this.doRequest("GenerateDataKey", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.getRequestHeaders());
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseGenerateDataKeyResponse(responseEntity.getBodyBytes());
        GenerateDataKeyResponse generateDataKeyResponse = TeaModel.toModel(TeaConverter.buildMap(
                new TeaPair("RequestId", respMap.get("RequestId")),
                new TeaPair("KeyId", respMap.get("KeyId")),
                new TeaPair("Iv", respMap.get("Iv")),
                new TeaPair("Plaintext", respMap.get("Plaintext")),
                new TeaPair("CiphertextBlob", respMap.get("CiphertextBlob")),
                new TeaPair("Algorithm", respMap.get("Algorithm"))
        ), new GenerateDataKeyResponse());
        generateDataKeyResponse.setResponseHeaders(responseEntity.getResponseHeaders());
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
        ResponseEntity responseEntity = this.doRequest("GetPublicKey", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime, request.getRequestHeaders());
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseGetPublicKeyResponse(responseEntity.getBodyBytes());
        GetPublicKeyResponse getPublicKeyResponse = TeaModel.toModel(TeaConverter.buildMap(
                new TeaPair("RequestId", respMap.get("RequestId")),
                new TeaPair("KeyId", respMap.get("KeyId")),
                new TeaPair("PublicKey", respMap.get("PublicKey"))
        ), new GetPublicKeyResponse());
        getPublicKeyResponse.setResponseHeaders(responseEntity.getResponseHeaders());
        return getPublicKeyResponse;
    }

    public GetPublicKeyResponse getPublicKey(GetPublicKeyRequest request) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        return this.getPublicKeyWithOptions(request, runtime);
    }
}
