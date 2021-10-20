package com.example.tpp.servlets;

import com.example.tpp.DirectoryWorker;
import com.example.tpp.model.FileModel;

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
        File file = new File(path);
        path = file.getAbsolutePath();
        List<FileModel> content;
        if(path == null)
             content = new ArrayList<>();
        else content = dw.getListOfDirs(path);
        Date date = new Date();
        req.setAttribute("date", date.toString());
        req.setAttribute("content", content);
        req.setAttribute("path", path);
        req.getRequestDispatcher("directoryViewer.jsp").forward(req, resp);
    }
}
