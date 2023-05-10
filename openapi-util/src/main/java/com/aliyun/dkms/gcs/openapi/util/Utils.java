package com.aliyun.dkms.gcs.openapi.util;

import com.aliyun.dkms.gcs.openapi.util.protobuf.ApiModels;
import com.aliyun.tea.TeaRequest;
import com.aliyun.tea.utils.StringUtils;
import com.google.protobuf.ByteString;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.*;

public class Utils {
    public final static String SEPARATOR = "&";
    public final static String URL_ENCODING = "UTF-8";
    public static final String HASH_SHA256 = "SHA-256";
    private static final String HEXES_ARRAY = "0123456789ABCDEF";
    private static final String BEGIN_CERT = "-----BEGIN CERTIFICATE-----";
    private static final String END_CERT = "-----END CERTIFICATE-----";
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

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

    public static String getCaCertFromFile(String caFilePath) throws Exception {
        File file = JsonUtils.getFileByPath(caFilePath);
        if (!file.exists()) {
            throw new RuntimeException(String.format("ca certificate file[%s] not found", caFilePath));
        }
        try (InputStream is = new FileInputStream(file)) {
            return readCaCertificate(is);
        }
    }

    public static String getCaCertFromContent(byte[] caContent) throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(caContent);
        return readCaCertificate(in);
    }

    public static String readCaCertificate(InputStream inStream) throws Exception {
        X509Certificate[] certificateChain = readCertificateChain(inStream);
        for (X509Certificate certificate : certificateChain) {
            if (!certificate.getIssuerDN().equals(certificate.getSubjectDN())) {
                return convertToPEM(certificate);
            }
        }
        throw new RuntimeException("not found second CA certificate, expect sub CA certificate or CA certificate chain");
    }

    public static X509Certificate[] readCertificateChain(InputStream inStream) throws Exception {
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        Collection<? extends Certificate> certList = certFactory.generateCertificates(inStream);
        X509Certificate[] certs = new X509Certificate[certList.size()];
        return certList.toArray(certs);
    }

    public static String convertToPEM(X509Certificate cert) throws CertificateEncodingException {
        return BEGIN_CERT + LINE_SEPARATOR +
                Base64.getMimeEncoder(64, LINE_SEPARATOR.getBytes(StandardCharsets.UTF_8)).encodeToString(cert.getEncoded()) +
                LINE_SEPARATOR + END_CERT;
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
        Object paddingMode = reqBody.get("PaddingMode");
        if (paddingMode != null) {
            builder.setPaddingMode((String) paddingMode);
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseEncryptResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.EncryptResponse response = ApiModels.EncryptResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("CiphertextBlob", response.getCiphertextBlob().toByteArray());
        result.put("Iv", response.getIv().toByteArray());
        result.put("Algorithm", response.getAlgorithm());
        result.put("PaddingMode", response.getPaddingMode());
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
        Object paddingMode = reqBody.get("PaddingMode");
        if (paddingMode != null) {
            builder.setPaddingMode((String) paddingMode);
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseDecryptResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.DecryptResponse response = ApiModels.DecryptResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("Plaintext", response.getPlaintext().toByteArray());
        result.put("Algorithm", response.getAlgorithm());
        result.put("PaddingMode", response.getPaddingMode());
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
        Object algorithm = reqBody.get("Algorithm");
        if (algorithm != null) {
            builder.setAlgorithm((String) algorithm);
        }
        Object message = reqBody.get("Message");
        if (message != null) {
            builder.setMessage(ByteString.copyFrom((byte[]) message));
        }
        Object messageType = reqBody.get("MessageType");
        if (messageType != null) {
            builder.setMessageType((String) messageType);
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseSignResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.SignResponse response = ApiModels.SignResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("Signature", response.getSignature().toByteArray());
        result.put("Algorithm", response.getAlgorithm());
        result.put("MessageType", response.getMessageType());
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
        Object signature = reqBody.get("Signature");
        if (signature != null) {
            builder.setSignature(ByteString.copyFrom((byte[]) signature));
        }
        Object message = reqBody.get("Message");
        if (message != null) {
            builder.setMessage(ByteString.copyFrom((byte[]) message));
        }
        Object messageType = reqBody.get("MessageType");
        if (messageType != null) {
            builder.setMessageType((String) messageType);
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseVerifyResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.VerifyResponse response = ApiModels.VerifyResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("Value", response.getValue());
        result.put("Algorithm", response.getAlgorithm());
        result.put("MessageType", response.getMessageType());
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

    public static byte[] getSerializedGenerateDataKeyRequest(java.util.Map<String, Object> reqBody) throws Exception {
        ApiModels.GenerateDataKeyRequest.Builder builder = ApiModels.GenerateDataKeyRequest.newBuilder();
        Object keyId = reqBody.get("KeyId");
        if (keyId != null) {
            builder.setKeyId((String) keyId);
        }
        Object algorithm = reqBody.get("Algorithm");
        if (algorithm != null) {
            builder.setAlgorithm((String) algorithm);
        }
        Object numberOfBytes = reqBody.get("NumberOfBytes");
        if (numberOfBytes != null) {
            builder.setNumberOfBytes((int) numberOfBytes);
        }
        Object aad = reqBody.get("Aad");
        if (aad != null) {
            builder.setAad(ByteString.copyFrom((byte[]) aad));
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseGenerateDataKeyResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.GenerateDataKeyResponse response = ApiModels.GenerateDataKeyResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("Iv", response.getIv().toByteArray());
        result.put("Plaintext", response.getPlaintext().toByteArray());
        result.put("CiphertextBlob", response.getCiphertextBlob().toByteArray());
        result.put("Algorithm", response.getAlgorithm());
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

    public static byte[] getSerializedGetPublicKeyRequest(java.util.Map<String, Object> reqBody) throws Exception {
        ApiModels.GetPublicKeyRequest.Builder builder = ApiModels.GetPublicKeyRequest.newBuilder();
        Object keyId = reqBody.get("KeyId");
        if (keyId != null) {
            builder.setKeyId((String) keyId);
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseGetPublicKeyResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.GetPublicKeyResponse response = ApiModels.GetPublicKeyResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("PublicKey", response.getPublicKey());
        result.put("RequestId", response.getRequestId());
        return result;
    }

    public static byte[] getSerializedGetSecretValueRequest(java.util.Map<String, Object> reqBody) throws Exception {
        ApiModels.GetSecretValueRequest.Builder builder = ApiModels.GetSecretValueRequest.newBuilder();
        Object secretName = reqBody.get("SecretName");
        if (secretName != null) {
            builder.setSecretName((String) secretName);
        }
        Object versionStage = reqBody.get("VersionStage");
        if (versionStage != null) {
            builder.setVersionStage((String) versionStage);
        }
        Object versionId = reqBody.get("VersionId");
        if (versionId != null) {
            builder.setVersionId((String) versionId);
        }
        Object fetchExtendedConfig = reqBody.get("FetchExtendedConfig");
        if (fetchExtendedConfig != null) {
            builder.setFetchExtendedConfig((boolean) fetchExtendedConfig);
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseGetSecretValueResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.GetSecretValueResponse response = ApiModels.GetSecretValueResponse.parseFrom(resBody);
        result.put("SecretName", response.getSecretName());
        result.put("SecretType", response.getSecretType());
        result.put("SecretData", response.getSecretData());
        result.put("SecretDataType", response.getSecretDataType());
        result.put("VersionStages", response.getVersionStagesList());
        result.put("VersionId", response.getVersionId());
        result.put("CreateTime", response.getCreateTime());
        result.put("LastRotationDate", response.getLastRotationDate());
        result.put("NextRotationDate", response.getNextRotationDate());
        result.put("ExtendedConfig", response.getExtendedConfig());
        result.put("AutomaticRotation", response.getAutomaticRotation());
        result.put("RotationInterval", response.getRotationInterval());
        result.put("RequestId", response.getRequestId());
        return result;
    }
    public static byte[] getSerializedAdvanceEncryptRequest(java.util.Map<String, Object> reqBody) throws Exception {
        ApiModels.AdvanceEncryptRequest.Builder builder = ApiModels.AdvanceEncryptRequest.newBuilder();
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
        Object aad = reqBody.get("Aad");
        if (aad != null) {
            builder.setAad(ByteString.copyFrom((byte[]) aad));
        }
        Object iv = reqBody.get("Iv");
        if (iv != null) {
            builder.setIv(ByteString.copyFrom((byte[]) iv));
        }
        Object paddingMode = reqBody.get("PaddingMode");
        if (paddingMode != null) {
            builder.setPaddingMode((String) paddingMode);
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseAdvanceEncryptResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.AdvanceEncryptResponse response = ApiModels.AdvanceEncryptResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("CiphertextBlob", response.getCiphertextBlob().toByteArray());
        result.put("Iv", response.getIv().toByteArray());
        result.put("RequestId", response.getRequestId());
        result.put("Algorithm", response.getAlgorithm());
        result.put("PaddingMode", response.getPaddingMode());
        result.put("KeyVersionId", response.getKeyVersionId());
        return result;
    }

    public static byte[] getSerializedAdvanceDecryptRequest(java.util.Map<String, Object> reqBody) throws Exception {
        ApiModels.AdvanceDecryptRequest.Builder builder = ApiModels.AdvanceDecryptRequest.newBuilder();
        Object ciphertextBlob = reqBody.get("CiphertextBlob");
        if (ciphertextBlob != null) {
            builder.setCiphertextBlob(ByteString.copyFrom((byte[]) ciphertextBlob));
        }
        Object keyId = reqBody.get("KeyId");
        if (keyId != null) {
            builder.setKeyId((String) keyId);
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
        Object paddingMode = reqBody.get("PaddingMode");
        if (paddingMode != null) {
            builder.setPaddingMode((String) paddingMode);
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseAdvanceDecryptResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.AdvanceDecryptResponse response = ApiModels.AdvanceDecryptResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("Plaintext", response.getPlaintext().toByteArray());
        result.put("RequestId", response.getRequestId());
        result.put("Algorithm", response.getAlgorithm());
        result.put("PaddingMode", response.getPaddingMode());
        result.put("KeyVersionId", response.getKeyVersionId());
        return result;
    }

    public static byte[] getSerializedAdvanceGenerateDataKeyRequest(java.util.Map<String, Object> reqBody) throws Exception {
        ApiModels.AdvanceGenerateDataKeyRequest.Builder builder = ApiModels.AdvanceGenerateDataKeyRequest.newBuilder();
        Object keyId = reqBody.get("KeyId");
        if (keyId != null) {
            builder.setKeyId((String) keyId);
        }
        Object numberOfBytes = reqBody.get("NumberOfBytes");
        if (numberOfBytes != null) {
            builder.setNumberOfBytes((Integer) numberOfBytes);
        }
        Object aad = reqBody.get("Aad");
        if (aad != null) {
            builder.setAad(ByteString.copyFrom((byte[]) aad));
        }
        return builder.build().toByteArray();
    }

    public static java.util.Map<String, Object> parseAdvanceGenerateDataKeyResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.AdvanceGenerateDataKeyResponse response = ApiModels.AdvanceGenerateDataKeyResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("Iv", response.getIv().toByteArray());
        result.put("Plaintext", response.getPlaintext().toByteArray());
        result.put("CiphertextBlob", response.getCiphertextBlob().toByteArray());
        result.put("RequestId", response.getRequestId());
        result.put("Algorithm", response.getAlgorithm());
        result.put("KeyVersionId", response.getKeyVersionId());
        return result;
    }
}
