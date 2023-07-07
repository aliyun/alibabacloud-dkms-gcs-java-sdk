// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class GetPublicKeyResponse extends TeaModel {
    /**
     * <p>密钥的全局唯一标识符该参数也可以被指定为密钥别名</p>
     */
    @NameInMap("KeyId")
    public String keyId;

    /**
     * <p>PEM格式的公钥</p>
     */
    @NameInMap("PublicKey")
    public String publicKey;

    /**
     * <p>请求ID</p>
     */
    @NameInMap("RequestId")
    public String requestId;

    /**
     * <p>响应头</p>
     */
    @NameInMap("responseHeaders")
    public java.util.Map<String, String> responseHeaders;

    public static GetPublicKeyResponse build(java.util.Map<String, ?> map) throws Exception {
        GetPublicKeyResponse self = new GetPublicKeyResponse();
        return TeaModel.build(map, self);
    }

    public GetPublicKeyResponse setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public GetPublicKeyResponse setPublicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }
    public String getPublicKey() {
        return this.publicKey;
    }

    public GetPublicKeyResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

    public GetPublicKeyResponse setResponseHeaders(java.util.Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
        return this;
    }
    public java.util.Map<String, String> getResponseHeaders() {
        return this.responseHeaders;
    }

}
