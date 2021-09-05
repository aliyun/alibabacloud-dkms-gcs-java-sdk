// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class HmacResponse extends TeaModel {
    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("Signature")
    public byte[] signature;

    @NameInMap("RequestId")
    public String requestId;

    public static HmacResponse build(java.util.Map<String, ?> map) throws Exception {
        HmacResponse self = new HmacResponse();
        return TeaModel.build(map, self);
    }

    public HmacResponse setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public HmacResponse setSignature(byte[] signature) {
        this.signature = signature;
        return this;
    }
    public byte[] getSignature() {
        return this.signature;
    }

    public HmacResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

}
