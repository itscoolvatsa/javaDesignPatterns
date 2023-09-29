<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.StudentServlet.Student" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<table>
    <tr>
        <th>Name</th>
        <th>ID</th>
        <th>Marks</th>
    </tr>
    <%
    ArrayList <Student> students = (ArrayList <Student>) request.getAttribute("students");
    if (students != null) {
        for (Student student : students) {
            %>
                <tr>
                    <td><%= student.name %></td>
                    <td><%= student.id %></td>
                    <td><%= student.marks %></td>
                </tr>
            <%
        }
    }
    %>
</table>

</body>
</html>