// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class GenerateDataKeyPairResponse extends TeaModel {
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

    @NameInMap("responseHeaders")
    public java.util.Map<String, String> responseHeaders;

    public static GenerateDataKeyPairResponse build(java.util.Map<String, ?> map) throws Exception {
        GenerateDataKeyPairResponse self = new GenerateDataKeyPairResponse();
        return TeaModel.build(map, self);
    }

    public GenerateDataKeyPairResponse setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public GenerateDataKeyPairResponse setIv(byte[] iv) {
        this.iv = iv;
        return this;
    }
    public byte[] getIv() {
        return this.iv;
    }

    public GenerateDataKeyPairResponse setKeyPairSpec(String keyPairSpec) {
        this.keyPairSpec = keyPairSpec;
        return this;
    }
    public String getKeyPairSpec() {
        return this.keyPairSpec;
    }

    public GenerateDataKeyPairResponse setPrivateKeyPlaintext(byte[] privateKeyPlaintext) {
        this.privateKeyPlaintext = privateKeyPlaintext;
        return this;
    }
    public byte[] getPrivateKeyPlaintext() {
        return this.privateKeyPlaintext;
    }

    public GenerateDataKeyPairResponse setPrivateKeyCiphertextBlob(byte[] privateKeyCiphertextBlob) {
        this.privateKeyCiphertextBlob = privateKeyCiphertextBlob;
        return this;
    }
    public byte[] getPrivateKeyCiphertextBlob() {
        return this.privateKeyCiphertextBlob;
    }

    public GenerateDataKeyPairResponse setPublicKey(byte[] publicKey) {
        this.publicKey = publicKey;
        return this;
    }
    public byte[] getPublicKey() {
        return this.publicKey;
    }

    public GenerateDataKeyPairResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

    public GenerateDataKeyPairResponse setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

    public GenerateDataKeyPairResponse setResponseHeaders(java.util.Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
        return this;
    }
    public java.util.Map<String, String> getResponseHeaders() {
        return this.responseHeaders;
    }

}
