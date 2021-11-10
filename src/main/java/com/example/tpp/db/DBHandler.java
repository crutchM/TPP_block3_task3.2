package com.example.tpp.db;
import com.example.tpp.model.User;
import java.sql.*;
import java.util.*;
import java.sql.DriverManager;

public class DBHandler {
    private Connection connection;
    private static final String user = "root";
    private static final String password = "22334455";
    private static final String url = "jdbc:mysql://localhost/users";
    public DBHandler(){
        try {
           Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
           DriverManager.registerDriver(driver);
           this.connection =DriverManager.getConnection(url, user, password);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public List<User> getAllUsers(){
        try(Statement statement = this.connection.createStatement()){
            ArrayList<User> users = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("SELECT login, password FROM users");
            while (resultSet.next()){
                users.add(new User(resultSet.getString("login"),
                        resultSet.getString("password")));
            }
            if (users.isEmpty())
                return Collections.emptyList();
            return users;
        } catch (SQLException e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void addUser(User user){
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO users(`login`, `password`) VALUES(?,?)")){
            statement.setObject(1, user.getLogin());
            statement.setObject(2, user.getPassword());
            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
