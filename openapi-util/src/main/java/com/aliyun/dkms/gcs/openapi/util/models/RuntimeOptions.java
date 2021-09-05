// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.openapi.util.models;

import com.aliyun.tea.*;

public class RuntimeOptions extends TeaModel {
    @NameInMap("autoretry")
    public Boolean autoretry;

    @NameInMap("ignoreSSL")
    public Boolean ignoreSSL;

    @NameInMap("maxAttempts")
    public Number maxAttempts;

    @NameInMap("backoffPolicy")
    public String backoffPolicy;

    @NameInMap("backoffPeriod")
    public Number backoffPeriod;

    @NameInMap("readTimeout")
    public Number readTimeout;

    @NameInMap("connectTimeout")
    public Number connectTimeout;

    @NameInMap("httpProxy")
    public String httpProxy;

    @NameInMap("httpsProxy")
    public String httpsProxy;

    @NameInMap("noProxy")
    public String noProxy;

    @NameInMap("maxIdleConns")
    public Number maxIdleConns;

    @NameInMap("socks5Proxy")
    public String socks5Proxy;

    @NameInMap("socks5NetWork")
    public String socks5NetWork;

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

}
