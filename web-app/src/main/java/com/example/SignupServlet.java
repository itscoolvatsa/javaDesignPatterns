package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User.users.put(email, password);

        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("email", email);
        jsonResponse.put("password", password);

        res.setContentType("application/json;charset=UTF-8");
        res.setStatus(HttpServletResponse.SC_OK);

//        PrintWriter out = res.getWriter();
//        out.println(jsonResponse);
//        out.flush();
        res.sendRedirect("/signin.jsp");
    }
}
