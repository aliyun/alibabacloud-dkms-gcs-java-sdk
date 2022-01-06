// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk;

import com.aliyun.tea.*;
import com.aliyun.dkms.gcs.sdk.models.*;
import com.aliyun.teautil.*;
import com.aliyun.dkms.gcs.openapi.util.*;
import com.aliyun.dkms.gcs.openapi.util.models.*;
import com.aliyun.dkms.gcs.openapi.*;
import com.aliyun.dkms.gcs.openapi.models.*;

public class Client extends com.aliyun.dkms.gcs.openapi.Client {

    public Client(Config config) throws Exception {
        super(config);
    }


    public EncryptResponse encryptWithOptions(EncryptRequest request, RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedEncryptRequest(reqBody);
        byte[] respBytes = this.doRequest("Encrypt", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime);
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseEncryptResponse(respBytes);
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("KeyId", respMap.get("KeyId")),
            new TeaPair("CiphertextBlob", respMap.get("CiphertextBlob")),
            new TeaPair("Iv", respMap.get("Iv")),
            new TeaPair("Algorithm", respMap.get("Algorithm")),
            new TeaPair("PaddingMode", respMap.get("PaddingMode"))
        ), new EncryptResponse());
    }

    public EncryptResponse encrypt(EncryptRequest request) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        return this.encryptWithOptions(request, runtime);
    }

    public DecryptResponse decryptWithOptions(DecryptRequest request, RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedDecryptRequest(reqBody);
        byte[] respBytes = this.doRequest("Decrypt", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime);
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseDecryptResponse(respBytes);
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("KeyId", respMap.get("KeyId")),
            new TeaPair("Plaintext", respMap.get("Plaintext")),
            new TeaPair("Algorithm", respMap.get("Algorithm")),
            new TeaPair("PaddingMode", respMap.get("PaddingMode"))
        ), new DecryptResponse());
    }

    public DecryptResponse decrypt(DecryptRequest request) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        return this.decryptWithOptions(request, runtime);
    }

    public HmacResponse hmacWithOptions(HmacRequest request, RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedHmacRequest(reqBody);
        byte[] respBytes = this.doRequest("Hmac", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime);
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseHmacResponse(respBytes);
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("KeyId", respMap.get("KeyId")),
            new TeaPair("Signature", respMap.get("Signature"))
        ), new HmacResponse());
    }

    public HmacResponse hmac(HmacRequest request) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        return this.hmacWithOptions(request, runtime);
    }

    public SignResponse signWithOptions(SignRequest request, RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedSignRequest(reqBody);
        byte[] respBytes = this.doRequest("Sign", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime);
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseSignResponse(respBytes);
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("KeyId", respMap.get("KeyId")),
            new TeaPair("Signature", respMap.get("Signature")),
            new TeaPair("Algorithm", respMap.get("Algorithm")),
            new TeaPair("MessageType", respMap.get("MessageType"))
        ), new SignResponse());
    }

    public SignResponse sign(SignRequest request) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        return this.signWithOptions(request, runtime);
    }

    public VerifyResponse verifyWithOptions(VerifyRequest request, RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedVerifyRequest(reqBody);
        byte[] respBytes = this.doRequest("Verify", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime);
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseVerifyResponse(respBytes);
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("KeyId", respMap.get("KeyId")),
            new TeaPair("Value", respMap.get("Value")),
            new TeaPair("Algorithm", respMap.get("Algorithm")),
            new TeaPair("MessageType", respMap.get("MessageType"))
        ), new VerifyResponse());
    }

    public VerifyResponse verify(VerifyRequest request) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        return this.verifyWithOptions(request, runtime);
    }

    public GenerateRandomResponse generateRandomWithOptions(GenerateRandomRequest request, RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedGenerateRandomRequest(reqBody);
        byte[] respBytes = this.doRequest("GenerateRandom", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime);
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseGenerateRandomResponse(respBytes);
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("Random", respMap.get("Random"))
        ), new GenerateRandomResponse());
    }

    public GenerateRandomResponse generateRandom(GenerateRandomRequest request) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        return this.generateRandomWithOptions(request, runtime);
    }

    public GenerateDataKeyResponse generateDataKeyWithOptions(GenerateDataKeyRequest request, RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedGenerateDataKeyRequest(reqBody);
        byte[] respBytes = this.doRequest("GenerateDataKey", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime);
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseGenerateDataKeyResponse(respBytes);
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("KeyId", respMap.get("KeyId")),
            new TeaPair("Iv", respMap.get("Iv")),
            new TeaPair("Plaintext", respMap.get("Plaintext")),
            new TeaPair("CiphertextBlob", respMap.get("CiphertextBlob")),
            new TeaPair("Algorithm", respMap.get("Algorithm"))
        ), new GenerateDataKeyResponse());
    }

    public GenerateDataKeyResponse generateDataKey(GenerateDataKeyRequest request) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        return this.generateDataKeyWithOptions(request, runtime);
    }

    public GetPublicKeyResponse getPublicKeyWithOptions(GetPublicKeyRequest request, RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> reqBody = com.aliyun.teautil.Common.toMap(request);
        byte[] reqBodyBytes = com.aliyun.dkms.gcs.openapi.util.Client.getSerializedGetPublicKeyRequest(reqBody);
        byte[] respBytes = this.doRequest("GetPublicKey", "dkms-gcs-0.2", "https", "POST", "RSA_PKCS1_SHA_256", reqBodyBytes, runtime);
        java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.parseGetPublicKeyResponse(respBytes);
        return TeaModel.toModel(TeaConverter.buildMap(
            new TeaPair("RequestId", respMap.get("RequestId")),
            new TeaPair("KeyId", respMap.get("KeyId")),
            new TeaPair("PublicKey", respMap.get("PublicKey"))
        ), new GetPublicKeyResponse());
    }

    public GetPublicKeyResponse getPublicKey(GetPublicKeyRequest request) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        return this.getPublicKeyWithOptions(request, runtime);
    }
}
