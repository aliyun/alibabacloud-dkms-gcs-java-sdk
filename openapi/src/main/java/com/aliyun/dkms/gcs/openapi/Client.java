// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.openapi;

import com.aliyun.tea.*;
import com.aliyun.tea.interceptor.InterceptorChain;
import com.aliyun.tea.interceptor.RuntimeOptionsInterceptor;
import com.aliyun.tea.interceptor.RequestInterceptor;
import com.aliyun.tea.interceptor.ResponseInterceptor;


public class Client {

    private final static InterceptorChain interceptorChain = InterceptorChain.create();
    private final static String USER_AGENT = com.aliyun.dkms.gcs.openapi.util.Client.PROJECT_NAME + "/" + com.aliyun.dkms.gcs.openapi.util.Client.PROJECT_VERSKION;
    public String _endpoint;
    public String _regionId;
    public String _protocol;
    public Number _readTimeout;
    public Number _connectTimeout;
    public String _httpProxy;
    public String _httpsProxy;
    public String _noProxy;
    public String _userAgent;
    public String _socks5Proxy;
    public String _socks5NetWork;
    public Number _maxIdleConns;
    public com.aliyun.dkms.gcs.openapi.credential.Client _credential;
    public String _ca;
    public Boolean _ignoreSSL;

    public Client(com.aliyun.dkms.gcs.openapi.models.Config config) throws Exception {
        if (com.aliyun.teautil.Common.isUnset(config)) {
            throw new TeaException(TeaConverter.buildMap(
                    new TeaPair("name", "ParameterMissing"),
                    new TeaPair("message", "'config' can not be unset")
            ));
        }

        if (com.aliyun.teautil.Common.empty(config.endpoint)) {
            throw new TeaException(TeaConverter.buildMap(
                    new TeaPair("code", "ParameterMissing"),
                    new TeaPair("message", "'config.endpoint' can not be empty")
            ));
        }

        if (!com.aliyun.teautil.Common.empty(config.clientKeyContent)) {
            config.type = "rsa_key_pair";
            com.aliyun.dkms.gcs.openapi.credential.models.Config contentConfig = com.aliyun.dkms.gcs.openapi.credential.models.Config.build(TeaConverter.buildMap(
                    new TeaPair("type", config.type),
                    new TeaPair("clientKeyContent", config.clientKeyContent),
                    new TeaPair("password", config.password)
            ));
            this._credential = new com.aliyun.dkms.gcs.openapi.credential.Client(contentConfig);
        } else if (!com.aliyun.teautil.Common.empty(config.clientKeyFile)) {
            config.type = "rsa_key_pair";
            com.aliyun.dkms.gcs.openapi.credential.models.Config clientKeyConfig = com.aliyun.dkms.gcs.openapi.credential.models.Config.build(TeaConverter.buildMap(
                    new TeaPair("type", config.type),
                    new TeaPair("clientKeyFile", config.clientKeyFile),
                    new TeaPair("password", config.password)
            ));
            this._credential = new com.aliyun.dkms.gcs.openapi.credential.Client(clientKeyConfig);
        } else if (!com.aliyun.teautil.Common.empty(config.accessKeyId) && !com.aliyun.teautil.Common.empty(config.privateKey)) {
            config.type = "rsa_key_pair";
            com.aliyun.dkms.gcs.openapi.credential.models.Config credentialConfig = com.aliyun.dkms.gcs.openapi.credential.models.Config.build(TeaConverter.buildMap(
                    new TeaPair("type", config.type),
                    new TeaPair("accessKeyId", config.accessKeyId),
                    new TeaPair("privateKey", config.privateKey)
            ));
            this._credential = new com.aliyun.dkms.gcs.openapi.credential.Client(credentialConfig);
        } else if (!com.aliyun.teautil.Common.isUnset(config.credential)) {
            this._credential = config.credential;
        }

        if (!com.aliyun.teautil.Common.isUnset(config.ca)) {
            this._ca = com.aliyun.dkms.gcs.openapi.util.Client.getCaCertFromContent(com.aliyun.teautil.Common.toBytes(config.ca));
        } else {
            if (!com.aliyun.teautil.Common.isUnset(config.caFilePath)) {
                this._ca = com.aliyun.dkms.gcs.openapi.util.Client.getCaCertFromFile(config.caFilePath);
            }

        }

        this._endpoint = config.endpoint;
        this._protocol = config.protocol;
        this._regionId = config.regionId;
        this._userAgent = config.userAgent == null ? USER_AGENT : config.userAgent;
        this._readTimeout = config.readTimeout;
        this._connectTimeout = config.connectTimeout;
        this._httpProxy = config.httpProxy;
        this._httpsProxy = config.httpsProxy;
        this._noProxy = config.noProxy;
        this._socks5Proxy = config.socks5Proxy;
        this._socks5NetWork = config.socks5NetWork;
        this._maxIdleConns = config.maxIdleConns;
        this._ignoreSSL = config.ignoreSSL;
    }

    public java.util.Map<String, ?> doRequest(String apiName, String apiVersion, String protocol, String method, String signatureMethod, byte[] reqBodyBytes, com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions runtime, java.util.Map<String, String> requestHeaders) throws Exception {
        java.util.Map<String, Object> runtime_ = TeaConverter.buildMap(
                new TeaPair("timeouted", "retry"),
                new TeaPair("readTimeout", com.aliyun.teautil.Common.defaultNumber(runtime.readTimeout, _readTimeout)),
                new TeaPair("connectTimeout", com.aliyun.teautil.Common.defaultNumber(runtime.connectTimeout, _connectTimeout)),
                new TeaPair("httpProxy", com.aliyun.teautil.Common.defaultString(runtime.httpProxy, _httpProxy)),
                new TeaPair("httpsProxy", com.aliyun.teautil.Common.defaultString(runtime.httpsProxy, _httpsProxy)),
                new TeaPair("noProxy", com.aliyun.teautil.Common.defaultString(runtime.noProxy, _noProxy)),
                new TeaPair("socks5Proxy", com.aliyun.teautil.Common.defaultString(runtime.socks5Proxy, _socks5Proxy)),
                new TeaPair("socks5NetWork", com.aliyun.teautil.Common.defaultString(runtime.socks5NetWork, _socks5NetWork)),
                new TeaPair("maxIdleConns", com.aliyun.teautil.Common.defaultNumber(runtime.maxIdleConns, _maxIdleConns)),
                new TeaPair("retry", TeaConverter.buildMap(
                        new TeaPair("retryable", com.aliyun.dkms.gcs.openapi.util.Client.defaultBoolean(runtime.autoretry, true)),
                        new TeaPair("maxAttempts", com.aliyun.teautil.Common.defaultNumber(runtime.maxAttempts, 3))
                )),
                new TeaPair("backoff", TeaConverter.buildMap(
                        new TeaPair("policy", com.aliyun.teautil.Common.defaultString(runtime.backoffPolicy, "yes")),
                        new TeaPair("period", com.aliyun.teautil.Common.defaultNumber(runtime.backoffPeriod, 1))
                )),
                new TeaPair("ignoreSSL", com.aliyun.dkms.gcs.openapi.util.Client.defaultBoolean(_ignoreSSL, runtime.ignoreSSL)),
                new TeaPair("ca", _ca)
        );

        TeaRequest _lastRequest = null;
        Exception _lastException = null;
        long _now = System.currentTimeMillis();
        int _retryTimes = 0;
        while (Tea.allowRetry((java.util.Map<String, Object>) runtime_.get("retry"), _retryTimes, _now)) {
            if (_retryTimes > 0) {
                int backoffTime = Tea.getBackoffTime(runtime_.get("backoff"), _retryTimes);
                if (backoffTime > 0) {
                    Tea.sleep(backoffTime);
                }
            }
            _retryTimes = _retryTimes + 1;
            try {
                TeaRequest request_ = new TeaRequest();
                request_.protocol = com.aliyun.teautil.Common.defaultString(_protocol, protocol);
                request_.method = method;
                request_.pathname = "/";
                request_.headers = TeaConverter.merge(String.class,
                        requestHeaders
                );
                request_.headers.put("accept", "application/x-protobuf");
                request_.headers.put("host", _endpoint);
                request_.headers.put("date", com.aliyun.teautil.Common.getDateUTCString());
                request_.headers.put("user-agent", com.aliyun.teautil.Common.getUserAgent(_userAgent));
                request_.headers.put("x-kms-apiversion", apiVersion);
                request_.headers.put("x-kms-apiname", apiName);
                request_.headers.put("x-kms-signaturemethod", signatureMethod);
                request_.headers.put("x-kms-acccesskeyid", _credential.getAccessKeyId());
                request_.headers.put("content-type", "application/x-protobuf");
                request_.headers.put("content-length", com.aliyun.dkms.gcs.openapi.util.Client.getContentLength(reqBodyBytes));
                request_.headers.put("content-sha256", com.aliyun.darabonbastring.Client.toUpper(com.aliyun.openapiutil.Client.hexEncode(com.aliyun.openapiutil.Client.hash(reqBodyBytes, "ACS3-RSA-SHA256"))));
                request_.body = Tea.toReadable(reqBodyBytes);
                String strToSign = com.aliyun.dkms.gcs.openapi.util.Client.getStringToSign(method, request_.pathname, request_.headers, request_.query);
                request_.headers.put("authorization", _credential.getSignature(strToSign));
                _lastRequest = request_;
                TeaResponse response_ = Tea.doAction(request_, runtime_, interceptorChain);

                byte[] bodyBytes = null;
                if (com.aliyun.teautil.Common.is4xx(response_.statusCode) || com.aliyun.teautil.Common.is5xx(response_.statusCode)) {
                    bodyBytes = com.aliyun.teautil.Common.readAsBytes(response_.body);
                    java.util.Map<String, Object> respMap = com.aliyun.teautil.Common.assertAsMap(com.aliyun.dkms.gcs.openapi.util.Client.getErrMessage(bodyBytes));
                    throw new TeaException(TeaConverter.buildMap(
                            new TeaPair("code", respMap.get("Code")),
                            new TeaPair("message", respMap.get("Message")),
                            new TeaPair("data", TeaConverter.buildMap(
                                    new TeaPair("httpCode", response_.statusCode),
                                    new TeaPair("requestId", respMap.get("RequestId")),
                                    new TeaPair("hostId", respMap.get("HostId"))
                            ))
                    ));
                }

                bodyBytes = com.aliyun.teautil.Common.readAsBytes(response_.body);
                java.util.Map<String, Object> responseHeaders = new java.util.HashMap<>();
                java.util.Map<String, String> headers = response_.headers;
                if (!com.aliyun.teautil.Common.isUnset(runtime.responseHeaders)) {
                    for (String key : com.aliyun.darabonba.map.Client.keySet(headers)) {
                        if (com.aliyun.darabonba.array.Client.contains(runtime.responseHeaders, key)) {
                            responseHeaders.put(key, headers.get(key));
                        }

                    }
                }

                return TeaConverter.buildMap(
                        new TeaPair("bodyBytes", bodyBytes),
                        new TeaPair("responseHeaders", responseHeaders)
                );
            } catch (Exception e) {
                if (Tea.isRetryable(e) || com.aliyun.dkms.gcs.openapi.util.Client.isRetryErr(e)) {
                    _lastException = e;
                    continue;
                }
                throw e;
            }
        }
        throw new TeaUnretryableException(_lastRequest, _lastException);
    }

    public void addRuntimeOptionsInterceptor(RuntimeOptionsInterceptor interceptor) {
        interceptorChain.addRuntimeOptionsInterceptor(interceptor);
    }

    public void addRequestInterceptor(RequestInterceptor interceptor) {
        interceptorChain.addRequestInterceptor(interceptor);
    }

    public void addResponseInterceptor(ResponseInterceptor interceptor) {
        interceptorChain.addResponseInterceptor(interceptor);
    }

}
