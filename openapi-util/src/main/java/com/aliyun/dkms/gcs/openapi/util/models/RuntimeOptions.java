// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.openapi.util.models;

import com.aliyun.tea.*;

public class RuntimeOptions extends TeaModel {
    /**
     * <p>是否自动重试</p>
     */
    @NameInMap("autoretry")
    public Boolean autoretry;

    /**
     * <p>是否忽略SSL认证</p>
     */
    @NameInMap("ignoreSSL")
    public Boolean ignoreSSL;

    /**
     * <p>最大重试次数</p>
     */
    @NameInMap("maxAttempts")
    public Number maxAttempts;

    /**
     * <p>回退策略</p>
     */
    @NameInMap("backoffPolicy")
    public String backoffPolicy;

    /**
     * <p>回退周期</p>
     */
    @NameInMap("backoffPeriod")
    public Number backoffPeriod;

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
     * <p>校验</p>
     */
    @NameInMap("verify")
    public String verify;

    /**
     * <p>响应头</p>
     */
    @NameInMap("responseHeaders")
    public java.util.List<String> responseHeaders;

    public static RuntimeOptions build(java.util.Map<String, ?> map) throws Exception {
        RuntimeOptions self = new RuntimeOptions();
        return TeaModel.build(map, self);
    }

    public RuntimeOptions setAutoretry(Boolean autoretry) {
        this.autoretry = autoretry;
        return this;
    }
    public Boolean getAutoretry() {
        return this.autoretry;
    }

    public RuntimeOptions setIgnoreSSL(Boolean ignoreSSL) {
        this.ignoreSSL = ignoreSSL;
        return this;
    }
    public Boolean getIgnoreSSL() {
        return this.ignoreSSL;
    }

    public RuntimeOptions setMaxAttempts(Number maxAttempts) {
        this.maxAttempts = maxAttempts;
        return this;
    }
    public Number getMaxAttempts() {
        return this.maxAttempts;
    }

    public RuntimeOptions setBackoffPolicy(String backoffPolicy) {
        this.backoffPolicy = backoffPolicy;
        return this;
    }
    public String getBackoffPolicy() {
        return this.backoffPolicy;
    }

    public RuntimeOptions setBackoffPeriod(Number backoffPeriod) {
        this.backoffPeriod = backoffPeriod;
        return this;
    }
    public Number getBackoffPeriod() {
        return this.backoffPeriod;
    }

    public RuntimeOptions setReadTimeout(Number readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }
    public Number getReadTimeout() {
        return this.readTimeout;
    }

    public RuntimeOptions setConnectTimeout(Number connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }
    public Number getConnectTimeout() {
        return this.connectTimeout;
    }

    public RuntimeOptions setHttpProxy(String httpProxy) {
        this.httpProxy = httpProxy;
        return this;
    }
    public String getHttpProxy() {
        return this.httpProxy;
    }

    public RuntimeOptions setHttpsProxy(String httpsProxy) {
        this.httpsProxy = httpsProxy;
        return this;
    }
    public String getHttpsProxy() {
        return this.httpsProxy;
    }

    public RuntimeOptions setNoProxy(String noProxy) {
        this.noProxy = noProxy;
        return this;
    }
    public String getNoProxy() {
        return this.noProxy;
    }

    public RuntimeOptions setMaxIdleConns(Number maxIdleConns) {
        this.maxIdleConns = maxIdleConns;
        return this;
    }
    public Number getMaxIdleConns() {
        return this.maxIdleConns;
    }

    public RuntimeOptions setSocks5Proxy(String socks5Proxy) {
        this.socks5Proxy = socks5Proxy;
        return this;
    }
    public String getSocks5Proxy() {
        return this.socks5Proxy;
    }

    public RuntimeOptions setSocks5NetWork(String socks5NetWork) {
        this.socks5NetWork = socks5NetWork;
        return this;
    }
    public String getSocks5NetWork() {
        return this.socks5NetWork;
    }

    public RuntimeOptions setVerify(String verify) {
        this.verify = verify;
        return this;
    }
    public String getVerify() {
        return this.verify;
    }

    public RuntimeOptions setResponseHeaders(java.util.List<String> responseHeaders) {
        this.responseHeaders = responseHeaders;
        return this;
    }
    public java.util.List<String> getResponseHeaders() {
        return this.responseHeaders;
    }

}
