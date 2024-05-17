package com.cli;

public class File {
    private final String fileName;

    public File() {
        this.fileName = "DefaultFileName";
    }

    public File(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
