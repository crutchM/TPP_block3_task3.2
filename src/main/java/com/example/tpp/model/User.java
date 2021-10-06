package com.example.tpp.model;

public class User {
    private String login;
    private String password;
    private String homeDirectory;

    public User(String login, String password){
        this.login = login;
        this.password = password;
        this.homeDirectory = "/" + login;
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
