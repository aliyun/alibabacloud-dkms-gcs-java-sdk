// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class GenerateRandomResponse extends TeaModel {
    @NameInMap("Random")
    public byte[] random;

    @NameInMap("RequestId")
    public String requestId;

    public static GenerateRandomResponse build(java.util.Map<String, ?> map) throws Exception {
        GenerateRandomResponse self = new GenerateRandomResponse();
        return TeaModel.build(map, self);
    }

    public GenerateRandomResponse setRandom(byte[] random) {
        this.random = random;
        return this;
    }
    public byte[] getRandom() {
        return this.random;
    }

    public GenerateRandomResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

}
