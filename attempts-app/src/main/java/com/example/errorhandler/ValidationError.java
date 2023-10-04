package com.example.errorhandler;

public class ValidationError extends CustomErrorException{
    public ValidationError(String message) {
        super(message);
    }
}
