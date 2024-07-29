// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;

public class GenerateDataKeyPairWithoutPlaintextRequest extends TeaModel {
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

    public static GenerateDataKeyPairWithoutPlaintextRequest build(java.util.Map<String, ?> map) throws Exception {
        GenerateDataKeyPairWithoutPlaintextRequest self = new GenerateDataKeyPairWithoutPlaintextRequest();
        return TeaModel.build(map, self);
    }

    public GenerateDataKeyPairWithoutPlaintextRequest setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest setKeyPairSpec(String keyPairSpec) {
        this.keyPairSpec = keyPairSpec;
        return this;
    }
    public String getKeyPairSpec() {
        return this.keyPairSpec;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest setKeyFormat(String keyFormat) {
        this.keyFormat = keyFormat;
        return this;
    }
    public String getKeyFormat() {
        return this.keyFormat;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest setAad(byte[] aad) {
        this.aad = aad;
        return this;
    }
    public byte[] getAad() {
        return this.aad;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest setRequestHeaders(java.util.Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
        return this;
    }
    public java.util.Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

}
