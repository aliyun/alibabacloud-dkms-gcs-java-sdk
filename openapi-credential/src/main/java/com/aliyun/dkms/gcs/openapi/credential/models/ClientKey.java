// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.openapi.credential.models;

import com.aliyun.tea.*;

public class ClientKey extends TeaModel {
    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("PrivateKeyData")
    public String privateKeyData;

    public static ClientKey build(java.util.Map<String, ?> map) throws Exception {
        ClientKey self = new ClientKey();
        return TeaModel.build(map, self);
    }

    public ClientKey setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public ClientKey setPrivateKeyData(String privateKeyData) {
        this.privateKeyData = privateKeyData;
        return this;
    }
    public String getPrivateKeyData() {
        return this.privateKeyData;
    }

}
