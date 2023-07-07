// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class SignResponse extends TeaModel {
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
     * <p>请求ID</p>
     */
    @NameInMap("RequestId")
    public String requestId;

    /**
     * <p>加密算法</p>
     */
    @NameInMap("Algorithm")
    public String algorithm;

    /**
     * <p>消息类型: 1. RAW（默认值）：原始数据2. DIGEST：原始数据的消息摘要</p>
     */
    @NameInMap("MessageType")
    public String messageType;

    /**
     * <p>响应头</p>
     */
    @NameInMap("responseHeaders")
    public java.util.Map<String, String> responseHeaders;

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

    public SignResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
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

    public SignResponse setResponseHeaders(java.util.Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
        return this;
    }
    public java.util.Map<String, String> getResponseHeaders() {
        return this.responseHeaders;
    }

}
