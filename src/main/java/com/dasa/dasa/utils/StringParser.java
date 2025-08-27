package com.dasa.dasa.utils;

public final class StringParser {

    private StringParser() { }

    public static boolean isEmptyOrNull(String value) {
        return value == null || value.isBlank();
    }
}