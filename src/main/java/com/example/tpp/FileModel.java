package com.example.tpp;

import java.util.Date;

public class FileModel {
    private String name;
    private boolean isDirectory;
    private long size;
    private long redactDate;

    public FileModel(String name, boolean isDirectory, long size, long redactDate){
        this.name = name;
        this.isDirectory = isDirectory;
        this.size = size;
        this.redactDate=redactDate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getRedactDate() {
        return redactDate;
    }

    public void setRedactDate(long redactDate) {
        this.redactDate = redactDate;
    }
}

