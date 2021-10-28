// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class EncryptRequest extends TeaModel {
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

    public static EncryptRequest build(java.util.Map<String, ?> map) throws Exception {
        EncryptRequest self = new EncryptRequest();
        return TeaModel.build(map, self);
    }

    public EncryptRequest setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public EncryptRequest setPlaintext(byte[] plaintext) {
        this.plaintext = plaintext;
        return this;
    }
    public byte[] getPlaintext() {
        return this.plaintext;
    }

    public EncryptRequest setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

    public EncryptRequest setAad(byte[] aad) {
        this.aad = aad;
        return this;
    }
    public byte[] getAad() {
        return this.aad;
    }

    public EncryptRequest setIv(byte[] iv) {
        this.iv = iv;
        return this;
    }
    public byte[] getIv() {
        return this.iv;
    }

    public EncryptRequest setPaddingMode(String paddingMode) {
        this.paddingMode = paddingMode;
        return this;
    }
    public String getPaddingMode() {
        return this.paddingMode;
    }

}
