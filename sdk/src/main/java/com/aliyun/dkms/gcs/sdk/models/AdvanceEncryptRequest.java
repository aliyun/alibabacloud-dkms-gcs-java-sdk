// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class AdvanceEncryptRequest extends DKMSRequest {
    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("Plaintext")
    public byte[] plaintext;

    @NameInMap("Algorithm")
    public String algorithm;

    @NameInMap("Aad")
    public byte[] aad;

    @NameInMap("Iv")
    public byte[] iv;

    @NameInMap("PaddingMode")
    public String paddingMode;

    public static AdvanceEncryptRequest build(java.util.Map<String, ?> map) throws Exception {
        AdvanceEncryptRequest self = new AdvanceEncryptRequest();
        return TeaModel.build(map, self);
    }

    public AdvanceEncryptRequest setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public AdvanceEncryptRequest setPlaintext(byte[] plaintext) {
        this.plaintext = plaintext;
        return this;
    }

    public byte[] getPlaintext() {
        return this.plaintext;
    }

    public AdvanceEncryptRequest setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public AdvanceEncryptRequest setAad(byte[] aad) {
        this.aad = aad;
        return this;
    }

    public byte[] getAad() {
        return this.aad;
    }

    public AdvanceEncryptRequest setIv(byte[] iv) {
        this.iv = iv;
        return this;
    }

    public byte[] getIv() {
        return this.iv;
    }

    public AdvanceEncryptRequest setPaddingMode(String paddingMode) {
        this.paddingMode = paddingMode;
        return this;
    }

    public String getPaddingMode() {
        return this.paddingMode;
    }

}
