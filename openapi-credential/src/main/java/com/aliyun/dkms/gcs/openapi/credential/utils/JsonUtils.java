package com.aliyun.dkms.gcs.openapi.credential.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

public class JsonUtils {
    private JsonUtils() {
    }

    public static <T> T readObject(String filePath, Class<T> type) {
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader)
        ) {
            return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create().fromJson(reader, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T parseJson(String json, Class<T> type) {
        return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create().fromJson(json, type);
    }

}
