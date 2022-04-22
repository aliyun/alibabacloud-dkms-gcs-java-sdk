package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.TeaModel;

import java.util.Map;

public class DKMSResponse extends TeaModel {
    private Map<String, String> responseHeaders;

    public Map<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

}
