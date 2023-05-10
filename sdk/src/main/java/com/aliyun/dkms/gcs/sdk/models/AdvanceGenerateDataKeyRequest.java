// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class AdvanceGenerateDataKeyRequest extends DKMSRequest {
    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("NumberOfBytes")
    public Integer numberOfBytes;

    @NameInMap("Aad")
    public byte[] aad;

    public static AdvanceGenerateDataKeyRequest build(java.util.Map<String, ?> map) throws Exception {
        AdvanceGenerateDataKeyRequest self = new AdvanceGenerateDataKeyRequest();
        return TeaModel.build(map, self);
    }

    public AdvanceGenerateDataKeyRequest setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public AdvanceGenerateDataKeyRequest setNumberOfBytes(Integer numberOfBytes) {
        this.numberOfBytes = numberOfBytes;
        return this;
    }

    public Integer getNumberOfBytes() {
        return this.numberOfBytes;
    }

    public AdvanceGenerateDataKeyRequest setAad(byte[] aad) {
        this.aad = aad;
        return this;
    }

    public byte[] getAad() {
        return this.aad;
    }

}
