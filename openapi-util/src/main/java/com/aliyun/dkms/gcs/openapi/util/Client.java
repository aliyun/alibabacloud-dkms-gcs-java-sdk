// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.openapi.util;

import com.aliyun.dkms.gcs.openapi.util.protobuf.ApiModels;
import com.google.protobuf.ByteString;

import java.security.KeyStore;
import java.security.PrivateKey;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

import com.aliyun.tea.*;

public class Client {

    public final static String PROJECT_NAME = "kms-gcs-java-sdk-version";
    public final static String PROJECT_VERSKION = "0.5.1";

    public static java.util.Map<String, Object> getErrMessage(byte[] msg) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.Error response = ApiModels.Error.parseFrom(msg);
        result.put("Code", response.getErrorCode());
        result.put("Message", response.getErrorMessage());
        result.put("RequestId", response.getRequestId());
        return result;
    }

    public static String getContentLength(byte[] reqBody) throws Exception {
        return String.valueOf(reqBody.length);
    }

    public static String getPrivatePemFromPk12(byte[] privateKeyData, String password) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(new ByteArrayInputStream(privateKeyData), password.toCharArray());
        Enumeration<String> e = keyStore.aliases();
        String alias = e.nextElement();
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, password.toCharArray());
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }

    public static String getStringToSign(String method, String pathname, java.util.Map<String, String> headers, java.util.Map<String, String> query) throws Exception {
        String contentSHA256 = headers.get("content-sha256");
        if (com.aliyun.teautil.Common.isUnset(contentSHA256)) {
            contentSHA256 = "";
        }

        String contentType = headers.get("content-type");
        if (com.aliyun.teautil.Common.isUnset(contentType)) {
            contentType = "";
        }

        String date = headers.get("date");
        if (com.aliyun.teautil.Common.isUnset(date)) {
            date = "";
        }

        String header = "" + method + "\n" + contentSHA256 + "\n" + contentType + "\n" + date + "\n";
        String canonicalizedHeaders = Client.getCanonicalizedHeaders(headers);
        String canonicalizedResource = Client.getCanonicalizedResource(pathname, query);
        return "" + header + "" + canonicalizedHeaders + "" + canonicalizedResource + "";
    }

    public static String getCanonicalizedHeaders(java.util.Map<String, String> headers) throws Exception {
        if (com.aliyun.teautil.Common.isUnset(headers)) {
            return null;
        }

        String prefix = "x-kms-";
        java.util.List<String> keys = com.aliyun.darabonba.map.Client.keySet(headers);
        java.util.List<String> sortedKeys = com.aliyun.darabonba.array.Client.ascSort(keys);
        String canonicalizedHeaders = "";
        for (String key : sortedKeys) {
            if (com.aliyun.darabonbastring.Client.hasPrefix(key, prefix)) {
                canonicalizedHeaders = "" + canonicalizedHeaders + "" + key + ":" + com.aliyun.darabonbastring.Client.trim(headers.get(key)) + "\n";
            }

        }
        return canonicalizedHeaders;
    }

    public static String getCanonicalizedResource(String pathname, java.util.Map<String, String> query) throws Exception {
        if (!com.aliyun.teautil.Common.isUnset(pathname)) {
            return "/";
        }

        if (com.aliyun.teautil.Common.isUnset(query)) {
            return pathname;
        }

        String canonicalizedResource = "";
        java.util.List<String> queryArray = com.aliyun.darabonba.map.Client.keySet(query);
        java.util.List<String> sortedQueryArray = com.aliyun.darabonba.array.Client.ascSort(queryArray);
        String separator = "";
        canonicalizedResource = "" + pathname + "?";
        for (String key : sortedQueryArray) {
            canonicalizedResource = "" + canonicalizedResource + "" + separator + "" + key + "";
            if (!com.aliyun.teautil.Common.empty(query.get(key))) {
                canonicalizedResource = "" + canonicalizedResource + "=" + query.get(key) + "";
            }

            separator = "&";
        }
        return canonicalizedResource;
    }

    public static String getCaCertFromContent(byte[] reqBody) throws Exception {
        return resolveSubCa(com.aliyun.teautil.Common.toString(reqBody));
    }

    public static String getCaCertFromFile(String reqBody) throws Exception {
        String caCerts = Client.readFileContent(reqBody);
        return resolveSubCa(caCerts);
    }

    public static String resolveSubCa(String caCerts) throws Exception {
        if (com.aliyun.teautil.Common.isUnset(caCerts)) {
            throw new TeaException(TeaConverter.buildMap(
                    new TeaPair("code", "ParameterMissing"),
                    new TeaPair("message", "'CA' can not be empty")
            ));
        }

        Integer length = com.aliyun.darabonbanumber.Client.parseInt(Client.getContentLength(com.aliyun.darabonbastring.Client.toBytes(caCerts, "UTF-8")));
        Long endIndex = com.aliyun.darabonbanumber.Client.itol(com.aliyun.darabonbastring.Client.index(caCerts, "-----END CERTIFICATE-----"));
        Long suffixLength = com.aliyun.darabonbanumber.Client.itol(25);
        Integer subCaStart = com.aliyun.darabonbanumber.Client.ltoi(com.aliyun.darabonbanumber.Client.add(endIndex, suffixLength));
        String rootCa = com.aliyun.darabonbastring.Client.subString(caCerts, 0, subCaStart);
        String subCa = com.aliyun.darabonbastring.Client.subString(caCerts, subCaStart, length);
        if (com.aliyun.teautil.Common.empty(com.aliyun.darabonbastring.Client.trim(subCa))) {
            return rootCa;
        }

        return subCa;
    }

    public static String readFileContent(String filePath) throws Exception {
        File file = getFileByPath(filePath);
        if (file == null || !file.exists()) {
            try (InputStream in = Client.class.getClassLoader().getResourceAsStream(filePath);
            ) {
                return readContent(in);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try (FileInputStream inputStream = new FileInputStream(file)) {
                return readContent(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static File getFileByPath(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            URL resource = Client.class.getClassLoader().getResource("");
            String path = "";
            if (resource != null) {
                path = resource.getPath();
            }
            if (!(file = new File(path + filePath)).exists()) {
                path = Paths.get(filePath).toAbsolutePath().toString();
                if (!(file = new File(path)).exists()) {
                    return null;
                }
            }
        }
        return file;
    }

    private static String readContent(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        StringBuffer content = new StringBuffer();
        byte[] input = new byte[inputStream.available()];
        while ((inputStream.read(input)) != -1) {
            content.append(new String(input, 0, input.length));
        }
        return content.toString();
    }

    public static Boolean defaultBoolean(Boolean bool1, Boolean bool2) throws Exception {
        if (com.aliyun.teautil.Common.isUnset(bool1)) {
            return bool2;
        } else {
            return bool1;
        }

    }

    public static Boolean isRetryErr(Exception err) throws Exception {
        if (err instanceof TeaException) {
            String code = ((TeaException) err).getCode();
            String message = ((TeaException) err).getMessage();
            if ("Rejected.Throttling".equals(code) || message.contains("The Param Content-SHA256 is invalid.")) {
                return true;
            }
        }
        return false;
    }

    public static String getUserAgent(String userAgent) {
        Properties sysProps = System.getProperties();
        String projectUserAgent = "";
        if (userAgent != null) {
            projectUserAgent = userAgent;
        }
        return String.format("AlibabaCloud (%s; %s) Java/%s %s %s/%s", sysProps.getProperty("os.name"), sysProps
                .getProperty("os.arch"), sysProps.getProperty("java.runtime.version"), projectUserAgent, PROJECT_NAME, PROJECT_VERSKION);
    }

    public static java.util.Map<String, Object> parseEncryptResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.EncryptResponse response = ApiModels.EncryptResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("CiphertextBlob", response.getCiphertextBlob().toByteArray());
        result.put("Iv", response.getIv().toByteArray());
        result.put("RequestId", response.getRequestId());
        result.put("Algorithm", response.getAlgorithm());
        result.put("PaddingMode", response.getPaddingMode());
        return result;
    }

    public static byte[] getSerializedDecryptRequest(java.util.Map<String, Object> reqBody) throws Exception {
        ApiModels.DecryptRequest.Builder builder = ApiModels.DecryptRequest.newBuilder();
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

    public static java.util.Map<String, Object> parseDecryptResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.DecryptResponse response = ApiModels.DecryptResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("Plaintext", response.getPlaintext().toByteArray());
        result.put("RequestId", response.getRequestId());
        result.put("Algorithm", response.getAlgorithm());
        result.put("PaddingMode", response.getPaddingMode());
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
        result.put("RequestId", response.getRequestId());
        result.put("Algorithm", response.getAlgorithm());
        result.put("MessageType", response.getMessageType());
        return result;
    }

    public static byte[] getSerializedVerifyRequest(java.util.Map<String, Object> reqBody) throws Exception {
        ApiModels.VerifyRequest.Builder builder = ApiModels.VerifyRequest.newBuilder();
        Object keyId = reqBody.get("KeyId");
        if (keyId != null) {
            builder.setKeyId((String) keyId);
        }
        Object digest = reqBody.get("Digest");
        if (digest != null) {
            builder.setDigest(ByteString.copyFrom((byte[]) digest));
        }
        Object signature = reqBody.get("Signature");
        if (signature != null) {
            builder.setSignature(ByteString.copyFrom((byte[]) signature));
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

    public static java.util.Map<String, Object> parseVerifyResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.VerifyResponse response = ApiModels.VerifyResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("Value", response.getValue());
        result.put("RequestId", response.getRequestId());
        result.put("Algorithm", response.getAlgorithm());
        result.put("MessageType", response.getMessageType());
        return result;
    }

    public static byte[] getSerializedGenerateRandomRequest(java.util.Map<String, Object> reqBody) throws Exception {
        ApiModels.GenerateRandomRequest.Builder builder = ApiModels.GenerateRandomRequest.newBuilder();
        Object length = reqBody.get("Length");
        if (length != null) {
            builder.setLength((Integer) length);
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
            builder.setNumberOfBytes((Integer) numberOfBytes);
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
        result.put("RequestId", response.getRequestId());
        result.put("Algorithm", response.getAlgorithm());
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

    public static Map<String, Object> parseGetSecretValueResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.GetSecretValueResponse response = ApiModels.GetSecretValueResponse.parseFrom(resBody);
        result.put("SecretName", response.getSecretName());
        result.put("SecretType", response.getSecretType());
        result.put("SecretData", response.getSecretData());
        result.put("SecretDataType", response.getSecretDataType());
        result.put("VersionStages", response.getVersionStagesList());
        result.put("VersionId", response.getVersionId());
        result.put("CreateTime", response.getCreateTime());
        result.put("RequestId", response.getRequestId());
        result.put("LastRotationDate", response.getLastRotationDate());
        result.put("NextRotationDate", response.getNextRotationDate());
        result.put("ExtendedConfig", response.getExtendedConfig());
        result.put("AutomaticRotation", response.getAutomaticRotation());
        result.put("RotationInterval", response.getRotationInterval());
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

    public static byte[] getSerializedGenerateDataKeyPairRequest(Map<String, Object> reqBody) throws Exception {
        ApiModels.GenerateDataKeyPairRequest.Builder builder = ApiModels.GenerateDataKeyPairRequest.newBuilder();
        Object keyId = reqBody.get("KeyId");
        if (keyId != null) {
            builder.setKeyId((String) keyId);
        }
        Object algorithm = reqBody.get("Algorithm");
        if (algorithm != null) {
            builder.setAlgorithm((String) algorithm);
        }
        Object keyPairSpec = reqBody.get("KeyPairSpec");
        if (keyPairSpec != null) {
            builder.setKeyPairSpec((String) keyPairSpec);
        }
        Object keyFormat = reqBody.get("KeyFormat");
        if (keyFormat != null) {
            builder.setKeyFormat((String) keyFormat);
        }
        Object aad = reqBody.get("Aad");
        if (aad != null) {
            builder.setAad(ByteString.copyFrom((byte[]) aad));
        }
        return builder.build().toByteArray();
    }

    public static Map<String, Object> parseGenerateDataKeyPairResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.GenerateDataKeyPairResponse response = ApiModels.GenerateDataKeyPairResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("Iv", response.getIv().toByteArray());
        result.put("KeyPairSpec", response.getKeyPairSpec());
        result.put("PrivateKeyPlaintext", response.getPrivateKeyPlaintext().toByteArray());
        result.put("PrivateKeyCiphertextBlob", response.getPrivateKeyCiphertextBlob().toByteArray());
        result.put("PublicKey", response.getPublicKey().toByteArray());
        result.put("RequestId", response.getRequestId());
        result.put("Algorithm", response.getAlgorithm());
        return result;
    }

    public static byte[] getSerializedGenerateDataKeyPairWithoutPlaintextRequest(Map<String, Object> reqBody) throws Exception {
        ApiModels.GenerateDataKeyPairWithoutPlaintextRequest.Builder builder = ApiModels.GenerateDataKeyPairWithoutPlaintextRequest.newBuilder();
        Object keyId = reqBody.get("KeyId");
        if (keyId != null) {
            builder.setKeyId((String) keyId);
        }
        Object algorithm = reqBody.get("Algorithm");
        if (algorithm != null) {
            builder.setAlgorithm((String) algorithm);
        }
        Object keyPairSpec = reqBody.get("KeyPairSpec");
        if (keyPairSpec != null) {
            builder.setKeyPairSpec((String) keyPairSpec);
        }
        Object keyFormat = reqBody.get("KeyFormat");
        if (keyFormat != null) {
            builder.setKeyFormat((String) keyFormat);
        }
        Object aad = reqBody.get("Aad");
        if (aad != null) {
            builder.setAad(ByteString.copyFrom((byte[]) aad));
        }
        return builder.build().toByteArray();
    }

    public static Map<String, Object> parseGenerateDataKeyPairWithoutPlaintextResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.GenerateDataKeyPairWithoutPlaintextResponse response = ApiModels.GenerateDataKeyPairWithoutPlaintextResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("Iv", response.getIv().toByteArray());
        result.put("KeyPairSpec", response.getKeyPairSpec());
        result.put("PrivateKeyCiphertextBlob", response.getPrivateKeyCiphertextBlob().toByteArray());
        result.put("PublicKey", response.getPublicKey().toByteArray());
        result.put("RequestId", response.getRequestId());
        result.put("Algorithm", response.getAlgorithm());
        return result;
    }

    public static byte[] getSerializedAdvanceGenerateDataKeyPairRequest(Map<String, Object> reqBody) throws Exception {
        ApiModels.AdvanceGenerateDataKeyPairRequest.Builder builder = ApiModels.AdvanceGenerateDataKeyPairRequest.newBuilder();
        Object keyId = reqBody.get("KeyId");
        if (keyId != null) {
            builder.setKeyId((String) keyId);
        }
        Object keyPairSpec = reqBody.get("KeyPairSpec");
        if (keyPairSpec != null) {
            builder.setKeyPairSpec((String) keyPairSpec);
        }
        Object keyFormat = reqBody.get("KeyFormat");
        if (keyFormat != null) {
            builder.setKeyFormat((String) keyFormat);
        }
        Object aad = reqBody.get("Aad");
        if (aad != null) {
            builder.setAad(ByteString.copyFrom((byte[]) aad));
        }
        return builder.build().toByteArray();
    }

    public static Map<String, Object> parseAdvanceGenerateDataKeyPairResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.AdvanceGenerateDataKeyPairResponse response = ApiModels.AdvanceGenerateDataKeyPairResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("Iv", response.getIv().toByteArray());
        result.put("KeyPairSpec", response.getKeyPairSpec());
        result.put("PrivateKeyPlaintext", response.getPrivateKeyPlaintext().toByteArray());
        result.put("PrivateKeyCiphertextBlob", response.getPrivateKeyCiphertextBlob().toByteArray());
        result.put("PublicKey", response.getPublicKey().toByteArray());
        result.put("RequestId", response.getRequestId());
        result.put("Algorithm", response.getAlgorithm());
        result.put("KeyVersionId", response.getKeyVersionId());
        return result;
    }

    public static byte[] getSerializedAdvanceGenerateDataKeyPairWithoutPlaintextRequest(Map<String, Object> reqBody) throws Exception {
        ApiModels.AdvanceGenerateDataKeyPairWithoutPlaintextRequest.Builder builder = ApiModels.AdvanceGenerateDataKeyPairWithoutPlaintextRequest.newBuilder();
        Object keyId = reqBody.get("KeyId");
        if (keyId != null) {
            builder.setKeyId((String) keyId);
        }
        Object keyPairSpec = reqBody.get("KeyPairSpec");
        if (keyPairSpec != null) {
            builder.setKeyPairSpec((String) keyPairSpec);
        }
        Object keyFormat = reqBody.get("KeyFormat");
        if (keyFormat != null) {
            builder.setKeyFormat((String) keyFormat);
        }
        Object aad = reqBody.get("Aad");
        if (aad != null) {
            builder.setAad(ByteString.copyFrom((byte[]) aad));
        }
        return builder.build().toByteArray();
    }

    public static Map<String, Object> parseAdvanceGenerateDataKeyPairWithoutPlaintextResponse(byte[] resBody) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ApiModels.AdvanceGenerateDataKeyPairWithoutPlaintextResponse response = ApiModels.AdvanceGenerateDataKeyPairWithoutPlaintextResponse.parseFrom(resBody);
        result.put("KeyId", response.getKeyId());
        result.put("Iv", response.getIv().toByteArray());
        result.put("KeyPairSpec", response.getKeyPairSpec());
        result.put("PrivateKeyCiphertextBlob", response.getPrivateKeyCiphertextBlob().toByteArray());
        result.put("PublicKey", response.getPublicKey().toByteArray());
        result.put("RequestId", response.getRequestId());
        result.put("Algorithm", response.getAlgorithm());
        result.put("KeyVersionId", response.getKeyVersionId());
        return result;
    }
}
