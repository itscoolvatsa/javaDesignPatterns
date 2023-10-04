package com.example.services;

import com.example.bean.SignupBean;
import com.example.model.UsersModelImpl;
import com.example.utils.JsonResponse;
import com.example.utils.Pair;
import com.example.utils.Validator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class UsersServicesImpl implements IUsersServices {
    @Override
    public void SignupUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Pair<Boolean, String> nameValidation = Validator.ValidateName(name);
        Pair<Boolean, String> emailValidation = Validator.ValidateEmail(email);
        Pair<Boolean, String> passwordValidation = Validator.ValidatePassword(password);

        res.setContentType("application/json");
        res.setCharacterEncoding("utf-8");

        JsonResponse resp;
        JSONObject respJson;
        HashMap<String, String> data = new HashMap<>();

        if (!nameValidation.first) {
            resp = new JsonResponse(HttpServletResponse.SC_BAD_REQUEST, nameValidation.second, data, false);
            respJson = resp.convertJson();
            resp.sendResponse(res, respJson);
            return;
        } else if (!emailValidation.first) {
            resp = new JsonResponse(HttpServletResponse.SC_BAD_REQUEST, emailValidation.second, data, false);
            respJson = resp.convertJson();
            resp.sendResponse(res, respJson);
            return;
        } else if (!passwordValidation.first) {
            resp = new JsonResponse(HttpServletResponse.SC_BAD_REQUEST, passwordValidation.second, data, false);
            respJson = resp.convertJson();
            resp.sendResponse(res, respJson);
            return;
        }

        SignupBean signupBean = new SignupBean(name, email, password);
        UsersModelImpl usersModel = new UsersModelImpl();
        String userId = usersModel.createUser(signupBean);

        data.put("email", email);
        data.put("_id", userId);
        resp = new JsonResponse(HttpServletResponse.SC_OK, "signup success", data, true);
        respJson = resp.convertJson();
        resp.sendResponse(res, respJson);
    }

    // @TODO("Sign In User")
    @Override
    public void SigninUser(HttpServletRequest req, HttpServletResponse res) {

    }
}
