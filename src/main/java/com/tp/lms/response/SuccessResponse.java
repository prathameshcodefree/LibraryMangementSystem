package com.tp.lms.response;

public class SuccessResponse {
    private boolean status;
    private String message;

    public SuccessResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters and setters
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
