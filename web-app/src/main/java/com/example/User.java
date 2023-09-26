package com.example;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;


public class User {
    public static ConcurrentHashMap<String, String> users = new ConcurrentHashMap<>();


    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
