// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class AdvanceGenerateDataKeyPairWithoutPlaintextResponse extends TeaModel {
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

    @NameInMap("KeyVersionId")
    public String keyVersionId;

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
