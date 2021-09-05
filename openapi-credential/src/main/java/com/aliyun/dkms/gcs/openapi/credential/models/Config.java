// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.openapi.credential.models;

import com.aliyun.tea.*;

public class Config extends TeaModel {
    @NameInMap("type")
    @Validation(required = true)
    public String type;

    @NameInMap("accessKeyId")
    public String accessKeyId;

    @NameInMap("privateKey")
    public String privateKey;

    @NameInMap("clientKeyFile")
    public String clientKeyFile;

    @NameInMap("clientKeyContent")
    public String clientKeyContent;

    @NameInMap("password")
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
