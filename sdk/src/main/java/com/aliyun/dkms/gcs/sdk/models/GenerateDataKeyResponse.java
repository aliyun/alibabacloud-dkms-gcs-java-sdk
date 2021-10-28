// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class GenerateDataKeyResponse extends TeaModel {
    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("Iv")
    public byte[] iv;

    @NameInMap("Plaintext")
    public byte[] plaintext;

    @NameInMap("CiphertextBlob")
    public byte[] ciphertextBlob;

    @NameInMap("Algorithm")
    public String algorithm;

    @NameInMap("RequestId")
    public String requestId;

    public static GenerateDataKeyResponse build(java.util.Map<String, ?> map) throws Exception {
        GenerateDataKeyResponse self = new GenerateDataKeyResponse();
        return TeaModel.build(map, self);
    }

    public GenerateDataKeyResponse setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public GenerateDataKeyResponse setIv(byte[] iv) {
        this.iv = iv;
        return this;
    }
    public byte[] getIv() {
        return this.iv;
    }

    public GenerateDataKeyResponse setPlaintext(byte[] plaintext) {
        this.plaintext = plaintext;
        return this;
    }
    public byte[] getPlaintext() {
        return this.plaintext;
    }

    public GenerateDataKeyResponse setCiphertextBlob(byte[] ciphertextBlob) {
        this.ciphertextBlob = ciphertextBlob;
        return this;
    }
    public byte[] getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public GenerateDataKeyResponse setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

    public GenerateDataKeyResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

}
