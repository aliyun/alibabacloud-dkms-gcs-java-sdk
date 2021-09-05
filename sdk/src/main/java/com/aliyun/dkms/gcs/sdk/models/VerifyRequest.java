// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class VerifyRequest extends TeaModel {
    @NameInMap("KeyId")
    @Validation(required = true)
    public String keyId;

    @NameInMap("Digest")
    @Validation(required = true)
    public byte[] digest;

    @NameInMap("Signature")
    public byte[] signature;

    @NameInMap("Algorithm")
    @Validation(required = true)
    public String algorithm;

    public static VerifyRequest build(java.util.Map<String, ?> map) throws Exception {
        VerifyRequest self = new VerifyRequest();
        return TeaModel.build(map, self);
    }

    public VerifyRequest setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public VerifyRequest setDigest(byte[] digest) {
        this.digest = digest;
        return this;
    }
    public byte[] getDigest() {
        return this.digest;
    }

    public VerifyRequest setSignature(byte[] signature) {
        this.signature = signature;
        return this;
    }
    public byte[] getSignature() {
        return this.signature;
    }

    public VerifyRequest setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

}
