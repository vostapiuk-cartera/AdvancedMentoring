package com.ostapiuk.core.exception;

public class DriverDockerException extends RuntimeException {
    public DriverDockerException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}