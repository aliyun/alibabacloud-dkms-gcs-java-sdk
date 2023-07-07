// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.openapi.credential.models;

import com.aliyun.tea.*;

public class Config extends TeaModel {
    /**
     * <p>访问凭证类型</p>
     */
    @NameInMap("Type")
    @Validation(required = true)
    public String type;

    /**
     * <p>访问凭证ID</p>
     */
    @NameInMap("Type")
    public String accessKeyId;

    /**
     * <p>pkcs1 或 pkcs8 PEM 格式私钥</p>
     */
    @NameInMap("Type")
    public String privateKey;

    /**
     * <p>ClientKey文件路径</p>
     */
    @NameInMap("Type")
    public String clientKeyFile;

    /**
     * <p>ClientKey文件内容</p>
     */
    @NameInMap("Type")
    public String clientKeyContent;

    /**
     * <p>ClientKey密码</p>
     */
    @NameInMap("Type")
    public String password;

    public static Config build(java.util.Map<String, ?> map) throws Exception {
        Config self = new Config();
        return TeaModel.build(map, self);
    }

    public Config setType(String type) {
        this.type = type;
        return this;
    }
    public String getType() {
        return this.type;
    }

    public Config setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
    }
    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public Config setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
        return this;
    }
    public String getPrivateKey() {
        return this.privateKey;
    }

    public Config setClientKeyFile(String clientKeyFile) {
        this.clientKeyFile = clientKeyFile;
        return this;
    }
    public String getClientKeyFile() {
        return this.clientKeyFile;
    }

    public Config setClientKeyContent(String clientKeyContent) {
        this.clientKeyContent = clientKeyContent;
        return this;
    }
    public String getClientKeyContent() {
        return this.clientKeyContent;
    }

    public Config setPassword(String password) {
        this.password = password;
        return this;
    }
    public String getPassword() {
        return this.password;
    }

}
