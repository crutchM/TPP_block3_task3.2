package com.example.tpp.servlets;

import com.example.tpp.DirectoryWorker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ServletDirectoriesGet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DirectoryWorker dw = new DirectoryWorker();
        String path = req.getAttribute("path").toString();
        ArrayList<String> content = getContentNames(dw.getContent(path));
        req.setAttribute("content", content);
        req.setAttribute("path", path);
        getServletContext().getRequestDispatcher("/jsp/directoryViewer.jsp").forward(req, resp);
    }

    private ArrayList<String> getContentNames(ArrayList<File> content){
        ArrayList<String> result = new ArrayList<>();
        for(File item : content){
            result.add(item.getName());
        }
        return result;
    }
}
