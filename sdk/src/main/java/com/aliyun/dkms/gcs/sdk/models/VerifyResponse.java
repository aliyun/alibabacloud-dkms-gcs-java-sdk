// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class VerifyResponse extends TeaModel {
    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("Value")
    public Boolean value;

    @NameInMap("RequestId")
    public String requestId;

    public static VerifyResponse build(java.util.Map<String, ?> map) throws Exception {
        VerifyResponse self = new VerifyResponse();
        return TeaModel.build(map, self);
    }

    public VerifyResponse setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public VerifyResponse setValue(Boolean value) {
        this.value = value;
        return this;
    }
    public Boolean getValue() {
        return this.value;
    }

    public VerifyResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

}
