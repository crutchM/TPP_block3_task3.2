package com.example.tpp.db;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserDataSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    public UserDataSet(String login, String password)
    {
        this.login = login;
        this.password = password;
    }
    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
