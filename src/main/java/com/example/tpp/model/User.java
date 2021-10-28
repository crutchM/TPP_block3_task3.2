package com.example.tpp.model;

import java.util.Objects;

public class User extends Object{
    private String login;
    private String password;
    private String homeDirectory;

    public User(String login, String password){
        this.login = login;
        this.password = password;
        this.homeDirectory = "/" + login;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getHomeDirectory() {
        return homeDirectory;
    }
}
