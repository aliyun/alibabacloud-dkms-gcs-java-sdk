// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class EncryptResponse extends TeaModel {
    /**
     * <p>密钥的全局唯一标识符该参数也可以被指定为密钥别名</p>
     */
    @NameInMap("KeyId")
    public String keyId;

    /**
     * <p>数据被指定密钥加密后的密文</p>
     */
    @NameInMap("CiphertextBlob")
    public byte[] ciphertextBlob;

    /**
     * <p>加密数据时使用的初始向量</p>
     */
    @NameInMap("Iv")
    public byte[] iv;

    /**
     * <p>请求ID</p>
     */
    @NameInMap("RequestId")
    public String requestId;

    /**
     * <p>加密算法</p>
     */
    @NameInMap("Algorithm")
    public String algorithm;

    /**
     * <p>填充模式</p>
     */
    @NameInMap("PaddingMode")
    public String paddingMode;

    /**
     * <p>响应头</p>
     */
    @NameInMap("responseHeaders")
    public java.util.Map<String, String> responseHeaders;

    public static EncryptResponse build(java.util.Map<String, ?> map) throws Exception {
        EncryptResponse self = new EncryptResponse();
        return TeaModel.build(map, self);
    }

    public EncryptResponse setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public EncryptResponse setCiphertextBlob(byte[] ciphertextBlob) {
        this.ciphertextBlob = ciphertextBlob;
        return this;
    }
    public byte[] getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public EncryptResponse setIv(byte[] iv) {
        this.iv = iv;
        return this;
    }
    public byte[] getIv() {
        return this.iv;
    }

    public EncryptResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

    public EncryptResponse setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

    public EncryptResponse setPaddingMode(String paddingMode) {
        this.paddingMode = paddingMode;
        return this;
    }
    public String getPaddingMode() {
        return this.paddingMode;
    }

    public EncryptResponse setResponseHeaders(java.util.Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
        return this;
    }
    public java.util.Map<String, String> getResponseHeaders() {
        return this.responseHeaders;
    }

}
