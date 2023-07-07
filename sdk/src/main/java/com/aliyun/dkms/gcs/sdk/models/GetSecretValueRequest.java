// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.*;

public class GetSecretValueRequest extends TeaModel {
    /**
     * <p>凭据名称</p>
     */
    @NameInMap("SecretName")
    public String secretName;

    /**
     * <p>版本状态</p>
     */
    @NameInMap("VersionStage")
    public String versionStage;

    /**
     * <p>版本号</p>
     */
    @NameInMap("VersionId")
    public String versionId;

    /**
     * <p>是否获取凭据的拓展配置true（默认值）：是,false：否</p>
     */
    @NameInMap("FetchExtendedConfig")
    public Boolean fetchExtendedConfig;

    /**
     * <p>请求头</p>
     */
    @NameInMap("requestHeaders")
    public java.util.Map<String, String> requestHeaders;

    public static GetSecretValueRequest build(java.util.Map<String, ?> map) throws Exception {
        GetSecretValueRequest self = new GetSecretValueRequest();
        return TeaModel.build(map, self);
    }

    public GetSecretValueRequest setSecretName(String secretName) {
        this.secretName = secretName;
        return this;
    }
    public String getSecretName() {
        return this.secretName;
    }

    public GetSecretValueRequest setVersionStage(String versionStage) {
        this.versionStage = versionStage;
        return this;
    }
    public String getVersionStage() {
        return this.versionStage;
    }

    public GetSecretValueRequest setVersionId(String versionId) {
        this.versionId = versionId;
        return this;
    }
    public String getVersionId() {
        return this.versionId;
    }

    public GetSecretValueRequest setFetchExtendedConfig(Boolean fetchExtendedConfig) {
        this.fetchExtendedConfig = fetchExtendedConfig;
        return this;
    }
    public Boolean getFetchExtendedConfig() {
        return this.fetchExtendedConfig;
    }

    public GetSecretValueRequest setRequestHeaders(java.util.Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
        return this;
    }
    public java.util.Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

}
