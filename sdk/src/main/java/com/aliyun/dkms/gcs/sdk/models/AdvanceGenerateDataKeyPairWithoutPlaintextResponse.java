// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;

public class AdvanceGenerateDataKeyPairWithoutPlaintextResponse extends TeaModel {
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
     * <p>指定生成的数据密钥对类型</p>
     */
    @NameInMap("KeyPairSpec")
    public String keyPairSpec;

    /**
     * <p>私钥密文</p>
     */
    @NameInMap("PrivateKeyCiphertextBlob")
    public byte[] privateKeyCiphertextBlob;

    /**
     * <p>公钥</p>
     */
    @NameInMap("PublicKey")
    public byte[] publicKey;

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

    public static AdvanceGenerateDataKeyPairWithoutPlaintextResponse build(java.util.Map<String, ?> map) throws Exception {
        AdvanceGenerateDataKeyPairWithoutPlaintextResponse self = new AdvanceGenerateDataKeyPairWithoutPlaintextResponse();
        return TeaModel.build(map, self);
    }

    public AdvanceGenerateDataKeyPairWithoutPlaintextResponse setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public AdvanceGenerateDataKeyPairWithoutPlaintextResponse setIv(byte[] iv) {
        this.iv = iv;
        return this;
    }
    public byte[] getIv() {
        return this.iv;
    }

    public AdvanceGenerateDataKeyPairWithoutPlaintextResponse setKeyPairSpec(String keyPairSpec) {
        this.keyPairSpec = keyPairSpec;
        return this;
    }
    public String getKeyPairSpec() {
        return this.keyPairSpec;
    }

    public AdvanceGenerateDataKeyPairWithoutPlaintextResponse setPrivateKeyCiphertextBlob(byte[] privateKeyCiphertextBlob) {
        this.privateKeyCiphertextBlob = privateKeyCiphertextBlob;
        return this;
    }
    public byte[] getPrivateKeyCiphertextBlob() {
        return this.privateKeyCiphertextBlob;
    }

    public AdvanceGenerateDataKeyPairWithoutPlaintextResponse setPublicKey(byte[] publicKey) {
        this.publicKey = publicKey;
        return this;
    }
    public byte[] getPublicKey() {
        return this.publicKey;
    }

    public AdvanceGenerateDataKeyPairWithoutPlaintextResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

    public AdvanceGenerateDataKeyPairWithoutPlaintextResponse setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

    public AdvanceGenerateDataKeyPairWithoutPlaintextResponse setKeyVersionId(String keyVersionId) {
        this.keyVersionId = keyVersionId;
        return this;
    }
    public String getKeyVersionId() {
        return this.keyVersionId;
    }

    public AdvanceGenerateDataKeyPairWithoutPlaintextResponse setResponseHeaders(java.util.Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
        return this;
    }
    public java.util.Map<String, String> getResponseHeaders() {
        return this.responseHeaders;
    }

}
