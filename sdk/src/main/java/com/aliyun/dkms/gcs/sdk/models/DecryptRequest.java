// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class DecryptRequest extends TeaModel {
    @NameInMap("CiphertextBlob")
    @Validation(required = true)
    public byte[] ciphertextBlob;

    @NameInMap("KeyId")
    @Validation(required = true)
    public String keyId;

    @NameInMap("Algorithm")
    @Validation(required = true)
    public String algorithm;

    @NameInMap("Aad")
    public byte[] aad;

    @NameInMap("Iv")
    public byte[] iv;

    public static DecryptRequest build(java.util.Map<String, ?> map) throws Exception {
        DecryptRequest self = new DecryptRequest();
        return TeaModel.build(map, self);
    }

    public DecryptRequest setCiphertextBlob(byte[] ciphertextBlob) {
        this.ciphertextBlob = ciphertextBlob;
        return this;
    }
    public byte[] getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public DecryptRequest setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public DecryptRequest setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

    public DecryptRequest setAad(byte[] aad) {
        this.aad = aad;
        return this;
    }
    public byte[] getAad() {
        return this.aad;
    }

    public DecryptRequest setIv(byte[] iv) {
        this.iv = iv;
        return this;
    }
    public byte[] getIv() {
        return this.iv;
    }

}
