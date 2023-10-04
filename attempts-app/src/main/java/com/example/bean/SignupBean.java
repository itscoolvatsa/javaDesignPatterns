package com.example.bean;

import org.bson.Document;

public class SignupBean extends UserBean{
    public SignupBean(String Name, String Email, String Password) {
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
    }
}
