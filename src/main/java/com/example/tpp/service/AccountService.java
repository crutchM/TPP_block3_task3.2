package com.example.tpp.service;

import com.example.tpp.db.UsersDAO;
import com.example.tpp.db.UsersDAOImpl;
import com.example.tpp.model.User;
import com.example.tpp.db.DBHandler;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Objects;

public class AccountService {
    public static class Accounts {
        private static UsersDAO dao = new UsersDAOImpl();
        //private static HashMap<String, String> users = new HashMap<>();
        private static HashMap<User, HttpSession> sessions = new HashMap<>();
        private static final DBHandler dbHandler = new DBHandler();



        public static void addUsers(User user, HttpSession session){
            dao.add(user);
            addSession(user, session);
        }

        public static boolean checkUser(User user)
        {
            if(dao.getAll() == null)
            //if(dbHandler.getAllUsers() == null)
                return false;
            else {
                if (!dao.getAll().contains(user)) {
                    return false;
                } else {
                    for (User e : dao.getAll())
                        if (e.getLogin().equals(user.getLogin()))
                            return e.getPassword().equals(user.getPassword());
                }
            }
                return false;
        }

        public static void addSession(User user, HttpSession session){
            if(!sessions.containsKey(user))
                sessions.put(user, session);
        }

        public static void logOut(User user)
        {
            sessions.remove(user);
        }

        public static User getById(String id){
            for(User user : sessions.keySet()){
                if(Objects.equals(sessions.get(user).getId(), id)){
                    return user;
                }
            }
            return null;
        }
    }
}