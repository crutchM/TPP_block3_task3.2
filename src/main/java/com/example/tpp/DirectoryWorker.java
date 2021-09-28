package com.example.tpp;

import java.io.File;
import java.util.ArrayList;

public class DirectoryWorker {
    private ArrayList<File> content = new ArrayList<>();

    public ArrayList<File> getContent(String path){
        if(getDirectoryContent(path).compareTo(null) == 0){
            return content;
        } else return null;
    }

    private String getDirectoryContent(String path){
        String result = "";
        File dir = new File(path);
        if(dir.compareTo(null) == 0){
            return "directory:" + path + " does not exists";
        } else {
            if (dir.isDirectory()) {
                for (File item : dir.listFiles()) {
                    content.add(item);
                }
            } else {
                return path + " is file";
            }
        }
        return null;
    }

}
