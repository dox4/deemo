package com.study.deemo.object;

public enum DmType {
    OBJECT,
    ARRAY,
    BOOLEAN,
    STRING,
    NUMBER,
    NULL;

    public static boolean isComparable(DmType type) {
        return type == STRING || type == NUMBER;
    }
}
