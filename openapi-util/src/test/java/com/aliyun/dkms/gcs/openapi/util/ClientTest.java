package com.aliyun.dkms.gcs.openapi.util;

import com.aliyun.dkms.gcs.openapi.util.protobuf.ApiModels;
import com.aliyun.tea.TeaRequest;
import com.google.protobuf.ByteString;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientTest {

    @org.junit.jupiter.api.Test
    void getHost() throws Exception {
        String host = Client.getHost("", "");

        assertEquals("kms-instance.cn-hangzhou.aliyuncs.com", host);

        String regionId = "regionId";
        host = Client.getHost(regionId, "");

        assertEquals("kms-instance.regionId.aliyuncs.com", host);

        String endpoint = "endpoint";
        host = Client.getHost(regionId, endpoint);

        assertEquals("endpoint", host);
    }

    @org.junit.jupiter.api.Test
    void getErrMessage() throws Exception {
        String errorMessage = "error message";
        String errorCode = "error code";
        String requestId = "request id";

        ApiModels.Error.Builder builder = ApiModels.Error.newBuilder();
        builder.setErrorMessage(errorMessage);
        builder.setErrorCode(errorCode);
        builder.setRequestId(requestId);
        Map<String, Object> resp = Client.getErrMessage(builder.build().toByteArray());

        assertEquals(errorMessage, resp.get("Message"));
        assertEquals(errorCode, resp.get("Code"));
        assertEquals(requestId, resp.get("RequestId"));
    }

    @org.junit.jupiter.api.Test
    void getStringToSign() throws Exception {
        String expect = "POST\n9F86D081884C7D659A2FEAA0C55AD015A3BF4F1B2B0B822CD15D6C15B0F00A08\napplication/x-protobuf\nTue, 06 Jul 2021 11:25:31 GMT\nx-kms-accesskeyid:access-key-id\nx-kms-apiname:Decrypt\nx-kms-apiversion:0.1.0\nx-kms-signaturemethod:RSA_PKCS1_SHA_256\n/";
        TeaRequest request = new TeaRequest();
        request.protocol = "https";
        request.method = "POST";
        request.pathname = "/";
        request.headers.put("accept", "application/x-protobuf");
        request.headers.put("host", "host");
        request.headers.put("date", "Tue, 06 Jul 2021 11:25:31 GMT");
        request.headers.put("user-agent", "user-agent");
        request.headers.put("x-kms-apiversion", "0.1.0");
        request.headers.put("x-kms-apiname", "Decrypt");
        request.headers.put("x-kms-signaturemethod", "RSA_PKCS1_SHA_256");
        request.headers.put("x-kms-accesskeyid", "access-key-id");
        request.headers.put("content-type", "application/x-protobuf");
        request.headers.put("content-length", "4");
        request.headers.put("content-sha256", "9F86D081884C7D659A2FEAA0C55AD015A3BF4F1B2B0B822CD15D6C15B0F00A08");
        String strToSign = Client.getStringToSign(request);

        assertEquals(expect, strToSign);
    }

    @org.junit.jupiter.api.Test
    void getContentSHA256() throws Exception {
        String content = "test";
        String expect = "9F86D081884C7D659A2FEAA0C55AD015A3BF4F1B2B0B822CD15D6C15B0F00A08";
        String sha256 = Client.getContentSHA256(content.getBytes(StandardCharsets.UTF_8));

        assertEquals(expect, sha256);
    }

    @org.junit.jupiter.api.Test
    void getSerializedEncryptRequest() throws Exception {
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("KeyId", "KeyId");
        reqBody.put("Algorithm", "Algorithm");
        reqBody.put("Plaintext", "Plaintext".getBytes(StandardCharsets.UTF_8));
        reqBody.put("Aad", "Aad".getBytes(StandardCharsets.UTF_8));
        reqBody.put("Iv", "Iv".getBytes(StandardCharsets.UTF_8));
        reqBody.put("PaddingMode", "PaddingMode");
        byte[] reqBodyBytes = Client.getSerializedEncryptRequest(reqBody);
        ApiModels.EncryptRequest request = ApiModels.EncryptRequest.parseFrom(reqBodyBytes);

        assertEquals("KeyId", request.getKeyId());
        assertEquals("Algorithm", request.getAlgorithm());
        assertEquals("Plaintext", new String(request.getPlaintext().toByteArray()));
        assertEquals("Aad", new String(request.getAad().toByteArray()));
        assertEquals("Iv", new String(request.getIv().toByteArray()));
        assertEquals("PaddingMode", request.getPaddingMode());
    }

    @org.junit.jupiter.api.Test
    void parseEncryptResponse() throws Exception {
        String keyId = "KeyId";
        byte[] ciphertext = "CiphertextBlob".getBytes(StandardCharsets.UTF_8);
        String requestId = "RequestId";
        byte[] iv = "Iv".getBytes(StandardCharsets.UTF_8);
        String algorithm = "Algorithm";
        String paddingMode = "PaddingMode";

        ApiModels.EncryptResponse.Builder builder = ApiModels.EncryptResponse.newBuilder();
        builder.setKeyId(keyId);
        builder.setCiphertextBlob(ByteString.copyFrom(ciphertext));
        builder.setIv(ByteString.copyFrom(iv));
        builder.setRequestId(requestId);
        builder.setAlgorithm(algorithm);
        builder.setPaddingMode(paddingMode);
        Map<String, Object> response = Client.parseEncryptResponse(builder.build().toByteArray());

        assertEquals(keyId, response.get("KeyId"));
        assertEquals(new String(ciphertext), new String((byte[]) response.get("CiphertextBlob")));
        assertEquals(new String(iv), new String((byte[]) response.get("Iv")));
        assertEquals(requestId, response.get("RequestId"));
        assertEquals(algorithm, response.get("Algorithm"));
        assertEquals(paddingMode, response.get("PaddingMode"));
    }

    @org.junit.jupiter.api.Test
    void getSerializedDecryptRequest() throws Exception {
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("KeyId", "KeyId");
        reqBody.put("Algorithm", "Algorithm");
        reqBody.put("CiphertextBlob", "CiphertextBlob".getBytes(StandardCharsets.UTF_8));
        reqBody.put("Aad", "Aad".getBytes(StandardCharsets.UTF_8));
        reqBody.put("Iv", "Iv".getBytes(StandardCharsets.UTF_8));
        reqBody.put("PaddingMode", "PaddingMode");
        byte[] reqBodyBytes = Client.getSerializedDecryptRequest(reqBody);
        ApiModels.DecryptRequest request = ApiModels.DecryptRequest.parseFrom(reqBodyBytes);

        assertEquals("KeyId", request.getKeyId());
        assertEquals("Algorithm", request.getAlgorithm());
        assertEquals("CiphertextBlob", new String(request.getCiphertextBlob().toByteArray()));
        assertEquals("Aad", new String(request.getAad().toByteArray()));
        assertEquals("Iv", new String(request.getIv().toByteArray()));
        assertEquals("PaddingMode", request.getPaddingMode());
    }

    @org.junit.jupiter.api.Test
    void parseDecryptResponse() throws Exception {
        String keyId = "KeyId";
        byte[] plaintext = "Plaintext".getBytes(StandardCharsets.UTF_8);
        String requestId = "RequestId";
        String algorithm = "Algorithm";
        String paddingMode = "PaddingMode";

        ApiModels.DecryptResponse.Builder builder = ApiModels.DecryptResponse.newBuilder();
        builder.setKeyId(keyId);
        builder.setPlaintext(ByteString.copyFrom(plaintext));
        builder.setRequestId(requestId);
        builder.setAlgorithm(algorithm);
        builder.setPaddingMode(paddingMode);
        Map<String, Object> response = Client.parseDecryptResponse(builder.build().toByteArray());

        assertEquals(keyId, response.get("KeyId"));
        assertEquals(new String(plaintext), new String((byte[]) response.get("Plaintext")));
        assertEquals(requestId, response.get("RequestId"));
        assertEquals(algorithm, response.get("Algorithm"));
        assertEquals(paddingMode, response.get("PaddingMode"));
    }

    @org.junit.jupiter.api.Test
    void getSerializedHmacRequest() throws Exception {
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("KeyId", "KeyId");
        reqBody.put("Message", "Message".getBytes(StandardCharsets.UTF_8));
        byte[] reqBodyBytes = Client.getSerializedHmacRequest(reqBody);
        ApiModels.HmacRequest request = ApiModels.HmacRequest.parseFrom(reqBodyBytes);

        assertEquals("KeyId", request.getKeyId());
        assertEquals("Message", new String(request.getMessage().toByteArray()));
    }

    @org.junit.jupiter.api.Test
    void parseHmacResponse() throws Exception {
        String keyId = "KeyId";
        byte[] signature = "Signature".getBytes(StandardCharsets.UTF_8);
        String requestId = "RequestId";

        ApiModels.HmacResponse.Builder builder = ApiModels.HmacResponse.newBuilder();
        builder.setKeyId(keyId);
        builder.setSignature(ByteString.copyFrom(signature));
        builder.setRequestId(requestId);
        Map<String, Object> response = Client.parseHmacResponse(builder.build().toByteArray());

        assertEquals(keyId, response.get("KeyId"));
        assertEquals(new String(signature), new String((byte[]) response.get("Signature")));
        assertEquals(requestId, response.get("RequestId"));
    }

    @org.junit.jupiter.api.Test
    void getSerializedSignRequest() throws Exception {
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("KeyId", "KeyId");
        reqBody.put("Algorithm", "Algorithm");
        reqBody.put("Message", "Message".getBytes(StandardCharsets.UTF_8));
        reqBody.put("MessageType", "MessageType");
        byte[] reqBodyBytes = Client.getSerializedSignRequest(reqBody);
        ApiModels.SignRequest request = ApiModels.SignRequest.parseFrom(reqBodyBytes);

        assertEquals("KeyId", request.getKeyId());
        assertEquals("Algorithm", request.getAlgorithm());
        assertEquals("Message", new String(request.getMessage().toByteArray()));
        assertEquals("MessageType", request.getMessageType());
    }

    @org.junit.jupiter.api.Test
    void parseSignResponse() throws Exception {
        String keyId = "KeyId";
        byte[] signature = "Signature".getBytes(StandardCharsets.UTF_8);
        String requestId = "RequestId";
        String algorithm = "Algorithm";
        String messageType = "MessageType";

        ApiModels.SignResponse.Builder builder = ApiModels.SignResponse.newBuilder();
        builder.setKeyId(keyId);
        builder.setSignature(ByteString.copyFrom(signature));
        builder.setAlgorithm(algorithm);
        builder.setMessageType(messageType);
        builder.setRequestId(requestId);
        Map<String, Object> response = Client.parseSignResponse(builder.build().toByteArray());

        assertEquals(keyId, response.get("KeyId"));
        assertEquals(new String(signature), new String((byte[]) response.get("Signature")));
        assertEquals(requestId, response.get("RequestId"));
        assertEquals(algorithm, response.get("Algorithm"));
        assertEquals(messageType, response.get("MessageType"));
    }

    @org.junit.jupiter.api.Test
    void getSerializedVerifyRequest() throws Exception {
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("KeyId", "KeyId");
        reqBody.put("Algorithm", "Algorithm");
        reqBody.put("Signature", "Signature".getBytes(StandardCharsets.UTF_8));
        reqBody.put("Message", "Message".getBytes(StandardCharsets.UTF_8));
        reqBody.put("MessageType", "MessageType");
        byte[] reqBodyBytes = Client.getSerializedVerifyRequest(reqBody);
        ApiModels.VerifyRequest request = ApiModels.VerifyRequest.parseFrom(reqBodyBytes);

        assertEquals("KeyId", request.getKeyId());
        assertEquals("Algorithm", request.getAlgorithm());
        assertEquals("Signature", new String(request.getSignature().toByteArray()));
        assertEquals("Message", new String(request.getMessage().toByteArray()));
        assertEquals("MessageType", request.getMessageType());
    }

    @org.junit.jupiter.api.Test
    void parseVerifyResponse() throws Exception {
        String keyId = "KeyId";
        String requestId = "RequestId";
        String algorithm = "Algorithm";
        String messageType = "MessageType";

        ApiModels.VerifyResponse.Builder builder = ApiModels.VerifyResponse.newBuilder();
        builder.setKeyId(keyId);
        builder.setRequestId(requestId);
        builder.setValue(true);
        builder.setAlgorithm(algorithm);
        builder.setMessageType(messageType);
        Map<String, Object> response = Client.parseVerifyResponse(builder.build().toByteArray());

        assertEquals(keyId, response.get("KeyId"));
        assertEquals(true, response.get("Value"));
        assertEquals(requestId, response.get("RequestId"));
        assertEquals(algorithm, response.get("Algorithm"));
        assertEquals(messageType, response.get("MessageType"));
    }

    @org.junit.jupiter.api.Test
    void getSerializedHashRequest() throws Exception {
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("Algorithm", "Algorithm");
        reqBody.put("Message", "Message".getBytes(StandardCharsets.UTF_8));
        byte[] reqBodyBytes = Client.getSerializedHashRequest(reqBody);
        ApiModels.HashRequest request = ApiModels.HashRequest.parseFrom(reqBodyBytes);

        assertEquals("Algorithm", request.getAlgorithm());
        assertEquals("Message", new String(request.getMessage().toByteArray()));
    }

    @org.junit.jupiter.api.Test
    void parseHashResponse() throws Exception {
        byte[] digest = "Digest".getBytes(StandardCharsets.UTF_8);
        String requestId = "RequestId";

        ApiModels.HashResponse.Builder builder = ApiModels.HashResponse.newBuilder();
        builder.setDigest(ByteString.copyFrom(digest));
        builder.setRequestId(requestId);
        Map<String, Object> response = Client.parseHashResponse(builder.build().toByteArray());

        assertEquals(new String(digest), new String((byte[]) response.get("Digest")));
        assertEquals(requestId, response.get("RequestId"));
    }

    @org.junit.jupiter.api.Test
    void getSerializedGenerateDataKeyRequest() throws Exception {
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("KeyId", "KeyId");
        reqBody.put("Algorithm", "Algorithm");
        reqBody.put("NumberOfBytes", 32);
        reqBody.put("Aad", "Aad".getBytes(StandardCharsets.UTF_8));
        byte[] reqBodyBytes = Client.getSerializedGenerateDataKeyRequest(reqBody);
        ApiModels.GenerateDataKeyRequest request = ApiModels.GenerateDataKeyRequest.parseFrom(reqBodyBytes);

        assertEquals("KeyId", request.getKeyId());
        assertEquals("Algorithm", request.getAlgorithm());
        assertEquals(32, request.getNumberOfBytes());
        assertEquals("Aad", new String(request.getAad().toByteArray()));
    }

    @org.junit.jupiter.api.Test
    void parseGenerateDataKeyResponse() throws Exception {
        String keyId = "KeyId";
        byte[] iv = "Iv".getBytes(StandardCharsets.UTF_8);
        byte[] plaintext = "Plaintext".getBytes(StandardCharsets.UTF_8);
        byte[] ciphertext = "CiphertextBlob".getBytes(StandardCharsets.UTF_8);
        String algorithm = "Algorithm";
        String requestId = "RequestId";

        ApiModels.GenerateDataKeyResponse.Builder builder = ApiModels.GenerateDataKeyResponse.newBuilder();
        builder.setKeyId(keyId);
        builder.setIv(ByteString.copyFrom(iv));
        builder.setPlaintext(ByteString.copyFrom(plaintext));
        builder.setCiphertextBlob(ByteString.copyFrom(ciphertext));
        builder.setAlgorithm(algorithm);
        builder.setRequestId(requestId);
        Map<String, Object> response = Client.parseGenerateDataKeyResponse(builder.build().toByteArray());

        assertEquals(keyId, response.get("KeyId"));
        assertEquals(new String(iv), new String((byte[]) response.get("Iv")));
        assertEquals(new String(plaintext), new String((byte[]) response.get("Plaintext")));
        assertEquals(new String(ciphertext), new String((byte[]) response.get("CiphertextBlob")));
        assertEquals(algorithm, response.get("Algorithm"));
        assertEquals(requestId, response.get("RequestId"));
    }
}