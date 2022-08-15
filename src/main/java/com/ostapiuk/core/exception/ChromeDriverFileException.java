package com.ostapiuk.core.exception;

public class ChromeDriverFileException extends RuntimeException {
    public ChromeDriverFileException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
