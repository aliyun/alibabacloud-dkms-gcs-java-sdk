// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class AdvanceEncryptResponse extends DKMSResponse {
    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("CiphertextBlob")
    public byte[] ciphertextBlob;

    @NameInMap("Iv")
    public byte[] iv;

    @NameInMap("RequestId")
    public String requestId;

    @NameInMap("Algorithm")
    public String algorithm;

    @NameInMap("PaddingMode")
    public String paddingMode;

    @NameInMap("KeyVersionId")
    public String keyVersionId;

    public static AdvanceEncryptResponse build(java.util.Map<String, ?> map) throws Exception {
        AdvanceEncryptResponse self = new AdvanceEncryptResponse();
        return TeaModel.build(map, self);
    }

    public AdvanceEncryptResponse setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public AdvanceEncryptResponse setCiphertextBlob(byte[] ciphertextBlob) {
        this.ciphertextBlob = ciphertextBlob;
        return this;
    }

    public byte[] getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public AdvanceEncryptResponse setIv(byte[] iv) {
        this.iv = iv;
        return this;
    }

    public byte[] getIv() {
        return this.iv;
    }

    public AdvanceEncryptResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public AdvanceEncryptResponse setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public AdvanceEncryptResponse setPaddingMode(String paddingMode) {
        this.paddingMode = paddingMode;
        return this;
    }

    public String getPaddingMode() {
        return this.paddingMode;
    }

    public AdvanceEncryptResponse setKeyVersionId(String keyVersionId) {
        this.keyVersionId = keyVersionId;
        return this;
    }

    public String getKeyVersionId() {
        return this.keyVersionId;
    }

}
