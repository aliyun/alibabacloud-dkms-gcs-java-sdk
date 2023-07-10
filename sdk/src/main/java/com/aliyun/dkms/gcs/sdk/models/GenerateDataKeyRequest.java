// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class GenerateDataKeyRequest extends TeaModel {
    /**
     * <p>密钥的全局唯一标识符该参数也可以被指定为密钥别名</p>
     */
    @NameInMap("KeyId")
    public String keyId;

    /**
     * <p>加密算法</p>
     */
    @NameInMap("Algorithm")
    public String algorithm;

    /**
     * <p>生成的数据密钥的长度</p>
     */
    @NameInMap("NumberOfBytes")
    public Integer numberOfBytes;

    /**
     * <p>对数据密钥加密时使用的GCM加密模式认证数据</p>
     */
    @NameInMap("Aad")
    public byte[] aad;

    /**
     * <p>请求头</p>
     */
    @NameInMap("requestHeaders")
    public java.util.Map<String, String> requestHeaders;

    public static GenerateDataKeyRequest build(java.util.Map<String, ?> map) throws Exception {
        GenerateDataKeyRequest self = new GenerateDataKeyRequest();
        return TeaModel.build(map, self);
    }

    public GenerateDataKeyRequest setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public GenerateDataKeyRequest setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

    public GenerateDataKeyRequest setNumberOfBytes(Integer numberOfBytes) {
        this.numberOfBytes = numberOfBytes;
        return this;
    }
    public Integer getNumberOfBytes() {
        return this.numberOfBytes;
    }

    public GenerateDataKeyRequest setAad(byte[] aad) {
        this.aad = aad;
        return this;
    }
    public byte[] getAad() {
        return this.aad;
    }

    public GenerateDataKeyRequest setRequestHeaders(java.util.Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
        return this;
    }
    public java.util.Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

}
