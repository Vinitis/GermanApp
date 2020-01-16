package com.example.tsuki.germaninnutshell;

public class CatchEx extends Exception {

    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}