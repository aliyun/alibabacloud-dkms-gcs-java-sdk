// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class AdvanceDecryptRequest extends DKMSRequest {
    @NameInMap("CiphertextBlob")
    public byte[] ciphertextBlob;

    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("Algorithm")
    public String algorithm;

    @NameInMap("Aad")
    public byte[] aad;

    @NameInMap("Iv")
    public byte[] iv;

    @NameInMap("PaddingMode")
    public String paddingMode;

    public static AdvanceDecryptRequest build(java.util.Map<String, ?> map) throws Exception {
        AdvanceDecryptRequest self = new AdvanceDecryptRequest();
        return TeaModel.build(map, self);
    }

    public AdvanceDecryptRequest setCiphertextBlob(byte[] ciphertextBlob) {
        this.ciphertextBlob = ciphertextBlob;
        return this;
    }

    public byte[] getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public AdvanceDecryptRequest setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public AdvanceDecryptRequest setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public AdvanceDecryptRequest setAad(byte[] aad) {
        this.aad = aad;
        return this;
    }

    public byte[] getAad() {
        return this.aad;
    }

    public AdvanceDecryptRequest setIv(byte[] iv) {
        this.iv = iv;
        return this;
    }

    public byte[] getIv() {
        return this.iv;
    }

    public AdvanceDecryptRequest setPaddingMode(String paddingMode) {
        this.paddingMode = paddingMode;
        return this;
    }

    public String getPaddingMode() {
        return this.paddingMode;
    }

}
