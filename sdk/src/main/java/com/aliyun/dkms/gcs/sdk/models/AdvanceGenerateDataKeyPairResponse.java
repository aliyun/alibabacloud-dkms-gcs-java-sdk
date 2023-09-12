// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class AdvanceGenerateDataKeyPairResponse extends TeaModel {
    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("Iv")
    public byte[] iv;

    @NameInMap("KeyPairSpec")
    public String keyPairSpec;

    @NameInMap("PrivateKeyPlaintext")
    public byte[] privateKeyPlaintext;

    @NameInMap("PrivateKeyCiphertextBlob")
    public byte[] privateKeyCiphertextBlob;

    @NameInMap("PublicKey")
    public byte[] publicKey;

    @NameInMap("RequestId")
    public String requestId;

    @NameInMap("Algorithm")
    public String algorithm;

    @NameInMap("KeyVersionId")
    public String keyVersionId;

    @NameInMap("responseHeaders")
    public java.util.Map<String, String> responseHeaders;

    public static AdvanceGenerateDataKeyPairResponse build(java.util.Map<String, ?> map) throws Exception {
        AdvanceGenerateDataKeyPairResponse self = new AdvanceGenerateDataKeyPairResponse();
        return TeaModel.build(map, self);
    }

    public AdvanceGenerateDataKeyPairResponse setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public AdvanceGenerateDataKeyPairResponse setIv(byte[] iv) {
        this.iv = iv;
        return this;
    }
    public byte[] getIv() {
        return this.iv;
    }

    public AdvanceGenerateDataKeyPairResponse setKeyPairSpec(String keyPairSpec) {
        this.keyPairSpec = keyPairSpec;
        return this;
    }
    public String getKeyPairSpec() {
        return this.keyPairSpec;
    }

    public AdvanceGenerateDataKeyPairResponse setPrivateKeyPlaintext(byte[] privateKeyPlaintext) {
        this.privateKeyPlaintext = privateKeyPlaintext;
        return this;
    }
    public byte[] getPrivateKeyPlaintext() {
        return this.privateKeyPlaintext;
    }

    public AdvanceGenerateDataKeyPairResponse setPrivateKeyCiphertextBlob(byte[] privateKeyCiphertextBlob) {
        this.privateKeyCiphertextBlob = privateKeyCiphertextBlob;
        return this;
    }
    public byte[] getPrivateKeyCiphertextBlob() {
        return this.privateKeyCiphertextBlob;
    }

    public AdvanceGenerateDataKeyPairResponse setPublicKey(byte[] publicKey) {
        this.publicKey = publicKey;
        return this;
    }
    public byte[] getPublicKey() {
        return this.publicKey;
    }

    public AdvanceGenerateDataKeyPairResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

    public AdvanceGenerateDataKeyPairResponse setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

    public AdvanceGenerateDataKeyPairResponse setKeyVersionId(String keyVersionId) {
        this.keyVersionId = keyVersionId;
        return this;
    }
    public String getKeyVersionId() {
        return this.keyVersionId;
    }

    public AdvanceGenerateDataKeyPairResponse setResponseHeaders(java.util.Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
        return this;
    }
    public java.util.Map<String, String> getResponseHeaders() {
        return this.responseHeaders;
    }

}
