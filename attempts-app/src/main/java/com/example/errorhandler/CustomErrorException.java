package com.example.errorhandler;

public class CustomErrorException extends Exception{
    public CustomErrorException(String message) {
        super(message);
    }
}
