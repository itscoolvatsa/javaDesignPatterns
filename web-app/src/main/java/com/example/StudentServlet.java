package com.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

@WebServlet("/play")
public class StudentServlet extends HttpServlet {

    public class Student {
        public String name;

        public int id;
        public int marks;

        public Student(String name, int id, int marks) {
            this.name = name;
            this.id = id;
            this.marks = marks;
        }
    }

    public static ArrayList<Student> studentList = new ArrayList<>();

    private String generateRandomName() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder randomName = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            randomName.append(chars.charAt(random.nextInt(chars.length())));
        }
        return randomName.toString();
    }

    {
        for (int id = 1; id <= 10; id++) {
            String randomName = generateRandomName();
            int marks = 70 + new Random().nextInt(31); // Random marks between 70 and 100
            studentList.add(new Student(randomName, id, marks));
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("students", studentList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/play.jsp");
        dispatcher.forward(req, res);
    }
}
