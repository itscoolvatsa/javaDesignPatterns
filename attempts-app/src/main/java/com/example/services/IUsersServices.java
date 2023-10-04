package com.example.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface IUsersServices {
    public void SignupUser(HttpServletRequest req, HttpServletResponse res) throws IOException;
    public void SigninUser(HttpServletRequest req, HttpServletResponse res);
}
