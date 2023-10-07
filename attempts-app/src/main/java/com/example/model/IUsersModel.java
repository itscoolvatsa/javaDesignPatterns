package com.example.model;

import com.example.bean.SigninBean;
import com.example.bean.SignupBean;
import com.example.utils.Pair;

import java.util.Date;

public interface IUsersModel {
    public String createUser(SignupBean signupBean);

    public SigninBean findUserByEmail(String email);

    public Pair<Date, Integer> findUserByEmailAndUpdateDate(String email);

    public void findUserByEmailAndUpdateAttempts(String email, int attempts);
}
