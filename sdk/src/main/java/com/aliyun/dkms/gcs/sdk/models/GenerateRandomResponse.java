// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class GenerateRandomResponse extends TeaModel {
    /**
     * <p>随机数</p>
     */
    @NameInMap("Random")
    public byte[] random;

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

    public static GenerateRandomResponse build(java.util.Map<String, ?> map) throws Exception {
        GenerateRandomResponse self = new GenerateRandomResponse();
        return TeaModel.build(map, self);
    }

    public GenerateRandomResponse setRandom(byte[] random) {
        this.random = random;
        return this;
    }
    public byte[] getRandom() {
        return this.random;
    }

    public GenerateRandomResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

    public GenerateRandomResponse setResponseHeaders(java.util.Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
        return this;
    }
    public java.util.Map<String, String> getResponseHeaders() {
        return this.responseHeaders;
    }

}
