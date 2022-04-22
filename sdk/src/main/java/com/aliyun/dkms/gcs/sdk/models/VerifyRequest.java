// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;

public class VerifyRequest extends DKMSRequest {
    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("Signature")
    public byte[] signature;

    @NameInMap("Algorithm")
    public String algorithm;

    @NameInMap("Message")
    public byte[] message;

    @NameInMap("MessageType")
    public String messageType;

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

    public VerifyRequest setMessage(byte[] message) {
        this.message = message;
        return this;
    }
    public byte[] getMessage() {
        return this.message;
    }

    public VerifyRequest setMessageType(String messageType) {
        this.messageType = messageType;
        return this;
    }
    public String getMessageType() {
        return this.messageType;
    }

}
