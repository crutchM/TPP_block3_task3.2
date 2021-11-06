package com.example.tpp.servlets;

import com.example.tpp.DirectoryWorker;
import com.example.tpp.model.FileModel;
import com.example.tpp.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/")
public class ServletDirectoriesGet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DirectoryWorker dw = new DirectoryWorker();
        String path = req.getParameter("path");
        if (AccountService.Accounts.getById(req.getSession().getId()) == null){
            resp.sendRedirect("http://localhost:8080/TPP_block3_task3_2_war_exploded/login?act=reg");
        }
        File file = new File(path);
        String absolutePath = file.getCanonicalPath();
        List<FileModel> content;
        if (path.equals("")) {
            content = dw.getListOfDirs(path);
        } else {
            content = new ArrayList<>();
        }
        Date date = new Date();
        if (file.getCanonicalPath().equals("/")){
           throw new IOException("похоже вы решили за пределы дозволенного, пожалуйста, вернитесь назад");
        }
        req.setAttribute("date", date.toString());
        req.setAttribute("content", content);
        req.setAttribute("path", absolutePath);
        req.getRequestDispatcher("directoryViewer.jsp").forward(req, resp);
    }
}
