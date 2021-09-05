package com.aliyun.dkms.gcs.openapi.util;

import com.aliyun.dkms.gcs.openapi.util.protobuf.ApiModels;
import com.aliyun.tea.TeaRequest;
import com.aliyun.tea.utils.StringUtils;
import com.google.protobuf.ByteString;

import java.security.MessageDigest;
import java.util.*;

public class Utils {
    public final static String SEPARATOR = "&";
    public final static String URL_ENCODING = "UTF-8";
    public static final String HASH_SHA256 = "SHA-256";
    private static final String HEXES_ARRAY = "0123456789ABCDEF";

    public static String getHost(String regionId, String endpoint) {
        if (!StringUtils.isEmpty(endpoint)) {
            return endpoint;
        }
        if (StringUtils.isEmpty(regionId)) {
            regionId = "cn-hangzhou";
        }
        return "kms-instance." + regionId + ".aliyuncs.com";
    }

    public static java.util.Map<String, Object> getErrMessage(byte[] msg) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.Error response = ApiModels.Error.parseFrom(msg);
        result.put("Code", response.getErrorCode());
        result.put("Message", response.getErrorMessage());
        result.put("RequestId", response.getRequestId());
        return result;
    }

    public static String getStringToSign(TeaRequest request) throws Exception {
        if (request == null) {
            return "";
        }
        String method = request.method;
        String pathname = request.pathname;
        Map<String, String> headers = request.headers;
        Map<String, String> query = request.query;
        String contentSHA256 = headers.get("content-sha256") == null ? "" : headers.get("content-sha256");
        String contentType = headers.get("content-type") == null ? "" : headers.get("content-type");
        String date = headers.get("date") == null ? "" : headers.get("date");
        String header = method + "\n" + contentSHA256 + "\n" + contentType + "\n" + date + "\n";
        String canonicalizedHeaders = getCanonicalizedHeaders(headers);
        String canonicalizedResource = getCanonicalizedResource(pathname, query);
        return header + canonicalizedHeaders + canonicalizedResource;
    }

    protected static String getCanonicalizedHeaders(Map<String, String> headers) {
        if (headers == null) {
            return "";
        }
        String prefix = "x-kms-";
        Set<String> keys = headers.keySet();
        List<String> canonicalizedKeys = new ArrayList<>();
        for (String key : keys) {
            if (key.startsWith(prefix)) {
                canonicalizedKeys.add(key);
            }
        }
        String[] canonicalizedKeysArray = canonicalizedKeys.toArray(new String[canonicalizedKeys.size()]);
        Arrays.sort(canonicalizedKeysArray);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < canonicalizedKeysArray.length; i++) {
            String key = canonicalizedKeysArray[i];
            result.append(key);
            result.append(":");
            result.append(headers.get(key).trim());
            result.append("\n");
        }
        return result.toString();
    }

    protected static String getCanonicalizedResource(String pathname, Map<String, String> query) throws Exception {
        if (pathname == null) {
            return "/";
        }
        if (query == null || query.size() == 0) {
            return pathname;
        }
        String[] keys = query.keySet().toArray(new String[query.size()]);
        StringBuilder result = new StringBuilder(pathname);
        result.append("?");
        return getCanonicalizedQueryString(result, query, keys);
    }

    protected static String getCanonicalizedQueryString(StringBuilder sb, Map<String, String> query, String[] keys) throws Exception {
        if (query == null || query.size() == 0) {
            return "";
        }
        if (keys == null || keys.length == 0) {
            return "";
        }
        if (sb == null) {
            sb = new StringBuilder();
        }
        Arrays.sort(keys);
        String key;
        String value;
        for (int i = 0; i < keys.length; i++) {
            key = keys[i];
            sb.append(key);
            value = query.get(key);
            if (!StringUtils.isEmpty(value)) {
                sb.append("=");
                sb.append(value);
            }
            sb.append(SEPARATOR);
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static String getContentLength(byte[] reqBody) {
        return String.valueOf(reqBody.length);
    }

    public static String getContentSHA256(byte[] reqBody) throws Exception {
        MessageDigest digest = MessageDigest.getInstance(HASH_SHA256);
        byte[] messageDigest = digest.digest(reqBody);
        return toHexString(messageDigest);
    }

    public static String toHexString(byte[] byteArray) {
        final StringBuilder hex = new StringBuilder(2 * byteArray.length);
        for (final byte b : byteArray) {
            hex.append(HEXES_ARRAY.charAt((b & 0xF0) >> 4)).append(HEXES_ARRAY.charAt((b & 0x0F)));
        }
        return hex.toString();
    }

    public static byte[] getSerializedEncryptRequest(java.util.Map<String, Object> reqBody) throws Exception {
        ApiModels.EncryptRequest.Builder builder = ApiModels.EncryptRequest.newBuilder();
        Object keyId = reqBody.get("KeyId");
        if (keyId != null) {
            builder.setKeyId((String) keyId);
        }
        Object plaintext = reqBody.get("Plaintext");
        if (plaintext != null) {
            builder.setPlaintext(ByteString.copyFrom((byte[]) plaintext));
        }
        Object algorithm = reqBody.get("Algorithm");
        if (algorithm != null) {
            builder.setAlgorithm((String) algorithm);
        }
        Object iv = reqBody.get("Iv");
        if (iv != null) {
            builder.setIv(ByteString.copyFrom((byte[]) iv));
        }
        Object aad = reqBody.get("Aad");
        if (aad != null) {
            builder.setAad(ByteString.copyFrom((byte[]) aad));
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseEncryptResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.EncryptResponse response = ApiModels.EncryptResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("CiphertextBlob", response.getCiphertextBlob().toByteArray());
        result.put("Iv", response.getIv().toByteArray());
        result.put("RequestId", response.getRequestId());
        return result;
    }

    public static byte[] getSerializedDecryptRequest(java.util.Map<String, Object> reqBody) throws Exception {
        ApiModels.DecryptRequest.Builder builder = ApiModels.DecryptRequest.newBuilder();
        Object keyId = reqBody.get("KeyId");
        if (keyId != null) {
            builder.setKeyId((String) keyId);
        }
        Object ciphertextBlob = reqBody.get("CiphertextBlob");
        if (ciphertextBlob != null) {
            builder.setCiphertextBlob(ByteString.copyFrom((byte[]) ciphertextBlob));
        }
        Object algorithm = reqBody.get("Algorithm");
        if (algorithm != null) {
            builder.setAlgorithm((String) algorithm);
        }
        Object aad = reqBody.get("Aad");
        if (aad != null) {
            builder.setAad(ByteString.copyFrom((byte[]) aad));
        }
        Object iv = reqBody.get("Iv");
        if (iv != null) {
            builder.setIv(ByteString.copyFrom((byte[]) iv));
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseDecryptResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.DecryptResponse response = ApiModels.DecryptResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("Plaintext", response.getPlaintext().toByteArray());
        result.put("RequestId", response.getRequestId());
        return result;
    }

    public static byte[] getSerializedHmacRequest(java.util.Map<String, Object> reqBody) throws Exception {
        ApiModels.HmacRequest.Builder builder = ApiModels.HmacRequest.newBuilder();
        Object keyId = reqBody.get("KeyId");
        if (keyId != null) {
            builder.setKeyId((String) keyId);
        }
        Object message = reqBody.get("Message");
        if (message != null) {
            builder.setMessage(ByteString.copyFrom((byte[]) message));
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseHmacResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.HmacResponse response = ApiModels.HmacResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("Signature", response.getSignature().toByteArray());
        result.put("RequestId", response.getRequestId());
        return result;
    }

    public static byte[] getSerializedSignRequest(java.util.Map<String, Object> reqBody) throws Exception {
        ApiModels.SignRequest.Builder builder = ApiModels.SignRequest.newBuilder();
        Object keyId = reqBody.get("KeyId");
        if (keyId != null) {
            builder.setKeyId((String) keyId);
        }
        Object digest = reqBody.get("Digest");
        if (digest != null) {
            builder.setDigest(ByteString.copyFrom((byte[]) digest));
        }
        Object algorithm = reqBody.get("Algorithm");
        if (algorithm != null) {
            builder.setAlgorithm((String) algorithm);
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseSignResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.SignResponse response = ApiModels.SignResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("Signature", response.getSignature().toByteArray());
        result.put("RequestId", response.getRequestId());
        return result;
    }

    public static byte[] getSerializedVerifyRequest(java.util.Map<String, Object> reqBody) throws Exception {
        ApiModels.VerifyRequest.Builder builder = ApiModels.VerifyRequest.newBuilder();
        Object keyId = reqBody.get("KeyId");
        if (keyId != null) {
            builder.setKeyId((String) keyId);
        }
        Object algorithm = reqBody.get("Algorithm");
        if (algorithm != null) {
            builder.setAlgorithm((String) algorithm);
        }
        Object digest = reqBody.get("Digest");
        if (digest != null) {
            builder.setDigest(ByteString.copyFrom((byte[]) digest));
        }
        Object signature = reqBody.get("Signature");
        if (signature != null) {
            builder.setSignature(ByteString.copyFrom((byte[]) signature));
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseVerifyResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.VerifyResponse response = ApiModels.VerifyResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("Value", response.getValue());
        result.put("RequestId", response.getRequestId());
        return result;
    }

    public static byte[] getSerializedGenerateRandomRequest(java.util.Map<String, Object> reqBody) throws Exception {
        ApiModels.GenerateRandomRequest.Builder builder = ApiModels.GenerateRandomRequest.newBuilder();
        Object length = reqBody.get("Length");
        if (length != null) {
            builder.setLength((int) length);
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseGenerateRandomResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.GenerateRandomResponse response = ApiModels.GenerateRandomResponse.parseFrom(resBody);
        result.put("Random", response.getRandom().toByteArray());
        result.put("RequestId", response.getRequestId());
        return result;
    }

    public static byte[] getSerializedHashRequest(java.util.Map<String, Object> reqBody) throws Exception {
        ApiModels.HashRequest.Builder builder = ApiModels.HashRequest.newBuilder();
        Object algorithm = reqBody.get("Algorithm");
        if (algorithm != null) {
            builder.setAlgorithm((String) algorithm);
        }
        Object message = reqBody.get("Message");
        if (message != null) {
            builder.setMessage(ByteString.copyFrom((byte[]) message));
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseHashResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.HashResponse response = ApiModels.HashResponse.parseFrom(resBody);
        result.put("Digest", response.getDigest().toByteArray());
        result.put("RequestId", response.getRequestId());
        return result;
    }

    public static byte[] getSerializedKmsEncryptRequest(java.util.Map<String, Object> reqBody) throws Exception {
        ApiModels.KmsEncryptRequest.Builder builder = ApiModels.KmsEncryptRequest.newBuilder();
        Object plaintext = reqBody.get("Plaintext");
        if (plaintext != null) {
            builder.setPlaintext(ByteString.copyFrom((byte[]) plaintext));
        }
        Object keyId = reqBody.get("KeyId");
        if (keyId != null) {
            builder.setKeyId((String) keyId);
        }
        Object aad = reqBody.get("Aad");
        if (aad != null) {
            builder.setAad(ByteString.copyFrom((byte[]) aad));
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseKmsEncryptResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.KmsEncryptResponse response = ApiModels.KmsEncryptResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("CiphertextBlob", response.getCiphertextBlob().toByteArray());
        result.put("RequestId", response.getRequestId());
        return result;
    }

    public static byte[] getSerializedKmsDecryptRequest(java.util.Map<String, Object> reqBody) throws Exception {
        ApiModels.KmsDecryptRequest.Builder builder = ApiModels.KmsDecryptRequest.newBuilder();
        Object ciphertextBlob = reqBody.get("CiphertextBlob");
        if (ciphertextBlob != null) {
            builder.setCiphertextBlob(ByteString.copyFrom((byte[]) ciphertextBlob));
        }
        Object aad = reqBody.get("Aad");
        if (aad != null) {
            builder.setAad(ByteString.copyFrom((byte[]) aad));
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseKmsDecryptResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.KmsDecryptResponse response = ApiModels.KmsDecryptResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("Plaintext", response.getPlaintext().toByteArray());
        result.put("RequestId", response.getRequestId());
        return result;
    }
}
