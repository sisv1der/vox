package ru.yarigo.vox.exception;

public enum ErrorCode {
    JWT_FAILED("JWT_FAILED"),
    BAD_CREDENTIALS("BAD_CREDENTIALS"),
    BAD_REQUEST("BAD_REQUEST"),
    CONFLICT("CONFLICT"),
    FORBIDDEN("FORBIDDEN"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR"),
    AUTHENTICATION_FAILED("AUTHENTICATION_FAILED"),
    NOT_FOUND("NOT_FOUND"),
    AUTHORIZATION_FAILED("AUTHORIZATION_FAILED"),;

    private final String name;

    ErrorCode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
