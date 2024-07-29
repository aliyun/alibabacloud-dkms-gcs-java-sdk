// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;

public class AdvanceGenerateDataKeyPairWithoutPlaintextRequest extends TeaModel {
    /**
     * <p>密钥的全局唯一标识符该参数也可以被指定为密钥别名</p>
     */
    @NameInMap("KeyId")
    public String keyId;

    /**
     * <p>指定生成的数据密钥对类型</p>
     */
    @NameInMap("KeyPairSpec")
    public String keyPairSpec;

    /**
     * <p>生成数据密钥对格式，取值:PEM,DER</p>
     */
    @NameInMap("KeyFormat")
    public String keyFormat;

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

    public static AdvanceGenerateDataKeyPairWithoutPlaintextRequest build(java.util.Map<String, ?> map) throws Exception {
        AdvanceGenerateDataKeyPairWithoutPlaintextRequest self = new AdvanceGenerateDataKeyPairWithoutPlaintextRequest();
        return TeaModel.build(map, self);
    }

    public AdvanceGenerateDataKeyPairWithoutPlaintextRequest setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public AdvanceGenerateDataKeyPairWithoutPlaintextRequest setKeyPairSpec(String keyPairSpec) {
        this.keyPairSpec = keyPairSpec;
        return this;
    }
    public String getKeyPairSpec() {
        return this.keyPairSpec;
    }

    public AdvanceGenerateDataKeyPairWithoutPlaintextRequest setKeyFormat(String keyFormat) {
        this.keyFormat = keyFormat;
        return this;
    }
    public String getKeyFormat() {
        return this.keyFormat;
    }

    public AdvanceGenerateDataKeyPairWithoutPlaintextRequest setAad(byte[] aad) {
        this.aad = aad;
        return this;
    }
    public byte[] getAad() {
        return this.aad;
    }

    public AdvanceGenerateDataKeyPairWithoutPlaintextRequest setRequestHeaders(java.util.Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
        return this;
    }
    public java.util.Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

}
