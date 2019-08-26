package com.friendsurance.impl.exceptions;

/**
 * @author M.Yeganeh
 **/
public class JobExecutionException extends Exception{

    public JobExecutionException() {
    }

    /**
     * @param message
     **/
    public JobExecutionException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public JobExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     **/
    public JobExecutionException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public JobExecutionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
