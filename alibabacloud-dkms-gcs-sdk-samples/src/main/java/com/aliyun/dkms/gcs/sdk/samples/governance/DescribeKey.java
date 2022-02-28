package com.aliyun.dkms.gcs.sdk.samples.governance;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.kms.model.v20160120.*;
import com.aliyuncs.profile.DefaultProfile;

public class DescribeKey {

    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<your-access-key-id>", "<your-access-key-secret>");
        /** use STS Token
         DefaultProfile profile = DefaultProfile.getProfile(
         "<your-region-id>",           // The region ID
         "<your-access-key-id>",       // The AccessKey ID of the RAM account
         "<your-access-key-secret>",   // The AccessKey Secret of the RAM account
         "<your-sts-token>");          // STS Token
         **/
        IAcsClient client = new DefaultAcsClient(profile);

        DescribeKeyRequest request = new DescribeKeyRequest();
        request.setKeyId("<your-key-id>");
        try {
            DescribeKeyResponse response = client.getAcsResponse(request);
            final DescribeKeyResponse.KeyMetadata keyMetadata = response.getKeyMetadata();
            System.out.printf("KeyId: %s%n", keyMetadata.getKeyId());
            System.out.printf("Description: %s%n", keyMetadata.getDescription());
            System.out.printf("KeyState: %s%n", keyMetadata.getKeyState());
            System.out.printf("CreationDate: %s%n", keyMetadata.getCreationDate());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }

    }
}
