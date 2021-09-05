package com.aliyun.dkms.gcs.openapi.credential;

import com.aliyun.dkms.gcs.openapi.credential.models.Config;
import com.aliyun.dkms.gcs.openapi.credential.provider.RsaKeyPairCredentialProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientTest {

    @org.junit.jupiter.api.Test
    void setCredentialsProvider() throws Exception {
        String publicKeyId1 = "public_key_id1";
        String privateKey1 = "private_key1";
        String publicKeyId2 = "public_key_id2";
        String privateKey2 = "private_key2";

        Config config = new Config();
        config.setType("rsa_key_pair");
        config.setAccessKeyId(publicKeyId1);
        config.setPrivateKey(privateKey1);
        Client client = new Client(config);

        assertEquals(publicKeyId1, client.getAccessKeyId());
        assertEquals(privateKey1, client.getAccessKeySecret());

        RsaKeyPairCredentialProvider provider = new RsaKeyPairCredentialProvider(publicKeyId2, privateKey2);
        client.setCredentialsProvider(provider);

        assertEquals(publicKeyId2, client.getAccessKeyId());
        assertEquals(privateKey2, client.getAccessKeySecret());
    }

    @org.junit.jupiter.api.Test
    void getAccessKeyId() throws Exception {
        String publicKeyId = "public_key_id";
        String privateKey = "private_key";

        Config config = new Config();
        config.setType("rsa_key_pair");
        config.setAccessKeyId(publicKeyId);
        config.setPrivateKey(privateKey);
        Client client = new Client(config);

        assertEquals(publicKeyId, client.getAccessKeyId());
    }

    @org.junit.jupiter.api.Test
    void getAccessKeySecret() throws Exception {
        String publicKeyId = "public_key_id";
        String privateKey = "private_key";

        Config config = new Config();
        config.setType("rsa_key_pair");
        config.setAccessKeyId(publicKeyId);
        config.setPrivateKey(privateKey);
        Client client = new Client(config);

        assertEquals(privateKey, client.getAccessKeySecret());
    }

    @org.junit.jupiter.api.Test
    void getSignature() throws Exception {
        String strToSign = "string to sign";
        String accessKeyId = "access_key_id";
        String privateKey = "-----BEGIN RSA PRIVATE KEY-----\nMIIEpQIBAAKCAQEAy/WL7do1hzpl00OXGnRjhRmiWUZbTgJv1PEND2ZgSIAAROJF2XFxYyWKH7I+a9TQPe/j4L1nIg5lLEsssSYK0fhGQM/hy/aiyNHzwBEShoBdxp7dC17rRmGsBeHf5LMjM/ToYbMIWa4owB8L7sTqHQesJzfSuwvnWm4/lt+Yw/jdUwHL4Wo8AGiWKFluBDXdIDekkSiE9ulKqqZDA7+AiDKASp/+Ag5FEqOVAXduolQvD4MzESaxfE5i8G1IRwo3I3kpyhCe+vaem4FcQdh8Iwjt7XuMGzllv8qUabuRXR5mThYCZwhErFKPhadjp7U874VSSNjnoK+JXm+d8bsKpQIDAQABAoIBAFyun0CdmRdzRRREsaR24UZ5iJnS6+i+GL2GMG4gEn6/k9+5hw4xi9oHFAYlRFJR6bNLkJzu1K/YJMeE/bEeXWpezOXk0XGTCRQCvCY6W9W8/WAljsL9BiL8fWRK6SgO819H2lWTOqcuChyLvytoVg6NDwDfUCZpWV9xm/neb5gVbicwvq4YfYsVQSmxchFb8FuFApNgq3DPNUk6ZZ75mSyO1kM4ewG0gSAAV1elQRovBhm9X92+cDwGfttb3pMABsUZ4INj0h2hVvTj2bbjw0j/6CJzUdFfJt7tiXnm0Kz7RQ6X15v7lsRWyX/fIDlbVvw9ZE79fCOXl8JHnNo6AyECgYEA5oh5RA7KeUvODQUPs9z8pYug83AKT1GJf1tz1FQzBi2NsTdFPPmCFzaAaDC4L8bTnXaQyvuVeiSKbjPHYaoZRdQUZ7M2H4nsu0ut0yVLFDxMDR7UMdayyXYWkxsJyloHP2DQD7qgvI9c5mwT54yk76nbZlv53a9XMSvwXaUGfU0CgYEA4n2OZx2zZ92gO5fPsMszzdPTrikPBZb6kNxfi8Em0cH6K2fY/oLQWyyTV6iOI2XUTzHZl9NtJa63mIlbiWO/C1i5LwIKHaPYnmUhCpIgIYTEPmyTu+nLXlXR80z0nZbbi+XLplMUr02koGu5OITnBT/H4gCKdfpJjmWLyHrtdrkCgYEAwdOxEdXVyxI/VpcQ0stU6ONzGfrz0CjgEGKWCsoYdHNMlNnBrzihdl7uq6t60UC8n8IWj3PkA+RBN9L1KlpYEWv1FBOLyAyxK/C/X64VaBgiYU2wX48Cl3xgEqNDIg171n/Rr8fcaW2oUFxCiAaqjo8j1vYyKX/JMaCd4j5kLGkCgYEA4eSAJvBEgw9URJuBFb9Vh7ABq+5fgR+4AMsKsISQhxyEus30asNls8mdmwwN19g0DFiXwQmqDq9XhddZaIoHfPWcnPnXxQApiLEsZzKewU99uxTns7/WidvmblcOki5oAfvLRbQPKVizHRzTuz8yetXGMe6AKnLa8h7tb6LLPGECgYEAjThPt4rTyov/EMwva2PifPd19+rvwYzM4/A7z1gIysJkB+JYNa9P4MrcRv8I1BjMsCG/VzifJ29HHxIcx/8Qf/ICUPNnEg/whV29nsUgj6PfS22cg9LGytN8RhnKaDjzdyfTSauA2hUbm1ea+DmMcZOGRw78Ff8+7MXPxwqpmSI=\n-----END RSA PRIVATE KEY-----";
        String signature = "Bearer gvXsVIkQF/QLMFRfkXaEb4Ul7NFSwYks04e2ZDIRE38WvGrRuvYOE78TUucrtWCKcVpj0MxoDEyyjBcUoi+XPtEzNJXkQ0JQdoISBTClVW6BaecuWg7mWosDqlBuxXH9oYQhD5prERbuGOa9Ft+kbzyJe6p8lDkAlVuI8tGHBXsbFBRHR1gm8rcSv7xOBR3NBL718Lh1H0PUIGSkj6pAyGGTalIrhFB+bFMpblgs79mlepa5ZMrkXa7iSMsEACYFrF0Ya1jOdJABKxx/GjHohZDBdWSfO4NH7VzAkKvH9dbEJ25C9K/TksvD3XbSFKwzZZJKiGHlSTXyGZ8nfhCWaA==";
        String signature1 = "Bearer 8qCkGCbTUrY8sA17CiaGvUEX/xFAsHyckv8sh3eVUyUz9iMyJE+vGX+LnVX+vNxCE+bepwxlrewa8mlppq5SoswwGWipOFP91TqgdqD44hOiLr/5wtDNRAYyWzriFD/gt1ZklzxKr0rmW0c7kCA+QnB0t6uotHPfXhG+5/E7zRMq/GpRIylYvi50k/26vTouRo7zjc4f6Gf9L+oAuPRih6KarNvw08FQH8DRQ3xVe4QKVwW4hdk47RQ8JySR6lLoli8DFXRmY4d7NNAlyIkGauF1MXGoKv+IzgSJ24QnCyQZ/3bXD4ZnGCguKd92mvF1z7S5hw+aeuXsU+he4LS8QA==";

        Config config = new Config();
        config.setType("rsa_key_pair");
        config.setAccessKeyId(accessKeyId);
        config.setPrivateKey(privateKey);

        Client client = new Client(config);
        assertEquals(signature, client.getSignature(strToSign));

        Config clientKeyConfig = new Config();
        clientKeyConfig.setType("rsa_key_pair");
        clientKeyConfig.setClientKeyContent("{\n" +
                "\"KeyId\":\"key_for_unit_test\",\n" +
                "\"PrivateKeyData\":\"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\"\n" +
                "}");
        clientKeyConfig.setPassword("1234");

        Client clientKeyClient = new Client(clientKeyConfig);
        assertEquals(signature1, clientKeyClient.getSignature(strToSign));
    }
}