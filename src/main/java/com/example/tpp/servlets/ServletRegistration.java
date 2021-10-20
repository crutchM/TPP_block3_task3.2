package com.example.tpp.servlets;

import com.example.tpp.model.User;
import com.example.tpp.service.AccountService.Accounts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/login")
public class ServletRegistration extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        if(Objects.equals(request.getParameter("act"), "reg"))
            request.getRequestDispatcher("register.jsp").forward(request, response);
        else request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest r, HttpServletResponse re) throws IOException, ServletException{
        String act = r.getParameter("act");
        String login = r.getParameter("login");
        String pas = r.getParameter("password");
        if(Objects.equals(act, "reg")){
            Accounts.addUsers(new User(login, pas), r.getSession());
            Accounts.addSession(new User(login, pas), r.getSession());
            redirect(new User(login, pas), r, re);
        } else {
            if(Accounts.checkUser(new User(login, pas))){
                if (Accounts.getById(r.getSession().getId()) != null)
                    redirect(Accounts.getById(r.getSession().getId()), r, re);
                else {
                    Accounts.addSession(new User(login, pas), r.getSession());
                    redirect(new User(login, pas), r, re);
                }
            } else {
                r.setAttribute("error", "wrong password");
            }
        }
    }

    private void redirect(User user, HttpServletRequest r, HttpServletResponse re) throws IOException{
        re.sendRedirect(r.getContextPath().split("/login")[0] + "?path=" + user.getHomeDirectory());
    }

}