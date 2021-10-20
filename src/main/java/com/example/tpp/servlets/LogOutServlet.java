package com.example.tpp.servlets;

import com.example.tpp.service.AccountService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
class ServletLogOut extends HttpServlet {

    public void doGet(HttpServletRequest r, HttpServletResponse re) throws IOException{
        AccountService.Accounts.logOut(AccountService.Accounts.getById(r.getSession().getId()));
        re.sendRedirect("http://localhost:8080/TPP_block3_task3_2_war_exploded/login?act=log");
    }
}