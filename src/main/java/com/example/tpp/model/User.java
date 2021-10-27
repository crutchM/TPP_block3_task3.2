package com.example.tpp.model;

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
    public boolean equals(Object obj){
        User tmp = (User)obj;
        return this.hashCode() == tmp.hashCode();
    }

    @Override
    public int hashCode(){
        int result = 0;
        char[] tmp = login.toCharArray();
        for(int i = 0; i < login.length(); i++){
            result += tmp[i];
        }
        return (result + password.toCharArray()[2]) / homeDirectory.toCharArray()[3];
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
