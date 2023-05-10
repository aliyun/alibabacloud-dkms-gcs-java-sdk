// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class AdvanceDecryptResponse extends DKMSResponse {
    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("Plaintext")
    public byte[] plaintext;

    @NameInMap("RequestId")
    public String requestId;

    @NameInMap("Algorithm")
    public String algorithm;

    @NameInMap("PaddingMode")
    public String paddingMode;

    @NameInMap("KeyVersionId")
    public String keyVersionId;

    public static AdvanceDecryptResponse build(java.util.Map<String, ?> map) throws Exception {
        AdvanceDecryptResponse self = new AdvanceDecryptResponse();
        return TeaModel.build(map, self);
    }

    public AdvanceDecryptResponse setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public AdvanceDecryptResponse setPlaintext(byte[] plaintext) {
        this.plaintext = plaintext;
        return this;
    }

    public byte[] getPlaintext() {
        return this.plaintext;
    }

    public AdvanceDecryptResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public AdvanceDecryptResponse setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public AdvanceDecryptResponse setPaddingMode(String paddingMode) {
        this.paddingMode = paddingMode;
        return this;
    }

    public String getPaddingMode() {
        return this.paddingMode;
    }

    public AdvanceDecryptResponse setKeyVersionId(String keyVersionId) {
        this.keyVersionId = keyVersionId;
        return this;
    }

    public String getKeyVersionId() {
        return this.keyVersionId;
    }

}
