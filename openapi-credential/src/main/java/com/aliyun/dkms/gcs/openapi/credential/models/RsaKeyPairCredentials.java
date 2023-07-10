// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.openapi.credential.models;

import com.aliyun.tea.*;

public class RsaKeyPairCredentials extends TeaModel {
    /**
     * <p>访问凭证私钥</p>
     */
    @NameInMap("privateKeySecret")
    public String privateKeySecret;

    /**
     * <p>访问凭证ID</p>
     */
    @NameInMap("keyId")
    public String keyId;

    public static RsaKeyPairCredentials build(java.util.Map<String, ?> map) throws Exception {
        RsaKeyPairCredentials self = new RsaKeyPairCredentials();
        return TeaModel.build(map, self);
    }

    public RsaKeyPairCredentials setPrivateKeySecret(String privateKeySecret) {
        this.privateKeySecret = privateKeySecret;
        return this;
    }
    public String getPrivateKeySecret() {
        return this.privateKeySecret;
    }

    public RsaKeyPairCredentials setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

}
