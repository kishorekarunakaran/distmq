package com.github.wenweihu86.distmq.client.utils;

import com.google.gson.*;

import java.lang.reflect.Type;

public class JsonUtil {

    private static Gson gson;

    static {
        gson = getGB().setDateFormat("yyyy-MM-dd HH:mm:ss").disableHtmlEscaping().create();
    }

    private static GsonBuilder getGB() {
        return new GsonBuilder();
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }

    public static String toJson(Object o) {
        return gson.toJson(o);
    }

    public static String toPrettyPrintJson(Object o) {
        return getGB().setPrettyPrinting().create().toJson(o);
    }

    public Boolean isValidJson(String str) {
        try {
            gson.fromJson(str, Object.class);
            return true;
        } catch (JsonSyntaxException e) {
            return false;
        }
    }

    public static JsonElement parseJson(String json) {
        return new JsonParser().parse(json);
    }

}
