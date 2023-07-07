// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.openapi.models;

import com.aliyun.tea.*;

public class Config extends TeaModel {
    /**
     * <p>访问凭证ID</p>
     */
    @NameInMap("accessKeyId")
    public String accessKeyId;

    /**
     * <p>pkcs1 或 pkcs8 PEM 格式私钥</p>
     */
    @NameInMap("privateKey")
    public String privateKey;

    /**
     * <p>实例地址</p>
     */
    @NameInMap("endpoint")
    public String endpoint;

    /**
     * <p>协议</p>
     */
    @NameInMap("protocol")
    public String protocol;

    /**
     * <p>区域标识</p>
     */
    @NameInMap("regionId")
    @Validation(pattern = "[a-zA-Z0-9-_]+")
    public String regionId;

    /**
     * <p>读取超时时间</p>
     */
    @NameInMap("readTimeout")
    public Number readTimeout;

    /**
     * <p>连接超时时间</p>
     */
    @NameInMap("connectTimeout")
    public Number connectTimeout;

    /**
     * <p>http代理</p>
     */
    @NameInMap("httpProxy")
    public String httpProxy;

    /**
     * <p>https代理</p>
     */
    @NameInMap("httpsProxy")
    public String httpsProxy;

    /**
     * <p>无代理</p>
     */
    @NameInMap("noProxy")
    public String noProxy;

    /**
     * <p>最大闲置连接数</p>
     */
    @NameInMap("maxIdleConns")
    public Number maxIdleConns;

    /**
     * <p>socks5代理</p>
     */
    @NameInMap("socks5Proxy")
    public String socks5Proxy;

    /**
     * <p>socks5代理协议</p>
     */
    @NameInMap("socks5NetWork")
    public String socks5NetWork;

    /**
     * <p>访问凭证类型</p>
     */
    @NameInMap("type")
    @Validation(required = true)
    public String type;

    /**
     * <p>用户代理</p>
     */
    @NameInMap("userAgent")
    public String userAgent;

    /**
     * <p>访问凭证</p>
     */
    @NameInMap("credential")
    public com.aliyun.dkms.gcs.openapi.credential.Client credential;

    /**
     * <p>ClientKey文件路径</p>
     */
    @NameInMap("clientKeyFile")
    public String clientKeyFile;

    /**
     * <p>ClientKey文件内容</p>
     */
    @NameInMap("clientKeyContent")
    public String clientKeyContent;

    /**
     * <p>ClientKey密码</p>
     */
    @NameInMap("password")
    public String password;

    /**
     * <p>ca证书内容</p>
     */
    @NameInMap("ca")
    public String ca;

    /**
     * <p>ca证书文件路径</p>
     */
    @NameInMap("caFilePath")
    public String caFilePath;

    /**
     * <p>是否忽略SSL认证</p>
     */
    @NameInMap("ignoreSSL")
    public Boolean ignoreSSL;

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

    public Config setType(String type) {
        this.type = type;
        return this;
    }
    public String getType() {
        return this.type;
    }

    public Config setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }
    public String getUserAgent() {
        return this.userAgent;
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

    public Config setCa(String ca) {
        this.ca = ca;
        return this;
    }
    public String getCa() {
        return this.ca;
    }

    public Config setCaFilePath(String caFilePath) {
        this.caFilePath = caFilePath;
        return this;
    }
    public String getCaFilePath() {
        return this.caFilePath;
    }

    public Config setIgnoreSSL(Boolean ignoreSSL) {
        this.ignoreSSL = ignoreSSL;
        return this;
    }
    public Boolean getIgnoreSSL() {
        return this.ignoreSSL;
    }

}
