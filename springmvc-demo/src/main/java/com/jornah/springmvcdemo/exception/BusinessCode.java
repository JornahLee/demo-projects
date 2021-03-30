package com.jornah.springmvcdemo.exception;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BusinessCode {
    // 1000~2000
    // 2000~3000
    // 4000~5000
    // 5000~6000
    GATEWAY_CONNECTION_FAILED("001"),
    BAD_GATEWAY("002"),
    VALIDATION_ERROR("003"),
    ENTITY_NOT_FOUND("004"),
    PERMISSION_DENY("005"),
    NOT_SUPPORT("006"),
    TRIER_EXPIRED("007"),
    USER_EXPIRED("008"),
    ACCESS_DENY("009"),
    DEVICE_HAD_TRIED("010"),
    SERVER_REMIND("011"),
    VERIFICATION_CODE_ERROR("012"),
    DEVICE_BIND_LIMIT_ERROR("013"),
    TOKEN_EXPIRED("014"),
    SERVER_ERROR("999");

    private String value;

    BusinessCode(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }

}
