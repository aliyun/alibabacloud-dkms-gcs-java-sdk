// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class DecryptResponse extends TeaModel {
    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("Plaintext")
    public byte[] plaintext;

    @NameInMap("RequestId")
    public String requestId;

    public static DecryptResponse build(java.util.Map<String, ?> map) throws Exception {
        DecryptResponse self = new DecryptResponse();
        return TeaModel.build(map, self);
    }

    public DecryptResponse setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public DecryptResponse setPlaintext(byte[] plaintext) {
        this.plaintext = plaintext;
        return this;
    }
    public byte[] getPlaintext() {
        return this.plaintext;
    }

    public DecryptResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

}
