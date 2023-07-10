// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class GenerateRandomRequest extends TeaModel {
    /**
     * <p>要生成的随机数字节长度</p>
     */
    @NameInMap("Length")
    public Integer length;

    /**
     * <p>请求头</p>
     */
    @NameInMap("requestHeaders")
    public java.util.Map<String, String> requestHeaders;

    public static GenerateRandomRequest build(java.util.Map<String, ?> map) throws Exception {
        GenerateRandomRequest self = new GenerateRandomRequest();
        return TeaModel.build(map, self);
    }

    public GenerateRandomRequest setLength(Integer length) {
        this.length = length;
        return this;
    }
    public Integer getLength() {
        return this.length;
    }

    public GenerateRandomRequest setRequestHeaders(java.util.Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
        return this;
    }
    public java.util.Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

}
