package com.example.controller;

import com.example.services.UsersServicesImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;

@WebServlet("/users/signin")
public class SignInServletController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UsersServicesImpl usersServices = new UsersServicesImpl();
        try {
            usersServices.SigninUser(req, res);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
