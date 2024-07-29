// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;

public class GenerateDataKeyPairWithoutPlaintextResponse extends TeaModel {
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
     * <p>响应头</p>
     */
    @NameInMap("responseHeaders")
    public java.util.Map<String, String> responseHeaders;

    public static GenerateDataKeyPairWithoutPlaintextResponse build(java.util.Map<String, ?> map) throws Exception {
        GenerateDataKeyPairWithoutPlaintextResponse self = new GenerateDataKeyPairWithoutPlaintextResponse();
        return TeaModel.build(map, self);
    }

    public GenerateDataKeyPairWithoutPlaintextResponse setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public GenerateDataKeyPairWithoutPlaintextResponse setIv(byte[] iv) {
        this.iv = iv;
        return this;
    }
    public byte[] getIv() {
        return this.iv;
    }

    public GenerateDataKeyPairWithoutPlaintextResponse setKeyPairSpec(String keyPairSpec) {
        this.keyPairSpec = keyPairSpec;
        return this;
    }
    public String getKeyPairSpec() {
        return this.keyPairSpec;
    }

    public GenerateDataKeyPairWithoutPlaintextResponse setPrivateKeyCiphertextBlob(byte[] privateKeyCiphertextBlob) {
        this.privateKeyCiphertextBlob = privateKeyCiphertextBlob;
        return this;
    }
    public byte[] getPrivateKeyCiphertextBlob() {
        return this.privateKeyCiphertextBlob;
    }

    public GenerateDataKeyPairWithoutPlaintextResponse setPublicKey(byte[] publicKey) {
        this.publicKey = publicKey;
        return this;
    }
    public byte[] getPublicKey() {
        return this.publicKey;
    }

    public GenerateDataKeyPairWithoutPlaintextResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

    public GenerateDataKeyPairWithoutPlaintextResponse setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

    public GenerateDataKeyPairWithoutPlaintextResponse setResponseHeaders(java.util.Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
        return this;
    }
    public java.util.Map<String, String> getResponseHeaders() {
        return this.responseHeaders;
    }

}
