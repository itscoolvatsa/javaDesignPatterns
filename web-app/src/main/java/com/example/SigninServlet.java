package com.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        JSONObject jsonResponse = new JSONObject();
        res.setContentType("application/json;charset=UTF-8");
        PrintWriter out = res.getWriter();

        boolean exists = User.users.containsKey(email);
        System.out.println(exists);

        if(!exists) {
            jsonResponse.put("Error", "user doesn't exists");
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            out.println(jsonResponse);
            return;
        }else {
            String storedPassword = User.users.get(email);
            if(!Objects.equals(storedPassword, password)) {
                jsonResponse.put("Error", "password incorrect");
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                out.println(jsonResponse);
                return;
            }
        }

//        jsonResponse.put("email", email);
//        jsonResponse.put("password", password);
        res.setHeader("email", email);
        res.setHeader("password", password);
        res.setStatus(HttpServletResponse.SC_OK);
//        res.sendRedirect("/dashboard.jsp");
//        out.println(jsonResponse);
//        out.flush();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/dashboard.jsp");
        dispatcher.forward(req, res);
    }
}
