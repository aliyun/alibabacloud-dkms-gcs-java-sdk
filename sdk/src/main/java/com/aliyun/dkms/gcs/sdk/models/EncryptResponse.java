// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class EncryptResponse extends TeaModel {
    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("CiphertextBlob")
    public byte[] ciphertextBlob;

    @NameInMap("Iv")
    public byte[] iv;

    @NameInMap("Algorithm")
    public String algorithm;

    @NameInMap("PaddingMode")
    public String paddingMode;

    @NameInMap("RequestId")
    public String requestId;

    public static EncryptResponse build(java.util.Map<String, ?> map) throws Exception {
        EncryptResponse self = new EncryptResponse();
        return TeaModel.build(map, self);
    }

    public EncryptResponse setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public EncryptResponse setCiphertextBlob(byte[] ciphertextBlob) {
        this.ciphertextBlob = ciphertextBlob;
        return this;
    }
    public byte[] getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public EncryptResponse setIv(byte[] iv) {
        this.iv = iv;
        return this;
    }
    public byte[] getIv() {
        return this.iv;
    }

    public EncryptResponse setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

    public EncryptResponse setPaddingMode(String paddingMode) {
        this.paddingMode = paddingMode;
        return this;
    }
    public String getPaddingMode() {
        return this.paddingMode;
    }

    public EncryptResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

}
