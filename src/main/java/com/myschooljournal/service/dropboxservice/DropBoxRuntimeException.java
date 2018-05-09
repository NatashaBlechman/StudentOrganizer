package com.myschooljournal.service.dropboxservice;

public class DropBoxRuntimeException extends RuntimeException {
    public DropBoxRuntimeException() {
    }

    public DropBoxRuntimeException(String message) {
        super(message);
    }

    public DropBoxRuntimeException(Throwable cause) {
        super(cause);
    }
}
