package com.cp.microservice.account.exception;

public class UserException extends Exception {
    private static final long serialVersionUID = 1L;

    public UserException() {
        super();
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(String message) {
        super(message);
    }

}
