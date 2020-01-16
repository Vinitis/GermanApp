package com.example.tsuki.germaninnutshell;

public class User {

    String username;
    int accountType = 0;
    String userTag = "Casual";

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
