// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class AdvanceGenerateDataKeyResponse extends DKMSResponse {
    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("Iv")
    public byte[] iv;

    @NameInMap("Plaintext")
    public byte[] plaintext;

    @NameInMap("CiphertextBlob")
    public byte[] ciphertextBlob;

    @NameInMap("RequestId")
    public String requestId;

    @NameInMap("Algorithm")
    public String algorithm;

    @NameInMap("KeyVersionId")
    public String keyVersionId;

    public static AdvanceGenerateDataKeyResponse build(java.util.Map<String, ?> map) throws Exception {
        AdvanceGenerateDataKeyResponse self = new AdvanceGenerateDataKeyResponse();
        return TeaModel.build(map, self);
    }

    public AdvanceGenerateDataKeyResponse setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public AdvanceGenerateDataKeyResponse setIv(byte[] iv) {
        this.iv = iv;
        return this;
    }

    public byte[] getIv() {
        return this.iv;
    }

    public AdvanceGenerateDataKeyResponse setPlaintext(byte[] plaintext) {
        this.plaintext = plaintext;
        return this;
    }

    public byte[] getPlaintext() {
        return this.plaintext;
    }

    public AdvanceGenerateDataKeyResponse setCiphertextBlob(byte[] ciphertextBlob) {
        this.ciphertextBlob = ciphertextBlob;
        return this;
    }

    public byte[] getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public AdvanceGenerateDataKeyResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public AdvanceGenerateDataKeyResponse setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public AdvanceGenerateDataKeyResponse setKeyVersionId(String keyVersionId) {
        this.keyVersionId = keyVersionId;
        return this;
    }

    public String getKeyVersionId() {
        return this.keyVersionId;
    }

}
