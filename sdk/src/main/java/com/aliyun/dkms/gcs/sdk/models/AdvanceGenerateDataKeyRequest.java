// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class AdvanceGenerateDataKeyRequest extends TeaModel {
    /**
     * <p>密钥的全局唯一标识符该参数也可以被指定为密钥别名</p>
     */
    @NameInMap("KeyId")
    public String keyId;

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

    public static AdvanceGenerateDataKeyRequest build(java.util.Map<String, ?> map) throws Exception {
        AdvanceGenerateDataKeyRequest self = new AdvanceGenerateDataKeyRequest();
        return TeaModel.build(map, self);
    }

    public AdvanceGenerateDataKeyRequest setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public AdvanceGenerateDataKeyRequest setNumberOfBytes(Integer numberOfBytes) {
        this.numberOfBytes = numberOfBytes;
        return this;
    }
    public Integer getNumberOfBytes() {
        return this.numberOfBytes;
    }

    public AdvanceGenerateDataKeyRequest setAad(byte[] aad) {
        this.aad = aad;
        return this;
    }
    public byte[] getAad() {
        return this.aad;
    }

    public AdvanceGenerateDataKeyRequest setRequestHeaders(java.util.Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
        return this;
    }
    public java.util.Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

}
