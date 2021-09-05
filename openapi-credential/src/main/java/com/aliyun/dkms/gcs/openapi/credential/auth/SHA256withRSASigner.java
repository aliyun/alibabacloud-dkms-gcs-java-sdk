package com.aliyun.dkms.gcs.openapi.credential.auth;

import org.bouncycastle.asn1.*;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class SHA256withRSASigner extends Signer {
    public static final String ENCODING = "UTF-8";
    private static final String ALGORITHM_NAME = "RSA_PKCS1_SHA_256";
    private static final String PEM_PRIVATE_KEY_PREFIX_PKCS1 = "-----BEGIN RSA PRIVATE KEY-----";
    private static final String PEM_PRIVATE_KEY_PREFIX_PKCS8 = "-----BEGIN PRIVATE KEY-----";
    private static final String PEM_PRIVATE_KEY_SUFFIX_PKCS1 = "-----END RSA PRIVATE KEY-----";
    private static final String PEM_PRIVATE_KEY_SUFFIX_PKCS8 = "-----END PRIVATE KEY-----";

    @Override
    public String signString(String stringToSign, String accessKeySecret) {
        try {
            Signature rsaSign = Signature.getInstance("SHA256withRSA");
            KeyFactory kf = KeyFactory.getInstance("RSA");
            byte[] pkcs8KeySpec;
            if (accessKeySecret.contains(PEM_PRIVATE_KEY_PREFIX_PKCS1) && accessKeySecret.contains(PEM_PRIVATE_KEY_SUFFIX_PKCS1)) {
                String privateKeyDer = accessKeySecret
                        .replace(PEM_PRIVATE_KEY_PREFIX_PKCS1, "")
                        .replaceAll("\r\n", "")
                        .replaceAll("\n", "")
                        .replace(PEM_PRIVATE_KEY_SUFFIX_PKCS1, "");
                byte[] keySpec = Base64.getDecoder().decode(privateKeyDer);
                pkcs8KeySpec = formatPkcs1ToPkcs8(keySpec);
            } else if (accessKeySecret.contains(PEM_PRIVATE_KEY_PREFIX_PKCS8) && accessKeySecret.contains(PEM_PRIVATE_KEY_SUFFIX_PKCS8)) {
                String privateKeyDer = accessKeySecret
                        .replace(PEM_PRIVATE_KEY_PREFIX_PKCS8, "")
                        .replaceAll("\r\n", "")
                        .replaceAll("\n", "")
                        .replace(PEM_PRIVATE_KEY_SUFFIX_PKCS8, "");
                pkcs8KeySpec = Base64.getDecoder().decode(privateKeyDer);
            } else {
                throw new IllegalArgumentException("Illegal private key pem format");
            }
            PrivateKey privateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(pkcs8KeySpec));
            rsaSign.initSign(privateKey);
            rsaSign.update(stringToSign.getBytes(ENCODING));
            byte[] sign = rsaSign.sign();
            return "Bearer " + Base64.getEncoder().encodeToString(sign);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Private key contains " + e.getMessage());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | SignatureException
                | UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e.toString());
        }
    }

    @Override
    public String signString(String stringToSign, AlibabaCloudCredentials credentials) {
        return signString(stringToSign, credentials.getAccessKeySecret());
    }

    @Override
    public String getSignerName() {
        return ALGORITHM_NAME;
    }

    @Override
    public String getSignerVersion() {
        return "1.0";
    }

    @Override
    public String getSignerType() {
        return "rsa_key_pair";
    }

    private byte[] formatPkcs1ToPkcs8(byte[] pkcs1PrivateKey) {
        try (ASN1InputStream asn1InputStream = new ASN1InputStream(pkcs1PrivateKey)) {
            AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption);
            ASN1Primitive asn1Object = asn1InputStream.readObject();
            PrivateKeyInfo privKeyInfo = new PrivateKeyInfo(algorithmIdentifier, asn1Object);
            return privKeyInfo.getEncoded();
        } catch (IOException e) {
            throw new IllegalArgumentException(e.toString());
        }
    }
}
