package com.example.tpp.service;

import com.example.tpp.model.User;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AccountService {
    public static class Accounts {
        private static HashMap<String, String> users = new HashMap<>();
        private static HashMap<User, HttpSession> sessions = new HashMap<>();

        public static void addUsers(User user, HttpSession session){
            users.put(user.getLogin(), user.getPassword());
            addSession(user, session);
        }

        public static boolean checkUser(User user)
        {
            if(!users.containsKey(user.getLogin())){
                return false;
            } else return Objects.equals(users.get(user.getLogin()), user.getPassword());
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