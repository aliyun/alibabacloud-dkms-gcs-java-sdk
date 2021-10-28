// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class SignResponse extends TeaModel {
    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("Signature")
    public byte[] signature;

    @NameInMap("Algorithm")
    public String algorithm;

    @NameInMap("MessageType")
    public String messageType;

    @NameInMap("RequestId")
    public String requestId;

    public static SignResponse build(java.util.Map<String, ?> map) throws Exception {
        SignResponse self = new SignResponse();
        return TeaModel.build(map, self);
    }

    public SignResponse setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public SignResponse setSignature(byte[] signature) {
        this.signature = signature;
        return this;
    }
    public byte[] getSignature() {
        return this.signature;
    }

    public SignResponse setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

    public SignResponse setMessageType(String messageType) {
        this.messageType = messageType;
        return this;
    }
    public String getMessageType() {
        return this.messageType;
    }

    public SignResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

}
