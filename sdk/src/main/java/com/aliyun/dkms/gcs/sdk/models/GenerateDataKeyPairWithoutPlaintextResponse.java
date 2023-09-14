// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class GenerateDataKeyPairWithoutPlaintextResponse extends TeaModel {
    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("Iv")
    public byte[] iv;

    @NameInMap("KeyPairSpec")
    public String keyPairSpec;

    @NameInMap("PrivateKeyCiphertextBlob")
    public byte[] privateKeyCiphertextBlob;

    @NameInMap("PublicKey")
    public byte[] publicKey;

    @NameInMap("RequestId")
    public String requestId;

    @NameInMap("Algorithm")
    public String algorithm;

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
