package com.friendsurance.impl.exceptions;

public class InvalidDataFormatException extends Exception {

    /**
     *
     **/
    public InvalidDataFormatException() {
    }

    /**
     * @param message
     **/
    public InvalidDataFormatException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     **/
    public InvalidDataFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     **/
    public InvalidDataFormatException(Throwable cause) {
        super(cause);
    }


    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     **/
    public InvalidDataFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
