package com.example.model;

import com.example.bean.SignupBean;

public interface IUsersModel {
    public String createUser(SignupBean signupBean);
    public String findUserByEmail(String email);
}
