// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.openapi.util.models;

import com.aliyun.tea.*;

public class ErrorResponse extends TeaModel {
    @NameInMap("StatusCode")
    @Validation(required = true)
    public String statusCode;

    @NameInMap("ErrorCode")
    @Validation(required = true)
    public String errorCode;

    @NameInMap("ErrorMessage")
    @Validation(required = true)
    public String errorMessage;

    @NameInMap("RequestId")
    @Validation(required = true)
    public String requestId;

    public static ErrorResponse build(java.util.Map<String, ?> map) throws Exception {
        ErrorResponse self = new ErrorResponse();
        return TeaModel.build(map, self);
    }

    public ErrorResponse setStatusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public String getStatusCode() {
        return this.statusCode;
    }

    public ErrorResponse setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }
    public String getErrorCode() {
        return this.errorCode;
    }

    public ErrorResponse setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
    public String getErrorMessage() {
        return this.errorMessage;
    }

    public ErrorResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

}
