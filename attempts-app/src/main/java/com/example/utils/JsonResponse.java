package com.example.utils;

import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class JsonResponse {
    private int StatusCode;
    private String Message;
    private HashMap<String, String> data;
    private Boolean type;
    private JSONObject jsonResponse;

    public JsonResponse(int statusCode, String message) {
        StatusCode = statusCode;
        Message = message;
    }

    public JsonResponse(int statusCode, String message, HashMap<String, String> data, Boolean type) {
        StatusCode = statusCode;
        Message = message;
        this.data = data;
        this.type = type;
    }

    public JsonResponse convertJson() {
        jsonResponse = new JSONObject();
        jsonResponse.put("message", this.Message);
        jsonResponse.put("data", this.data);
        jsonResponse.put("status", type);
        return this;
    }

    public void sendResponse(HttpServletResponse response) throws IOException {
        response.setStatus(this.StatusCode);
        PrintWriter out = response.getWriter();
        out.println(jsonResponse);
        out.flush();
    }
}
