// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class HmacRequest extends TeaModel {
    @NameInMap("KeyId")
    @Validation(required = true)
    public String keyId;

    @NameInMap("Message")
    @Validation(required = true)
    public byte[] message;

    public static HmacRequest build(java.util.Map<String, ?> map) throws Exception {
        HmacRequest self = new HmacRequest();
        return TeaModel.build(map, self);
    }

    public HmacRequest setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public HmacRequest setMessage(byte[] message) {
        this.message = message;
        return this;
    }
    public byte[] getMessage() {
        return this.message;
    }

}
