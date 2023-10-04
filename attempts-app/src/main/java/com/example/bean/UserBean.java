package com.example.bean;

public class UserBean {
    private String Name;
    private String Email;
    private String Password;

    public UserBean(String name, String email, String password) {
        Name = name;
        Email = email;
        Password = password;
    }

    public UserBean(String email, String password) {
        Email = email;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
