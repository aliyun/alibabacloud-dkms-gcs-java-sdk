// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class GenerateDataKeyPairWithoutPlaintextRequest extends TeaModel {
    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("Algorithm")
    public String algorithm;

    @NameInMap("KeyPairSpec")
    public String keyPairSpec;

    @NameInMap("KeyFormat")
    public String keyFormat;

    @NameInMap("Aad")
    public byte[] aad;

    @NameInMap("requestHeaders")
    public java.util.Map<String, String> requestHeaders;

    public static GenerateDataKeyPairWithoutPlaintextRequest build(java.util.Map<String, ?> map) throws Exception {
        GenerateDataKeyPairWithoutPlaintextRequest self = new GenerateDataKeyPairWithoutPlaintextRequest();
        return TeaModel.build(map, self);
    }

    public GenerateDataKeyPairWithoutPlaintextRequest setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest setKeyPairSpec(String keyPairSpec) {
        this.keyPairSpec = keyPairSpec;
        return this;
    }
    public String getKeyPairSpec() {
        return this.keyPairSpec;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest setKeyFormat(String keyFormat) {
        this.keyFormat = keyFormat;
        return this;
    }
    public String getKeyFormat() {
        return this.keyFormat;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest setAad(byte[] aad) {
        this.aad = aad;
        return this;
    }
    public byte[] getAad() {
        return this.aad;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest setRequestHeaders(java.util.Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
        return this;
    }
    public java.util.Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

}
