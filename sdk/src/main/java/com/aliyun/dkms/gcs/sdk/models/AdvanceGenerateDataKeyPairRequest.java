// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class AdvanceGenerateDataKeyPairRequest extends TeaModel {
    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("KeyPairSpec")
    public String keyPairSpec;

    @NameInMap("KeyFormat")
    public String keyFormat;

    @NameInMap("Aad")
    public byte[] aad;

    @NameInMap("requestHeaders")
    public java.util.Map<String, String> requestHeaders;

    public static AdvanceGenerateDataKeyPairRequest build(java.util.Map<String, ?> map) throws Exception {
        AdvanceGenerateDataKeyPairRequest self = new AdvanceGenerateDataKeyPairRequest();
        return TeaModel.build(map, self);
    }

    public AdvanceGenerateDataKeyPairRequest setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public AdvanceGenerateDataKeyPairRequest setKeyPairSpec(String keyPairSpec) {
        this.keyPairSpec = keyPairSpec;
        return this;
    }
    public String getKeyPairSpec() {
        return this.keyPairSpec;
    }

    public AdvanceGenerateDataKeyPairRequest setKeyFormat(String keyFormat) {
        this.keyFormat = keyFormat;
        return this;
    }
    public String getKeyFormat() {
        return this.keyFormat;
    }

    public AdvanceGenerateDataKeyPairRequest setAad(byte[] aad) {
        this.aad = aad;
        return this;
    }
    public byte[] getAad() {
        return this.aad;
    }

    public AdvanceGenerateDataKeyPairRequest setRequestHeaders(java.util.Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
        return this;
    }
    public java.util.Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

}
