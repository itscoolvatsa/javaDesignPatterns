package com.example;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = null;
        MongoDatabase usersDatabase = MongoConn.getUserDatabase();
        MongoCollection<Document> usersCollection = usersDatabase.getCollection("users");

        JSONObject jsonResponse = new JSONObject();
        res.setContentType("application/json;charset=UTF-8");
        PrintWriter out = res.getWriter();

        Bson filter = Filters.eq("email", email);
        Document userDocument = usersCollection.find(filter).first();

//        try (MongoCursor<Document> cursor = usersCollection.find(filter).iterator()) {
//            while (cursor.hasNext()) {
//                Document document = cursor.next();
//
//                // Extract user data from the document
//                String storedEmail = document.getString("email");
//                String storedPassword = document.getString("password");
//
//                // Create a User object and add it to the list
//                user = new User(storedEmail, storedPassword);
//            }
//        }


        if (userDocument == null) {
            jsonResponse.put("Error", "user doesn't exists");
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            out.println(jsonResponse);
            return;
        } else {
            String storedEmail = userDocument.getString("email");
            String storedPassword = userDocument.getString("password");

            if (!Objects.equals(storedPassword, password)) {
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
