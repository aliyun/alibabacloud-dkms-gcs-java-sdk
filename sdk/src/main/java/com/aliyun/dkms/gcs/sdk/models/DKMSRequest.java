package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.TeaModel;

import java.util.Map;

public class DKMSRequest extends TeaModel {
    private Map<String, String> requestHeaders;

    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }
}
