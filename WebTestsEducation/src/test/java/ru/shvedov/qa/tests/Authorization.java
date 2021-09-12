package ru.shvedov.qa.tests;

public class Authorization {
    private String passAuth;
    private String loginAuth;

    public Authorization(String login, String pass){
        this.loginAuth = login;
        this.passAuth = pass;
    }

    public String getLoginAuth() {
        return loginAuth;
    }
    public String getPassAuth(){
        return passAuth;
    }
}
