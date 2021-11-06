package com.example.tpp;

import com.example.tpp.model.FileModel;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoryWorker{
    public List<FileModel> getListOfDirs(String path) {
        //String root = "C:\\Users\\sads1\\IdeaProjects\\TPP_block3_task3.2";
        String root = "/home/crutchm/";
        //path = root + path.replace("/", "\\");
        path = root + path;
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }
        return Stream.of(new File(path).listFiles())
                .map(file -> new FileModel(
                        //file.getName().replace("\\", "/"),
                        file.getName(),
                        file.isDirectory(),
                        file.length(),
                        file.lastModified()
                ))
                .collect(Collectors.toList());
    }
}
