package com.example.utils;

import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class JsonResponse {


    public int StatusCode;
    public String Message;
    public HashMap<String, String> data;
    public Boolean type;

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

    public JSONObject convertJson() {
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("message", this.Message);
        jsonResponse.put("data", this.data);
        jsonResponse.put("status", type);
        return jsonResponse;
    }

    public void sendResponse(HttpServletResponse response, JSONObject json) throws IOException {
        response.setStatus(this.StatusCode);
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
    }
}
