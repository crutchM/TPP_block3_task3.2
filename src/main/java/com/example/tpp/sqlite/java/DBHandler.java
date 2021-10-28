package com.example.tpp.sqlite.java;
import com.example.tpp.model.User;
import org.sqlite.JDBC;
import java.sql.*;
import java.util.*;

public class DBHandler {
    private static final String con_str = "jdbc:sqlite:/home/crutchm/Desktop/edu/tpp/src/main/java/com/example/tpp/sqlite/java/users.db";

    private static DBHandler instance = null;

    private Connection connection;

    public static DBHandler getInstance() throws SQLException{
        if(instance == null)
            instance = new DBHandler();
        return instance;
    }

    private DBHandler() throws SQLException{
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(con_str);
    }

    public List<User> getAllUsers(){
        try(Statement statement = this.connection.createStatement()){
            List<User> users = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("SELECT login, password FROM users");
            while (resultSet.next()){
                users.add(new User(resultSet.getString("login"),
                        resultSet.getString("password")));
            }
            return users;
        } catch (SQLException e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void addUser(User user){
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO users(`login`, `password`, `homeDirectory`) VALUES(?,?,?)")){
            statement.setObject(1, user.getLogin());
            statement.setObject(2, user.getPassword());
            statement.setObject(3, user.getHomeDirectory());
            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
