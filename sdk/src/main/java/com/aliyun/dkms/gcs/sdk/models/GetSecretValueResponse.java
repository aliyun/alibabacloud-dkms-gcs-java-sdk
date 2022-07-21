// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class GetSecretValueResponse extends DKMSResponse {
    @NameInMap("SecretName")
    public String secretName;

    @NameInMap("SecretType")
    public String secretType;

    @NameInMap("SecretData")
    public String secretData;

    @NameInMap("SecretDataType")
    public String secretDataType;

    @NameInMap("VersionStages")
    public java.util.List<String> versionStages;

    @NameInMap("VersionId")
    public String versionId;

    @NameInMap("CreateTime")
    public String createTime;

    @NameInMap("RequestId")
    public String requestId;

    @NameInMap("LastRotationDate")
    public String lastRotationDate;

    @NameInMap("NextRotationDate")
    public String nextRotationDate;

    @NameInMap("ExtendedConfig")
    public String extendedConfig;

    @NameInMap("AutomaticRotation")
    public String automaticRotation;

    @NameInMap("RotationInterval")
    public String rotationInterval;

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

}
