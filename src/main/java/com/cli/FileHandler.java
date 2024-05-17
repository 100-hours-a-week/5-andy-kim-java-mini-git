package com.cli;

public class FileHandler {

    public FileHandler() {}

    public File makeFile(int type, String fileName) {
        File file;
        if (type == 1) {
            file = new TextFile(fileName);
        } else{
            file = new BinaryFile(fileName);
        }
        return file;
    }
}
