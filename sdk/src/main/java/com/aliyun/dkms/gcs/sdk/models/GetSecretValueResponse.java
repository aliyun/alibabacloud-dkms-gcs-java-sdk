// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class GetSecretValueResponse extends TeaModel {
    /**
     * <p>凭据名称</p>
     */
    @NameInMap("SecretName")
    public String secretName;

    /**
     * <p>凭据类型</p>
     */
    @NameInMap("SecretType")
    public String secretType;

    /**
     * <p>凭据值</p>
     */
    @NameInMap("SecretData")
    public String secretData;

    /**
     * <p>凭据值类型</p>
     */
    @NameInMap("SecretDataType")
    public String secretDataType;

    /**
     * <p>凭据版本的状态标记</p>
     */
    @NameInMap("VersionStages")
    public java.util.List<String> versionStages;

    /**
     * <p>凭据版本的标识符</p>
     */
    @NameInMap("VersionId")
    public String versionId;

    /**
     * <p>创建凭据的时间</p>
     */
    @NameInMap("CreateTime")
    public String createTime;

    /**
     * <p>请求ID</p>
     */
    @NameInMap("RequestId")
    public String requestId;

    /**
     * <p>最近一次轮转的时间</p>
     */
    @NameInMap("LastRotationDate")
    public String lastRotationDate;

    /**
     * <p>下一次轮转的时间</p>
     */
    @NameInMap("NextRotationDate")
    public String nextRotationDate;

    /**
     * <p>凭据的拓展配置</p>
     */
    @NameInMap("ExtendedConfig")
    public String extendedConfig;

    /**
     * <p>是否开启自动轮转</p>
     */
    @NameInMap("AutomaticRotation")
    public String automaticRotation;

    /**
     * <p>凭据自动轮转的周期</p>
     */
    @NameInMap("RotationInterval")
    public String rotationInterval;

    /**
     * <p>响应头</p>
     */
    @NameInMap("responseHeaders")
    public java.util.Map<String, String> responseHeaders;

    public static GetSecretValueResponse build(java.util.Map<String, ?> map) throws Exception {
        GetSecretValueResponse self = new GetSecretValueResponse();
        return TeaModel.build(map, self);
    }

    public GetSecretValueResponse setSecretName(String secretName) {
        this.secretName = secretName;
        return this;
    }
    public String getSecretName() {
        return this.secretName;
    }

    public GetSecretValueResponse setSecretType(String secretType) {
        this.secretType = secretType;
        return this;
    }
    public String getSecretType() {
        return this.secretType;
    }

    public GetSecretValueResponse setSecretData(String secretData) {
        this.secretData = secretData;
        return this;
    }
    public String getSecretData() {
        return this.secretData;
    }

    public GetSecretValueResponse setSecretDataType(String secretDataType) {
        this.secretDataType = secretDataType;
        return this;
    }
    public String getSecretDataType() {
        return this.secretDataType;
    }

    public GetSecretValueResponse setVersionStages(java.util.List<String> versionStages) {
        this.versionStages = versionStages;
        return this;
    }
    public java.util.List<String> getVersionStages() {
        return this.versionStages;
    }

    public GetSecretValueResponse setVersionId(String versionId) {
        this.versionId = versionId;
        return this;
    }
    public String getVersionId() {
        return this.versionId;
    }

    public GetSecretValueResponse setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }
    public String getCreateTime() {
        return this.createTime;
    }

    public GetSecretValueResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

    public GetSecretValueResponse setLastRotationDate(String lastRotationDate) {
        this.lastRotationDate = lastRotationDate;
        return this;
    }
    public String getLastRotationDate() {
        return this.lastRotationDate;
    }

    public GetSecretValueResponse setNextRotationDate(String nextRotationDate) {
        this.nextRotationDate = nextRotationDate;
        return this;
    }
    public String getNextRotationDate() {
        return this.nextRotationDate;
    }

    public GetSecretValueResponse setExtendedConfig(String extendedConfig) {
        this.extendedConfig = extendedConfig;
        return this;
    }
    public String getExtendedConfig() {
        return this.extendedConfig;
    }

    public GetSecretValueResponse setAutomaticRotation(String automaticRotation) {
        this.automaticRotation = automaticRotation;
        return this;
    }
    public String getAutomaticRotation() {
        return this.automaticRotation;
    }

    public GetSecretValueResponse setRotationInterval(String rotationInterval) {
        this.rotationInterval = rotationInterval;
        return this;
    }
    public String getRotationInterval() {
        return this.rotationInterval;
    }

    public GetSecretValueResponse setResponseHeaders(java.util.Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
        return this;
    }
    public java.util.Map<String, String> getResponseHeaders() {
        return this.responseHeaders;
    }

}
