// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class SignRequest extends TeaModel {
    @NameInMap("KeyId")
    @Validation(required = true)
    public String keyId;

    @NameInMap("Digest")
    @Validation(required = true)
    public byte[] digest;

    @NameInMap("Algorithm")
    @Validation(required = true)
    public String algorithm;

    public static SignRequest build(java.util.Map<String, ?> map) throws Exception {
        SignRequest self = new SignRequest();
        return TeaModel.build(map, self);
    }

    public SignRequest setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public SignRequest setDigest(byte[] digest) {
        this.digest = digest;
        return this;
    }
    public byte[] getDigest() {
        return this.digest;
    }

    public SignRequest setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

}
