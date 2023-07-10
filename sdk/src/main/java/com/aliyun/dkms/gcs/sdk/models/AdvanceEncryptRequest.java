// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class AdvanceEncryptRequest extends TeaModel {
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
     * <p>加密算法</p>
     */
    @NameInMap("Algorithm")
    public String algorithm;

    /**
     * <p>对数据密钥加密时使用的GCM加密模式认证数据</p>
     */
    @NameInMap("Aad")
    public byte[] aad;

    /**
     * <p>加密数据时使用的初始向量</p>
     */
    @NameInMap("Iv")
    public byte[] iv;

    /**
     * <p>填充模式</p>
     */
    @NameInMap("PaddingMode")
    public String paddingMode;

    /**
     * <p>请求头</p>
     */
    @NameInMap("requestHeaders")
    public java.util.Map<String, String> requestHeaders;

    public static AdvanceEncryptRequest build(java.util.Map<String, ?> map) throws Exception {
        AdvanceEncryptRequest self = new AdvanceEncryptRequest();
        return TeaModel.build(map, self);
    }

    public AdvanceEncryptRequest setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public AdvanceEncryptRequest setPlaintext(byte[] plaintext) {
        this.plaintext = plaintext;
        return this;
    }
    public byte[] getPlaintext() {
        return this.plaintext;
    }

    public AdvanceEncryptRequest setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

    public AdvanceEncryptRequest setAad(byte[] aad) {
        this.aad = aad;
        return this;
    }
    public byte[] getAad() {
        return this.aad;
    }

    public AdvanceEncryptRequest setIv(byte[] iv) {
        this.iv = iv;
        return this;
    }
    public byte[] getIv() {
        return this.iv;
    }

    public AdvanceEncryptRequest setPaddingMode(String paddingMode) {
        this.paddingMode = paddingMode;
        return this;
    }
    public String getPaddingMode() {
        return this.paddingMode;
    }

    public AdvanceEncryptRequest setRequestHeaders(java.util.Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
        return this;
    }
    public java.util.Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

}
