package com.example.session2.excptnhandling;

public class CustomWebException extends Exception {

    private static final long serialVersionUID = 1L;
    private String message;
    private int status;

    public CustomWebException(String message, int status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private CustomWebException() {
        //
    }
}
