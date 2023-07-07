// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class AdvanceDecryptResponse extends TeaModel {
    /**
     * <p>密钥的全局唯一标识符该参数也可以被指定为密钥别名</p>
     */
    @NameInMap("KeyId")
    public String keyId;

    /**
     * <p>待加密的明文数据</p>
     */
    @NameInMap("Plaintext")
    public byte[] plaintext;

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
     * <p>密钥版本唯一标识符</p>
     */
    @NameInMap("KeyVersionId")
    public String keyVersionId;

    /**
     * <p>响应头</p>
     */
    @NameInMap("responseHeaders")
    public java.util.Map<String, String> responseHeaders;

    public static AdvanceDecryptResponse build(java.util.Map<String, ?> map) throws Exception {
        AdvanceDecryptResponse self = new AdvanceDecryptResponse();
        return TeaModel.build(map, self);
    }

    public AdvanceDecryptResponse setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public AdvanceDecryptResponse setPlaintext(byte[] plaintext) {
        this.plaintext = plaintext;
        return this;
    }
    public byte[] getPlaintext() {
        return this.plaintext;
    }

    public AdvanceDecryptResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

    public AdvanceDecryptResponse setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

    public AdvanceDecryptResponse setPaddingMode(String paddingMode) {
        this.paddingMode = paddingMode;
        return this;
    }
    public String getPaddingMode() {
        return this.paddingMode;
    }

    public AdvanceDecryptResponse setKeyVersionId(String keyVersionId) {
        this.keyVersionId = keyVersionId;
        return this;
    }
    public String getKeyVersionId() {
        return this.keyVersionId;
    }

    public AdvanceDecryptResponse setResponseHeaders(java.util.Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
        return this;
    }
    public java.util.Map<String, String> getResponseHeaders() {
        return this.responseHeaders;
    }

}
