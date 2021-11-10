package com.example.tpp.db;

import com.example.tpp.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UsersDAO {
    User get(long id);
    List<User> getAll() ;
    void add(User dataSet);
}
