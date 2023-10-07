package com.example.controller;

import com.example.services.UsersServicesImpl;
import com.example.utils.LoggerUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/users/signup")
public class SignUpServletController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        LoggerUtil
                .getInstance()
                .info("signup method called");
        UsersServicesImpl usersServices = new UsersServicesImpl();
        usersServices.SignupUser(req, res);
    }
}
