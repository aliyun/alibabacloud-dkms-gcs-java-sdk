// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.openapi.models;

import com.aliyun.tea.*;

public class Config extends TeaModel {
    @NameInMap("accessKeyId")
    public String accessKeyId;

    // pkcs1 or pkcs8 PEM format private key
    @NameInMap("privateKey")
    public String privateKey;

    // crypto service address
    @NameInMap("endpoint")
    public String endpoint;

    @NameInMap("protocol")
    public String protocol;

    @NameInMap("regionId")
    @Validation(pattern = "[a-zA-Z0-9-_]+")
    public String regionId;

    @NameInMap("readTimeout")
    public Number readTimeout;

    @NameInMap("connectTimeout")
    public Number connectTimeout;

    @NameInMap("httpProxy")
    public String httpProxy;

    @NameInMap("httpsProxy")
    public String httpsProxy;

    @NameInMap("socks5Proxy")
    public String socks5Proxy;

    @NameInMap("socks5NetWork")
    public String socks5NetWork;

    @NameInMap("noProxy")
    public String noProxy;

    @NameInMap("maxIdleConns")
    public Number maxIdleConns;

    @NameInMap("userAgent")
    public String userAgent;

    @NameInMap("type")
    public String type;

    @NameInMap("credential")
    public com.aliyun.dkms.gcs.openapi.credential.Client credential;

    @NameInMap("clientKeyFile")
    public String clientKeyFile;

    // client key content
    @NameInMap("clientKeyContent")
    public String clientKeyContent;

    @NameInMap("password")
    public String password;

    @NameInMap("caFilePath")
    public String caFilePath;

    @NameInMap("ca")
    public String ca;

    public static Config build(java.util.Map<String, ?> map) throws Exception {
        Config self = new Config();
        return TeaModel.build(map, self);
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

    public Config setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public Config setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public Config setRegionId(String regionId) {
        this.regionId = regionId;
        return this;
    }

    public String getRegionId() {
        return this.regionId;
    }

    public Config setReadTimeout(Number readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public Number getReadTimeout() {
        return this.readTimeout;
    }

    public Config setConnectTimeout(Number connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public Number getConnectTimeout() {
        return this.connectTimeout;
    }

    public Config setHttpProxy(String httpProxy) {
        this.httpProxy = httpProxy;
        return this;
    }

    public String getHttpProxy() {
        return this.httpProxy;
    }

    public Config setHttpsProxy(String httpsProxy) {
        this.httpsProxy = httpsProxy;
        return this;
    }

    public String getHttpsProxy() {
        return this.httpsProxy;
    }

    public Config setSocks5Proxy(String socks5Proxy) {
        this.socks5Proxy = socks5Proxy;
        return this;
    }

    public String getSocks5Proxy() {
        return this.socks5Proxy;
    }

    public Config setSocks5NetWork(String socks5NetWork) {
        this.socks5NetWork = socks5NetWork;
        return this;
    }

    public String getSocks5NetWork() {
        return this.socks5NetWork;
    }

    public Config setNoProxy(String noProxy) {
        this.noProxy = noProxy;
        return this;
    }

    public String getNoProxy() {
        return this.noProxy;
    }

    public Config setMaxIdleConns(Number maxIdleConns) {
        this.maxIdleConns = maxIdleConns;
        return this;
    }

    public Number getMaxIdleConns() {
        return this.maxIdleConns;
    }

    public Config setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public Config setType(String type) {
        this.type = type;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public Config setCredential(com.aliyun.dkms.gcs.openapi.credential.Client credential) {
        this.credential = credential;
        return this;
    }

    public com.aliyun.dkms.gcs.openapi.credential.Client getCredential() {
        return this.credential;
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

    public String getCaFilePath() {
        return this.caFilePath;
    }

    public void setCaFilePath(String caFilePath) {
        this.caFilePath = caFilePath;
    }

    public String getCa() {
        return this.ca;
    }

    public void setCa(String ca) {
        this.ca = ca;
    }

}
