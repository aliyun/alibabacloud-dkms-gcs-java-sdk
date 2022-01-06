// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.openapi.util;

import com.aliyun.tea.*;
import com.aliyun.dkms.gcs.openapi.util.models.*;
import com.aliyun.teautil.*;

public class Client {

    public static String getHost(String regionId, String endpoint) throws Exception {
        return Utils.getHost(regionId, endpoint);
    }

    public static java.util.Map<String, Object> getErrMessage(byte[] msg) throws Exception {
        return Utils.getErrMessage(msg);
    }

    public static String getStringToSign(TeaRequest request) throws Exception {
        return Utils.getStringToSign(request);
    }

    public static String getContentLength(byte[] reqBody) throws Exception {
        return Utils.getContentLength(reqBody);
    }

    public static String getContentSHA256(byte[] reqBody) throws Exception {
        return Utils.getContentSHA256(reqBody);
    }

    public static String toHexString(byte[] byteArray) throws Exception {
        return Utils.toHexString(byteArray);
    }

    public static byte[] getSerializedEncryptRequest(java.util.Map<String, Object> reqBody) throws Exception {
        return Utils.getSerializedEncryptRequest(reqBody);
    }

    public static java.util.Map<String, Object> parseEncryptResponse(byte[] resBody) throws Exception {
        return Utils.parseEncryptResponse(resBody);
    }

    public static byte[] getSerializedDecryptRequest(java.util.Map<String, Object> reqBody) throws Exception {
        return Utils.getSerializedDecryptRequest(reqBody);
    }

    public static java.util.Map<String, Object> parseDecryptResponse(byte[] resBody) throws Exception {
        return Utils.parseDecryptResponse(resBody);
    }

    public static byte[] getSerializedHmacRequest(java.util.Map<String, Object> reqBody) throws Exception {
        return Utils.getSerializedHmacRequest(reqBody);
    }

    public static java.util.Map<String, Object> parseHmacResponse(byte[] resBody) throws Exception {
        return Utils.parseHmacResponse(resBody);
    }

    public static byte[] getSerializedSignRequest(java.util.Map<String, Object> reqBody) throws Exception {
        return Utils.getSerializedSignRequest(reqBody);
    }

    public static java.util.Map<String, Object> parseSignResponse(byte[] resBody) throws Exception {
        return Utils.parseSignResponse(resBody);
    }

    public static byte[] getSerializedVerifyRequest(java.util.Map<String, Object> reqBody) throws Exception {
        return Utils.getSerializedVerifyRequest(reqBody);
    }

    public static java.util.Map<String, Object> parseVerifyResponse(byte[] resBody) throws Exception {
        return Utils.parseVerifyResponse(resBody);
    }

    public static byte[] getSerializedGenerateRandomRequest(java.util.Map<String, Object> reqBody) throws Exception {
        return Utils.getSerializedGenerateRandomRequest(reqBody);
    }

    public static java.util.Map<String, Object> parseGenerateRandomResponse(byte[] resBody) throws Exception {
        return Utils.parseGenerateRandomResponse(resBody);
    }

    public static byte[] getSerializedGenerateDataKeyRequest(java.util.Map<String, Object> reqBody) throws Exception {
        return Utils.getSerializedGenerateDataKeyRequest(reqBody);
    }

    public static java.util.Map<String, Object> parseGenerateDataKeyResponse(byte[] resBody) throws Exception {
        return Utils.parseGenerateDataKeyResponse(resBody);
    }

    public static byte[] getSerializedHashRequest(java.util.Map<String, Object> reqBody) throws Exception {
        return Utils.getSerializedHashRequest(reqBody);
    }

    public static java.util.Map<String, Object> parseHashResponse(byte[] resBody) throws Exception {
        return Utils.parseHashResponse(resBody);
    }

    public static byte[] getSerializedKmsEncryptRequest(java.util.Map<String, Object> reqBody) throws Exception {
        return Utils.getSerializedKmsEncryptRequest(reqBody);
    }

    public static java.util.Map<String, Object> parseKmsEncryptResponse(byte[] resBody) throws Exception {
        return Utils.parseKmsEncryptResponse(resBody);
    }

    public static byte[] getSerializedKmsDecryptRequest(java.util.Map<String, Object> reqBody) throws Exception {
        return Utils.getSerializedKmsDecryptRequest(reqBody);
    }

    public static java.util.Map<String, Object> parseKmsDecryptResponse(byte[] resBody) throws Exception {
        return Utils.parseKmsDecryptResponse(resBody);
    }

    public static byte[] getSerializedGetPublicKeyRequest(java.util.Map<String, Object> reqBody) throws Exception {
        return Utils.getSerializedGetPublicKeyRequest(reqBody);
    }

    public static java.util.Map<String, Object> parseGetPublicKeyResponse(byte[] resBody) throws Exception {
        return Utils.parseGetPublicKeyResponse(resBody);
    }
}
