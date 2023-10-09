package com.example.controller;

import com.example.services.UsersServicesImpl;
import com.example.utils.LoggerUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;

@WebServlet("/users/signin")
public class SignInServletController extends HttpServlet {
    private static Logger log= LogManager.getLogger(SignInServletController.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UsersServicesImpl usersServices = new UsersServicesImpl();
        log.info("signin method called");
        try {
            usersServices.SigninUser(req, res);
            LoggerUtil
                    .getInstance(SignInServletController.class)
                    .info("signin method called");
        } catch (ParseException e) {
            LoggerUtil
                    .getInstance(SignInServletController.class)
                    .error("parsing error happened!");
            throw new RuntimeException(e);
        }
    }
}
