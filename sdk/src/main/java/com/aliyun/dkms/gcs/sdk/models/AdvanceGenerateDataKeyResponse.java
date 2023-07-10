// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class AdvanceGenerateDataKeyResponse extends TeaModel {
    /**
     * <p>密钥的全局唯一标识符该参数也可以被指定为密钥别名</p>
     */
    @NameInMap("KeyId")
    public String keyId;

    /**
     * <p>加密数据时使用的初始向量</p>
     */
    @NameInMap("Iv")
    public byte[] iv;

    /**
     * <p>待加密的明文数据</p>
     */
    @NameInMap("Plaintext")
    public byte[] plaintext;

    /**
     * <p>数据被指定密钥加密后的密文</p>
     */
    @NameInMap("CiphertextBlob")
    public byte[] ciphertextBlob;

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
     * <p>密钥版本唯一标识符</p>
     */
    @NameInMap("KeyVersionId")
    public String keyVersionId;

    /**
     * <p>响应头</p>
     */
    @NameInMap("responseHeaders")
    public java.util.Map<String, String> responseHeaders;

    public static AdvanceGenerateDataKeyResponse build(java.util.Map<String, ?> map) throws Exception {
        AdvanceGenerateDataKeyResponse self = new AdvanceGenerateDataKeyResponse();
        return TeaModel.build(map, self);
    }

    public AdvanceGenerateDataKeyResponse setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public AdvanceGenerateDataKeyResponse setIv(byte[] iv) {
        this.iv = iv;
        return this;
    }
    public byte[] getIv() {
        return this.iv;
    }

    public AdvanceGenerateDataKeyResponse setPlaintext(byte[] plaintext) {
        this.plaintext = plaintext;
        return this;
    }
    public byte[] getPlaintext() {
        return this.plaintext;
    }

    public AdvanceGenerateDataKeyResponse setCiphertextBlob(byte[] ciphertextBlob) {
        this.ciphertextBlob = ciphertextBlob;
        return this;
    }
    public byte[] getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public AdvanceGenerateDataKeyResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

    public AdvanceGenerateDataKeyResponse setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

    public AdvanceGenerateDataKeyResponse setKeyVersionId(String keyVersionId) {
        this.keyVersionId = keyVersionId;
        return this;
    }
    public String getKeyVersionId() {
        return this.keyVersionId;
    }

    public AdvanceGenerateDataKeyResponse setResponseHeaders(java.util.Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
        return this;
    }
    public java.util.Map<String, String> getResponseHeaders() {
        return this.responseHeaders;
    }

}
