// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.dkms.gcs.sdk.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;

public class GenerateDataKeyRequest extends DKMSRequest {
    @NameInMap("KeyId")
    public String keyId;

    @NameInMap("Algorithm")
    public String algorithm;

    @NameInMap("NumberOfBytes")
    public Integer numberOfBytes;

    @NameInMap("Aad")
    public byte[] aad;

    public static GenerateDataKeyRequest build(java.util.Map<String, ?> map) throws Exception {
        GenerateDataKeyRequest self = new GenerateDataKeyRequest();
        return TeaModel.build(map, self);
    }

    public GenerateDataKeyRequest setKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }
    public String getKeyId() {
        return this.keyId;
    }

    public GenerateDataKeyRequest setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    public String getAlgorithm() {
        return this.algorithm;
    }

    public GenerateDataKeyRequest setNumberOfBytes(Integer numberOfBytes) {
        this.numberOfBytes = numberOfBytes;
        return this;
    }
    public Integer getNumberOfBytes() {
        return this.numberOfBytes;
    }

    public GenerateDataKeyRequest setAad(byte[] aad) {
        this.aad = aad;
        return this;
    }
    public byte[] getAad() {
        return this.aad;
    }

}
