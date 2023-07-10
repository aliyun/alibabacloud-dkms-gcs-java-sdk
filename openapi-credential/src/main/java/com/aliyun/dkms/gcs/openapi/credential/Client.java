// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.openapi.credential;

import com.aliyun.tea.*;
import com.aliyun.dkms.gcs.openapi.credential.models.*;

public class Client {

    public String _keyId;
    public String _privateKeySecret;
    public Client(Config config) throws Exception {
        if (com.aliyun.teautil.Common.equalString("rsa_key_pair", config.type)) {
            if (!com.aliyun.teautil.Common.empty(config.clientKeyContent)) {
                Object json = com.aliyun.teautil.Common.parseJSON(config.clientKeyContent);
                java.util.Map<String, Object> clientKey = com.aliyun.teautil.Common.assertAsMap(json);
                byte[] privateKeyData = com.aliyun.darabonba.encode.Encoder.base64Decode(com.aliyun.teautil.Common.assertAsString(clientKey.get("PrivateKeyData")));
                this._privateKeySecret = com.aliyun.dkms.gcs.openapi.util.Client.getPrivatePemFromPk12(privateKeyData, config.password);
                this._keyId = com.aliyun.teautil.Common.assertAsString(clientKey.get("KeyId"));
            } else if (!com.aliyun.teautil.Common.empty(config.clientKeyFile)) {
                Object jsonFromFile = com.aliyun.teautil.Common.readAsJSON(com.aliyun.darabonba.stream.Client.readFromFilePath(config.clientKeyFile));
                if (com.aliyun.teautil.Common.isUnset(jsonFromFile)) {
                    throw new TeaException(TeaConverter.buildMap(
                        new TeaPair("message", "read client key file failed: " + config.clientKeyFile + "")
                    ));
                }

                java.util.Map<String, Object> clientKeyFromFile = com.aliyun.teautil.Common.assertAsMap(jsonFromFile);
                byte[] privateKeyDataFromFile = com.aliyun.darabonba.encode.Encoder.base64Decode(com.aliyun.teautil.Common.assertAsString(clientKeyFromFile.get("PrivateKeyData")));
                this._privateKeySecret = com.aliyun.dkms.gcs.openapi.util.Client.getPrivatePemFromPk12(privateKeyDataFromFile, config.password);
                this._keyId = com.aliyun.teautil.Common.assertAsString(clientKeyFromFile.get("KeyId"));
            } else {
                this._privateKeySecret = config.privateKey;
                this._keyId = config.accessKeyId;
            }

        } else {
            throw new TeaException(TeaConverter.buildMap(
                new TeaPair("message", "Only support rsa key pair credential provider now.")
            ));
        }

    }


    public String getAccessKeyId() throws Exception {
        return _keyId;
    }

    public String getAccessKeySecret() throws Exception {
        return _privateKeySecret;
    }

    public String getSignature(String strToSign) throws Exception {
        String prefix = "Bearer ";
        String sign = com.aliyun.darabonba.encode.Encoder.base64EncodeToString(com.aliyun.darabonba.signature.Signer.SHA256withRSASign(strToSign, this.getAccessKeySecret()));
        return "" + prefix + "" + sign + "";
    }
}
