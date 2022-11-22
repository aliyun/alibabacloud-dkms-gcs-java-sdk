// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.openapi;

import com.aliyun.dkms.gcs.openapi.models.ResponseEntity;
import com.aliyun.dkms.gcs.openapi.util.models.RuntimeOptions;
import com.aliyun.tea.*;
import com.aliyun.tea.utils.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Client {

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

    public Client(com.aliyun.dkms.gcs.openapi.models.Config config) throws Exception {
        if (com.aliyun.teautil.Common.isUnset(TeaModel.buildMap(config))) {
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
        if (!StringUtils.isEmpty(config.ca)) {
            this._ca = com.aliyun.dkms.gcs.openapi.util.Client.getCaCertFromContent(config.ca.getBytes(StandardCharsets.UTF_8));
        } else {
            if (!StringUtils.isEmpty(config.caFilePath)) {
                this._ca = com.aliyun.dkms.gcs.openapi.util.Client.getCaCertFromFile(config.caFilePath);
            }
        }
        this._endpoint = config.endpoint;
        this._protocol = config.protocol;
        this._regionId = config.regionId;
        this._userAgent = config.userAgent;
        this._readTimeout = config.readTimeout;
        this._connectTimeout = config.connectTimeout;
        this._httpProxy = config.httpProxy;
        this._httpsProxy = config.httpsProxy;
        this._noProxy = config.noProxy;
        this._socks5Proxy = config.socks5Proxy;
        this._socks5NetWork = config.socks5NetWork;
        this._maxIdleConns = config.maxIdleConns;
    }

    public ResponseEntity doRequest(String apiName, String apiVersion, String protocol, String method, String signatureMethod, byte[] reqBodyBytes, RuntimeOptions runtime, Map<String, String> requestHeaders) throws Exception {
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
                        new TeaPair("retryable", runtime.autoretry),
                        new TeaPair("maxAttempts", com.aliyun.teautil.Common.defaultNumber(runtime.maxAttempts, 3))
                )),
                new TeaPair("backoff", TeaConverter.buildMap(
                        new TeaPair("policy", com.aliyun.teautil.Common.defaultString(runtime.backoffPolicy, "no")),
                        new TeaPair("period", com.aliyun.teautil.Common.defaultNumber(runtime.backoffPeriod, 1))
                )),
                new TeaPair("ignoreSSL", runtime.ignoreSSL)
        );
        if ((runtime.ignoreSSL == null || !runtime.ignoreSSL) && !StringUtils.isEmpty(this._ca)) {
            runtime_.put("ca", this._ca);
        }
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
                request_.headers = TeaConverter.buildMap();
                if (requestHeaders != null && requestHeaders.size() > 0) {
                    request_.headers.putAll(requestHeaders);
                }
                request_.headers.put("accept", "application/x-protobuf");
                request_.headers.put("host", com.aliyun.dkms.gcs.openapi.util.Client.getHost(_regionId, _endpoint));
                request_.headers.put("date", com.aliyun.teautil.Common.getDateUTCString());
                request_.headers.put("user-agent", com.aliyun.teautil.Common.getUserAgent(_userAgent));
                request_.headers.put("x-kms-apiversion", apiVersion);
                request_.headers.put("x-kms-apiname", apiName);
                request_.headers.put("x-kms-signaturemethod", signatureMethod);
                request_.headers.put("x-kms-acccesskeyid", _credential.getAccessKeyId());
                request_.headers.put("content-type", "application/x-protobuf");
                request_.headers.put("content-length", com.aliyun.dkms.gcs.openapi.util.Client.getContentLength(reqBodyBytes));
                request_.headers.put("content-sha256", com.aliyun.dkms.gcs.openapi.util.Client.getContentSHA256(reqBodyBytes));
                request_.body = Tea.toReadable(reqBodyBytes);
                String strToSign = com.aliyun.dkms.gcs.openapi.util.Client.getStringToSign(request_);
                request_.headers.put("authorization", _credential.getSignature(strToSign));
                _lastRequest = request_;
                TeaResponse response_ = Tea.doAction(request_, runtime_);

                byte[] bodyBytes = null;
                if (com.aliyun.teautil.Common.is4xx(response_.statusCode) || com.aliyun.teautil.Common.is5xx(response_.statusCode)) {
                    bodyBytes = com.aliyun.teautil.Common.readAsBytes(response_.body);
                    java.util.Map<String, Object> respMap = com.aliyun.dkms.gcs.openapi.util.Client.getErrMessage(bodyBytes);
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
                Map<String, String> responseHeaders = null;
                if (runtime.getResponseHeaders() != null && runtime.getResponseHeaders().size() > 0) {
                    responseHeaders = new HashMap<>();
                    for (String header : runtime.getResponseHeaders()) {
                        if (response_.headers.containsKey(header)) {
                            responseHeaders.put(header, response_.headers.get(header));
                        }
                    }
                }
                return new ResponseEntity(bodyBytes, responseHeaders);
            } catch (Exception e) {
                if (Tea.isRetryable(e)) {
                    _lastException = e;
                    continue;
                }
                throw e;
            }
        }

        throw new TeaUnretryableException(_lastRequest, _lastException);
    }

}
