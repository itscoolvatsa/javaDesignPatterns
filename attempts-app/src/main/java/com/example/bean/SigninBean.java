package com.example.bean;

import java.util.Date;

public class SigninBean extends UserBean {
    public SigninBean(String Name, String Email, String Password) {
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
    }

    public SigninBean(String Name, String Email, String Password, Integer ATTEMPT_COUNT, Date LAST_ATTEMPT) {
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
        this.ATTEMPT_COUNT = ATTEMPT_COUNT;
        this.LAST_ATTEMPT = LAST_ATTEMPT;
    }
}
