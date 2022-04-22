package com.aliyun.dkms.gcs.openapi.models;

import java.util.Map;

public class ResponseBody {
    private byte[] bodyBytes;
    private Map<String, String> responseHeaders;

    public ResponseBody() {
    }

    public ResponseBody(byte[] bodyBytes, Map<String, String> responseHeaders) {
        this.bodyBytes = bodyBytes;
        this.responseHeaders = responseHeaders;
    }

    public byte[] getBodyBytes() {
        return bodyBytes;
    }

    public void setBodyBytes(byte[] bodyBytes) {
        this.bodyBytes = bodyBytes;
    }

    public Map<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }
}
