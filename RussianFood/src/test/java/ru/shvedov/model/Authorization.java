package ru.shvedov.model;

public class Authorization {

    private String login;
    private String password;

    public Authorization(String name , String pass){
        this.login = name;
        this.password = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


}
