package com.example;

import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(email, password);
        Document userDocument = new Document("email", user.getEmail()).append("password", user.getPassword());

        MongoDatabase usersDatabase = MongoConn.getUserDatabase();
        usersDatabase.getCollection("users").insertOne(userDocument);

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
