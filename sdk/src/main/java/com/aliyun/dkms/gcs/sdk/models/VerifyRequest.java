// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class VerifyRequest extends TeaModel {
    /**
     * <p>密钥的全局唯一标识符该参数也可以被指定为密钥别名</p>
     */
    @NameInMap("KeyId")
    public String keyId;

    /**
     * <p>计算出来的签名值</p>
     */
    @NameInMap("Signature")
    public byte[] signature;

    /**
     * <p>加密算法</p>
     */
    @NameInMap("Algorithm")
    public String algorithm;

    /**
     * <p>签名消息</p>
     */
    @NameInMap("Message")
    public byte[] message;

    /**
     * <p>消息类型: 1. RAW（默认值）：原始数据2. DIGEST：原始数据的消息摘要</p>
     */
    @NameInMap("MessageType")
    public String messageType;

    /**
     * <p>请求头</p>
     */
    @NameInMap("requestHeaders")
    public java.util.Map<String, String> requestHeaders;

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

    public VerifyRequest setRequestHeaders(java.util.Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
        return this;
    }
    public java.util.Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

}
