package com.aliyun.dkms.gcs.openapi.credential.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Base64;
import java.util.Enumeration;

public class KeyStoreUtils {
    private KeyStoreUtils() {
    }

    public static String getPrivateKeyPemFromPk12(byte[] pk12, String password) throws KeyStoreException, CertificateException, IOException, NoSuchAlgorithmException, UnrecoverableKeyException {
        String prefix = "-----BEGIN PRIVATE KEY-----\n";
        String suffix = "-----END PRIVATE KEY-----\n";
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(new ByteArrayInputStream(pk12), password.toCharArray());
        Enumeration<String> e = keyStore.aliases();
        String alias = e.nextElement();
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, password.toCharArray());
        return prefix + Base64.getEncoder().encodeToString(privateKey.getEncoded()) + "\n" + suffix;
    }
}
